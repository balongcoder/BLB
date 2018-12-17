package com.blb.base.idao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.blb.base.model.ABaseModel;

public interface IBaseIdao <T extends ABaseModel> {

	/**
	 * 根据业务主键查询
	 * @param resourceID 业务主键
	 * @return 返回当前数据
	 */
	public T findByResourceID(String resourceID);
	/**
	 * 根据业务主键批量查询
	 * @param resourceIDs 批量业务主键
	 * @return 当前一批数据
	 */
	public List<T> findByResourceIDIn(List<String> resourceIDs);
	/**
	 * 根据ID集合查询
	 * @param idList  ID集合
	 * @return 当前一批数据
	 */
	public List<T> findByIdIn(List<Integer> idList,PageRequest pageRequest);
	
	public List<T> findByIdIn(List<Integer> idList);

	/**
	 * 单个保存数据
	 * @param model 保存对象 
	 * @return 当前保存对象
	 */
	public T save(T model);
	/**
	 * 批量保存数据
	 * @param modelList 一批保存对象 
	 * @return 当保存后的一批对象
	 */
	public List<T> save(List<T> modelList);
	/**
	 * 更新一批数据
	 * @param modelList 一批更新对象 
	 * @return 更新后的一批数据
	 */
	public List<T> update(List<T> modelList);
	/**
	 * 更新单个对象
	 * @param model 单个更新对象 
	 * @return 更新后的对象
	 */
	public T update(T model); 
	/**
	 * 根据ID查询
	 * @param id 查询 
	 * @return 当前ID查询的对象
	 */
	public T find(Integer id);
	/**
	 * 查询所有数据
	 * @return 当前表中所有数据
	 */
	public List<T> findAll();
	/**
	 * @return 当前总量
	 */
	public long count();
	/**
	 * 删除对象
	 * @param model 删除对象 
	 */
	public void delete(T model);
	/**
	 * 按照id删除对象
	 * @param model 删除对象 
	 */
	public void deleteById(Integer id);
	/**
	 * 批量删除
	 * @param modelList 
	 */
	public void deleteInBatch(List<T> modelList);
	/**
	 * 按照id批量删除
	 * @param modelList 
	 */
	public void deleteInBatchById(List<Integer> idList); 
	/**
	 * 分页查询所有数据
	 * @param request 请求分页
	 * @return 分页数据
	 */
	public Page<T> findAll(Pageable request);
}
