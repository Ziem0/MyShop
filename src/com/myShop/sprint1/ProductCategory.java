package com.myShop.sprint1;

import java.util.ArrayList;

public class ProductCategory {

    private static int index = 0;
    private static ArrayList<ProductCategory> productCategoryList = new ArrayList<>();
    private String name;
    private Integer ID;

    public ProductCategory() {
        this.name = "";
        this.ID = ++index;
        productCategoryList.add(this);
    }

    public ProductCategory(String name) {
        this.name = name;
        this.ID = ++index;
        productCategoryList.add(this);
    }

    public String getName() {
        return name;
    }

    public static ArrayList<ProductCategory> getAllProductCategory() {
        return productCategoryList;
    }

    public static ProductCategory getProductCategoryByID(int id) {
        for (ProductCategory productCategory : productCategoryList) {
            if (productCategory.ID == id) {
                return productCategory;
            }
        }
        return null;
    }

    public String toString() {
        return String.format("ID:%-5d name:%-5s", this.ID, this.name);
    }

}

