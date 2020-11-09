package com.crm.automation.pageobjects.modules.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/register/showRegistrationForm']")
	private WebElement registerNewUserButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getRegisterNewUserButton() {
		return registerNewUserButton;
	}
}
