package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class Order extends BaseClass {

    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public Order(WebDriver driver) throws IOException {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));



    @FindBy(xpath = "//span[@aria-label=\"minus\"]/following::span[1]")
    @CacheLookup
    WebElement quantity;

    @FindBy(xpath = "//span[@aria-label=\"plus\"]")//button[@class=\"ProductCount_productCountBtn__iYVPz\"][2]")
    @CacheLookup
    WebElement plus;

    @FindBy(xpath = "//button[text() = 'ORDER NOW']")
    @CacheLookup
    WebElement order;

    @FindBy(xpath = "//img[@alt=\"Spicy Lemongrass Soup (Small)\"]")
    @CacheLookup
    WebElement lemongrass;

    public void clickOrder() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(order));
        order.click();
    }
    public void chooseSoup() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(lemongrass));
        lemongrass.click();
    }

    public void clickPlus(){
        wait.until(ExpectedConditions.visibilityOf(plus));
        plus.click();
    }

    public String amount(){
        return quantity.getText();
    }

}
