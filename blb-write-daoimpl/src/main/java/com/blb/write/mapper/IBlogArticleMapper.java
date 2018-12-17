package com.blb.write.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blb.base.mapper.IBaseMapper;
import com.blb.write.model.BlogArticle;

@Mapper
public interface IBlogArticleMapper extends IBaseMapper<BlogArticle>{

}
