package com.blb.write.model;

import com.blb.base.model.ABaseModel;

public class BlogArticleAttachment extends ABaseModel {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 附件名
	 */
	private String attName;
	
	/**
	 * 文章RID
	 */
	private String blogArticleRid;
	
	/**
	 * 状态 0:缓存 1:使用中 2:删除
	 */
	private int status;

	public String getAttName() {
		return attName;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	public String getBlogArticleRid() {
		return blogArticleRid;
	}

	public void setBlogArticleRid(String blogArticleRid) {
		this.blogArticleRid = blogArticleRid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
