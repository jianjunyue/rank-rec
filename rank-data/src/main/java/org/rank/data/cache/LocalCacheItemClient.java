package org.rank.data.cache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.rank.base.redis.RedisClient;
import org.rank.data.item.ItemFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LocalCacheItemClient {

	private static Logger logger = LoggerFactory.getLogger(LocalCacheItemClient.class);
	private volatile static LocalCacheItemClient instance;
	private static Cache<Long, ItemFeature> localCacheItemAttribute;
	private static RedisClient redisClient;

	private static final String KEY_PREFIX = "itemIdCache:";

	private void init(){
		// initialCapacity 初始化容量
		// concurrentLevel 并发的线程数
		// expireAfterWrite 写入多长时间后，失效
		localCacheItemAttribute = CacheBuilder.newBuilder().initialCapacity(240000).maximumSize(800000).build();
		redisClient = new RedisClient();
	}

	public Map<Long, ItemFeature> getData(List<Long> itemIds){
		Map<Long, ItemFeature> mapItemFeature = Maps.newHashMap();
		try {
			ImmutableMap<Long, ItemFeature> immutableMap = localCacheItemAttribute.getAllPresent(itemIds);
			immutableMap.keySet().stream().forEach(action -> mapItemFeature.put(action, immutableMap.get(action)));

			List<Long> ids = itemIds.stream().filter(id -> !immutableMap.containsKey(id)).collect(Collectors.toList());
			if (ids != null && ids.size() > 0) {
				List<ItemFeature> redislist = getRedis(ids);
				redislist.forEach(action -> mapItemFeature.put(action.getItemId(), action));
			}
		} catch (Exception e) {
			logger.error("LocalCacheItemClient getData is error", e);
		}
		return mapItemFeature;
	}

	private List<ItemFeature> getRedis(List<Long> notLocalCacheIds){
		List<ItemFeature> list = Lists.newArrayList();
		try {
			List<String> keys = Lists.newArrayList();
			notLocalCacheIds.stream().forEach(action -> keys.add(KEY_PREFIX + action));
			List<String> result = redisClient.mget(keys.toArray(new String[] {}));
			result.stream().forEach(action -> {
				ItemFeature itemAttribute = JSONObject.parseObject(action, ItemFeature.class);
				if (itemAttribute != null) {
					list.add(itemAttribute);
				}
			});
			updateLocalCache(list);
		} catch (Exception e) {
			logger.error("LocalCacheItemClient getRedis is error", e);
		}
		return list;
	}

	private void updateLocalCache(List<ItemFeature> list){ list.stream().forEach(action -> localCacheItemAttribute.put(action.getItemId(), action)); }

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
