package org.rank.strategy.entity;

public enum Module {

	HOME("home"), CHANNEL("channel");

	private String moduleName;
	
	Module(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleName() {
		return moduleName;
	}
}
