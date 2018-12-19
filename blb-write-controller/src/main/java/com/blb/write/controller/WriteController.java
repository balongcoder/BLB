package com.blb.write.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.blb.base.model.UserVo;
import com.blb.base.util.IResultTemplate;
import com.blb.write.service.IWriteService;

@Controller
@RequestMapping("/writeController")
public class WriteController {

	@Autowired
	private IWriteService writerService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		String blogArticleRid = writerService.getNewBlogArticleRid();
		model.addAttribute("blogArticleRid", blogArticleRid);
		return "write/index";
	}
	
	@RequestMapping("/saveBlog")
	@ResponseBody
	public Map<String, Object> saveBlog(HttpServletRequest request){
	
		String rid = request.getParameter("rid");
		String title = request.getParameter("title");
		String md_content = request.getParameter("md_content");
		String ht_content = request.getParameter("ht_content");
		UserVo userVo = new UserVo();
		
		return writerService.saveBlogArticle(rid, title, md_content, ht_content, userVo);
	}
	
	
	@RequestMapping("/upload/editormdPic")
	@ResponseBody
	public JSONObject editormdPic(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String blogArticleRid = request.getParameter("blogArticleRid");
		
		UserVo userVo = new UserVo();
		
		Map<String, Object> result = writerService.uploadFile(blogArticleRid, file, userVo);
		String url = "";
		JSONObject res = new JSONObject();
		
		if(!IResultTemplate.isSuccess(result)) {
		     res.put("success", 0);
		     res.put("message", result.get(IResultTemplate.MESSAGE));
		     return res;
		}

        res.put("url", result.get("url").toString());
        res.put("success", 1);
        res.put("message", "upload success!");

        return res;
	}
}
