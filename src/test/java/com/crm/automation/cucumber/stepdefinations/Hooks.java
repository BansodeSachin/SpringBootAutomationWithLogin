package com.crm.automation.cucumber.stepdefinations;

import com.crm.automation.context.TestContext;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	
	public Hooks(TestContext context) {
		this.testContext = context;
	}
	
	public Hooks() {
		
	}
	
	@Before
	public void beforeSteps() {
		/** What all you can perform here
		 * Starting a WebDriver
		 * Setting up DB Connection
		 * Setting up test data
		 * Setting up browser cookies
		 * Navigating to certain page
		 * or anything before the test
		 */
	}
	
	@After
	public void afterSteps() {
		
	}
}
