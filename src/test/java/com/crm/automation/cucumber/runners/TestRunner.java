package com.crm.automation.cucumber.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalFeatures",
		glue = "com.crm.automation.cucumber.stepdefinations"
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
