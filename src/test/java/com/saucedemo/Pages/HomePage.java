package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

public class HomePage {

    public WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement product_xpath;
    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bolt-t-shirt')]")
    WebElement addToCartButton_xpath;

    @FindBy(xpath = "//span[@class='shopping_cart_badge'][contains(.,'1')]")
    WebElement cartText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

//    Call the Methods under Test folder in the PurchaseItem Class
    public void verifyUserIsLoggedIn() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(product_xpath));
//        product_xpath.isDisplayed();
        String productText = product_xpath.getText();
        Assert.assertEquals(productText, "Products");

    }

    public void clickAddToCartButton() {

        addToCartButton_xpath.click();
    }

    // 'isDisplayed' Returns a Boolean Value 'True of False'
    public void validatItemAddedToCart() {

        cartText.isDisplayed();
    }

    public void clickCart() {

        cartText.click();
    }
}
