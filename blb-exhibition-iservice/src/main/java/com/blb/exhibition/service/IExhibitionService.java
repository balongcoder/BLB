package com.blb.exhibition.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blb.base.iservice.IBaseService;

public interface IExhibitionService {

	/**
	 * 
	 * @Title: getArticle
	 * @Description: 获取文章
	 * @param bArticleRid
	 * @return
	 * @author bahailong
	 * @date 2018年12月18日 下午3:28:30
	 */
	public Map<String, Object> getArticle(String bArticleRid);

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
	public List<Map<String, Object>> getPreviewArticle(int pageNum);
}
