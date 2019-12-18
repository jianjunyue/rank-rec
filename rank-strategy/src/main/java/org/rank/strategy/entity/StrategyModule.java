package org.rank.strategy.entity;

public enum StrategyModule {

	HOME("home"), CHANNEL("channel");

	private String moduleName;

	StrategyModule(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleName() {
		return moduleName;
	}

}
