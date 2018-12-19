package com.blb.base.util;

import java.util.HashMap;
import java.util.Map;

public class IResultTemplate {
	
	//״̬
	public final static String STATUS = "status";
	// �ɹ�
	public final static String STATUS_SUCCESS = "success";
	// ʧ��
	public final static String STATUS_FAIL = "fail";
	//����
	public final static String STATUS_ERROR = "error";
	
	//��Ϣ
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
	
	public static boolean isSuccess(Map<String, Object> ret){
		Object status = ret.get(STATUS);
		if(null == status) {
			return false;
		}
		
		return STATUS_SUCCESS.equals(status.toString());
	}
	
	public static boolean isError(Map<String, Object> ret){
		Object status = ret.get(STATUS);
		if(null == status) {
			return false;
		}
		
		return STATUS_ERROR.equals(status.toString());
	}
	
	public static boolean isFail(Map<String, Object> ret){
		Object status = ret.get(STATUS);
		if(null == status) {
			return false;
		}
		
		return STATUS_FAIL.equals(status.toString());
	}
}
