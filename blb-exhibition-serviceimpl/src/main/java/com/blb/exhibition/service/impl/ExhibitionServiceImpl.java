package com.blb.exhibition.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.blb.base.util.IResultTemplate;
import com.blb.exhibition.service.IExhibitionService;
import com.blb.write.model.BlogArticle;
import com.blb.write.service.blogarticle.IBlogArticleService;

@Service
@PropertySource("classpath:conf.properties")
public class ExhibitionServiceImpl implements IExhibitionService {

	@Value("${blb.preview.pageSize}")
	private int pageSize;
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
		return IResultTemplate.success("获取成功", retMap);
	}

	/**
	 * 
	 * @Title: getPreviewArticle
	 * @Description: 首页预览
	 * @param pageNum
	 * @return	[
	 * 				{
	 * 					title:XXX,
	 * 					content:XX,
	 * 				}
	 * 			]
	 * @author bahailong
	 * @date 2018年12月18日 下午3:28:30
	 */
	@Override
	public List<Map<String, Object>> getPreviewArticle(int pageNum) {
		List<Map<String, Object>> aticales = new ArrayList<>();
		PageRequest p = new PageRequest(pageSize, pageNum);
		iBlogArticleService.findPreviewArticle(p);
		return null;
	}

}
