package com.testCases;

import com.base.BaseClass;
import com.pageObjects.LandingPage;
import com.pageObjects.LoginPage;
import com.pageObjects.Order;
import com.pageObjects.UserLanding;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class roughTestSpace extends BaseClass {


    @Test(priority = 1)
    public void soups4Karanveer() throws IOException, InterruptedException {

                LandingPage lp = new LandingPage(driver);
        LoginPage logp = new LoginPage(driver);
        UserLanding ul = new UserLanding(driver);
        Order o = new Order(driver);

        SoftAssert softassert = new SoftAssert();

        lp.enterZipcode();
        lp.submitZipCode();
        logger.info("zipcode is accepted");


        o.clickOrder();
        logger.info("click order");

        o.chooseSoup();

        logger.info("choose soup");

        Thread.sleep(3000);

        o.clickPlus();

        logger.info("click plus");

        Thread.sleep(3000);


        softassert.assertEquals(o.amount(), "2");
        logger.info("amount of items after clicking plus is " + o.amount() +  " as expected" );

        softassert.assertAll();




//
//    @Test(priority = 2)
//    public void testt() throws IOException, InterruptedException {
//
//

//
//        lp.enterZipcode();
//        lp.submitZipCode();
//        logger.info("zipcode is accepted");
//
////click profile image in order to get popup with options to proceed with signup
//
//        lp.clickProfileButton();
//        lp.clickSignupButton();
//        logger.info("landed on login page");
//
////continue with google
//
//        logp.gButtonClick();
//
////clicking the account in a popup window
//
//        logp.authorizeWithGoogle();
//        logger.info("authorized the google account");








//        String path = "C:\\Users\\Roman Yarmolenko\\IdeaProjects\\FreshiiTest\\src\\test\\java\\com\\inputs\\logpass.xlsx";
//        String email =
//                XLUtils.getCellData
//                        (path, "logpass", 0, 0);
//        String pass = XLUtils.getCellData
//                (path, "logpass", 0, 1);
//
//        System.out.println(email + pass);

                }
            }
