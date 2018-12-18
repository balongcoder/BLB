package com.blb.exhibition.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.base.util.IRsultTemplate;
import com.blb.exhibition.service.IExhibitionService;
import com.blb.write.model.BlogArticle;
import com.blb.write.service.blogarticle.IBlogArticleService;

@Service
public class ExhibitionServiceImpl implements IExhibitionService {

	/**
	 * 博客文章
	 */
	@Autowired
	private IBlogArticleService iBlogArticleService;
	
	/**
	 * 
	 * @Title: getArticle
	 * @Description: 获取文章
	 * @param bArticleRid
	 * @return
	 * @author bahailong
	 * @date 2018年12月18日 下午3:28:30
	 */
	@Override
	public Map<String, Object> getArticle(String bArticleRid) {
		Map<String, Object> retMap = new HashMap<>();
		BlogArticle blogArticle = iBlogArticleService.findByResourceID(bArticleRid);
		retMap.put("content", blogArticle.getHt_content());
		return IRsultTemplate.success("获取成功", retMap);
	}

}
