package org.fb.test.qa;

import org.apache.logging.log4j.Logger;
import org.fb.base.qa.BaseTest;
import org.fb.utils.qa.LogUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.fb.test.qa.LoginTest;

@Listeners(org.fb.listeners.qa.TestListener.class)
public class LoginTest extends BaseTest {

	//Logger log = LogUtil.getLogger(LoginTest.class);

	//String result = "PASS";

	@BeforeMethod
	public void setUp() {
		initialization();
		getDriver().get("https://www.flipkart.com");
	}

	@Test
	public void verifyTitle() {
		try {
			/*
			 * log.info("Browser is launching and URL Loading"); log.fatal("Fatal Ignored");
			 * log.warn("dghsdfjdsfb"); log.debug("sgauhdsga"); log.info("dbsjdfs");
			 */
	
			Assert.assertTrue(getDriver().getTitle().contains("Fa333cebook"));
		
		
		} catch (Exception e) {

			/*
			 * result = "Failed"; log.error("Test Got Failed- " + e.getMessage(), e);
			 */	}
		//log.info("The final result is " + result);
	}

	@AfterTest
	public void tearDown() {
		BaseTest.getDriver().quit();
	}
}
