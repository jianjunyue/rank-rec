package org.rank.strategy.test;

import org.rank.strategy.abtest.ABTestStrategy;
import org.rank.strategy.context.RankContext;
import org.rank.strategy.context.request.RankRequest;
import org.rank.strategy.context.util.RankContextUtils;
import org.rank.strategy.flow.RankManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModule {


	private static Logger logger = LoggerFactory.getLogger(TestModule.class);
	public static void main(String[] args){
		logger.info("teststasd");
		RankRequest rankRequest=new RankRequest();
		RankContextUtils util= new RankContextUtils();
		RankContext rankContext=util.getRankContext(rankRequest);
		RankManager manager=new RankManager();
		manager.run(rankContext);

		logger.info("end");
	}

}
