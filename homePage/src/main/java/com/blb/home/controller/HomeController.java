package com.blb.home.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blb.home.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	/**
	 * 
	 * @Title: target
	 * @Description: 模块/用户/目标  首页
	 * @param modular
	 * @param userCode
	 * @param target
	 * @return
	 * @author bahailong
	 * @date 2018年12月21日 上午11:32:37
	 */
	@RequestMapping("/{modular}/{userCode}/{target}")
	public String target(@PathVariable("modular") String modular, @PathVariable("userCode") String userCode, @PathVariable("target") String target, Model model) {
		model.addAllAttributes(homeService.getContentByModularInfo(modular, userCode, target));
		return modular + "/index";
	}
	
	/**
	 * 
	 * @Title: userCode
	 * @Description: 模块/用户  首页
	 * @param modular
	 * @param userCode
	 * @return
	 * @author bahailong
	 * @date 2018年12月21日 上午11:34:20
	 */
	@RequestMapping("/index/{modular}/{userCode}")
	public String userCode(@PathVariable("modular") String modular, @PathVariable("userCode") String userCode, Model model) {
		model.addAttribute("pageContentUrl", homeService.getContentByModularInfo(modular, userCode, null));
		return "home/index";
	}
	
	/**
	 * 
	 * @Title: modular
	 * @Description: 模块  首页
	 * @param modular
	 * @return
	 * @author bahailong
	 * @date 2018年12月21日 上午11:34:25
	 */
	@RequestMapping("/index/{modular}")
	public String modular(@PathVariable("modular") String modular, Model model) {
		model.addAttribute("pageContentUrl", homeService.getContentByModularInfo(modular, null, null));
		return "home/index";
	}
	
	/**
	 * 
	 * @Title: modular
	 * @Description: 模块  首页
	 * @param modular
	 * @return
	 * @author bahailong
	 * @date 2018年12月21日 上午11:34:25
	 */
	@RequestMapping("/index")
	public String modular(HttpServletRequest request) {
		request.setAttribute("pageContentUrl", "111");
		return "home/index";
	}
	
	/**
	 * 
	 * @Title: menu
	 * @Description: 首页菜单
	 * @return
	 * @author bahailong
	 * @date 2018年12月21日 上午11:34:25
	 */
	@RequestMapping("/menu")
	@ResponseBody
	public Map<String, Object> menu(HttpServletRequest request) {
		Map<String, Object> menuStruct = new LinkedHashMap<>();
		Map<String, Object> menuInfo = new LinkedHashMap<>();
		menuInfo.put("title", "BLB blog");
		menuInfo.put("showLogo", true);
		menuInfo.put("logoPath", "http://127.0.0.1:8801/imgs/logo_48.ico");
		
		List<Map<String, String>> menu_items = new ArrayList<>();
		Map<String, String> item1 = new HashMap<>();
		item1.put("id", "menu_home");
		item1.put("class_style", "glyphicon glyphicon-home");
		item1.put("text", "首页");
		item1.put("href", "/index");
		
		Map<String, String> item2 = new HashMap<>();
		item2.put("id", "menu_classify");
		item2.put("class_style", "glyphicon glyphicon-equalizer");
		item2.put("text", "分类");
		item2.put("href", "/index");
		
		Map<String, String> item3 = new HashMap<>();
		item3.put("id", "menu_tags");
		item3.put("class_style", "glyphicon glyphicon-tags");
		item3.put("text", "标签");
		item3.put("href", "/index");
		
		Map<String, String> item4 = new HashMap<>();
		item4.put("id", "menu_time");
		item4.put("class_style", "glyphicon glyphicon-time");
		item4.put("text", "时间");
		item4.put("href", "/index");
		
		Map<String, String> item5 = new HashMap<>();
		item5.put("id", "menu_search");
		item5.put("class_style", "glyphicon glyphicon-search");
		item5.put("text", "搜索");
		item5.put("href", "/index");
		menuStruct.put("menu", menuInfo);
		
		menu_items.add(item1);
		menu_items.add(item2);
		menu_items.add(item3);
		menu_items.add(item4);
		menu_items.add(item5);
		
		menuInfo.put("items", menu_items);
		return menuStruct;
	}
}
