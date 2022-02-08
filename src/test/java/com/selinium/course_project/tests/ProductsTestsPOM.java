package com.selinium.course_project.tests;

import com.selinium.course_project.tests.base.TestBaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ProductsTestsPOM extends TestBaseUtil {

    @Test
    public void addItemToCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCartByProductName("bike-light");
        productsPage.addItemToCartByProductName("onesie");
        productsPage.addItemToCartByProductName("bolt-t-shirt");

        Assert.assertEquals(productsPage.getNumbersInCart(), 3, "3 items was added in cart");
    }


}