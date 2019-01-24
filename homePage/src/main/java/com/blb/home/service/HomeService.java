package com.blb.home.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.base.util.IResultTemplate;
import com.blb.base.util.SendUtil;
import com.blb.home.model.Modular;

@Service
public class HomeService {

	@Autowired
	private ModularService modularService;
	
	public Map<String, Object> getContentByModularInfo(String code, String userCode, String target) {
		
		Map<String, Object> retMap = new HashMap<>();
		
		Modular modular = modularService.findByCode(code);
		
		if(null == modular) {
			retMap.put("view", "/error/404");
			return IResultTemplate.fail("获取不到");
		}
		StringBuffer url = new StringBuffer("http://");
		url.append(modular.getIp())
		.append(":")
		.append(modular.getPort())
		.append(modular.getUrlprefix())
		.append("/");
		if(null != userCode) {
			url.append(userCode).append("/");
			if(null != target) {
			  url.append(target);
			}
		}
		
		retMap = SendUtil.sendPostRequest(url.toString(), null, null);
		
		return IResultTemplate.success("成功", retMap);
	}
}
