package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.Cart;
import com.tc.PlantNursery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/customer/addToCart")
    public Cart addToCart(@RequestBody Cart cart){
        return cartService.saveCart(cart);
    }

    @GetMapping("/customer/getFromCart/{uid}")
    public List<Cart> getCartByUserId(@PathVariable Long uid){
        return cartService.getCartProductsByUserid(uid);
    }

    @DeleteMapping("/customer/removeFromCart/{uid}/{pid}")
    public String remove(@PathVariable Long uid , @PathVariable Long pid){
        return cartService.deleteCartProductByUserAndProductId(uid,pid);
    }



}