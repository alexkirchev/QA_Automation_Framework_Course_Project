package com.selenium.course_project.tests;

import com.selenium.course_project.tests.base.TestBaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProblemUserLogin extends TestBaseUtil {
    @Test
    public void ProblemUserLogin(){

        WebElement userNameInput = driver.findElement(By.xpath("//input[contains(@name,'name')]"));
        userNameInput.clear();
        userNameInput.sendKeys("problem_user");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[starts-with(@name,'login')]"));
        loginButton.click();

        WebElement wrongItemImage = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack' and @src='/static/media/sl-404.168b1cce.jpg']"));
        Assert.assertTrue(wrongItemImage.isDisplayed());
    }
}
