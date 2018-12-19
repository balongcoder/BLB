package com.blb.fileservice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blb.base.util.EnAndDeCodeUtil;
import com.blb.base.util.IResultTemplate;
import com.blb.fileservice.config.FileServiceConfigProperties;

@Controller
public class FileServiceController {

//	private static final int maxSize = 102400 * 1024;// 102400KB以内(100MB)
	
	@Autowired
	private FileServiceConfigProperties configProperties;
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Map<String, Object> uploadFile(String fileName, MultipartFile uploadFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String projectName = request.getParameter("projectName");
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		 
        //验证是否已登录
        if(!(configProperties.getUploadUserName().equals(userName) && configProperties.getUploadUserPass().equals(userPass))){
            return IResultTemplate.error("请登录");
        }
        
        // 要保存文件的绝对路径
        String buildPath = configProperties.getFileSystemPath() + "/" + projectName + "/";

        byte[] fileBytes;
		// 调用业务层保存文件名和扩展名
		File file = null;
		try {
			fileBytes = uploadFile.getBytes();
			File dir = new File(buildPath);
			if(!dir.exists())
				dir.mkdirs();
			file = new File(buildPath + File.separator + fileName);
			if(file.exists())
				file.delete();
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(fileBytes);
			outputStream.close();
		} catch (IOException e) {
			return IResultTemplate.error("文件提取错误");
		}
        
        String webroot = request.getScheme() + "://"
                + request.getServerName() + ":"
                + request.getServerPort()
                + request.getContextPath();
        fileName = EnAndDeCodeUtil.encode(projectName + "/" + fileName);
        String fileurl = webroot+"/getfile/" + fileName;

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("url", fileurl);
        retMap.put("fileName", fileName);
		return IResultTemplate.success("上传成功", retMap);
	}
	
	@RequestMapping("/getfile/{fileEncode}")
	public void getfile(@PathVariable("fileEncode") String fileEncode, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String fileName = configProperties.getFileSystemPath() + File.separator  + EnAndDeCodeUtil.decode(fileEncode);
		System.out.println(fileName);
		
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(fileName);
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((count = fis.read(buffer)) != -1) {
				os.write(buffer, 0, count);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/delfile/{fileEncode}")
	public Map<String, Object> delfile(@PathVariable("fileEncode") String fileEncode, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String fileName = configProperties.getFileSystemPath() + File.separator  + EnAndDeCodeUtil.decode(fileEncode);
		
		File file = new File(fileName);
		if(file.exists()) {
			file.delete();
		}
		
		return IResultTemplate.success("删除成功");
	}
}
