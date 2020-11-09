package com.crm.automation.pageobjects.modules.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@name='userName']")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//input[@name='matchingPassword']")
	private WebElement confirmPassword;
	
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(how = How.XPATH, using = "//select[@name='formRole']")
	private WebElement roleDropdown;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement registerButton;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getRoleDropdown() {
		return roleDropdown;
	}
	
	public WebElement getRegisterButton() {
		return registerButton;
	}
}
