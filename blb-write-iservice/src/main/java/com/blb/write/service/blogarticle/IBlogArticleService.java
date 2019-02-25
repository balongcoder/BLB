package com.blb.write.service.blogarticle;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.blb.base.iservice.IBaseService;
import com.blb.write.model.BlogArticle;

public interface IBlogArticleService extends IBaseService<BlogArticle> {

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
	List<BlogArticle> findPreviewArticle(PageRequest p);

}
