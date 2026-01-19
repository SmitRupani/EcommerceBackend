package com.Inclass.Ecommerce.controller;

import com.Inclass.Ecommerce.model.CartItem;
import com.Inclass.Ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public CartItem add(@RequestBody CartItem item) {
        return service.add(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> get(@PathVariable String userId) {
        return service.getUserCart(userId);
    }

    @DeleteMapping("/{userId}/clear")
    public String clear(@PathVariable String userId) {
        service.clear(userId);
        return "Cart cleared";
    }
}
