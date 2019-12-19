package org.rank.strategy.context.response;

import java.util.List;
import java.util.Map;

public class RankResponse {

	private  List<ShopResponse> rankList;

    private String rankId;

    /**
     * 返回的补充信息
     * */
    private Map<String, Object> attribute;
    
    public List<ShopResponse> getRankList(){ return rankList; }

	public void setRankList(List<ShopResponse> rankList){ this.rankList = rankList; }

	public String getRankId(){ return rankId; }

	public void setRankId(String rankId){ this.rankId = rankId; }

	public Map<String, Object> getAttribute(){ return attribute; }

	public void setAttribute(Map<String, Object> attribute){ this.attribute = attribute; }

	
}
