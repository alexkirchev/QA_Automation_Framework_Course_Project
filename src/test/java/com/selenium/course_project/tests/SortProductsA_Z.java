package com.selenium.course_project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SortProductsA_Z {
    private WebDriver driver;

    @BeforeTest
    public void setUpNewSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDownSession() {
        driver.quit();
    }

    @Test
    public void sortProductsA_Z() {
//        driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.cssSelector("[name=user-name]"));
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        Select productsSortingDropdown = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        productsSortingDropdown.selectByVisibleText("Name (A to Z)");



//        List<WebElement> productNameList = driver.findElements(By.className("inventory_item_name"));
//        boolean returnValue = true;
//        for(int i = 0; i < productNameList.size()-1; i++){
//            String name1Item = productNameList.get(i).getText();
//            String name2Item = productNameList.get(i+1).getText();
//            if(String.valueOf(name1Item) > String.valueOf(name2Item));
//            returnValue = false;
//        }




    }
}
