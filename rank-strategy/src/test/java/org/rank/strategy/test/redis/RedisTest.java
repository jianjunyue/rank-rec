package org.rank.strategy.test.redis;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.rank.base.redis.RedisClient;
import org.rank.data.item.ItemAttribute;
import org.rank.data.item.ItemInfo;
import org.rank.data.search.ItemSearchService;
import org.rank.data.user.UserPersona; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.Maps;

public class RedisTest {

	private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    private static final String KEY_PREFIX = "rankCache:";
	private static RedisClient client=new RedisClient();
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{
		put1();
		put();
		String value=client.get(KEY_PREFIX+1000);
		System.out.println(value);
		logger.info("logger info");
		UserPersona user=JSONObject.parseObject(value, UserPersona.class);
//		UserPersona user=ObjectMappers.INSTANCE.readValue(value, UserPersona.class);
		logger.info("logger info "+user.getUserId());
	}
	
	private static void put(){
		UserPersona user=new UserPersona();
		user.setUserId(1000);
		 Map<Long, Float> allRealTimeClickInfo=Maps.newHashMap();
		 allRealTimeClickInfo.put(1111L, 0.5f);
		user.setAllRealTimeClickInfo(allRealTimeClickInfo);
		client.put(KEY_PREFIX+user.getUserId(), JSONObject.toJSONString(user));
	}
	
	private static void put1() {
		String KEY_PREFIX = "itemIdCache:";

		List<ItemInfo> itemInfoList =ItemSearchService.search();
		itemInfoList.forEach(action->{
			ItemAttribute itemAttribute=new ItemAttribute();
			itemAttribute.setItemId(action.getItemId());
			itemAttribute.setSaleQuantity((int)action.getItemId());

			client.put(KEY_PREFIX+itemAttribute.getItemId(), JSONObject.toJSONString(itemAttribute));
		});
	}

}
