package com.kaipai.ck.configs;

import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

public final class AiwConfig {

    public static final ResourceBundle bundle = ResourceBundle.getBundle("config");
    
    public static final String AMT_INFO = getConfigValue("pay.cfg.amtinfo","");
    
    public static final String COLL_AMT_INFO = getConfigValue("pay.cfg.collinfo","");
    
    public static final String ACT_AMT_INFO = getConfigValue("pay.cfg.actinfo","");
    
    
    /**
     * 根据key获取value
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getConfigValue(String key,String defaultValue)  {
         String value = bundle.getString(key);
         if(StringUtils.isBlank(value)){
        	 return defaultValue;
         }else{
        	 return value;
         }
      
    }
}
