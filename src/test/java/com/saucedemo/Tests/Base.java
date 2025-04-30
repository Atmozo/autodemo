package com.saucedemo.Tests;


import com.saucedemo.Pages.*;
import com.saucedemo.Utils.BrowserFactory;
import com.saucedemo.Utils.ReadFromExcel;
import com.saucedemo.Utils.TakeScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

// Base class - The class used to Inherit everything that has been done on all other classes
public class Base {
// Inheritance - Create an Instance of a class
    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver=browserFactory.startBrowser("chrome","https://www.saucedemo.com/");

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    HomePage homePage = PageFactory.initElements(driver,HomePage.class);

    AddToCartPage addToCartPage = PageFactory.initElements(driver,AddToCartPage.class);

    CheckoutYourInfoPage checkoutYourInfoPage = PageFactory.initElements(driver, CheckoutYourInfoPage.class);

    OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);

    CompletePage CompletePage = PageFactory.initElements(driver, CompletePage.class);

    TakeScreenShots takeScreenShots = new TakeScreenShots();

    ReadFromExcel readFromExcel;

    {
        try {
            readFromExcel = new ReadFromExcel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
