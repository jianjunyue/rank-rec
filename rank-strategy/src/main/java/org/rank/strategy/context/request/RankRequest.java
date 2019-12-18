package org.rank.strategy.context.request;

import org.rank.strategy.entity.StrategyModule;

public class RankRequest  extends BaseRequest {

    private int offset;
    private int limit;
    
    private StrategyModule module;
    /**
     * 上层定义的筛选属性
     */
    private String specifiedAttributes;//特殊属性
}
