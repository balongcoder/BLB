package com.blb.exhibition.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blb.exhibition.service.IExhibitionService;

@Controller
public class ExhibitionController {

	@Autowired
	private IExhibitionService exhibitionService;
	
	@RequestMapping("/index")
	public String index() {
		return "exhibition/index";
	}
	
	@RequestMapping("/getArticle")
	@ResponseBody
	public Map<String, Object> getArticle(HttpServletRequest request){
		return exhibitionService.getArticle("com.blb.model.BlogArticle.20181216193018236.706514000");
	}
}
