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

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LoginPage extends BaseClass {

	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver rdriver) throws IOException {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	// locate continue with google button
	@FindBy(xpath = "//button[@class=\"SocialButton_googleBtn__rf4GV\"]")
	@CacheLookup
	WebElement googleButton;

	@FindBy(xpath = "//div[@class=\"w1I7fb\"]")
	@CacheLookup
	WebElement accountRow;

	@FindBy(xpath = "//input[@type=\"email\"]")
	@CacheLookup
	WebElement googleEmailRow;

	@FindBy(xpath = "//input[@type=\"password\"]")
	@CacheLookup
	WebElement passRow;

	@FindBy(xpath = "//span[text()='Next']")
	@CacheLookup
	WebElement submitBtn;

	@FindBy(xpath = "//span[text()='Next']")
	@CacheLookup
	WebElement submitBtn2;

	@FindBy(xpath = "//input[@name=\"phoneNumber\"]")
	@CacheLookup
	WebElement phoneRow;

	@FindBy(xpath = "//button[@qaattr=\"signUpButtonsCreateAcc\"]")
	@CacheLookup
	WebElement createAccBtn;

	String path = "C:\\Users\\Roman Yarmolenko\\IdeaProjects\\FreshiiTest\\src\\test\\java\\com\\inputs\\logpass.xlsx";
	String email =
			XLUtils.getCellData
					(path, "logpass", 0, 0 );
	String pass = XLUtils.getCellData
			(path, "logpass", 0, 1 );

	public void gButtonClick(){
		wait.until(ExpectedConditions.visibilityOf(googleButton));
		googleButton.click();
	}

	public void authorizeWithGoogle() throws InterruptedException {

		Thread.sleep(1000);

		Set<String> handles =  driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		String parentWindow = iterator.next();

		String subWindowHandler = iterator.next();
		driver.switchTo().window(subWindowHandler);

//        Perform actions in new window
				wait.until(ExpectedConditions.visibilityOf(googleEmailRow));
				googleEmailRow.sendKeys(email);
				submitBtn.click();

		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(passRow));

				passRow.sendKeys(pass);
				submitBtn2.click();


				driver.switchTo().window(parentWindow); //cntrl to parent window
			}
		}






//	public void registerWihGoogle(){
//
//		String parentWindow = driver.getWindowHandle();
//		Set<String> handles =  driver.getWindowHandles();
//		for(String windowHandle  : handles)
//		{
//			if(!windowHandle.equals(parentWindow))
//			{
//				driver.switchTo().window(windowHandle);
////        Perform actions in new window
//				wait.until(ExpectedConditions.visibilityOf(accountRow));
//				accountRow.click();
//				driver.switchTo().window(parentWindow); //cntrl to parent window
//			}
//		}
//	}
//	public void createAcc(){
//
//		wait.until(ExpectedConditions.visibilityOf(phoneRow));
//
//		phoneRow.sendKeys("226506"+randomeNum());
//		createAccBtn.click();
//	}





