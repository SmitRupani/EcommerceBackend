package com.Inclass.Ecommerce.controller;

import com.Inclass.Ecommerce.model.Order;
import com.Inclass.Ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestParam String userId) {
        return service.createOrder(userId);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable String id) {
        return service.getOrder(id);
    }
}
