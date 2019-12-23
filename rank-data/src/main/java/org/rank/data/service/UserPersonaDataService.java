package org.rank.data.service;

import org.rank.base.redis.RedisClient;
import org.rank.data.user.UserPersona;

import com.alibaba.fastjson.JSONObject;

public class UserPersonaDataService {

	private static final String KEY_PREFIX = "userCache:";
	private static RedisClient client = new RedisClient();

	public UserPersona getUserProfile(long userId){
		String value = client.get(KEY_PREFIX + 1000);
		UserPersona userPersona = JSONObject.parseObject(value, UserPersona.class);
		return userPersona;
	}
}
