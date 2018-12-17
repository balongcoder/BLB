package com.blb.write.service;

import java.util.Map;

public interface IWriteService {

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
	Map<String, Object> saveBlogArticle(String title, String md_content, String ht_content);

}
