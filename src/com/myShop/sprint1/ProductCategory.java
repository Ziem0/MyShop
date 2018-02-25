package com.myShop.sprint1;

public class ProductCategory {

    private static int index = 0;
    private String name;
    private Integer ID;

    public ProductCategory() {
        this.name = "";
        this.ID = ++index;
    }

    public ProductCategory(String name) {
        this.name = name;
        this.ID = ++index;
    }

    public String getName() {
        return name;
    }
}
