package com.myShop.sprint2;

public class Test2 {

    public static void main(String[] args) {

        Order order = new Order();
        System.out.println(order.getStatus());

        CheckoutProcess check = new CheckoutProcess();
        check.action(order);
        PaymentProcess pay = new PaymentProcess();
        pay.action(order);

    }

}
