package com.myShop.sprint2;

public class Order implements Orderable {

    private static int index = 0;
    private Integer id;
    private String status;


    public Order() {
        this.id = ++index;
        this.status = "new";
    }

    public String getStatus() {
        return status;
    }

    public void resetStatus() {
        this.status = "new";
    }

    @Override
    public Boolean checkout() {
        if (this.status.equals("new")) {
            this.status = "checked";
            return true;
        }
        return false;
    }

    @Override
    public Boolean pay() {
        if (this.status.equals("checked")) {
            this.status = "payed";
            return true;
        }
        return false;
    }
}
