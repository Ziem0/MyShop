package com.myShop.sprint2;

public class CheckoutProcess extends AbstractProcess {

    @Override
    void action(Orderable item) {
        System.out.println(item.checkout() ? "Success! Item is checked" : "Impossible to perform.");
    }
}
