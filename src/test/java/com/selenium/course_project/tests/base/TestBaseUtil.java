package com.selenium.course_project.tests.base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBaseUtil {
    protected WebDriver driver;
    private String applicationUrl, targetBrowser;
    private int implicitWaitSeconds, explicitWaitSeconds;

    @BeforeMethod
    public void setUpNewSession(){
        setupBrowserDriver();
        loadPageUrl();
    }
    private void loadPageUrl(){
        driver.get(applicationUrl);
    }

    private void setupBrowserDriver() {
        try {
            FileInputStream configuration = new FileInputStream("src/test/resources/configuration.properties");
            Properties configProperties = new Properties();
            configProperties.load(configuration);
            applicationUrl = configProperties.getProperty("url");
            targetBrowser = configProperties.getProperty("browser");
            implicitWaitSeconds = Integer.parseInt(configProperties.getProperty("implicitWait"));
            explicitWaitSeconds = Integer.parseInt(configProperties.getProperty("explicitWait"));

        } catch (IOException e) {
            System.out.println(e);
        }

        switch (targetBrowser) {
            case "chrome":
                driver = DriverFactory.setupChromeDriver(implicitWaitSeconds);
                break;
            case "firefox":
                driver = DriverFactory.setupFirefoxDriver(implicitWaitSeconds);
                break;
            case "edge":
                driver = DriverFactory.setupEdgeDriver(implicitWaitSeconds);
                break;
        }
    }

    @AfterTest
    public void tearDownSession(){
        driver.quit();
    }
}
