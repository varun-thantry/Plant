package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.Cart;
import com.tc.PlantNursery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/customer/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.saveCart(cart);
        if (savedCart != null) {
            return ResponseEntity.ok(savedCart);
        } else {
            return ResponseEntity.badRequest().body("Cart contains the product already");
        }
    }

    @GetMapping("/customer/getFromCart/{uid}")
    public List<Cart> getCartByUserId(@PathVariable Long uid){
        return cartService.getCartProductsByUserid(uid);
    }

    @DeleteMapping("/customer/removeFromCart/{uid}/{pid}")
    public String remove(@PathVariable Long uid , @PathVariable Long pid){
        return cartService.deleteCartProductByUserAndProductId(uid,pid);
    }

    @DeleteMapping("/customer/deleteCart/{uid}")
    public String deleteUserCart(@PathVariable Long uid){
        return  cartService.deleteUserCart(uid);
    }


}