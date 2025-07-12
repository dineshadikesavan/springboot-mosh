package com.tsc.demo.config;

import com.tsc.demo.service.KlarnaPaymentService;
import com.tsc.demo.service.OrderService;
import com.tsc.demo.service.PaymentService;
import com.tsc.demo.service.PaypalPaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public PaymentService klarna() {
        return new KlarnaPaymentService();
    }

    @Bean
    @Scope("prototype")
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    @Scope("prototype")
    public OrderService orderService() {
        return new OrderService(paypal());
    }
}
