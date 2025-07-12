package com.tsc.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("paypal")
@Primary
public class PaypalPaymentService implements PaymentService {
    @Override
    public void makePayment() {
        System.out.println("paypal payment service");
    }
}
