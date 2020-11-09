package com.crm.automation.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private Map<String, Object> scenarioContext;
	
	public ScenarioContext() {
		this.scenarioContext = new HashMap<>();
	}

	public Map<String, Object> getScenarioContext() {
		return scenarioContext;
	}

	public void setScenarioContext(Map<String, Object> scenarioContext) {
		this.scenarioContext = scenarioContext;
	}
	
	public boolean isContains(String key) {
		return scenarioContext.containsKey(key);
	}
}
