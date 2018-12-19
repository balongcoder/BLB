package com.blb.base.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SendUtil {

	/**
	 * 
	 * @Title: sendPostRequest
	 * @Description: TODO
	 * @param url
	 * @param param
	 * @param urlParam
	 * @return
	 * @author bahailong
	 * @date 2018年12月19日 上午10:57:24
	 */
	public static <T> Map<String, Object> sendPostRequest(String url, T param, List<String> urlParam) {
		Map<String, Object> retMap = new HashMap<>();
		if(null == urlParam) {
			urlParam = new ArrayList<>();
		}
		try {
			RestTemplate rs = new RestTemplate();
			HttpEntity<T> requestEntity = new HttpEntity<>(param);
			ResponseEntity<Map<String, Object>> response = rs.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Map<String, Object>>() {}, urlParam);
			retMap = response.getBody();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(retMap == null) {
			retMap = IResultTemplate.error("上传错误");
		}
		return retMap;
	}
}
