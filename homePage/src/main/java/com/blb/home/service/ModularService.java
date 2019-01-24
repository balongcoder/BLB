package com.blb.home.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blb.base.iservice.impl.BaseServiceImpl;
import com.blb.home.dao.ModularDao;
import com.blb.home.model.Modular;

@Service
public class ModularService extends BaseServiceImpl<Modular>{

	@Autowired
	private ModularDao modularDao;
	
	@PostConstruct
	public void Construct() {
		this.baseIdo = modularDao;
	}
	
	public Modular findByCode(String code) {
		return modularDao.findByCode(code);
	}
}
