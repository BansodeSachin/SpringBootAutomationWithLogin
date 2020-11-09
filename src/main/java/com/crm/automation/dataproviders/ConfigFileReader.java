package com.crm.automation.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.crm.automation.enums.DriverType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath="configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at: " + propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!=null)
			return driverPath;
		else
			throw new RuntimeException("Driver Path not specified in the configuration.properties file for the key: driverPath");
	}
	
	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " into Long");
			}
		}
		return 30;
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("Application URL not specified in the configuration.properties file for the key:url");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) 
			return DriverType.CHROME;
		else if(browserName.equals("firefox"))
			return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer"))
			return DriverType.INTERNET_EXPLORER;
		else 
			throw new RuntimeException("Browser Name Key value in configuration.properties is not matched : " + browserName);
		
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaxSize");
		if(windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}
}
