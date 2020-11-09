package com.crm.automation.cucumber.stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crm.automation.context.ScenarioContext;
import com.crm.automation.context.TestContext;
import com.crm.automation.util.Base;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination extends Base {
	
	public static Logger log = LogManager.getLogger(LoginStepDefination.class.getName());

	private TestContext testContext;
	
	public LoginStepDefination(TestContext context) {
		testContext = context;
		testContext.scenarioContext = new ScenarioContext();
	}
	
	public LoginStepDefination() {
		
	}
	
	@Before
	public void beforeScenarios() {
		System.out.println("Cucumber Before Scenario");
	}
	
	@Given("^Initialize the browser with your browser option$")
	public void initialize_the_browser_with_your_browser_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and log in$")
	public void user_enters_and_and_log_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Verify that user successfully Logged In$")
	public void verify_that_user_successfully_Logged_In() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Take Screenshot in file \"([^\"]*)\" and Close the browser\\.$")
	public void take_Screenshot_in_file_and_Close_the_browser(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Verify that user NOT Logged In$")
	public void verify_that_user_NOT_Logged_In() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@After
	public void afterScenarios() {
		System.out.println("Cucumber After Scenario");
	}
}
