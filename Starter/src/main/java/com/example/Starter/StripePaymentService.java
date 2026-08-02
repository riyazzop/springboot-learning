package com.example.Starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Component
//@Service
//@Controller
//@Repository
@ConditionalOnProperty(name = "payment.provider",havingValue = "stripe")
public class StripePaymentService implements  PaymentService{
    @Override
    public String pay() {
        return "Stripe Payment Service";
    }
}
