package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartPage {

    public WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Your Cart')]")
    WebElement yourCart_xpath;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement checkoutButton_xpath;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateAddToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(yourCart_xpath));
        String yourCartText = yourCart_xpath.getText();
        Assert.assertEquals(yourCartText, "Your Cart");

    }

    public void verifyCheckoutButtonIsDisplayed() {
        checkoutButton_xpath.isDisplayed();
    }

    public void clickCheckoutButton() {
        checkoutButton_xpath.click();
    }

}
