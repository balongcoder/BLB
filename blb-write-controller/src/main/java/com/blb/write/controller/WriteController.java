package com.blb.write.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blb.write.service.IWriteService;

@Controller
@RequestMapping("/writeController")
public class WriteController {

	@Autowired
	private IWriteService writerService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		request.setAttribute("basePath", "http://localhost:8080/write");
		return "write/index";
	}
	
	@RequestMapping("/saveBlog")
	@ResponseBody
	public Map<String, Object> saveBlog(HttpServletRequest request){
	
		String title = request.getParameter("title");
		String md_content = request.getParameter("md_content");
		String ht_content = request.getParameter("ht_content");
		
		return writerService.saveBlogArticle(title, md_content, ht_content);
	}
}
