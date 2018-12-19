package com.blb.write.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blb.base.mapper.IBaseMapper;
import com.blb.write.model.BlogArticle;
import com.blb.write.model.BlogArticleAttachment;

@Mapper
public interface IBlogArticleAttachmentMapper extends IBaseMapper<BlogArticleAttachment>{

}
