package org.rank.strategy.context.request;

public class RankRequest {
	
    private String requestId;
	private String rankId;
	
  
    /**
     * userId，字符串格式
     */
    private String uid;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 上层定义的筛选属性
     */
    private String specifiedAttributes;//特殊属性
}
