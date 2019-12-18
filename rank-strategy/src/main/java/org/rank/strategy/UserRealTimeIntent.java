package org.rank.strategy;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class UserRealTimeIntent {


    @PostConstruct
    private void init() {
    	
    }
    public Map<String, Float> extendUserIntent() { 
    	System.out.println("extendUserIntent");
        return null;
    }
}
