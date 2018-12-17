package com.blb.base.util;

import java.util.HashMap;
import java.util.Map;

public class IRsultTemplate {
	
	//状态
	public final static String STATUS = "status";
	// 成功
	public final static String STATUS_SUCCESS = "success";
	// 失败
	public final static String STATUS_FAIL = "fail";
	//错误
	public final static String STATUS_ERROR = "error";
	
	//消息
    public final static String MESSAGE = "message";

	
	
	public static Map<String, Object> success(){
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(STATUS, STATUS_SUCCESS); 
		return retMap;
	}
	
	public static Map<String, Object> success(String msg){
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(STATUS, STATUS_SUCCESS); 
		retMap.put(MESSAGE, msg);
		return retMap;
	}
	
	public static Map<String, Object> success(String msg, Map<String, Object> param){
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(STATUS, STATUS_SUCCESS); 
		retMap.put(MESSAGE, msg);
		retMap.putAll(param);
		return retMap;
	}
	
	public static Map<String, Object> fail(String msg){
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(STATUS, STATUS_FAIL); 
		retMap.put(MESSAGE, msg);
		return retMap;
	}
	
	public static Map<String, Object> error(String msg){
		Map<String, Object> retMap = new HashMap<>();
		retMap.put(STATUS, STATUS_ERROR); 
		retMap.put(MESSAGE, msg); 
		return retMap;
	}
}
