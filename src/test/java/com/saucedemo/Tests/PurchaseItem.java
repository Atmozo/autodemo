package com.saucedemo.Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

// Class Inheritance: PurchaseItem is call everything from the Base Class
public class PurchaseItem extends Base {

    Faker faker = new Faker();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String postalcode = faker.address().zipCode();

//    Creating Methods - Dependence on Methods
    @Test
    public void enterUsernameTests() {

        loginPage.enterUsername(readFromExcel.username);
    }

    @Test
    public void enterPasswordTests() {

        loginPage.enterPassword(readFromExcel.password);
    }

    @Test(dependsOnMethods = "enterPasswordTests")
    public void clickLoginButtonTests() {
        takeScreenShots.takesSnapShot(driver, "Login Page");
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "clickLoginButtonTests")
    public void verifyLoginSuccessTests() {
        homePage.verifyUserIsLoggedIn();
        takeScreenShots.takesSnapShot(driver, "Home Page");
    }

    @Test(dependsOnMethods = "verifyLoginSuccessTests")
    public void clickAddToCartButtonTests() {
        homePage.clickAddToCartButton();
    }

    @Test(dependsOnMethods = "clickAddToCartButtonTests")
    public void verifyItemAddedToCartTests() {
        homePage.validatItemAddedToCart();
        takeScreenShots.takesSnapShot(driver, "ItemAddedToCart on Home Page");
    }

    @Test(dependsOnMethods = "verifyItemAddedToCartTests")
    public void clickCartTests() {
        homePage.clickCart();
    }

    @Test(dependsOnMethods = "clickCartTests")
    public void validateAddToCartTests() {
        addToCartPage.validateAddToCart();
        takeScreenShots.takesSnapShot(driver, "Item Add To Cart Page");
    }

    @Test(dependsOnMethods = "validateAddToCartTests")
    public void verifyCheckoutButtonTests() {
        addToCartPage.verifyCheckoutButtonIsDisplayed();
    }

    @Test(dependsOnMethods = "verifyCheckoutButtonTests")
    public void clickCheckoutButtonTests() {
        addToCartPage.clickCheckoutButton();
    }

    @Test(dependsOnMethods = "clickCheckoutButtonTests")
    public void checkoutYourInformationTests() {
        checkoutYourInfoPage.validateAddToCart();
        takeScreenShots.takesSnapShot(driver, "CheckoutYourInformationPage");
    }

    @Test(dependsOnMethods = "checkoutYourInformationTests")
    public void enterFirstNameTests() {
        checkoutYourInfoPage.enterFirstName(firstname);
    }

    @Test(dependsOnMethods = "enterFirstNameTests")
    public void enterLastNameTests() {
        checkoutYourInfoPage.enterLastName(lastname);
    }

    @Test(dependsOnMethods = "enterLastNameTests")
    public void enterPostalCodeTests() {
        checkoutYourInfoPage.enterPostalCode(postalcode);
    }

    @Test(dependsOnMethods = "enterPostalCodeTests")
    public void clickContinueButtonTests() {
        takeScreenShots.takesSnapShot(driver, "InfoAddedToCheckoutYourInformationPage");
        checkoutYourInfoPage.clickContinueButton();
    }

    @Test(dependsOnMethods = "clickContinueButtonTests")
    public void OverviewTests() {
        overviewPage.verifyCheckoutOverview();
        takeScreenShots.takesSnapShot(driver, "Checkout:Overview Page");
    }

    @Test(dependsOnMethods = "OverviewTests")
    public void InventoryItemOverviewTests() {
        overviewPage.verifyInventoryItemOverview();
        takeScreenShots.takesSnapShot(driver, "Checkout:Complete Page");
    }

    @Test(dependsOnMethods = "InventoryItemOverviewTests")
    public void verifyItemTotalPlusTaxTests() throws InterruptedException {
        overviewPage.verifyItemTotalPlusTax();
    }

    @Test(dependsOnMethods = "verifyItemTotalPlusTaxTests")
    public void verifyClickFinishButtonTests() {
        overviewPage.clickFinishButton();

    }

    @Test(dependsOnMethods = "verifyClickFinishButtonTests")
    public void verifyCompletePageTests() {
        CompletePage.verifyCompletePage();

    }
    @Test(dependsOnMethods = "verifyCompletePageTests")
    public void clickBackHomeButtonTests() {
        CompletePage.clickBackHomeButton();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();

    }

}
