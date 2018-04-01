package com.kaipai.ck.configs;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class RedisConfig {

    public static final ResourceBundle bundle = ResourceBundle.getBundle("redis");
    public static final String host = getConfigValue("redis.ip","");
    public static final String port = getConfigValue("redis.port","6379");
    public static final String timeout = getConfigValue("redis.timeout","1000");
    public static final String password = getConfigValue("redis.password","");
    public static final String cluster = getConfigValue("redis.cluster.address","");
    public static final int ttlNum = 100;

    
    /**
     * 根据key获取value
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getConfigValue(String key,String defaultValue)  {
    	try{
    		String value = bundle.getString(key);
    		return value;
    	}catch (MissingResourceException e) {
    		return defaultValue;
		}
    }

}
