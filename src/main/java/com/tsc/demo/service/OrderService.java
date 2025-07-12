package com.tsc.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

//@Service("orderService")
public class OrderService {

    @Value("${stripe.supported-currencies}")
    private List<String> currencies;

    private PaymentService paymentService;

    public OrderService(@Qualifier("klarna") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        System.out.println("Order Placed");
        System.out.println("Currencies :: " + currencies);
        this.paymentService.makePayment();
    }

}
