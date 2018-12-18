package com.blb.write.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
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
	
	
	@RequestMapping("/upload/editormdPic")
	@ResponseBody
	public JSONObject editormdPic (@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{
		String trueFileName = file.getOriginalFilename();  

        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));

        String fileName = System.currentTimeMillis()+"_"+Math.random() * 1000 +suffix;  

        String path = request.getSession().getServletContext().getRealPath("/assets/msg/upload/");
        System.out.println(path);  

        File targetFile = new File(path);  
        if(!targetFile.exists()){  
           targetFile.mkdirs();  
        }  

       //保存  
        try {
           file.transferTo(targetFile);  
        } catch (Exception e) {  
           e.printStackTrace();  
        }  


        JSONObject res = new JSONObject();
        res.put("url", path + fileName);
        res.put("success", 1);
        res.put("message", "upload success!");

        return res;
	}
}
