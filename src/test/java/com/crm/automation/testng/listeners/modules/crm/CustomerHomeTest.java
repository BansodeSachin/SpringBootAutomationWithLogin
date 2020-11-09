package com.crm.automation.testng.listeners.modules.crm;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.crm.automation.util.Base;

public class CustomerHomeTest extends Base {
	
	@Test
	public void testCustomerHomePage(ITestContext context) {
	
		context.setAttribute("testDescriptionLine", "Login with User -> Verify Customer Home Page is visible:");
		
		service.navigateToHomePage();
	}
}
