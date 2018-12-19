package com.blb.write.service.impl.blogarticle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.base.iservice.impl.BaseServiceImpl;
import com.blb.write.idao.IBlogArticleAttachmentDao;
import com.blb.write.model.BlogArticleAttachment;
import com.blb.write.service.blogarticle.IBlogArticleAttachmentService;

@Service
public class BlogArticleAttachmentImpl extends BaseServiceImpl<BlogArticleAttachment> implements IBlogArticleAttachmentService {


	@Autowired
	private IBlogArticleAttachmentDao iBlogArticleAttachmentDao;
	
	@PostConstruct
	private void postConstruct(){
		baseIdo = iBlogArticleAttachmentDao;
	}


}
