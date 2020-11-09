package com.crm.automation.testng.listeners.modules.crm;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.crm.automation.pageobjects.modules.crm.CustomerHomePage;
import com.crm.automation.util.Base;

public class AddCustomerTest extends Base {

	@Test
	public void testCustomerHomePage(ITestContext context) {
	
		context.setAttribute("testDescriptionLine", "Login with User -> Click on Add Customer Button -> Verify Add Customer Page");
		
		service.navigateToHomePage();
		
		CustomerHomePage customerHomePage = new CustomerHomePage(driver);
		
		customerHomePage.getAddButton().click();
		
		
	}
}
