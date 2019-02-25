package com.blb.write.service.impl.blogarticle;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	public List<BlogArticle> findPreviewArticle(PageRequest p) {
		// TODO Auto-generated method stub
		return null;
	}

}
