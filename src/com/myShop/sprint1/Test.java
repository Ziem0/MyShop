package com.myShop.sprint1;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Date dateNow = new Date();
        Basket basket = new Basket();

        FeaturedProductCategory cars = new FeaturedProductCategory("cars", dateNow);
        ProductCategory motors = new ProductCategory("motors");
        Product ferrari = new Product("ferrari", 399000f, cars);
        Product subaru = new Product("subaru", 230000f, cars);
        Product honda = new Product("honda", 98000f, motors);
        Product kawasaki = new Product("kawasaki", 87000f, motors);

        basket.addProduct(ferrari);
        basket.addProduct(honda);
        basket.addProduct(subaru);
        basket.addProduct(kawasaki);

        System.out.println(basket.getProductByID(2));
        basket.removeProduct(honda);

        Iterator iterator = basket.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            System.out.println(iterator.next().getProductCategory());
        }


    }




}
