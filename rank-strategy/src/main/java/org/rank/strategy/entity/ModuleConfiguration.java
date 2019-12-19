package org.rank.strategy.entity;

import java.util.List;

import org.rank.strategy.shop.face.IShopInsert;
import org.rank.strategy.shop.face.IShopPhase;
import org.rank.strategy.shop.face.IShopWeight;

import com.google.common.collect.Lists;

/**
 * 业务策略和算法策略任务
 */
public class ModuleConfiguration {

	private List<IShopPhase> shopPhaseList = Lists.newArrayList();
	private List<IShopWeight> shopWeightList = Lists.newArrayList();
	private List<IShopInsert> shopInsertList = Lists.newArrayList();

	public List<IShopPhase> getShopPhaseList(){ return shopPhaseList; }

	public void setShopPhaseList(List<IShopPhase> shopPhaseList){ this.shopPhaseList = shopPhaseList; }

	public List<IShopWeight> getShopWeightList(){ return shopWeightList; }

	public void setShopWeightList(List<IShopWeight> shopWeightList){ this.shopWeightList = shopWeightList; }

	public List<IShopInsert> getShopInsertList(){ return shopInsertList; }

	public void setShopInsertList(List<IShopInsert> shopInsertList){ this.shopInsertList = shopInsertList; }

}
