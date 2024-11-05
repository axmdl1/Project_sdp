package org.example.EcommerceFacade;

import org.example.Service.InventoryService;
import org.example.Service.PaymentService;
import org.example.model.Product;

public class ECommerceFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;

    public ECommerceFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
    }

    public void purchaseProduct(Product product, String paymentMethod) {
        if (inventoryService.isAvailable(product)) {
            paymentService.processPayment(product.getPrice(), paymentMethod);
        } else {
            System.out.println("Product not available");
        }
    }
}
