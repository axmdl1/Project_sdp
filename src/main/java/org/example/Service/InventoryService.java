package org.example.Service;

import org.example.model.Product;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Product, Integer> inventory = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    public boolean isAvailable(Product product) {
        return inventory.getOrDefault(product, 0) > 0;
    }

    public void reduceStock(Product product) {
        if (isAvailable(product)) {
            inventory.put(product, inventory.get(product) - 1);
        } else {
            System.out.println("Stock unavailable for product: " + product.getName());
        }
    }
}

