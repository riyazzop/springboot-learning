package com.example.Starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name = "payment.provider",havingValue = "razorpay")
public class RazorPayPaymentService implements  PaymentService{
    public String pay(){
        return "Razorpay Payment";
    }
}
