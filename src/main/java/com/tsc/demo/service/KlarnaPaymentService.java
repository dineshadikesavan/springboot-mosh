package com.tsc.demo.service;

import org.springframework.stereotype.Service;

//@Service("klarna")
public class KlarnaPaymentService implements PaymentService {

    @Override
    public void makePayment() {
        System.out.println("Klarna payment service");
    }
}
