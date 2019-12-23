package org.rank.strategy.common;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.rank.strategy.entity.ModuleConfiguration;
import org.rank.strategy.face.IRankInsert;
import org.rank.strategy.face.IRankPhase;
import org.rank.strategy.face.IRankWeight;

public class StrategyConfBuilder {

	public ModuleConfiguration build(String confPath) {
		ModuleConfiguration moduleConf = new ModuleConfiguration();
		try {
			StrategyXmlParse xmlParse = new StrategyXmlParse();
			Map<String, Collection<String>> multiStrategy = xmlParse.getStrategyChain(confPath);

			multiStrategy.keySet().forEach(key -> {
				List<String> strategys=(List) multiStrategy.get(key);
				getStrategys(key,strategys , moduleConf);
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return moduleConf;
	}

	private void getStrategys(String key, List<String> strategys, ModuleConfiguration moduleConf) {
		try {
		switch (key) {
		case "phase":
			List<IRankPhase> shopPhaseList = buildRankStrategyList(strategys, IRankPhase.class);
			moduleConf.setShopPhaseList(shopPhaseList);
			break;
		case "weight":
			List<IRankWeight> shopWeightList = buildRankStrategyList(strategys, IRankWeight.class);
			moduleConf.setShopWeightList(shopWeightList);
			break;
		case "insert":
			List<IRankInsert> shopInsertList = buildRankStrategyList(strategys, IRankInsert.class);
			moduleConf.setShopInsertList(shopInsertList);
			break;
		default:
			break;
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private <T> List<T> buildRankStrategyList(List<String> rankStrategyList, Class<T> clazz) {
		List<T> strategyList = null;

		strategyList = rankStrategyList.stream().map(rs -> loadClass(rs, clazz)).filter(f -> f != null)
				.filter(bean -> clazz.isAssignableFrom(bean.getClass())).collect(Collectors.toList());

		return strategyList;
	}

	private <T> T loadClass(String className, Class<T> clazz) {
		try {
			Class<?> classAvailable = ClassLoader.getSystemClassLoader().loadClass(className);
			if (classAvailable != null) {
				T t = (T) classAvailable.newInstance();
				return t;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
