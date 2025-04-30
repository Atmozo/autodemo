package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

//    WebDriver
    public WebDriver driver;

//    These are the Locators eg(username_xpath) & Elements eg("//input[@id='user-name']")
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username_xpath;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password_xpath;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton_xpath;

//  Created a Constructor and assigned the WebDriver linking 'public WebDriver driver; with public LoginPage(WebDriver driver) {this.driver = driver;}
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //Creating a Methode and Declaring variables (public void - void is used because the methode is not returning anything)
    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.sendKeys(username);
    }

    public void enterPassword(String password) {

        password_xpath.sendKeys(password);
    }

    public void clickLoginButton() {

        loginButton_xpath.click();
    }



}
