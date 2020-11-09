package com.crm.automation.pageobjects.modules.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPage {
	
public WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[@href='/showMyLoginPage']")
	private WebElement loginWithNewUserLink;
	
	public RegisterSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginWithNewUserLink() {
		return loginWithNewUserLink;
	}
}
