package org.rank.strategy.context.request;

import java.util.Map;

import org.rank.strategy.entity.StrategyModule;

public class RankRequest  extends BaseRequest {

	private int offset;
    private int limit;
    
    private StrategyModule module;
    /**
     * 上层调用者传入的扩展参数，格式为json字符串
     */
    private Map<String,Object> extraMapParam;

    public int getOffset(){ return offset; }
	public void setOffset(int offset){ this.offset = offset; }
	public int getLimit(){ return limit; }
	public void setLimit(int limit){ this.limit = limit; }
	public StrategyModule getModule(){ return module; }
	public void setModule(StrategyModule module){ this.module = module; }
	public Map<String, Object> getExtraMapParam(){ return extraMapParam; }
	public void setExtraMapParam(Map<String, Object> extraMapParam){ this.extraMapParam = extraMapParam; }
    
}
