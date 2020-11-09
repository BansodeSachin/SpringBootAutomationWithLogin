package com.crm.automation.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.crm.automation.pageobjects.modules.crm.CustomerHomePage;
import com.crm.automation.pageobjects.modules.login.LoginPage;
import com.crm.automation.util.Configuration;

public class TestService {

	public static final Configuration CONF = new Configuration();
	public WebDriver driver;
	public Properties prop;
	protected CustomerHomePage customerHomePage;
	
	public WebDriver initializeDriver() {
		loadDriver();
		loadCustomerHomePage();
		return driver;
	}
	
	public void loadDriver() {
		prop = new Properties();
		InputStream inputStream;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("data.properties");
			prop.load(inputStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			String driverPath = "src/test/resources/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			
			driver = new ChromeDriver();
			
		} else if(browserName.equals("iexplorer")) {
			String driverPath = "src/test/resources/IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", driverPath);
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
			caps.setCapability("requireWindowFocus", false);
			caps.setCapability("nativeEvents", "accept");
			caps.setCapability("unExpectedAlertBehaviour", true);
			caps.setCapability("disable-popup-blocking", true);
			caps.setCapability("enablePersistentHover", true);
			caps.setCapability("ignoreZoomSetting", true);
			
			String baseTempPath = new File("src/test/resources").getAbsolutePath();
			File ie_tmp = new File(baseTempPath + "/selenium/IEDriverTemp");
			ie_tmp.mkdir();
			
			InternetExplorerDriverService.Builder ies = new InternetExplorerDriverService.Builder();
			ies.withExtractPath(ie_tmp);
			InternetExplorerDriverService service = ies.build();
			
			driver = new InternetExplorerDriver(service, caps);
			
		} else if(browserName.equals("firefox")) {
			String driverPath = "src/test/resources/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			
			driver = new FirefoxDriver();
			
		} else if(browserName.equals("msedge")) {
			String driverPath = "src/test/resources/EdgeDriver.exe";
			System.setProperty("webdriver.edge.driver", driverPath);
			
			driver = new EdgeDriver();
			
		} else if(browserName.equals("opera")) {
			String driverPath = "src/test/resources/OperaDriver.exe";
			System.setProperty("webdriver.opera.driver", driverPath);
			
			driver = new OperaDriver();
			
		}
	}
	
	public CustomerHomePage loadCustomerHomePage() {
		this.customerHomePage = new CustomerHomePage(driver);
		return this.customerHomePage;
	}
	
	public void navigateToHomePage() {
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(CONF.getUserName());
		lp.getPassword().sendKeys(CONF.getPassword());
		lp.getLoginButton().click();
	}
	
	public void clearSession() {
		final String killCommand = "taskkill /T /F /IM ";
		String processName = "IEDriverServer.exe";
		try {
			Runtime.getRuntime().exec(killCommand + processName);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
