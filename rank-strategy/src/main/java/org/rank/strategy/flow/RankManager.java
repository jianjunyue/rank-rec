package org.rank.strategy.flow;

import org.rank.strategy.context.RankContext;
import org.rank.strategy.entity.ModuleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 召回，策略，算法模型执行控制
 */
public class RankManager {

	private static Logger logger = LoggerFactory.getLogger(RankManager.class);

	public void run(RankContext rankContext){
		try {
			ModuleConfiguration moduleConf = rankContext.getStrategyConf();

			moduleConf.getShopWeightList().stream().forEach(action -> action.doWeight(rankContext));
			moduleConf.getShopInsertList().stream().forEach(action -> action.insert(rankContext));
			moduleConf.getShopPhaseList().stream().forEach(action -> action.execute(rankContext));
		} catch (Exception e) {
			logger.error("RankManager run is error", e);
		}
	}

}
