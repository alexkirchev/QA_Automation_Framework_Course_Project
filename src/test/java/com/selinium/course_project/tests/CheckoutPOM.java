package com.selinium.course_project.tests;

import com.selinium.course_project.tests.base.TestBaseUtil;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutPOM extends TestBaseUtil {
    @Test
    public void checkout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCartByProductName("onesie");
        CartPage cartPage = productsPage.openCart();
        CheckoutStepOnePage checkoutStepOnePage = cartPage.continueToCheckoutStepOnePage();
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.nameAndPostalCodeInput();
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.finishCheckout();
    }
}
