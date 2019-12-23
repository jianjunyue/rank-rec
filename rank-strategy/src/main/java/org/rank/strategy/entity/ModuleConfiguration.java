package org.rank.strategy.entity;

import java.util.List;

import org.rank.strategy.face.IRankInsert;
import org.rank.strategy.face.IRankPhase;
import org.rank.strategy.face.IRankWeight;

import com.google.common.collect.Lists;

/**
 * 业务策略和算法策略任务
 */
public class ModuleConfiguration {

	private List<IRankPhase> shopPhaseList = Lists.newArrayList();
	private List<IRankWeight> shopWeightList = Lists.newArrayList();
	private List<IRankInsert> shopInsertList = Lists.newArrayList();

	public List<IRankPhase> getShopPhaseList(){ return shopPhaseList; }

	public void setShopPhaseList(List<IRankPhase> shopPhaseList){ this.shopPhaseList = shopPhaseList; }

	public List<IRankWeight> getShopWeightList(){ return shopWeightList; }

	public void setShopWeightList(List<IRankWeight> shopWeightList){ this.shopWeightList = shopWeightList; }

	public List<IRankInsert> getShopInsertList(){ return shopInsertList; }

	public void setShopInsertList(List<IRankInsert> shopInsertList){ this.shopInsertList = shopInsertList; }

}
