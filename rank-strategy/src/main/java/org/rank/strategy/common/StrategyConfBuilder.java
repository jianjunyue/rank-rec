package org.rank.strategy.common;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.rank.strategy.entity.ModuleConfiguration; 
import org.rank.strategy.shop.face.IShopPhase;
import org.rank.strategy.shop.face.IShopWeight;

public class StrategyConfBuilder {

	@SuppressWarnings("unchecked")
	public static  ModuleConfiguration builder() {
		String path = "strategy/strategy.xml"; 
		StrategyXmlParse xmlParse = new StrategyXmlParse();
		Map<String, Collection<String>> multiStrategy = xmlParse.getStrategyChain(path);

		ModuleConfiguration moduleConf = new ModuleConfiguration();

		multiStrategy.keySet().forEach(key -> {
			getStrategys(key, (List) multiStrategy.get(key), moduleConf);
		});
		List<IShopPhase> strategyList = moduleConf.getShopPhaseList();
		strategyList.forEach(action -> action.execute(null));
		return moduleConf;
	}

	private static void getStrategys(String key, List<String> strategys, ModuleConfiguration moduleConf) {
		switch (key) {
		case "IShopPhase":
			List<IShopPhase> shopPhaseList = buildRankStrategyList(strategys, IShopPhase.class);
			moduleConf.setShopPhaseList(shopPhaseList);
			break;
		case "IShopWeight":
			List<IShopWeight> shopWeightList = buildRankStrategyList(strategys, IShopWeight.class);
			moduleConf.setShopWeightList(shopWeightList);
			break;
		default:
			break;
		}
	}

	private static <T> List<T> buildRankStrategyList(List<String> rankStrategyList, Class<T> clazz) {
		List<T> strategyList = null;

		strategyList = rankStrategyList.stream().map(rs -> loadClass(rs, clazz))
				.filter(bean -> clazz.isAssignableFrom(bean.getClass())).collect(Collectors.toList());

		return strategyList;
	}

	private static <T> T loadClass(String className, Class<T> clazz) {
		try {
			Class<?> classAvailable = ClassLoader.getSystemClassLoader().loadClass(className);
			if (classAvailable != null) {
				T t = (T) classAvailable.newInstance();
				;
				return t;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
