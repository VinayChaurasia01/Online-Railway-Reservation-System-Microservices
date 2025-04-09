package com.railway.paymentgatewayservice.controller;

import com.railway.paymentgatewayservice.model.Payment;
import com.railway.paymentgatewayservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public String processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }
}
