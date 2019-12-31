package org.rank.strategy.manager;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.rank.base.util.JsonUtils;
import org.rank.data.item.ItemInfo;
import org.rank.data.search.ItemSearchService;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.context.request.RankRequest;
import org.rank.strategy.context.util.RankContextUtils;
import org.rank.strategy.flow.RankManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestManager {

	private static Logger logger = LoggerFactory.getLogger(TestManager.class);
	public static void main(String[] args)  
	{

		CompletableFuture<List<ItemInfo>> asyncFuture =ItemSearchService.asyncSearch(null); 
		RankContextUtils utils=new RankContextUtils();
		RankContext rankContext=utils.getRankContext(new RankRequest());
		rankContext.setAsyncFuture(asyncFuture);
		RankManager manager=new RankManager();
		manager.run(rankContext);
		logger.warn("TestManager warn");
		logger.info("TestManager info");
		logger.error("TestManager error");
		logger.trace("TestManager trace");
		System.out.println(JsonUtils.toJSONString(rankContext));
	}
}
