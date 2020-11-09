package com.crm.automation.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {

	private Properties prop = new Properties();
	
	private InputStream inputStream;
	
	protected Map<String, String> loginUserList = new HashMap<>();
	
	public static final String DATE_TIME_STAMP = getCurrentTimeStamp();
	
	public Configuration() {
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("data.properties");
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//loadUserLoginList(); // Used For Multiple User Login Feature
	}
	
	public String getUserName() {
		return prop.getProperty("user");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getUserRole() {
		return prop.getProperty("userrole");
	}
	
	// Uncomment this only if we need multiple user login feature.
	/*
	 * private void loadUserLoginList() { BufferedReader br = null; String line =
	 * ""; String splitBy = ",";
	 * 
	 * try { br = new BufferedReader(new
	 * FileReader(getClass().getClassLoader().getResource("loginUsers.csv").getFile(
	 * ))); } catch(FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * try { while( (line = br.readLine()) != null) { String[] values =
	 * line.split(splitBy); loginUserList.put(values[0].replaceAll("\\s", ""),
	 * values[1].replaceAll("\\s", "")); } } catch(IOException e) {
	 * e.printStackTrace(); } }
	 */
	
	private static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		Date now = new Date();
		
		return sdfDateTime.format(now);
	}
}
