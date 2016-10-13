package com.eclink.hgpj.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * JsonUtil.java
 *
 * @Title:json处理
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.

 * @date Aug 9, 2011 5:21:06 PM
 *
 */
public class JsonUtil {
	private Map<String,Object> map = new HashMap<String, Object>();
	private static JsonConfig config = new JsonConfig();
	
	static{
		JsonValueProcessor processor = new JsonValueProcessor() {
	    	private final String format="yyyy-MM-dd HH:mm:ss";
		    public Object processObjectValue(String key, Object value,
		      JsonConfig arg2){
			     if(value==null)
			    	 return "";
			     if (value instanceof Date) {
				      String str = new SimpleDateFormat(format).format((Date) value);
				      return str;
			     }
			     return value.toString();
		    }
	
		    public Object processArrayValue(Object value, JsonConfig arg1){
			     if (value instanceof Date) {
				      String str = new SimpleDateFormat(format).format((Date) value);
				      return str;
			     }
			     return "";
		    }
	   };
	   config.registerJsonValueProcessor(java.sql.Timestamp.class,processor);
	   config.registerJsonValueProcessor(java.util.Date.class,processor);
	   config.registerJsonValueProcessor(java.sql.Date.class,processor);
	}
    public static String list2Json(List list){
    	JSONArray jsonArray = JSONArray.fromObject(list,config);  
    	return jsonArray.toString();
    }
    public static String obj2Json(Object obj){
    	JSONArray jsonArray = JSONArray.fromObject(obj, config);  
    	return jsonArray.toString();
    }
    public JsonUtil(Map map){
    	this.map = map;
    }
    
    public JsonUtil(String key, String value) {
    	map.put(key, value);
	}

	public JsonUtil append(String key, Object value){
    	map.put(key, value);
    	return this;
    }
	
    public JsonUtil() {
	}

	public String toString(){
    	return obj2Json(map);
    }
	
	
}
