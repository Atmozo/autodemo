package com.saucedemo.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrowserFactory {

//    Initialize a browser
    public static WebDriver driver;

//    Methode to start the browser (Select Multiple Browsers in the Parameter (url to change depending on the environment Prod/Dev))
    @BeforeClass
//    Public Static - Means something will never change
    public static WebDriver startBrowser(String browserChoice, String url) {
        if ("chrome".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
//      Safari Driver as Default Browser
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

}
