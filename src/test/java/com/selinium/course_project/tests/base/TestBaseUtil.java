package com.selinium.course_project.tests.base;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBaseUtil {
    protected WebDriver driver;
    private String applicationUrl, targetBrowser;
    private int implicitWaitSeconds, explicitWaitSeconds;

    @BeforeTest
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
//                getChromeDriver();
                break;
            case "firefox":
                driver = DriverFactory.setupFirefoxDriver(implicitWaitSeconds);
//                getFirefoxDriver();
                break;
            case "edge":
                driver = DriverFactory.setupEdgeDriver(implicitWaitSeconds);
//                getEdgeDriver();
                break;
        }
    }

//    private WebDriver getChromeDriver(){
//        driver = DriverFactory.setupChromeDriver(implicitWaitSeconds);
//        return driver;
//    }
//
//    private WebDriver getFirefoxDriver(){
//        driver = DriverFactory.setupFirefoxDriver(implicitWaitSeconds);
//        return driver;
//    }
//
//    private WebDriver getEdgeDriver(){
//        driver = DriverFactory.setupEdgeDriver(implicitWaitSeconds);
//        return driver;
//    }


//    @AfterTest
    public void tearDownSession(){
        driver.quit();
    }
}
