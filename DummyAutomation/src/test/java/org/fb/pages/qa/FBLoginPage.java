package org.fb.pages.qa;

import org.fb.base.qa.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage extends BaseTest {

	public FBLoginPage() {

		PageFactory.initElements(BaseTest.getDriver(), this);
	}

	@FindBy(id = "email")
	private WebElement userName;

	@FindBy(id = "pass")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginBtn;

	public void login(String un, String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}
