package org.rank.base.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	/**
	 * model to string json
	 * */
	public static String toJSONString(Object object)
	{ 
		return JSONObject.toJSONString(object); 
	}

	/**
	 * string json to model
	 * */
	public static <T> T parseObject(String text, Class<T> clazz)
	{ 
		return (T) JSONObject.parseObject(text, clazz); 
	}
	
	/**
	 * string json to model list ?
	 * */
	public static <T> List<T> parseList(String text, Class<T> clazz)
	{ 
		return (List<T>) JSONObject.parseArray(text, clazz); 
	}

}
