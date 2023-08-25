package com.tc.PlantNursery.service;


import com.tc.PlantNursery.entity.Cart;
import com.tc.PlantNursery.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    public Cart saveCart(Cart cart){
        Long uid = cart.getUser().getId();
        Long pid = cart.getProduct().getId();
        if (cartRepo.findByUserAndProduct(uid, pid) != null) {
            // Product is already in the cart, return the existing cart
            return null;
        }
        return cartRepo.save(cart);
    }

    public List<Cart> getCartProductsByUserid(Long uid){
        return cartRepo.getCartByUserId(uid);
    }

    public String deleteCartProductByUserAndProductId(Long uid, Long pid) {
        cartRepo.deleteByUserAndProduct(uid, pid);
        return "Product " + pid + " removed from cart for user " + uid;
    }

}