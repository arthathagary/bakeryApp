package com.example.myapplication.Adapters;

public class ProductClass {

    private String ProductId;
    private String ProductName;
    private int Price;
    private int Quantity;
    private String CategoryId;

    public ProductClass(){}

    public ProductClass(String productId, String productName, int price, int quantity, String categoryId) {
        ProductId = productId;
        ProductName = productName;
        Price = price;
        Quantity = quantity;
        CategoryId = categoryId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }
}

