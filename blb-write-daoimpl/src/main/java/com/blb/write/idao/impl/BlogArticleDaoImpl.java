package com.blb.write.idao.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blb.base.idao.impl.BaseIdaoImpl;
import com.blb.write.idao.IBlogArticleDao;
import com.blb.write.mapper.IBlogArticleMapper;
import com.blb.write.model.BlogArticle;

@Repository
public class BlogArticleDaoImpl extends BaseIdaoImpl<BlogArticle> implements IBlogArticleDao {
	/**
	 * 注入IBlogArticleMapper
	 */
	@Autowired
	private IBlogArticleMapper iBlogArticleMapper;
	
	@PostConstruct
	private void postConstruct(){
		baseMapper = iBlogArticleMapper;
	}
}
