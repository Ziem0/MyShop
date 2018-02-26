package com.myShop.sprint3;

public class AppView extends AbstractView {

    public void printMenu() {
        String menu = WHITE + "\t\tMenu:\n"
                + "1. Create new product category\n"
                + "2. Create new product\n"
                + "3. Show all available products\n"
                + "4. Show products from specific product category\n"
                + "5. Find specific product by name\n"
                + "\t\tBASKET\n"
                + "6. Add product to the basket\n"
                + "7. Remove product from the basket\n"
                + "8. See all products in the basket\n"
                + "9. Pay for your order\n"
                + "0. Exit\n";
        System.out.println(menu);
    }
}
