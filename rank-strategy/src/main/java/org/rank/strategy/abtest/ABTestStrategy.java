package org.rank.strategy.abtest;
 
import org.rank.strategy.entity.StrategyModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class ABTestStrategy {

	private static Logger logger = LoggerFactory.getLogger(ABTestStrategy.class);

    private static final String APP_ID = "rank";
    
    public static ABInfo get(String deviceId, int cityId, StrategyModule module) {
    	return new ABInfo(Maps.newHashMap());
    }
    

}
