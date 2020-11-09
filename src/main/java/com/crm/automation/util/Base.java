package com.crm.automation.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.crm.automation.pageobjects.modules.crm.CustomerHomePage;
import com.crm.automation.service.TestService;

public class Base {

	protected static final Configuration CONF = new Configuration();
	public static final TestService service = new TestService();
	public WebDriver driver;
	public XWPFDocument docx;
	protected CustomerHomePage customerHomePage;
	
	@BeforeTest
	public void initialize() {
		driver = service.initializeDriver();
		customerHomePage = service.loadCustomerHomePage();
	}
	
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.close();
			driver = null;
			service.clearSession();
		}
	}
	
}
