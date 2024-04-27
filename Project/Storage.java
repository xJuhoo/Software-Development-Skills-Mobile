package com.example.mobileproject;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Product> products = new ArrayList<>();
    private static Storage productStorage = null;

    public Storage(){
    }

    // Singleton
    public static Storage getInstance(){
        if (productStorage == null){
            productStorage = new Storage();
        }
        return productStorage;
    }

    // For adding items
    public void addProduct(Product product){
        products.add(product);
    }

    // For deleting items
    public void deleteProduct(String productName){
        int i = 0;

        for (Product product: products){
            if (product.getName().equals(productName)) {
                break;
            }
            i++;
        }
        products.remove(i);
    }

    // For listing items
    public ArrayList<Product> getProducts() {
        return products;
    }

    // For getting specific item
    public Product getProduct (int itemIndex){
        return products.get(itemIndex);
    }
}
