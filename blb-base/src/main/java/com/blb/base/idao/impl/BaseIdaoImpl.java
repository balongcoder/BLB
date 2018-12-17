package com.blb.base.idao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.blb.base.idao.IBaseIdao;
import com.blb.base.mapper.IBaseMapper;
import com.blb.base.model.ABaseModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class BaseIdaoImpl <T extends ABaseModel> implements IBaseIdao<T> {

	/**
	 * ∂®“ÂMapper
	 */
	@Autowired
	protected IBaseMapper<T> baseMapper;

	@Override
	public T findByResourceID(String resourceID) {
		return baseMapper.findByResourceID(resourceID);
	}

	@Override
	public List<T> findByResourceIDIn(List<String> resourceIDs) {
		return baseMapper.findByResourceIDIn(resourceIDs);
	}

	@Override
	public List<T> findByIdIn(List<Integer> idList,PageRequest pageRequest) {
		PageHelper.startPage(pageRequest.getPageNumber() == 0 ? 1: pageRequest.getPageNumber()+1,pageRequest.getPageSize());
		PageHelper.orderBy("id asc");
		return baseMapper.findByIdList(idList);
	}

	@Override
	public List<T> findByIdIn(List<Integer> idList) {
 		return baseMapper.findByIdList(idList);
	}
	
	@Override
	public T save(T model) {
		baseMapper.insert(model);
		return model;
	}

	@Override
	public List<T> save(List<T> modelList) {
		baseMapper.insertBatch(modelList);
		return modelList;
	}

	@Override
	public List<T> update(List<T> modelList) {
		baseMapper.updateBatch(modelList);
		return modelList;
	}

	@Override
	public T update(T model) {
		baseMapper.update(model);
		return model;
	}

	@Override
	public T find(Integer id) {
		return baseMapper.findOne(id);
	}

	@Override
	public List<T> findAll() {
		return baseMapper.findAll();
	}

	@Override
	public long count() {
		return baseMapper.count();
	}

	@Override
	public void delete(T model) {
		baseMapper.delete(model);
		
	}

	@Override
	public void deleteInBatch(List<T> modelList) {
		baseMapper.deleteBatch(modelList);
		
	}

	@Override
	public Page<T> findAll(Pageable request) {
		PageHelper.startPage(request.getPageNumber() == 0 ? 1: request.getPageNumber()+1,request.getPageSize());
		PageHelper.orderBy("id asc");
		List<T> content = baseMapper.findAll();
		PageInfo<T> pageInfo = new PageInfo<T>(content);
		return new PageImpl<T>(content, request, pageInfo.getTotal());
	}

	@Override
	public void deleteById(Integer id) {
		baseMapper.deleteById(id);
		
	}

	@Override
	public void deleteInBatchById(List<Integer> idList) {
		baseMapper.deleteBatchById(idList);
		
	}
}
