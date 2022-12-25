package com.pageObjects;

import com.base.BaseClass;
import com.utilities.XLUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
import java.util.List;

public class UserLanding extends BaseClass {

    public WebDriver ldriver;
    SoftAssert softassert = new SoftAssert();

    public UserLanding(WebDriver driver) throws IOException {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    @FindBy(xpath = "//img[@alt=\"Profile\"]")
    @CacheLookup
    WebElement profileImg;

    @FindBy(xpath = "//a[@qaattr=\"details\"]")
    @CacheLookup
    WebElement accountDetails;

    public void profileImgClick() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(profileImg));
        profileImg.click();}
    public void getInAccount() throws InterruptedException {

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(accountDetails));
        accountDetails.click();
    }

    @FindBy(xpath = "//nav[@class=\"bm-item-list\"]//div")
    @CacheLookup
    List<WebElement> options;

    public int optionsList(){

       return options.size();

    }

    @FindBy(xpath = "//h1[@class=\"FreshiiTitle_freshiiTitle___Fohf\"]")
    @CacheLookup
    WebElement title;


    public String titleText(){
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }

    String path = "C:\\Users\\Roman Yarmolenko\\IdeaProjects\\FreshiiTest\\src\\test\\java\\com\\inputs\\logpass.xlsx";
    String name =
            XLUtils.getCellData
                    (path, "username", 0, 0 );
    String lastname = XLUtils.getCellData
            (path, "username", 0, 1 );
    String email =
            XLUtils.getCellData
                    (path, "logpass", 0, 0 );

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    @CacheLookup
    WebElement nameRow;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    @CacheLookup
    WebElement lastNameRow;

    @FindBy(xpath = "//input[@name=\"email\"]")
    @CacheLookup
    WebElement emailRow;

    @FindBy(xpath = "//input[@class=\"form-control FormPhoneInput_phoneInput__Wg1_D\"]")
    @CacheLookup
    WebElement phoneRow;

    @FindBy(xpath = "//button[@qaattr=\"commonButtonsSave\"]")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(xpath = "//span[@aria-label=\"edit\"]")
    @CacheLookup
    WebElement editBtn;

    public void editBtnClick(){
        editBtn.click();
    }

    public void saveBtnClick(){
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }

    public boolean checkName(){
        wait.until(ExpectedConditions.visibilityOf(nameRow));
        return nameRow.getAttribute("value").equals(name);
    }
    public String username(){
        wait.until(ExpectedConditions.visibilityOf(nameRow));
        return nameRow.getAttribute("value");
    }

    public boolean checkLastName(){
        wait.until(ExpectedConditions.visibilityOf(lastNameRow));
        return lastNameRow.getAttribute("value").equals(lastname);
    }
    public String userLastname() throws InterruptedException {
        wait.ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    lastNameRow.getAttribute("value");
                    return true;
                });
        return lastNameRow.getAttribute("value");
    }

    public void editLastName(){
        wait.until(ExpectedConditions.visibilityOf(lastNameRow));
        lastNameRow.sendKeys(Keys.CONTROL + "a");
        lastNameRow.sendKeys(Keys.DELETE);
        lastNameRow.sendKeys(randomestring());

    }

    public boolean checkEmail(){
        wait.until(ExpectedConditions.visibilityOf(emailRow));

        return emailRow.getAttribute("value").equals(email);
    }
    public String userEmail(){
        return emailRow.getAttribute("value");
    }

    public boolean checkPhone(){
        wait.until(ExpectedConditions.visibilityOf(phoneRow));

        return phoneRow.getAttribute("value").isEmpty();
    }











}
