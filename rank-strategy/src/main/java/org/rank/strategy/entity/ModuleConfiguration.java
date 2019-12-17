package org.rank.strategy.entity;

import java.util.List;
import java.util.Map;

import org.rank.strategy.shop.face.IShopInsert;
import org.rank.strategy.shop.face.IShopPhase;
import org.rank.strategy.shop.face.IShopWeight;

/**
* 非业务策略和算法策略任务
*/
public class ModuleConfiguration {

	private Module module;

    private Map<String, String> parameters;

    private List<IShopPhase> shopPhaseList;
    private List<IShopWeight> shopWeightList;
    private List<IShopInsert> shopInsertList;
    private List<String> rankStrategyList;
    
    public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public List<IShopPhase> getShopPhaseList() {
		return shopPhaseList;
	}

	public void setShopPhaseList(List<IShopPhase> shopPhaseList) {
		this.shopPhaseList = shopPhaseList;
	}

	public List<IShopWeight> getShopWeightList() {
		return shopWeightList;
	}

	public void setShopWeightList(List<IShopWeight> shopWeightList) {
		this.shopWeightList = shopWeightList;
	}

	public List<IShopInsert> getShopInsertList() {
		return shopInsertList;
	}

	public void setShopInsertList(List<IShopInsert> shopInsertList) {
		this.shopInsertList = shopInsertList;
	}

	public List<String> getRankStrategyList() {
		return rankStrategyList;
	}

	public void setRankStrategyList(List<String> rankStrategyList) {
		this.rankStrategyList = rankStrategyList;
	}

}
