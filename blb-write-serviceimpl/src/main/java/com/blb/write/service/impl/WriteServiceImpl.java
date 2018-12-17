package com.blb.write.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.base.util.IRsultTemplate;
import com.blb.write.model.BlogArticle;
import com.blb.write.service.IWriteService;
import com.blb.write.service.blogarticle.IBlogArticleService;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

@Service
public class WriteServiceImpl implements IWriteService {

	@Autowired
	private IBlogArticleService blogArticleService;
	
	/**
	 * 
	 * @Title: saveBlogArticle
	 * @Description: 保存博客
	 * @param title
	 * @param md_content
	 * @param ht_content
	 * @author bahailong
	 * @date 2018年12月15日 下午4:45:07
	 */
	@Override
	public Map<String, Object> saveBlogArticle(String title, String md_content, String ht_content) {

		BlogArticle blogArticle = new BlogArticle();
		blogArticle.setTitle(title);
		blogArticle.setMd_content(md_content);
		blogArticle.setHt_content(ht_content);
		
		blogArticleService.save(blogArticle, null);
		
		return IRsultTemplate.success("保存成功");
	}

}
