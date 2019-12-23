package org.rank.strategy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.JsonNode;

import biz.k11i.xgboost.Predictor;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		strategyJson();
//    	strategyXML();
//    	ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring/rank_flow.xml");
//    	 List<RankCouponPhase> rankCouponPhaseList = (List<RankCouponPhase>) applicationContext.getBean("couponRankPhaseList");
		System.out.println("Hello World!");
	}

	public static void strategyJson() throws IOException {

		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL resource = cl.getResource("strategy/strategy.json");
		JsonNode jsonNode = null;//ObjectMappers.INSTANCE.readTree(resource);
		Iterator<String> iterator = jsonNode.fieldNames();
		List<String> moduleStrategyList = new ArrayList<>();
		while (iterator.hasNext()) {
			String modeName = iterator.next();
			JsonNode node = jsonNode.get(modeName);
			for (JsonNode j : node) {
				String rankStrategy = j.asText();
				moduleStrategyList.add(rankStrategy);
//				System.out.println(String.format("rankStrategy:%s", rankStrategy));
			}
		}

		List<IRankCouponPhase> strategyList = buildRankStrategyList(moduleStrategyList, IRankCouponPhase.class,
				"org.rank.strategy");
		strategyList.stream().forEach(action -> action.execute(null));
	}

	public static void strategyXML() throws IOException {
		String beanName = "couponRankPhaseList";
//		String configPath = "strategy/strategy.json";
		String configPath = "spring/rank_flow.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configPath);
		ApplicationContext ctx = new FileSystemXmlApplicationContext(configPath);
		Object objBean = ctx.getBean(beanName);

		Resource resource = applicationContext.getResource("");
		File file = resource.getFile();
		JsonNode jsonNode = null;//ObjectMappers.INSTANCE.readTree(file);
		Iterator<String> iterator = jsonNode.fieldNames();
		while (iterator.hasNext()) {
			String modeName = iterator.next();
			List<String> moduleStrategyList = new ArrayList<>();
			JsonNode node = jsonNode.get(modeName);
			for (JsonNode j : node) {
				String rankStrategy = j.asText();
				moduleStrategyList.add(rankStrategy);
//				System.out.println(String.format("rankStrategy:%s", rankStrategy));
			}
		}
	}

	private static <T> List<T> buildRankStrategyList(List<String> rankStrategyList, Class<T> clazz, String pre) {
		List<T> strategyList = null;

		strategyList = rankStrategyList.stream().map(rs -> reflectClass(rs, clazz, pre))
				.filter(bean -> clazz.isAssignableFrom(bean.getClass())).collect(Collectors.toList());

		return strategyList;
	}

	private static <T> T reflectClass(String strategyClassName, Class<T> clazz, String pre) {
		try { 
			String  className=pre + "." + strategyClassName;
			Class<?> classAvailable =ClassLoader.getSystemClassLoader().loadClass(className);
			if (classAvailable != null) {
				T c = (T) Class.forName(className).newInstance();
				return c;
			}
		} catch (Exception   e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
