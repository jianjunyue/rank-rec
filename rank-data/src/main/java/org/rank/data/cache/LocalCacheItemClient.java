package org.rank.data.cache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.rank.base.redis.RedisClient;
import org.rank.data.item.ItemAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LocalCacheItemClient {

	private static Logger logger = LoggerFactory.getLogger(LocalCacheItemClient.class);
	private volatile static LocalCacheItemClient instance;
	private static Cache<Long, ItemAttribute> localCacheItemAttribute;
	private static RedisClient redisClient;

	private static final String KEY_PREFIX = "itemIdCache:";

	private void init(){
		// initialCapacity 初始化容量
		// concurrentLevel 并发的线程数
		// expireAfterWrite 写入多长时间后，失效
		localCacheItemAttribute = CacheBuilder.newBuilder().initialCapacity(240000).maximumSize(800000).build();
		redisClient = new RedisClient();
	}

	public Map<Long, ItemAttribute> getData(List<Long> itemIds){
		try {
			Map<Long, ItemAttribute> mapItem = localCacheItemAttribute.getAllPresent(itemIds);
			List<Long> ids = itemIds.stream().filter(id -> !mapItem.containsKey(id)).collect(Collectors.toList());
			List<ItemAttribute> redislist = getRedis(ids);
			redislist.forEach(action -> mapItem.put(action.getItemId(), action));
			return mapItem;
		} catch (Exception e) {
			logger.error("LocalCacheItemClient getData is error", e);
		}
		return Maps.newHashMap();
	}

	private List<ItemAttribute> getRedis(List<Long> notLocalCacheIds){
		List<ItemAttribute> list = Lists.newArrayList();
		List<String> keys = Lists.newArrayList();
		notLocalCacheIds.stream().forEach(action -> keys.add(KEY_PREFIX + action));
		List<String> result = redisClient.mget(keys.toArray(new String[] {}));
		result.stream().forEach(action -> {
			ItemAttribute itemAttribute = JSONObject.parseObject(action, ItemAttribute.class);
			if (itemAttribute != null) {
				list.add(itemAttribute);
			}
		});
		updateLocalCache(list);
		return list;
	}

	private void updateLocalCache(List<ItemAttribute> list){ list.stream().forEach(action -> localCacheItemAttribute.put(action.getItemId(), action)); }

	private LocalCacheItemClient() {}

	public static LocalCacheItemClient getInstance(){
		if (instance == null) {
			synchronized (LocalCacheItemClient.class) {
				if (instance == null) {
					instance = new LocalCacheItemClient();
					instance.init();
				}
			}
		}
		return instance;
	}
}
