package org.example;


import org.example.Decorator.DiscountDecorator;
import org.example.Facade.ECommerceFacade;
import org.example.Observer.Customer;
import org.example.Service.InventoryService;
import org.example.model.Product;

public class Main {
    public static void main(String[] args) {
        ECommerceFacade eCommerceFacade = new ECommerceFacade();

        Product laptop = ProductFactory.createProduct("electronics", "Laptop", 1200.00);
        Product shirt = ProductFactory.createProduct("clothing", "T-Shirt", 20.00);

        Product discountedLaptop = new DiscountDecorator(laptop, 0.10);
        System.out.println("Original Laptop Price: " + laptop.getPrice());
        System.out.println("Discounted Laptop Price: " + discountedLaptop.getPrice());

        InventoryService inventoryService = new InventoryService();
        inventoryService.addProduct(laptop, 5);
        inventoryService.addProduct(shirt, 10);

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        inventoryService.addObserver(customer1);
        inventoryService.addObserver(customer2);

        System.out.println("\nAdding laptops to inventory...");
        inventoryService.addProduct(laptop, 2);

        System.out.println("\nAttempting to purchase a discounted laptop:");
        eCommerceFacade.purchaseProduct(discountedLaptop, "creditcard");

        System.out.println("\nAttempting to purchase a shirt:");
        eCommerceFacade.purchaseProduct(shirt, "paypal");

        System.out.println("\nCurrent stock status:");
        System.out.println("Laptops available: " + inventoryService.isAvailable(laptop));
        System.out.println("Shirts available: " + inventoryService.isAvailable(shirt));
    }
}

