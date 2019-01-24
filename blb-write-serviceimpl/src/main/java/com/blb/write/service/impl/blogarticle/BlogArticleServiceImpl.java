package com.blb.write.service.impl.blogarticle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.base.iservice.impl.BaseServiceImpl;
import com.blb.write.idao.IBlogArticleDao;
import com.blb.write.model.BlogArticle;
import com.blb.write.service.blogarticle.IBlogArticleService;

@Service
public class BlogArticleServiceImpl extends BaseServiceImpl<BlogArticle> implements IBlogArticleService {


	@Autowired
	private IBlogArticleDao iBlogArticleDao;
	
	@PostConstruct
	private void postConstruct(){
		baseIdo = iBlogArticleDao;
	}

}
