package org.rank.strategy.context;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.rank.data.item.ItemInfo;
import org.rank.strategy.context.request.RankRequest;
import org.rank.strategy.entity.StrategyModule;
import org.rank.strategy.entity.ModuleConfiguration; 

public class RankContext extends BaseContext{ 

	/**
     * 原始粗排召回shop列表
     */
	private List<ItemInfo> itemInfoList;
	 
	public List<ItemInfo> getItemInfoList(){ return itemInfoList; }

	public void setItemInfoList(List<ItemInfo> itemInfoList){ this.itemInfoList = itemInfoList; }

	public ItemInfo[] getItemInfos(){ return itemInfos; }

	public void setItemInfos(ItemInfo[] itemInfos){ this.itemInfos = itemInfos; }

	private ItemInfo[] itemInfos;
     
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
     * 提交召回请求，异步获取返回结果
     * */
    private CompletableFuture<List<ItemInfo>> asyncFuture;

    public CompletableFuture<List<ItemInfo>> getAsyncFuture(){ return asyncFuture; }

	public void setAsyncFuture(CompletableFuture<List<ItemInfo>> asyncFuture){ this.asyncFuture = asyncFuture; }

	/**
     * 用户数据
     */
    private Map<String, Object> userProfileMap;
 

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
