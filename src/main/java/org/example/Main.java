package org.example;


import org.example.Facade.ECommerceFacade;
import org.example.Service.InventoryService;
import org.example.model.Product;

public class Main {
    public static void main(String[] args) {
        ECommerceFacade eCommerceFacade = new ECommerceFacade();

        Product laptop = ProductFactory.createProduct("electronics", "Laptop", 1200.00);
        Product shirt = ProductFactory.createProduct("clothing", "T-Shirt", 20.00);

        InventoryService inventoryService = new InventoryService();
        inventoryService.addProduct(laptop, 5);
        inventoryService.addProduct(shirt, 10);

        System.out.println("Attempting to purchase a laptop:");
        eCommerceFacade.purchaseProduct(laptop, "creditcard");

        System.out.println("Attempting to purchase a shirt:");
        eCommerceFacade.purchaseProduct(shirt, "paypal");

        System.out.println("Attempting to purchase another laptop:");
        eCommerceFacade.purchaseProduct(laptop, "creditcard");

        System.out.println("Current stock status:");
        System.out.println("Laptops available: " + inventoryService.isAvailable(laptop));
        System.out.println("Shirts available: " + inventoryService.isAvailable(shirt));
    }
}
