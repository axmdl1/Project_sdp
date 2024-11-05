package org.example.Service;

public class PaymentService {
    public void processPayment(double amount, String paymentMethod) {
        PaymentStrategy paymentStrategy;
        switch (paymentMethod.toLowerCase()) {
            case "creditcard":
                paymentStrategy = new CreditCardPayment();
                break;
            case "paypal":
                paymentStrategy = new PayPalPayment();
                break;
            default:
                throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
        }
        paymentStrategy.pay(amount);
    }
}
