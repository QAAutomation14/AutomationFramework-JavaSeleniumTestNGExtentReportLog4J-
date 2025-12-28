package org.fb.test.qa;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.fb.base.qa.BaseTestFB;
import org.fb.pages.qa.FBLoginPage;
import org.fb.utils.qa.ExcelReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FBLoginTestDataDriven extends BaseTestFB {

	FBLoginPage fblp;

	FBLoginTestDataDriven() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		BaseTestFB.initialization();
		fblp = new FBLoginPage();
	}

	@Test(dataProvider = "getData")
	public void TC001_ValidLogin(String un, String pwd) {
		fblp.login(un, pwd);
	}
	
	@Test
	public void TC002_ValidLogin() {
		fblp.login("Abc", "Abc2");
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {

		Object[][] obj = ExcelReader.getExcelData("FBTestData");

		return obj;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
