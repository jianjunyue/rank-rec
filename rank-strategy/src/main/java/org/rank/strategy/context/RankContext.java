package org.rank.strategy.context;

import java.util.List;
import java.util.Map;

import org.rank.strategy.context.request.RankRequest;
import org.rank.strategy.entity.StrategyModule;
import org.rank.strategy.entity.ModuleConfiguration;
import org.rank.strategy.entity.ShopInfo;

public class RankContext extends BaseContext{

    /**
     * 原始粗排召回shop列表
     */
	private List<ShopInfo> shopInfoList;
	 
    private ShopInfo[] ShopInfos;
     
    /**
     * 策略链
     */
    private ModuleConfiguration strategyConf;

    /**
     * 请求体
     */
    private RankRequest rankRequest;
    /**
     * 排序模块
     */
    private StrategyModule module;
    
    private Map userProfile;

    /**
     * 用户数据
     */
    private Map<String, Object> userProfileMap;
}
