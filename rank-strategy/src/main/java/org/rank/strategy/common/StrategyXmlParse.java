package org.rank.strategy.common;

import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.ArrayListMultimap;

public class StrategyXmlParse {
	public Map<String, Collection<String>> getStrategyChain(String path) {
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

	private void getStrategyNode(ArrayListMultimap<String, String> multiStrategy, Node node, String strategyType,
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
