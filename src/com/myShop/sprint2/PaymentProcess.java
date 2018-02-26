package com.myShop.sprint2;

public class PaymentProcess extends AbstractProcess {

    @Override
    void action(Orderable item) {
        item.pay();
        System.out.println(item.checkout() ? "Success! Item is payed" : "Impossible to perform.");
    }
}
