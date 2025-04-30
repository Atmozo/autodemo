package com.saucedemo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OverviewPage {
    public WebDriver driver;
    @FindBy(xpath = "//span[contains(.,'Checkout: Overview')]")
    WebElement checkoutOverview_xpath;
    @FindBy(xpath = "//div[contains(@class,'inventory_item_name')]")
    WebElement inventoryItemName_xpath;
    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    WebElement itemPrice_xpath;
    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    WebElement total_xpath;
    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton_xpath;
//    @FindBy(xpath = "//button[@id='cancel']")
//    WebElement cancelButton_xpath;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyCheckoutOverview() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutOverview_xpath));
        String checkoutOverviewText = checkoutOverview_xpath.getText();
        Assert.assertEquals(checkoutOverviewText, "Checkout: Overview");
    }
    public void verifyInventoryItemOverview() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(inventoryItemName_xpath));
        String inventoryItemNameText = inventoryItemName_xpath.getText();
        Assert.assertEquals(inventoryItemNameText, "Sauce Labs Bolt T-Shirt");
    }
    public void verifyItemTotalPlusTax() throws InterruptedException {
        float itemTotal = Float.parseFloat(itemPrice_xpath.getText().replace("Item total: $",""));
        float ItemTotalPlusTax= (float) (itemTotal+(itemTotal*0.08));

        String Total = total_xpath.getText().replace("Total: $","");
        System.out.println(ItemTotalPlusTax);
        System.out.println(Total);
        Thread.sleep(5000);

        Assert.assertEquals(Total, "17.27");

//        if (ItemTotalPlusTax==Total){
//            finishButton_xpath.click();
//        }
//        else
//        {
//            cancelButton_xpath.click();
//        }
    }

    public void clickFinishButton() {

        finishButton_xpath.click();
    }

}
