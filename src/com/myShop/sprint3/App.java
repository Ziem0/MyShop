package com.myShop.sprint3;

import com.myShop.exceptions.NoProductException;

import java.text.ParseException;
import java.util.InputMismatchException;

public class App {

    private ShopEngine shop;
    private AppView ui;

    public App() {
        this.shop = new ShopEngine();
        this.ui = new AppView();
    }

    public static void main(String[] args) {
        App app = new App();
        Boolean exit = false;
        String userOption;

        do {
            app.ui.printMenu();
            userOption = app.ui.getUserInput("Type option number: ");

            switch (userOption) {
                case "0":
                    app.ui.printMessage("Goodbye.");
                    exit = true;
                    break;
                case "1":
                    try {
                        app.shop.createProductCategory();
                    } catch (ParseException e) {
                        app.ui.printError("Incorrect data format!");
                    }
                    break;
                case "2":
                    try {
                        app.shop.createNewProduct();
                    } catch (NumberFormatException e) {
                        app.ui.printError("Invalid price value format!");
                    } catch (InputMismatchException e) {
                        app.ui.printError("Incorrect category ID!");
                    }
                    break;
                case "3":
                    app.shop.listProducts();
                    break;
                case "4":
                    try {
                        app.shop.listProductsByCategory();
                    } catch (InputMismatchException e) {
                        app.ui.printError("Incorrect category ID");
                    }
                    break;
                case "5":
                    app.shop.listProductByName();
                    break;
                case "6":
                    try {
                        app.shop.addProductToBasket();
                    } catch (InputMismatchException e) {
                        app.ui.printError("Incorrect category ID format");
                    } catch (NoProductException e) {
                        //no product to add to the basket
                    }
                    break;
                case "7":
                    try {
                        app.shop.removeProductToBasket();
                    } catch (InputMismatchException e) {
                        app.ui.printError("Incorrect product ID format");
                    } catch (NoProductException e) {
                        //no product to remove to the basket
                    }
                    break;
                case "8":
                    try {
                        app.shop.listAllProductsInBasket();
                    } catch (NoProductException e) {
                        //basket is empty
                    }
                    break;
                case "9":
                    app.shop.payForOrder();
                    break;
                default:
                    app.ui.printError("Incorrect number option!");
            }
        } while (!exit);
    }
}
