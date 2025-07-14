package com.tsc.demo.service;

//@Service("klarna")
public class KlarnaPaymentService implements PaymentService {

    @Override
    public void makePayment() {
        System.out.println("Klarna payment service");
    }
}
