package com.example.mobileproject;

import java.util.Comparator;

public class Product {
    private String name, details;
    private int order;

    // Public constructor
    public Product(String name, String details, int order) {
        this.name = name;
        this.details = details;
        this.order = order;
    }

    // We need both getters and setters for name and details because the user can edit them
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    // Comparing the order of creation
    public static final Comparator<Product> sortByOrder = new Comparator<Product>() {
        @Override
        public int compare(Product firstProduct, Product secondProduct) {
            return firstProduct.order - (secondProduct.order);
        }
    };

    // Comparing the product names
    public static final Comparator<Product> sortByName = new Comparator<Product>() {
        @Override
        public int compare(Product firstProduct, Product secondProduct) {
            return firstProduct.name.compareTo(secondProduct.name);
        }
    };
}
