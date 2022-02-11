package com.selenium.course_project.tests;

import com.selenium.course_project.tests.base.TestBaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LockedOutUserLogin extends TestBaseUtil {

    @Test
    public void lockedOutUserLogin(){

        WebElement userNameInput = driver.findElement(By.xpath("//input[contains(@name,'name')]"));
        userNameInput.clear();
        userNameInput.sendKeys("locked_out_user");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[starts-with(@name,'login')]"));
        loginButton.click();

        WebElement loginErrorMessage = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
        Assert.assertTrue(loginErrorMessage.isDisplayed());
    }
}
