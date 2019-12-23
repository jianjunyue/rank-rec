package org.rank.strategy;

import java.util.List;

import org.rank.strategy.common.StrategyConfBuilder;
import org.rank.strategy.entity.ModuleConfiguration;
import org.rank.strategy.face.IRankPhase;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {

		String path = "strategy/strategy.xml"; 
		StrategyConfBuilder builder=new StrategyConfBuilder();
		ModuleConfiguration moduleConf = builder.build(path);

		List<IRankPhase> strategyList = moduleConf.getShopPhaseList();
		strategyList.forEach(action -> action.execute(null));
		
		
		UserRealTimeIntent d=SpringContextUtil.getBean(UserRealTimeIntent.class);
		d.extendUserIntent();
	}

}
