package org.rank.strategy.common;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.rank.strategy.entity.ModuleConfiguration;
import org.rank.strategy.entity.StrategyModule;

import com.google.common.collect.Maps;

/**
 * 策略模型执行
 */
public class StrategyManager {

	private static Map<String, ModuleConfiguration> moduleStrategyMap = Maps.newHashMap();

	private void init() {
		StrategyConfBuilder builder = new StrategyConfBuilder();
		for (StrategyModule module : StrategyModule.values()) {
			String confPath = StrategyConfUtils.getStrategyConfPath(module);
			if (!StringUtils.isEmpty(confPath)) {
				ModuleConfiguration moduleConf = builder.build(confPath);
				if (moduleConf != null) {
					moduleStrategyMap.put(module.getModuleName(), moduleConf);
				}
			}
		}
	}
	
//	public 

}
