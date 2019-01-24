package com.blb.home.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.blb.base.mapper.IBaseMapper;
import com.blb.home.model.Modular;

@Mapper
public interface ModularMapper extends IBaseMapper<Modular> {
	
	@Select("select * from modular where code = #{arg0}")
	public Modular findByCode(String code);
}
