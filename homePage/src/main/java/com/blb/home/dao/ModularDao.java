package com.blb.home.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blb.base.idao.impl.BaseIdaoImpl;
import com.blb.home.mapper.ModularMapper;
import com.blb.home.model.Modular;

@Repository
public class ModularDao extends BaseIdaoImpl<Modular> {
	
	@Autowired
	private ModularMapper modularMapper;
	
	@PostConstruct
	private void postConstruct(){
		baseMapper = modularMapper;
	}
	
	public Modular findByCode(String code) {
		return modularMapper.findByCode(code);
	}
}
