package com.myShop.sprint1;

import java.util.ArrayList;

public class Product {

    private static int index = 0;
    private static ArrayList<Product> productList;
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;

    public Product() {
        this.name = "";
        this.defaultPrice = 0f;
        this.productCategory = null;
        this.ID = ++index;
        productList.add(this);
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = ++index;
    }

    public Integer getID() {
        return ID;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String toString() {
        String categoryClassName = this.productCategory.getClass().getSimpleName();
        String headline = categoryClassName.equals("FeaturedProductCategory") ? categoryClassName : "";
        return String.format("%s ID:%d name:%s default price:%.2f",headline, this.ID, this.name, this.defaultPrice);
    }

    public static ArrayList<Product> getAllProducts() {
        return productList;
    }

    public static ArrayList<Product> getAllProductsBy(ProductCategory productCategory) {
        ArrayList<Product> selectedProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.productCategory == productCategory) {
                selectedProducts.add(product);
            }
        }
        return selectedProducts;
    }


}
