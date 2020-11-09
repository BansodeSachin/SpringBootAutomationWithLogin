package com.crm.automation.pageobjects.modules.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerHomePage {

	public WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a[href*='sign_in']")
	private WebElement signin;
	
	@FindBy(how = How.CSS, using = ".text-center>h2")
	private WebElement title;
	
	@FindBy(how = How.CSS, using = ".nav.navbar-nav.navbar-right>li>a")
	private WebElement navBar;
	
	@FindBy(how = How.XPATH, using = "//button[text()='NO THANKS']")
	private WebElement popup;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Add Customer']")
	private WebElement addButton;
	
	
	public CustomerHomePage(WebDriver driver) {
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
	
	public WebElement getUpdateLink(int customerId) {
		
		By updateLink = By.xpath("//a[contains(@href,'showFormForUpdate') and contains(@href,'customerId="+customerId+"')]");
		
		return driver.findElement(updateLink);
	}
	
	public WebElement getDeleteLink(int customerId) {
		
		By deleteLink = By.xpath("//a[contains(@href,'delete') and contains(@href,'customerId="+customerId+"')]");
		
		return driver.findElement(deleteLink);
	}
	
	public WebElement getAddButton() {
		return addButton;
	}
}
