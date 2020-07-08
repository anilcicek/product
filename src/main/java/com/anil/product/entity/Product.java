package com.anil.product.entity;

public class Product {

    private int id;
    private String name;
    private String price;
    private String category;


    public Product(int id, String name, String price,String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
