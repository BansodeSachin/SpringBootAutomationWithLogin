package com.crm.automation.pageobjects.modules.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	public WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a[href*='sign_in']")
	private WebElement signin;
	
	@FindBy(how = How.CSS, using = ".text-center>h2")
	private WebElement title;
	
	@FindBy(how = How.CSS, using = ".nav.navbar-nav.navbar-right>li>a")
	private WebElement navBar;
	
	@FindBy(how = How.XPATH, using = "//button[text()='NO THANKS']")
	private WebElement popup;
	
	@FindBy(how = How.XPATH, using = "//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement submit;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogin() {
		return signin;
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getNavigationBar() {
		return navBar;
	}
	
	public WebElement getPopUp() {
		return popup;
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
	
	public WebElement getSubmitButton() {
		return submit;
	}
}
