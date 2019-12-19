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

	public String getRankId(){ return rankId; }
	public void setRankId(String rankId){ this.rankId = rankId; }
	public String getRequestId(){ return requestId; }
	public void setRequestId(String requestId){ this.requestId = requestId; }
	public long getUserId(){ return userId; }
	public void setUserId(long userId){ this.userId = userId; }
	public String getPhone(){ return phone; }
	public void setPhone(String phone){ this.phone = phone; }
	public int getCityId(){ return cityId; }
	public void setCityId(int cityId){ this.cityId = cityId; }
	public String getDeviceId(){ return deviceId; }
	public void setDeviceId(String deviceId){ this.deviceId = deviceId; }
	public String getFromPage(){ return fromPage; }
	public void setFromPage(String fromPage){ this.fromPage = fromPage; }
	public String getPageType(){ return pageType; }
	public void setPageType(String pageType){ this.pageType = pageType; }
	public String getTerminal(){ return terminal; }
	public void setTerminal(String terminal){ this.terminal = terminal; }
}
