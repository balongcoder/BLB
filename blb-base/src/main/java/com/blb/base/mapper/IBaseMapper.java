package com.blb.base.mapper;

import java.util.List;

public interface IBaseMapper<T>{
	/**
	 * 添加
	 * @param model 插入对象
	 */
	void insert(T model);
	/**
	 * 批量添加
	 * @param modelList 批量插入对象
	 */
	void insertBatch(List<T> modelList);
	/**
 	 * @param model 更新对象
	 */
	void update(T model);
	/**
	 * 批量修改
	 * @param modelList 批量更新对象
	 */
	void updateBatch(List<T> modelList);
	/**
	 * 删除
	 * @param model 删除对象
	 */
	void delete(T model);
	/**
	 * 按照id删除
	 * @param model 删除对象
	 */
	void deleteById(Integer id);
	/**
	 * 批量删除
	 * @param modelList 批量删除对象
	 */
	void deleteBatch(List<T> modelList);
	/**
	 * 按照id批量删除
	 * @param modelList 批量删除对象
	 */
	void deleteBatchById(List<Integer> idList);
	/**
	 * 根据ResourceID 查询
	 * @param resourceID 业务主键
	 * @return 当前对象
	 */
	T findByResourceID(String resourceID);
	/**
	 * 批量查询
	 * @param resourceIDList 批量业务主键
	 * @return 当前对象
	 */
	List<T> findByResourceIDIn(List<String> resourceIDList);
	/**
	 * @return 总量
	 */
	long count();
	/**
	 * 	根据ID查询
	 * @param id 查询
	 * @return 当前唯一对象
	 */
	T findOne(Integer id);
	/**
	 * @param idList 批量ID查询
	 * @return 批量数据
	 */
	List<T> findByIdList(List<Integer> idList);
	/**
	 * 查询所有数据
	 * @return 所有数据
	 */
	List<T> findAll();
}
