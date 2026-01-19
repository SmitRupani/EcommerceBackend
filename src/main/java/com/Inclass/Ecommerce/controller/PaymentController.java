package com.Inclass.Ecommerce.controller;

import com.Inclass.Ecommerce.model.Payment;
import com.Inclass.Ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Payment pay(@RequestParam String orderId, @RequestParam Double amount) {
        return service.create(orderId, amount);
    }
}
