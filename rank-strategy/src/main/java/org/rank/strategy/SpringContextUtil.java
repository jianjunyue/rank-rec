package org.rank.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        if (applicationContext == null) {
            applicationContext = context;
//            AgentConfiguration.setAppId("waimai.ranking");
        }
    }

    public static Object getBean(String beanName) throws BeansException {
        return applicationContext.getBean(beanName);
    }

    public static Object getBean(String beanName, Class type) throws BeansException {
        return applicationContext.getBean(beanName, type);
    }

    public static <T> T getBean(Class<T> clssz) {
        return applicationContext.getBean(clssz);
    }

    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

    public static boolean isSingleton(String beanName) {
        return applicationContext.isSingleton(beanName);
    }
}