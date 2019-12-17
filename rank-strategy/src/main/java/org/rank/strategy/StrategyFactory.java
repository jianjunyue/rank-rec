package org.rank.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class StrategyFactory  implements ApplicationContextAware{

    private ApplicationContext applicationContext = null;
    
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 this.applicationContext = applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> buildRankStrategyList(List<String> rankStrategyList, Class<T> clazz) {
        return rankStrategyList.stream()
                .map(rs -> (T) applicationContext.getBean(rs))
                .filter(bean -> clazz.isAssignableFrom(bean.getClass()))
                .collect(Collectors.toList());
    }

}
