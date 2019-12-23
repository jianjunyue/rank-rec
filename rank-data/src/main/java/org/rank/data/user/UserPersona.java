package org.rank.data.user;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;

/**
 * 用户画像
 */
public class UserPersona {

	@JsonProperty("userId")
	private long userId;

    @JsonProperty("realtimeOrderInfo")
    private Map<String, String> realtimeOrderInfo;

    @JsonProperty("realtimeShopCartInfo")
    private Map<String, String> realtimeShopCartInfo;

    @JsonProperty("realtimeClickInfo")
    private Map<String, String> realtimeClickInfo;

    @JsonProperty("realtimeRecExpoInfo")
    private String realtimeRecExpoInfo;

    @JsonProperty("allRealTimeClickInfo")
    private Map<Long, Float> allRealTimeClickInfo;
 
 
    public long getUserId(){ return userId; }

	public void setUserId(long userId){ this.userId = userId; }

	public Map<String, String> getRealtimeOrderInfo(){ return realtimeOrderInfo; }

	public void setRealtimeOrderInfo(Map<String, String> realtimeOrderInfo){ this.realtimeOrderInfo = realtimeOrderInfo; }

	public Map<String, String> getRealtimeShopCartInfo(){ return realtimeShopCartInfo; }

	public void setRealtimeShopCartInfo(Map<String, String> realtimeShopCartInfo){ this.realtimeShopCartInfo = realtimeShopCartInfo; }

	public Map<String, String> getRealtimeClickInfo(){ return realtimeClickInfo; }

	public void setRealtimeClickInfo(Map<String, String> realtimeClickInfo){ this.realtimeClickInfo = realtimeClickInfo; }

	public String getRealtimeRecExpoInfo(){ return realtimeRecExpoInfo; }

	public void setRealtimeRecExpoInfo(String realtimeRecExpoInfo){ this.realtimeRecExpoInfo = realtimeRecExpoInfo; }

	public Map<Long, Float> getAllRealTimeClickInfo(){ return allRealTimeClickInfo; }

	public void setAllRealTimeClickInfo(Map<Long, Float> allRealTimeClickInfo){ this.allRealTimeClickInfo = allRealTimeClickInfo; }

}
