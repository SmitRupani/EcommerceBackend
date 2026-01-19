package com.Inclass.Ecommerce.service;

import com.Inclass.Ecommerce.model.Payment;
import com.Inclass.Ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository repo;
    private final OrderService orderService;

    public PaymentService(PaymentRepository r, OrderService o) {
        this.repo = r;
        this.orderService = o;
    }

    public Payment create(String orderId, Double amount) {
        Payment p = new Payment();
        p.setOrderId(orderId);
        p.setAmount(amount);
        p.setStatus("PENDING");
        p.setPaymentId(UUID.randomUUID().toString());
        p.setCreatedAt(Instant.now());

        // Mock webhook
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                p.setStatus("SUCCESS");
                repo.save(p);
                orderService.markPaid(orderId);
            } catch (Exception ignored) {}
        }).start();

        return repo.save(p);
    }
}
