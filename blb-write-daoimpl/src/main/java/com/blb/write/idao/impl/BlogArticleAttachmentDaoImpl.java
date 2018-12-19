package com.blb.write.idao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blb.base.idao.impl.BaseIdaoImpl;
import com.blb.write.idao.IBlogArticleAttachmentDao;
import com.blb.write.mapper.IBlogArticleAttachmentMapper;
import com.blb.write.model.BlogArticleAttachment;

@Repository
public class BlogArticleAttachmentDaoImpl extends BaseIdaoImpl<BlogArticleAttachment> implements IBlogArticleAttachmentDao {
	/**
	 * 注入IBlogArticleMapper
	 */
	@Autowired
	private IBlogArticleAttachmentMapper iBlogArticleAttachmentMapper;
	
	@PostConstruct
	private void postConstruct(){
		baseMapper = iBlogArticleAttachmentMapper;
	}
}
