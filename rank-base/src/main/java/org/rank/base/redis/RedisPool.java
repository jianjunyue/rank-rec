package org.rank.base.redis;

import java.io.IOException;
import java.util.Properties; 
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

	/**
	 * 用户特征相关redis
	 * */
	public JedisPool getUserJedisPool() {
		JedisPoolConfig redisConfig = new JedisPoolConfig();
		redisConfig.setMaxIdle(100); // 对象最大空闲时间
		redisConfig.setMaxWaitMillis(1000L); // 获取对象时最大等待时间
		redisConfig.setMaxTotal(100); // 最大活动的对象个数
		int timeout = 100;
		Properties properties = getProperties();
		String host = properties.get("rank_redis_host").toString();
		int port = Integer.parseInt(properties.get("rank_redis_port").toString());
		JedisPool pool = new JedisPool(redisConfig, host, port, timeout);
		return pool;
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("redis/redis.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return properties;
	}
	
}