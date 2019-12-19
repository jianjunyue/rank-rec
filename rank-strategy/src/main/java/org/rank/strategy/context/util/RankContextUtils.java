package org.rank.strategy.context.util;

import org.apache.commons.lang3.StringUtils;
import org.rank.strategy.abtest.ABTestStrategy;
import org.rank.strategy.common.StrategyManager;
import org.rank.strategy.common.UUIDUtils;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.context.request.RankRequest;
import org.rank.strategy.entity.StrategyModule;

public class RankContextUtils {
	
	public RankContext getRankContext(RankRequest rankRequest) {
		RankContext context=new RankContext();
		context.setRankRequest(rankRequest);
		context.setModule(getModule(rankRequest));
		context.setStrategyConf(StrategyManager.getInstance().getModuleConf(context.getModule()));
		context.setAbInfo(ABTestStrategy.get(rankRequest.getDeviceId(), rankRequest.getCityId(), context.getModule()));
		String rankId =StringUtils.isEmpty(rankRequest.getRankId())?UUIDUtils.generateUUID():rankRequest.getRankId();
		context.setRankId(rankId);
		return context;
	}

	private StrategyModule getModule(RankRequest request){
		StrategyModule module = StrategyModule.HOME;
		if ("home".equals(request.getFromPage())) {
			module = StrategyModule.HOME;
		}
		else if ("channel".equals(request.getFromPage())) {
			module = StrategyModule.CHANNEL;
		}

		return module;
	}

}
