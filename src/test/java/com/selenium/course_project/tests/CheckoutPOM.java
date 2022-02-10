package com.selenium.course_project.tests;

import com.selenium.course_project.tests.base.TestBaseUtil;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutPOM extends TestBaseUtil {
    @Test
    public void checkout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCartByProductName("onesie");
        CartPage cartPage = productsPage.openCart();
        CheckoutStepOnePage checkoutStepOnePage = cartPage.continueToCheckoutStepOnePage();
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.nameAndPostalCodeInput();
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.finishCheckout();
    }
}
