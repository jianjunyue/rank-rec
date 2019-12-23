package org.rank.strategy.manager;

import org.rank.base.util.JsonUtils;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.context.request.RankRequest;
import org.rank.strategy.context.util.RankContextUtils;
import org.rank.strategy.flow.RankManager;

public class TestManager {
	public static void main(String[] args)
	{
		RankContextUtils utils=new RankContextUtils();
		RankContext rankContext=utils.getRankContext(new RankRequest());
		RankManager manager=new RankManager();
		manager.run(rankContext);
		
		System.out.println(JsonUtils.toJSONString(rankContext));
	}
}
