package com.blb.base.iservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.blb.base.model.ABaseModel;
import com.blb.base.model.UserVo;

public interface IBaseService<T extends ABaseModel> {
	
	/**
	 * 创建业务主键
	 * @return 返回业务主键
	 */
	public String createRid();
	/**
	 * 根据业务主键查询
	 * @param resourceID 业务主键
	 * @return 返回当前数据
	 */
	public T findByResourceID(String resourceID);
	/**
	 * 根据业务主键批量查询
	 * @param resourceIDs 业务主键
	 * @return 当前一批数据
	 */
	public List<T> findByResourceIDIn(List<String> resourceIDs);
	/**
	 * 根据ID集合查询
	 * @param idList 一批主键
	 * @return 当前一批数据
	 */
	public List<T> findByIdIn(List<Integer> idList,PageRequest pageRequest);
	
	public List<T> findByIdIn(List<Integer> idList);

	/**
	 * 单个保存数据
	 * @param model 单个对象
	 * @param userVo 操作人
	 * @return 当前保存对象
	 */
	public T save(T model,UserVo userVo);
	/**
	 * 批量保存数据
	 * @param modelList 批量对象
	 * @param userVo 操作人
	 * @return 当保存后的一批对象
	 */
	public List<T> save(List<T> modelList,UserVo userVo);
	/**
	 * 更新一批数据
	 * @param modelList 批量对象
	 * @param userVo 操作人
	 * @return 更新后的一批数据
	 */
	public List<T> update(List<T> modelList,UserVo userVo);
	/**
	 * 更新单个对象
	 * @param model 单个更新对象
	 * @param userVo 操作人
	 * @return 更新后的对象
	 */
	public T update(T model,UserVo userVo); 
	/**
	 * @param id 根据ID查询
	 * @return  当前ID查询的对象
	 */
	public T find(Integer id);
	/**
	 * 
	 * @return 当前总量
	 */
	public long count();
	/**
	 * 删除对象
	 * @param model 单个删除对象
	 * @param userVo 操作人
	 */
	public void delete(T model,UserVo userVo);
	/**
	 * 批量删除
	 * @param modelList 批量删除数据
	 * @param userVo 操作人
	 */
	public void deleteInBatch(List<T> modelList,UserVo userVo); 
	/**
	 * 分页查询所有数据
	 * @param request 请求参数
	 * @return 所有数据
	 */
	public Page<T> findAll(Pageable request);
	/**
	 * 级连删除
	 * @param model 单个级连删除对象
	 * @param user 操作人
	 */
	public void preDelete(T model,UserVo user);
	/**
	 * 批量级连删除
	 * @param modelList 批量级连删除对象集合
	 * @param user 操作人
	 */
	public void preDeleteInBatch(List<T> modelList,UserVo user);
	
}
