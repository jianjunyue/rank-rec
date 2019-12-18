package org.rank.strategy.common;

import java.util.Map;

import org.rank.strategy.entity.StrategyModule;

import com.google.common.collect.Maps;

public class StrategyConfUtils {

	private static Map<String, String> strategyMap = Maps.newHashMap();

	public static String getStrategyConfPath(StrategyModule module) {
		return strategyMap.get(module.getModuleName());
	}

	static {
		strategyMap.put("home", "strategy.xml");
		strategyMap.put("channel", "strategy.xml");
	}

}
