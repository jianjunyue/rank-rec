package org.rank.strategy.context.request;

public class BaseRequest { 

	private String rankId;
    private String requestId; 
    private long userId;
    private String phone;  
    private int cityId;
    private String deviceId;
    private String fromPage;//页面来源（APP首页-home，搜索页-search_page）
    private String pageType;//同终端和页面来源情况下，区分不同的模块位置
    private String terminal;//终端来源 app，h5，微信小程序等
    
}
