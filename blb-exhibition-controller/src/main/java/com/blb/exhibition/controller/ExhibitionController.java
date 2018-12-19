package com.blb.exhibition.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blb.exhibition.service.IExhibitionService;

@Controller
public class ExhibitionController {

	@Autowired
	private IExhibitionService exhibitionService;
	
	@RequestMapping("/blog/{bArticleRid}")
	public String index(@PathVariable("bArticleRid")String blogArticleRid, HttpServletRequest request, Model model) {
		model.addAttribute("blogArticleRid", blogArticleRid);
		return "exhibition/index";
	}
	
	@RequestMapping("/getArticle")
	@ResponseBody
	public Map<String, Object> getArticle(String blogArticleRid, HttpServletRequest request){
		return exhibitionService.getArticle(blogArticleRid);
	}
}
