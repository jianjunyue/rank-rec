package org.rank.strategy.context;
 
import org.rank.data.user.UserPersona;
import org.rank.strategy.abtest.ABInfo;

public class BaseContext  {

	private String rankId;

    private long userId;

    /**
     * 用户画像
     */
    private UserPersona userPersona;

    private int cityId;

    /**
     * ab信息
     */
    private ABInfo abInfo;

    public String getRankId(){ return rankId; }

	public void setRankId(String rankId){ this.rankId = rankId; }

	public long getUserId(){ return userId; }

	public void setUserId(long userId){ this.userId = userId; }

	public UserPersona getUserPersona(){ return userPersona; }

	public void setUserPersona(UserPersona userPersona){ this.userPersona = userPersona; }

	public int getCityId(){ return cityId; }

	public void setCityId(int cityId){ this.cityId = cityId; }

	public ABInfo getAbInfo(){ return abInfo; }

	public void setAbInfo(ABInfo abInfo){ this.abInfo = abInfo; }
 


}
