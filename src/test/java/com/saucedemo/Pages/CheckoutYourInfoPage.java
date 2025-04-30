package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutYourInfoPage {

    public WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Your Information')]")
    WebElement checkoutYourInformation_xpath;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstname_xpath;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastname_xpath;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCode_xpath;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continue_xpath;

    public CheckoutYourInfoPage(WebDriver driver) {

        this.driver = driver;
    }

    public void validateAddToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutYourInformation_xpath));
        String yourCartText = checkoutYourInformation_xpath.getText();
        Assert.assertEquals(yourCartText, "Checkout: Your Information");
    }
    public void enterFirstName(String firstname) {

        firstname_xpath.sendKeys(firstname);
    }
    public void enterLastName(String lastname) {

        lastname_xpath.sendKeys(lastname);
    }
    public void enterPostalCode(String postalCode) {

        postalCode_xpath.sendKeys(postalCode);
    }
    public void clickContinueButton(){

        continue_xpath.click();
    }

}
