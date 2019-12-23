package org.rank.strategy.flow;

import java.util.Comparator;
import java.util.List;

import org.rank.data.item.ItemInfo;
import org.rank.data.search.ItemSearchService;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.entity.ModuleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 召回，策略，算法模型执行流程管理控制
 */
public class RankManager {

	private static Logger logger = LoggerFactory.getLogger(RankManager.class);

	public void run(RankContext rankContext){
		try {
			List<ItemInfo> itemInfoList =ItemSearchService.search();
			rankContext.setItemInfoList(itemInfoList);
			
			ModuleConfiguration moduleConf = rankContext.getStrategyConf();

			moduleConf.getShopPhaseList().stream().forEach(action -> action.execute(rankContext));
			moduleConf.getShopWeightList().stream().forEach(action -> action.doWeight(rankContext));
			moduleConf.getShopInsertList().stream().forEach(action -> action.insert(rankContext));
			
			rankContext.getItemInfoList().sort(Comparator.comparingDouble(ItemInfo::getScore).reversed());
		} catch (Exception e) {
			logger.error("RankManager run is error", e);
		}
	}
	
	

}
