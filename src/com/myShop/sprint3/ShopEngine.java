package com.myShop.sprint3;

import com.myShop.exceptions.NoProductException;
import com.myShop.sprint1.Basket;
import com.myShop.sprint1.FeaturedProductCategory;
import com.myShop.sprint1.Product;
import com.myShop.sprint1.ProductCategory;
import com.myShop.sprint2.CheckoutProcess;
import com.myShop.sprint2.Order;
import com.myShop.sprint2.PaymentProcess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public class ShopEngine {

    private ArrayList<Product> allProducts;
    private ArrayList<ProductCategory> allCategories;
    private Basket basket;
    private Order order;
    private EngineVIew ui;

    public ShopEngine() {
        this.allProducts = Product.getAllProducts();
        this.allCategories = ProductCategory.getAllProductCategory();
        this.basket = new Basket();
        this.order = null;
        this.ui = new EngineVIew();
    }

    public void createProductCategory() throws ParseException {
        ui.printTitle("\t\tProduct category creator\n");
        String name = ui.getUserInput("Type product category name: ");
        ui.printMessage("Type date to create Featured Product Category or ENTER to create Simple Category");
        String dateString = ui.getUserInput("Type product expiration date in format [yyyy-mm-dd]: ");

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        if (dateString.equals("")) {
            ProductCategory productCategory = new ProductCategory(name);
        } else {
            Date expirationDate = sd.parse(dateString);
            FeaturedProductCategory featuredProductCategory = new FeaturedProductCategory(name, expirationDate);
        }
        ui.printMessage("Category created!");
    }

    private void listProductCategories() {
        ui.printTitle("Available categories:\n");
        ui.printList(allCategories);
    }

    public void createNewProduct() throws NumberFormatException, InputMismatchException{
        ui.printTitle("Product creator\n");
        String name = ui.getUserInput("Type product name: ");
        String price = ui.getUserInput("Type product default price: ");
        Float defaultPrice = Float.parseFloat(price);

        this.listProductCategories();
        Integer selectedID = ui.getUserNumber("Choose category ID from the list: ");
        ProductCategory productCategory = ProductCategory.getProductCategoryByID(selectedID);

        if (productCategory != null) {
            new Product(name, defaultPrice, productCategory);
        } else {
            ui.printError("There is no such category ID!");
        }
        ui.printMessage("Product created!");
    }

    public void listProducts() {
        ui.printTitle("All available products:\n");
        ui.printList(allProducts);
    }

    public void listProductsByCategory() throws InputMismatchException {
        ArrayList<Product> selectedProducts = new ArrayList<>();
        this.listProductCategories();
        Integer selectedID = ui.getUserNumber("Type category ID: ");

        ProductCategory productCategory = ProductCategory.getProductCategoryByID(selectedID);
        if (productCategory != null) {
            selectedProducts = Product.getAllProductsBy(productCategory);
        }

        if (selectedProducts.size() > 0) {
            ui.printTitle("All products from category:\n");
            ui.printList(selectedProducts);
        } else {
            ui.printError("This category is empty!");
        }
    }

    public void listProductByName() {
        ui.printTitle("Find product\n");
        String name = ui.getUserInput("Type name of desired product: ");
        ArrayList<Product> selectedProducts = Product.getAllProductsByName(name);

        if (selectedProducts == null) {
            ui.printError("Requested product doesn't exist in our shop. Sorry for that.");
        } else {
            ui.printList(selectedProducts);
        }
    }

    public void addProductToBasket() throws NoProductException {
        ui.printTitle("Add product to the basket\n");
        this.listProducts();
        if (this.allProducts.size() < 1) {
            throw new NoProductException("Sorry! Our shop is closed");
        }

        Integer selectedID = ui.getUserNumber("Type product ID you want to add: ");
        Product selectedProduct = Product.getProductByID(selectedID);

        if (selectedProduct == null) {
            ui.printError("Invalid product ID!");
        } else {
            this.basket.addProduct(selectedProduct);
            this.order = new Order();
            ui.printMessage("Product added!");
        }
    }

    public void removeProductToBasket() throws NoProductException {
        ui.printTitle("Remove product from the basket\n");

        if (this.basket.getProductList().size() < 1) {
            throw new NoProductException("Your basket is empty currently!");
        } else {
            ui.printList(this.basket.getProductList());
        }
        Integer selectedID = ui.getUserNumber("Type product ID you want to add: ");
        Product selectedProduct = this.basket.getProductByID(selectedID);

        if (selectedProduct == null) {
            ui.printError("Invalid product ID!");
        } else {
            this.basket.removeProduct(selectedProduct);
            ui.printMessage("Product removed!");
        }
    }

    public void listAllProductsInBasket() throws NoProductException {
        ui.printTitle("All products in the basket\n");
        if (this.basket.getProductList().size() < 1) {
            throw new NoProductException("Your basket is empty currently!");
        } else {
            ui.printList(this.basket.getProductList());
        }
    }

    public void payForOrder() {
        ui.printTitle("Payment creator\n");
        ui.printMessage("Your current status is " + order.getStatus());
        if (this.order == null) {
            ui.printError("Your basket is empty!");
        } else {
            CheckoutProcess check = new CheckoutProcess();
            check.process(this.order);
            ui.printMessage("Your current status is " + order.getStatus());

            String userChoice = ui.getUserInput("Do you want to pay? [y for yes]").toLowerCase();

            switch (userChoice) {
                case "y":
                    PaymentProcess pay = new PaymentProcess();
                    pay.process(this.order);
                    ui.printMessage("Your current status is " + order.getStatus());
                    this.order = null;
                    this.basket = new Basket();
                    break;
                default:
                    this.order.resetStatus();
                    ui.printMessage("Payment is cancelled..");
                    ui.printMessage("Your current status is " + order.getStatus());
            }
        }
    }
}
