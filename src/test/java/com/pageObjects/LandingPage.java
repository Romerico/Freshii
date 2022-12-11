package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

import java.time.Duration;

public class LandingPage extends BaseClass {
	public WebDriver ldriver;
	SoftAssert softassert = new SoftAssert();

	public LandingPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	//Looking for address WebElement
	@FindBy(xpath = "//div[@class=\"ant-row ant-row-no-wrap ant-row-space-between ant-row-middle Header_headerContainer__E8jjb\"]" +
			"//div[@class=\"Header_threeDots__QZzHQ\"]")
	@CacheLookup
	WebElement address;

	public String address() {
		return address.getText();
	}

	public boolean addressDefaulted() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(address));
		return address().contains("Rosedale");
	}

	//Looking for SignUp WebElement
	@FindBy(xpath = "/html/body/div/main/section[1]/div/div/div/div/div/a[2]")
	@CacheLookup
	WebElement signup;

	//Performing click operations for SignUp WebElement
	public void clickSignup() {
		signup.click();

	}
}
