package com.blb.write.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.blb.base.model.UserVo;
import com.blb.base.util.IResultTemplate;
import com.blb.base.util.SendUtil;
import com.blb.write.model.BlogArticle;
import com.blb.write.model.BlogArticleAttachment;
import com.blb.write.service.IWriteService;
import com.blb.write.service.blogarticle.IBlogArticleAttachmentService;
import com.blb.write.service.blogarticle.IBlogArticleService;
import com.blb.write.util.ParamUtil;
import com.github.pagehelper.util.StringUtil;

@Service
public class WriteServiceImpl implements IWriteService {
	
	@Autowired
	private IBlogArticleService blogArticleService;
	@Autowired
	private IBlogArticleAttachmentService blogArticleAttachmentService;
	
	/**
	 * 
	 * @Title: saveBlogArticle
	 * @Description: 保存博客
	 * @param rid
	 * @param title
	 * @param md_content
	 * @param ht_content
	 * @param userVo
	 * @author bahailong
	 * @date 2018年12月15日 下午4:45:07
	 */
	@Override
	public Map<String, Object> saveBlogArticle(String rid, String title, String md_content, String ht_content, UserVo userVo) {

		BlogArticle blogArticle = new BlogArticle();
		blogArticle.setResourceID(rid);
		blogArticle.setTitle(title);
		blogArticle.setMd_content(md_content);
		blogArticle.setHt_content(ht_content);
		
		blogArticleService.save(blogArticle, userVo);
		
		return IResultTemplate.success("保存成功");
	}

	/**
	 * 
	 * @Title: getNewBlogArticleRid
	 * @Description: 创建一个新的RID返回，用于文章图片的缓存
	 * @return
	 * @author bahailong
	 * @date 2018年12月19日 上午10:00:56
	 */
	@Override
	public String getNewBlogArticleRid() {
		return blogArticleService.createRid();
	}

	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 上传文件
	 * @param blogArticleRid
	 * @param file
	 * @param userVo
	 * @return
	 * @author bahailong
	 * @date 2018年12月19日 上午10:18:49
	 */
	@Override
	public Map<String, Object> uploadFile(String blogArticleRid, MultipartFile partFile, UserVo userVo) {

		// 获取文件名,获取文件后缀名
		String filename = partFile.getOriginalFilename();
		if (StringUtil.isEmpty(filename)) {
			return IResultTemplate.error("文件名提取错误");
		}
		// 获取文件后缀名
		String extName = filename.substring(filename.lastIndexOf(".") + 1);
		byte[] fileBytes;
		// 调用业务层保存文件名和扩展名
		File file = null;
		try {
			fileBytes = partFile.getBytes();
			String dirName = ParamUtil.getCachePath();
			File dir = new File(dirName);
			if(!dir.exists())
				dir.mkdirs();
			file = new File(dirName + File.separator + blogArticleRid + extName);
			if(file.exists())
				file.delete();
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(fileBytes);
			outputStream.close();
		} catch (IOException e) {
			return IResultTemplate.error("文件提取错误");
		}

		FileSystemResource resource = new FileSystemResource(file);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();  
	    param.add("uploadFile", resource);  
	    param.add("fileName", blogArticleRid + filename);
	    param.add("userName", ParamUtil.getUploadUserName());
	    param.add("userPass", ParamUtil.getUploadUserPass());
	    param.add("projectName", ParamUtil.getProjectName());
		Map<String, Object> result = SendUtil.sendPostRequest(ParamUtil.getUploadUrl(), param, new ArrayList<>());
		
		if(!IResultTemplate.isSuccess(result)){
			return IResultTemplate.fail(result.get(IResultTemplate.MESSAGE).toString());
		}
		
		BlogArticleAttachment blogArticleAttachment = new BlogArticleAttachment();
		blogArticleAttachment.setAttName(result.get("fileName").toString());
		blogArticleAttachment.setBlogArticleRid(blogArticleRid);
		blogArticleAttachment.setStatus(0);
		
		blogArticleAttachmentService.save(blogArticleAttachment, userVo);
		
		// 删除缓存文件
		file.delete();
		return IResultTemplate.success("上传成功", result);
	}

}
