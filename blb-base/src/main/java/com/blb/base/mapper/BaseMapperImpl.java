package com.blb.base.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

@Mapper
public class BaseMapperImpl<T> extends SqlSessionDaoSupport implements IBaseMapper<T> {
	 /**
	  * 命名控件
	  */
	 private String namespace;
	 /**
	  * 单个插入
	  */
	 public static final String SQLID_INSERT = "insert";  
	 /**
	  * 批量插入
	  */
	 public static final String SQLID_INSERT_BATCH = "insertBatch";  
	 /**
	  * 更新
	  */
	 public static final String SQLID_UPDATE = "update";  
	 /**
	  * 批量更新
	  */
	 public static final String SQLID_UPDATE_BATCH = "updateBatch";  
	 /**
	  * 删除
	  */
	 public static final String SQLID_DELETE = "delete";  
	 /**
	  * 删除
	  */
	 public static final String SQLID_DELETEBYID = "deleteById"; 
	 /**
	  * 批量删除
	  */
	 public static final String SQLID_DELETE_BATCH = "deleteBatch"; 
	 /**
	  * 批量删除
	  */
	 public static final String SQLID_DELETE_BATCHBYID = "deleteBatchById";  
	 /**
	  * 统计总量
	  */
	 public static final String SQLID_COUNT = "count";
	 /**
	  * 根据业务主键查询
	  */
	 public static final String SQLID_FINDBYRESOURCEID = "findByResourceID";
	 /**
	  * 批量业务主键查询
	  */
	 public static final String SQLID_FINDBYRESOURCEIDIN = "findByResourceIDIn";
	 /**
	  * 单个对象
	  */
	 public static final String SQLID_FINDONE = "findOne";
	 /**
	  * 批量对象查询
	  */
	 public static final String SQLID_FINDBYIDLIST = "findByIdList";
	 /**
	  * 所有数据查询
	  */
	 public static final String SQLID_FINDALL = "findAll";
	 /**
	  * 查询Param
	  */
	 public static final String SQLID_SELECT_PARAM = "selectParam";
	 /**
	  * 
	  * @param sqlSessionTemplate 模版
	  */
	 @Resource(name = "sqlSessionTemplate")  
	 public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {  
	    super.setSqlSessionTemplate(sqlSessionTemplate);  
	 }     
	  
	 public String getNamespace() {  
	    return namespace;  
	 }    
	  
	 public void setNamespace(String namespace) {  
	    this.namespace = namespace;  
	 }    
	
	
	@Override
	public void insert(T model) {
		getSqlSession().insert(namespace + "." + SQLID_INSERT,model); 
	}

	@Override
	public void insertBatch(List<T> modelList) {
		getSqlSession().insert(namespace + "." + SQLID_INSERT_BATCH,modelList); 
	}

	@Override
	public void update(T model) {
		getSqlSession().update(namespace + "." + SQLID_UPDATE,model);
	}

	@Override
	public void updateBatch(List<T> modelList) {
		getSqlSession().update(namespace + "." + SQLID_UPDATE_BATCH,modelList);
	}

	@Override
	public void delete(T model) {
		getSqlSession().delete(namespace + "." + SQLID_DELETE,model);
	}

	@Override
	public void deleteBatch(List<T> modelList) {
		getSqlSession().delete(namespace + "." + SQLID_DELETE_BATCH,modelList);
	}

	@Override
	public T findByResourceID(String resourceID) {
		return getSqlSession().selectOne(namespace + "." + SQLID_FINDBYRESOURCEID,resourceID);
	}

	@Override
	public List<T> findByResourceIDIn(List<String> resourceIDList) {
		return getSqlSession().selectList(namespace + "." + SQLID_FINDBYRESOURCEIDIN,resourceIDList);
	}

	@Override
	public long count() {
		return getSqlSession().selectOne(namespace + "." + SQLID_COUNT);
	}

	@Override
	public T findOne(Integer id) {
		return getSqlSession().selectOne(namespace + "." + SQLID_FINDONE,id);
	}

	@Override
	public List<T> findByIdList(List<Integer> idList) {
		return getSqlSession().selectList(namespace + "." + SQLID_FINDBYIDLIST,idList);
	}

	@Override
	public List<T> findAll() {
		return getSqlSession().selectList(namespace + "." + SQLID_FINDALL);
	}

	@Override
	public void deleteById(Integer id) {
		getSqlSession().delete(namespace + "." + SQLID_DELETEBYID, id);
	}

	@Override
	public void deleteBatchById(List<Integer> idList) {
		getSqlSession().delete(namespace + "." + SQLID_DELETE_BATCHBYID, idList);
		
	}
}
