package org.fb.pages.qa;

import org.fb.base.qa.BaseTest;
import org.fb.base.qa.BaseTestFB;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage extends BaseTestFB {

	public FBLoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	static private WebElement userName;

	@FindBy(id = "pass")
	static private WebElement password;

	@FindBy(name = "login")
	static private WebElement loginBtn;

	public void login(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}
