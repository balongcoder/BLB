package com.blb.exhibition.api;

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
	
	//@RequestMapping("/blog/{userNumber}/{bArticleRid}")
	public String index(@PathVariable("bArticleRid")String blogArticleRid, HttpServletRequest request, Model model) {
		model.addAttribute("blogArticleRid", blogArticleRid);
		return "exhibition/index";
	}
	
	/**
	 * 
	 * @Title: getArticle
	 * @Description: TODO
	 * @param blogArticleRid
	 * @param request
	 * @return  content
	 * @author bahailong
	 * @date 2019年1月5日 下午1:30:54
	 */
	@RequestMapping("/blog/{userNumber}/{bArticleRid}")
	@ResponseBody
	public Map<String, Object> getArticle(@PathVariable("bArticleRid") String blogArticleRid, HttpServletRequest request){
		return exhibitionService.getArticle(blogArticleRid);
	}
}
