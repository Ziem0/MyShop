package com.myShop.sprint1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FeaturedProductCategory extends ProductCategory{

    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String toString() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return String.format(super.toString() + " --- > expirationDate:%s", sd.format(expirationDate));
    }
}
