package org.rank.strategy.common;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

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
		Properties properties = getProperties();
		for (StrategyModule module : StrategyModule.values()) {
			String confPath = properties.getProperty(module.getModuleName());
			if (!StringUtils.isEmpty(confPath)) {
				ModuleConfiguration moduleConf = builder.build(confPath);
				if (moduleConf != null) {
					moduleStrategyMap.put(module.getModuleName(), moduleConf);
				}
			}
		}
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("strategy/strategy_conf.properties"));
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return properties;
	}
	
//	public 

}
