package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CompletePage {
    public WebDriver driver;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Complete!')]")
    WebElement checkoutComplete_xpath;
    @FindBy(xpath = "//button[contains(@id,'back-to-products')]")
    WebElement backHomeButton_xpath;

    public CompletePage(WebDriver driver){
        this.driver = driver;
    }
    public void verifyCompletePage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutComplete_xpath));
        String checkoutCompleteText = checkoutComplete_xpath.getText();
        Assert.assertEquals(checkoutCompleteText, "Checkout: Complete!");
    }
    public void clickBackHomeButton(){
        backHomeButton_xpath.click();
    }

}
