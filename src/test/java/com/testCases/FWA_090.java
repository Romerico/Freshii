package com.testCases;
//"1. Click on continue with Google.
//2. Enter Email ID
//3. Enter Password
//4. Click User Pofile
//5. Click My Account from the menu options.
//6. Verify whether Firstname, Last name, EmaiId, phone number (optional) is autofilled.
//7. Save should be clickable.
//8. Click on Favourite option.
//9. Remove the location marked as favourite in the favourite screen.
//10. Check for the favourite location added.
//"

//"1. User should be able to enter the email Id
//2. User should be able to enter the Password
//3. Upon clicking on login, user should be able to navigate to Welcome Freshii page
//4. User should able to view the options in the user profile
//5. Upon clicking on My Account the user should be able to view the My account page
//6. The user details should be seen autofilled / Edit / save
//7. Upon clicking save, profile should be updated.
//8. A list of items previously marked as favorites is displayed.
//9. User should not be able to see the removed location in the favourite screen. "

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.UserLanding;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class FWA_090 extends BaseClass {

    @Test(priority = 1)
    public void FWA_090() throws IOException, InterruptedException {

        logger.info("Started FWA_090");
//		init pages and methods for further testing
        LandingPage lp = new LandingPage(driver);
        LoginPage logp = new LoginPage(driver);
        UserLanding ul = new UserLanding(driver);
        SoftAssert softassert = new SoftAssert();

//submit random zip as it's obligatory and shouldn't be hardcoded
//"1. User should be able to enter the email Id
//2. User should be able to enter the Password

        lp.enterZipcode();
        lp.submitZipCode();
        logger.info("zipcode is accepted");

//click profile image in order to get popup with options to proceed with signup

        lp.clickProfileButton();
        lp.clickSignupButton();
        logger.info("landed on login page");

//continue with google

        logp.gButtonClick();

//clicking the account in a popup window

        logp.authorizeWithGoogle();
        logger.info("authorized the google account");

//3. Upon clicking on login, user should be able to navigate to Welcome Freshii page

        softassert.assertTrue(driver.getTitle().contains("Freshii"), "User is not on welcome page after login through Google");

        softassert.assertAll();
        logger.info("Completed FWA_090");
    }


    @Test(priority = 2)
    public void FWA_090_1() throws IOException, InterruptedException {

        logger.info("Started FWA_090_1");

        LandingPage lp = new LandingPage(driver);
        LoginPage logp = new LoginPage(driver);
        UserLanding ul = new UserLanding(driver);
        SoftAssert softassert = new SoftAssert();

        lp.enterZipcode();
        lp.submitZipCode();
        logger.info("zipcode is accepted");

//click profile image in order to get popup with options to proceed with signup

        lp.clickProfileButton();
        lp.clickSignupButton();
        logger.info("landed on login page");

//continue with google

        logp.gButtonClick();

//clicking the account in a popup window

        logp.authorizeWithGoogle();
        logger.info("authorized the google account");

//enter profile
// 4. User should able to view the options in the user profile

        ul.profileImgClick();
        softassert.assertTrue(ul.optionsList() > 1);
        logger.info("there are options in the list");

        softassert.assertAll();
        logger.info("Completed FWA_090_1");
    }


    @Test(priority = 3)
    public void FWA_090_2() throws IOException, InterruptedException {

        logger.info("Started FWA_090_2");

        LandingPage lp = new LandingPage(driver);
        LoginPage logp = new LoginPage(driver);
        UserLanding ul = new UserLanding(driver);
        SoftAssert softassert = new SoftAssert();

        lp.enterZipcode();
        lp.submitZipCode();
        logger.info("zipcode is accepted");

//click profile image in order to get popup with options to proceed with signup

        lp.clickProfileButton();
        lp.clickSignupButton();
        logger.info("landed on login page");

//continue with google

        logp.gButtonClick();

//clicking the account in a popup window

        logp.authorizeWithGoogle();
        logger.info("authorized the google account");
        ul.profileImgClick();

//5. Upon clicking on My Account the user should be able to view the My account page
        ul.getInAccount();

        softassert.assertTrue(ul.titleText().contains("Account Details"),
                "User landed to the page other then profile, title is : " + ul.titleText());

        softassert.assertAll();
        logger.info("Upon clicking on My Account the user landed on My account page");

        logger.info("Completed FWA_090_2");
    }

    @Test(priority = 4)
    public void FWA_090_3() throws IOException, InterruptedException {

        logger.info("Started FWA_090_3");

        LandingPage lp = new LandingPage(driver);
        LoginPage logp = new LoginPage(driver);
        UserLanding ul = new UserLanding(driver);
        SoftAssert softassert = new SoftAssert();

        lp.enterZipcode();
        lp.submitZipCode();
        logger.info("zipcode is accepted");

//click profile image in order to get popup with options to proceed with signup

        lp.clickProfileButton();
        lp.clickSignupButton();
        logger.info("landed on login page");

//continue with google

        logp.gButtonClick();

//clicking the account in a popup window

        logp.authorizeWithGoogle();
        logger.info("authorized the google account");
        ul.profileImgClick();
        ul.getInAccount();

//6. Verify whether Firstname, Last name, EmaiId, phone number (optional) is autofilled.

        softassert.assertTrue(ul.checkName(), "First name autofilled wrong, name is : " + ul.username());
        softassert.assertTrue(ul.checkLastName(), "Last name autofilled wrong, lastname is : " + ul.userLastname());
        softassert.assertTrue(ul.checkEmail(), "Email autofilled wrong, email is : " + ul.userEmail());
        softassert.assertFalse(ul.checkPhone(), "Phone is not autofilled");

        softassert.assertAll();
        logger.info("Completed FWA_090_3");
    }

    @Test(priority = 5)
    public void FWA_090_4() throws IOException, InterruptedException {

        logger.info("Started FWA_090_4");

        LandingPage lp = new LandingPage(driver);
        LoginPage logp = new LoginPage(driver);
        UserLanding ul = new UserLanding(driver);
        SoftAssert softassert = new SoftAssert();

        lp.enterZipcode();
        lp.submitZipCode();
        logger.info("zipcode is accepted");

//click profile image in order to get popup with options to proceed with signup

        lp.clickProfileButton();
        lp.clickSignupButton();
        logger.info("landed on login page");

//continue with google

        logp.gButtonClick();

//clicking the account in a popup window

        logp.authorizeWithGoogle();
        logger.info("authorized the google account");
        ul.profileImgClick();
        ul.getInAccount();
        logger.info("entered the account");

//6. The user details should be seen autofilled / Edit / save
//7. Upon clicking save, profile should be updated.
        String lastname = ul.userLastname();
        logger.info("Lastname was : " + lastname);

//editing lastname
        ul.editBtnClick();
        ul.editLastName();
        ul.saveBtnClick();

        Thread.sleep(10000);
        logger.info("edited personal info");

        driver.navigate().refresh();


        softassert.assertNotEquals(lastname, ul.userLastname());


        softassert.assertAll();
        logger.info("Completed FWA_090_4");


    }

}


