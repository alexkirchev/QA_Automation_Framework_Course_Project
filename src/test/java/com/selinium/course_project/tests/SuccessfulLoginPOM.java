package com.selinium.course_project.tests;

import com.selinium.course_project.tests.base.TestBaseUtil;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SuccessfulLoginPOM extends TestBaseUtil {
    @Test
    public void successfulLoginPOM(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }
}
