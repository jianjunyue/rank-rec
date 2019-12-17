package org.rank.strategy;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.google.common.reflect.*;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.rank.strategy.context.RankContext;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;

public class XMLTest {

	public static void main(String[] args) throws ConfigurationException {
		String path = "strategy/strategy.xml";
		Map<String, Collection<String>> list = getStrategyChain(path);
		list.forEach((k, v) -> {
			v.forEach(value -> {
				System.out.println(String.format("k:%s , value:%s", k, value));
				try { 
					IRankCouponPhase phase = (IRankCouponPhase)Class.forName(value).newInstance();
					phase.execute(null);
//					MethodUtils.invokeMethod(p,)
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		});
	}

	public static Map<String, Collection<String>> getStrategyChain(String path) {
		ArrayListMultimap<String, String> multiStrategy = ArrayListMultimap.create();
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			URL url = cl.getResource(path);
			Configurations configs = new Configurations();
			XMLConfiguration xmlConfig = configs.xml(url);

			Document document = xmlConfig.getDocument();
			NodeList fieldList = document.getElementsByTagName("list");
			for (int i = 0; i < fieldList.getLength(); i++) {
				Node node = fieldList.item(i);
				NamedNodeMap attributes = node.getAttributes();
				Node strategyTypeNode = attributes.getNamedItem("interface");
				Node rootClassPathNode = attributes.getNamedItem("classpath");
				if (strategyTypeNode != null) {
					String strategyType = strategyTypeNode.getNodeValue();
					if (!StringUtils.isEmpty(strategyType)) {
						String rootClassPath = "";
						if (rootClassPathNode != null) {
							rootClassPath = rootClassPathNode.getNodeValue();
						}
						getStrategyNode(multiStrategy, node, strategyType, rootClassPath);
					}
				}
			}
		} catch (Exception ex) {

		}
		return multiStrategy.asMap();
	}

	private static void getStrategyNode(ArrayListMultimap<String, String> multiStrategy, Node node, String strategyType,
			String rootClassPath) {
		try {
			NodeList childNodeList = node.getChildNodes();
			for (int j = 0; j < childNodeList.getLength(); j++) {
				String strategyName;
				Node childNode = childNodeList.item(j);
				NamedNodeMap childAttributes = childNode.getAttributes();
				if (childAttributes != null) {
					Node strategyNameNode = childAttributes.getNamedItem("name");
					if (strategyNameNode != null) {
						strategyName = strategyNameNode.getNodeValue();
						Node classPathNode = childAttributes.getNamedItem("classpath");
						if (classPathNode != null) {
							strategyName = classPathNode.getNodeValue() + "." + strategyName;
						} else {
							strategyName = rootClassPath + "." + strategyName;
						}
						multiStrategy.put(strategyType, strategyName);
					}
				}
			}
		} catch (Exception ex) {

		}
	}

}
