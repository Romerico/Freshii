package com.pageObjects;

import com.base.BaseClass;
import com.utilities.XLUtils;
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

public class LandingPage extends BaseClass {
	public WebDriver ldriver;
	SoftAssert softassert = new SoftAssert();

	public LandingPage(WebDriver driver) throws IOException {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


	public static int randomNum(){
		int min = 1;
		int max = 162;
		int random = (int) (Math.random()*(max-min+1));
		return random;
	}
	String path = "C:\\Users\\Roman Yarmolenko\\IdeaProjects\\FreshiiTest\\src\\test\\java\\com\\inputs\\zipcode.xlsx";
	String randomZip =
		XLUtils.getCellData
		(path, "zipcode", randomNum(), 0 );
	//locate the zipcode row and submit button

	@FindBy(xpath = "//input[@name=\"postalCode\"]")
	@CacheLookup
	WebElement ziprow;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	@CacheLookup
	WebElement findStorebutton;

	public void enterZipcode(){
		wait.until(ExpectedConditions.visibilityOf(ziprow));


		ziprow.sendKeys(randomZip);
	}

	public void submitZipCode(){

		findStorebutton.click();

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

		wait.until(ExpectedConditions.visibilityOf(address));
		return address().contains("Rosedale");
	}



	//Looking for SignUp WebElement
	@FindBy(xpath = "//button[@qaattr=\"userProfile\"]")
	@CacheLookup
	WebElement profileButton;

	@FindBy(xpath = "//button[@qaattr=\"signIn\"]")
	@CacheLookup
	WebElement signupButton;

	public void clickSignupButton(){

		wait.until(ExpectedConditions.elementToBeClickable(signupButton));
		signupButton.click();
	}

	//Performing click operations for SignUp WebElement
	public void clickProfileButton() {

		wait.until(ExpectedConditions.elementToBeClickable(profileButton));
		profileButton.click();

	}
}
