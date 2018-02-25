package com.myShop.sprint1;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> productList;
    private Iterator iterator;

    public Iterator getIterator() {
        return new ProductIterator();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Boolean removeProduct(Product product) {
        return productList.remove(product);
    }

    public Product getProductByID(int id) {
        Iterator iterator = getIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getID() == (id)) {
                return product;
            }
        }
        return null;
    }

    private class ProductIterator implements Iterator {
        int index = 0;

        @Override
        public Boolean hasNext() {
            return index < productList.size();
        }

        @Override
        public Product next() {
            if (this.hasNext()) {
                return productList.get(++index);
            }
            return null;
        }
    }
}
