package com.crm.automation.testng.listeners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.automation.util.Base;
import com.crm.automation.util.ScreenShotUtils;

public class Listeners implements ITestListener {
	
	public static final Logger LOG = LogManager.getLogger(Listeners.class.getName());
	
	private ScreenShotUtils screenshotUtils = new ScreenShotUtils();
	
	@Override
	public void onStart(ITestContext context) {
		LOG.info("Inside On Start Listener Method");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		LOG.info("Inside On Test Failure Listener Method");
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			LOG.info("Pause failure in onTestFailure Method");
		}
		String testDescriptionLine = (String)result.getTestContext().getAttribute("testDescriptionLine");
		WebDriver driver = ((Base)result.getInstance()).driver;
		try {
			screenshotUtils.getScreenshot("FAILURE_" + result.getName(), driver, testDescriptionLine);
		} catch(IOException e) {
			LOG.info("Unable to capture screenshot!");
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		LOG.info("Inside On Finish Listener Method");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		LOG.info("Inside On Test Start Listener Method");
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LOG.info("Inside On Test Failed But Within Success Percentage Listener Method");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		LOG.info("Inside On Test Skipped Listener Method");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		LOG.info("Inside On Test Success Listener Method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LOG.info("Pause failure in onTestSuccess Method");
		}
		String testDescriptionLine = (String)result.getTestContext().getAttribute("testDescriptionLine");
		WebDriver driver = ((Base)result.getInstance()).driver;
		try {
			screenshotUtils.getScreenshot("SUCCESS_" + result.getName(), driver, testDescriptionLine);
		} catch(IOException e) {
			LOG.info("Unable to capture screenshot!");
			e.printStackTrace();
		}
	}
}
