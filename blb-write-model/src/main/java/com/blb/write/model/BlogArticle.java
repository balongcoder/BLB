package com.blb.write.model;

import com.blb.base.model.ABaseModel;

public class BlogArticle extends ABaseModel {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标题
	 */
	private String title;
	/**
	 * MarkDown内容
	 */
	private String md_content;
	/**
	 * html内容
	 */
	private String ht_content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMd_content() {
		return md_content;
	}
	public void setMd_content(String md_content) {
		this.md_content = md_content;
	}
	public String getHt_content() {
		return ht_content;
	}
	public void setHt_content(String ht_content) {
		this.ht_content = ht_content;
	}
}
