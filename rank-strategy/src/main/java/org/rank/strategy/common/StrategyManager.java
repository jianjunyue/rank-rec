package org.rank.strategy.common;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.rank.strategy.entity.ModuleConfiguration;
import org.rank.strategy.entity.StrategyModule;

import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 策略模型执行
 */
public class StrategyManager {
	private static StrategyManager strategyManager = null;

	private static Logger logger = LoggerFactory.getLogger(StrategyManager.class);
	private static Map<String, ModuleConfiguration> moduleStrategyMap = Maps.newHashMap();
	
	/**
	 * 通过请求枚举参数，获取该枚举参数配置对应的策略链
	 * */
	public ModuleConfiguration getModuleConf(StrategyModule module) {
		return moduleStrategyMap.get(module.getModuleName());
	}

	private void init(){
		try {
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
		} catch (Exception e) {
			logger.error("StrategyManager init is error", e);
		}
	}

	private Properties getProperties(){
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("strategy/strategy_conf.properties"));
		} catch (IOException e) {
			logger.error("StrategyManager getProperties is error", e);
		}
		return properties;
	}

	private StrategyManager() {}

	public static StrategyManager getInstance(){
		if (strategyManager == null) {
			synchronized (StrategyManager.class) {
				if (strategyManager == null) {
					strategyManager = new StrategyManager();
					strategyManager.init();
				}
			}
		}
		return strategyManager;
	}

}
