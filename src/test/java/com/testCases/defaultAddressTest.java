package com.testCases;

import java.io.IOException;

import com.pageObjects.LandingPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;

public class defaultAddressTest extends BaseClass {
	
	@Test(priority=1)
	public void defaultAddressTest() throws IOException
	{

		logger.info("Started defaultAddressTest");
//		init pages and methods for further testing
		LandingPage lp = new LandingPage(driver);
		SoftAssert softassert = new SoftAssert();

		softassert.assertTrue(lp.addressDefaulted(), "Test Failed! Address should be defaulted to Rosedale, " +
				"but is defaulted to : '" + lp.address() + "'" );

		softassert.assertAll();
		logger.info("Completed defaultAddressTest");
		
	}
	
	

}
