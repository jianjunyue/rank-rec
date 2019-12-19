package org.rank.strategy.entity;

/**
 * 控制排序策略和算法模型
 * */
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
