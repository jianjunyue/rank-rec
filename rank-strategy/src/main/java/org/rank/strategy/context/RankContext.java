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

    public List<ShopInfo> getShopInfoList(){ return shopInfoList; }

	public void setShopInfoList(List<ShopInfo> shopInfoList){ this.shopInfoList = shopInfoList; }

	public ShopInfo[] getShopInfos(){ return ShopInfos; }

	public void setShopInfos(ShopInfo[] shopInfos){ ShopInfos = shopInfos; }

	public ModuleConfiguration getStrategyConf(){ return strategyConf; }

	public void setStrategyConf(ModuleConfiguration strategyConf){ this.strategyConf = strategyConf; }

	public RankRequest getRankRequest(){ return rankRequest; }

	public void setRankRequest(RankRequest rankRequest){ this.rankRequest = rankRequest; }

	public StrategyModule getModule(){ return module; }

	public void setModule(StrategyModule module){ this.module = module; }

	public Map getUserProfile(){ return userProfile; }

	public void setUserProfile(Map userProfile){ this.userProfile = userProfile; }

	public Map<String, Object> getUserProfileMap(){ return userProfileMap; }

	public void setUserProfileMap(Map<String, Object> userProfileMap){ this.userProfileMap = userProfileMap; }

}
