package com.blb.write.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.blb.base.model.UserVo;

public interface IWriteService {

	/**
	 * 
	 * @Title: saveOrUpdateBlogArticle
	 * @Description: 保存博客
	 * @param rid
	 * @param title
	 * @param md_content
	 * @param ht_content
	 * @param userVo
	 * @author bahailong
	 * @date 2018年12月15日 下午4:45:07
	 */
	Map<String, Object> saveOrUpdateBlogArticle(String rid, String title, String md_content, String ht_content, UserVo userVo);

	/**
	 * 
	 * @Title: getNewBlogArticleRid
	 * @Description: 创建一个新的RID返回，用于文章图片的缓存
	 * @return
	 * @author bahailong
	 * @date 2018年12月19日 上午10:00:56
	 */
	String getNewBlogArticleRid();

	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 上传文件
	 * @param blogArticleRid
	 * @param file
	 * @param userVo
	 * @return
	 * @author bahailong
	 * @date 2018年12月19日 上午10:18:49
	 */
	Map<String, Object> uploadFile(String blogArticleRid, MultipartFile file, UserVo userVo);

}
