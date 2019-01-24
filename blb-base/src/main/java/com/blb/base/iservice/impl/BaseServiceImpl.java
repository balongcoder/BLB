package com.blb.base.iservice.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.blb.base.idao.IBaseIdao;
import com.blb.base.iservice.IBaseService;
import com.blb.base.model.ABaseModel;
import com.blb.base.model.UserVo;
import com.blb.base.util.DateUtil;

public class BaseServiceImpl <T extends ABaseModel> implements IBaseService<T> {
	/**
	 * 日志注入
	 */
	private static final Logger LOG = LoggerFactory.getLogger(BaseServiceImpl.class);
	/**
	 * 平台ID
	 */
	@Value("com.blb.model")
	private String tmpID;
	/**
	 * @return 平台ID
	 */
	public String getTmpID() {
		return tmpID;
	}
	/**
	 * @param tmpID 平台ID
	 */
	public void setTmpID(String tmpID) {
		this.tmpID = tmpID;
	}
	/**
	 * 注入
	 *
	 */
	protected IBaseIdao<T> baseIdo;
	/**
	 * 单个业务主键查询
	 * @param resourceID 业务主键
	 * @return 当前对象
	 */
	public T findByResourceID(String resourceID) {
		return baseIdo.findByResourceID(resourceID);
	}
	/**
	 * 批量业务主键查询
	 * @param resourceIDs 业务主键
	 * @return 一批对象
	 */
	public List<T> findByResourceIDIn(List<String> resourceIDs) {
		if (resourceIDs!=null&&!resourceIDs.isEmpty()) {
			return baseIdo.findByResourceIDIn(resourceIDs);
		}
		return new ArrayList<T>();
	}
	/**
	 *@return  查询总量
	 */
	public long count() {
		return baseIdo.count();
	}
	/**
	 * 随机数
	 */
	Random r = new Random();

	/**
	 *  isFrom Client:是否来自Client端
	 *  @param model 对象
	 *  @param createUser 操作人
	 *  @return <a>
	 */
	public T save(T model, UserVo createUser) {
		if (createUser != null) {
			model.setCreateUser(createUser.getUserNumber());
			model.setEditUser(model.getCreateUser());
		}
		if (((ABaseModel) model).getResourceID() == null) {
			model.setResourceID(createRid());
		}
		String dateStr =  DateUtil.getDateStr(new Date(), "yyyy-MM-dd HHmmssSSS");
 		Date date = DateUtil.getDate(dateStr, "yyyy-MM-dd HHmmssSSS");
		model.setCreateTime(date);
		model.setEditTime(date);
		return baseIdo.save(model);
	}

	/**
	 *  isFrom Client:是否来自Client端
	 *  @param modelList 批量更新对象
	 *  @param createUser 操作人
	 *  @return <a>
	 */
	public List<T> save(List<T> modelList, UserVo createUser) {
		if (modelList==null||modelList.isEmpty())
			return modelList;
		LOG.info("start build " + modelList.get(0).getClass().getName());
		for (Iterator<T> iterator = modelList.iterator(); iterator.hasNext();) {
			T model = iterator.next();
			if (createUser != null) {
				model.setCreateUser(createUser.getUserNumber());
				model.setEditUser(model.getCreateUser());
			}
			if (((ABaseModel) model).getResourceID() == null) {
				model.setResourceID(createRid());
 				String dateStr =  DateUtil.getDateStr(new Date(), "yyyy-MM-dd HHmmssSSS");
				Date date = DateUtil.getDate(dateStr, "yyyy-MM-dd HHmmssSSS");
				((ABaseModel) model).setCreateTime(date);
				((ABaseModel) model).setEditTime(date);
			}
		}
		LOG.info("end build " + modelList.get(0).getClass().getName());
		List<T> refModelList = baseIdo.save(modelList);
		LOG.info("batch save end,all " + refModelList.size() + " size");
		return refModelList;
	}

	/**
	 *  editUser:is null 表示Client端
	 *  @param modelList 批量更新对象
	 *  @param editUser 操作人
	 *  @return <a>
	 */
	public List<T> update(List<T> modelList, UserVo editUser) {
		if (modelList ==null || modelList.isEmpty())
			return modelList;

		if (editUser != null) {
			Logger updateLog = LoggerFactory.getLogger("updateLog");
			for (T model : modelList) {
				updateLog.info("Update Data:" + model.getChineseName() + ",UpdateUser:" + editUser.getUserNumber()
						+ ",ResourceID:" + model.getResourceID());
				model.setEditUser(editUser.getUserNumber());
				String dateStr =  DateUtil.getDateStr(new Date(), "yyyy-MM-dd HHmmssSSS");
				Date d = DateUtil.getDate(dateStr, "yyyy-MM-dd HHmmssSSS");
				model.setEditTime(d);
			}
		}
		return baseIdo.update(modelList);
	}
	/**
	 * 单个更新
	 * @param model 更新对象
	 * @param editUser 操作用户
	 * @return 更新后对象
	 */
	public T update(T model, UserVo editUser) {
		if (editUser != null) {
			model.setEditUser(editUser.getUserNumber());
			Logger updateLog = LoggerFactory.getLogger("updateLog");
			updateLog.info("Update Data:" + model.getChineseName() + ",UpdateUser:" + editUser.getUserNumber()
					+ ",ResourceID:" + model.getResourceID());
			String dateStr =  DateUtil.getDateStr(new Date(), "yyyy-MM-dd HHmmssSSS");
			Date d = DateUtil.getDate(dateStr, "yyyy-MM-dd HHmmssSSS");
			model.setEditTime(d);
		}
		return baseIdo.update(model);
	}
	/**
	 * 单个查询
	 * @param id 数据主键
	 * @return 当前对象
	 */
	public T find(Integer id) {
		return baseIdo.find(id);
	}
	/**
	 * ID集合查询
	 * @param idList 查询ID集合
	 * @return 一批数据
	 */
	public List<T> findByIdIn(List<Integer> idList,PageRequest pageRequest) {
		if (idList!=null&&!idList.isEmpty()) {
			return baseIdo.findByIdIn(idList,pageRequest);
		}
		return new ArrayList<T>();
	}
	
	public List<T> findByIdIn(List<Integer> idList) {
		if (idList!=null&&!idList.isEmpty()) {
			return baseIdo.findByIdIn(idList);
		}
		return new ArrayList<T>();
	}
	/**
	 * 查询ID集合
	 * @param idArray 数组
	 * @return 一批数据
	 */
	public List<T> findByIdIn(String[] idArray) {
		if (idArray!=null&&idArray.length > 0) {
			List<Integer> idList = new ArrayList<Integer>(idArray.length);
			for (String id : idArray) {
				idList.add(Integer.valueOf(id));
			}
			return baseIdo.findByIdIn(idList);
		}
		return new ArrayList<T>();
	}
	 
	/**
	 * 删除
	 * @param model 批量对象
	 * @param user 操作人员
	 */
	public void delete(T model, UserVo user) {
		if (model == null) {
			return;
		}
		Field[] fields = this.getFiles(model);
		preDelete(model, user);
		// 记录Delete的Log
		Logger deleteLog = LoggerFactory.getLogger("deleteLog");
		String dataInfo = this.getDataInfo(model, fields);
		baseIdo.delete(model);
		deleteLog.info("Detete Data:" + model.getChineseName() + ",DeleteUser:" + user.getUserNumber() + ",Info:" + dataInfo);
	}
	/**
	 * 级连单个删除
	 * @param model 对象
	 * @param user 操作人员
	 */
	public void preDelete(T model, UserVo user) {
		return;
	}
	/**
	 * 批量级连删除
	 * @param modelList 批量对象
	 * @param user 操作人员
	 */
	public void preDeleteInBatch(List<T> modelList, UserVo user) {
		for (T model : modelList) {
			preDelete(model, user);
		}
	}
	/**
	 * 批量删除
	 * @param modelList 批量对象
	 * @param user 操作人员
	 */
	public void deleteInBatch(List<T> modelList, UserVo user) {
		if(modelList!=null&&!modelList.isEmpty()){
			Field[] fields = null;
			Logger deleteLog = LoggerFactory.getLogger("deleteLog");
			if (user != null) {
				for (T model : modelList) {
					if (fields == null) {
						fields = this.getFiles(model);
					}
					String dataInfo = this.getDataInfo(model, fields);
					if (dataInfo != null)
						deleteLog.info(
								"Detete Data:" + model.getChineseName() + ",DeleteUser:" + user.getUserNumber() + dataInfo);
					else
						deleteLog.info("Detete Data:" + model.getChineseName() + ",DeleteUser:" + user.getUserNumber());
				}
			}
			preDeleteInBatch(modelList, user);
			baseIdo.deleteInBatch(modelList);
		}
	}
	/**
	 * 
	 * @param model 对象
	 * @return 对象所有子项
	 */
	protected Field[] getFiles(T model) {
		Field[] fields = model.getClass().getDeclaredFields();
		return fields;
	}

	/**
	 * 声明为 protected是为了子类能够使用该方法
	 * @param model 对象
	 * @param fields 子项
	 * @return 获取的子类
	 */
	private String getDataInfo(T model, Field[] fields) {
		StringBuilder result = new StringBuilder();
		result.append("	Info:");
		result.append("ResourceID:");
		result.append(model.getResourceID());
		result.append("; ");
		StringBuilder dateInfo = new StringBuilder();
		for (Field field : fields) {
			String filedType = field.getType().getName();
			if ("java.lang.String".equals(filedType)) {
				String fieldName = field.getName();

				field.setAccessible(true);
				String value = "";
				try {
					value = (String) field.get(model);
				} catch (IllegalArgumentException e) {
					LOG.debug(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					LOG.debug(e.getMessage(), e);
				}
				if (value != null && !"".equals(value)) {

					if (value.indexOf("\n") != -1) {
						value = value.replaceAll("\n", " ");
					}
					if (value.length() > 70) {
						value = value.substring(0, 70);
						dateInfo.append(fieldName);
						dateInfo.append(":");
						dateInfo.append("【");
						dateInfo.append(value);
						dateInfo.append("……");
						dateInfo.append("】");
						dateInfo.append("; ");
					} else {
						dateInfo.append(fieldName);
						dateInfo.append(":");
						dateInfo.append(value);
						dateInfo.append("; ");
					}
				}
			} else if ("java.lang.Boolean".equals(filedType) || "boolean".equals(filedType)) {
				String fieldName = field.getName();

				field.setAccessible(true);
				Boolean value = null;
				try {
					value = (Boolean) field.get(model);
				} catch (IllegalArgumentException e) {
					LOG.debug(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					LOG.debug(e.getMessage(), e);
				}
				if (value != null) {
					dateInfo.append(fieldName);
					dateInfo.append(":");
					dateInfo.append(value);
					dateInfo.append("; ");
				}
			} else if ("java.elselang.Integer".equals(filedType) ||"int".equals(filedType)) {
				String fieldName = field.getName();

				field.setAccessible(true);
				Integer value = null;
				try {
					value = (Integer) field.get(model);
				} catch (IllegalArgumentException e) {
					LOG.debug(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					LOG.debug(e.getMessage(), e);
				}
				if (value != null) {
					dateInfo.append(fieldName);
					dateInfo.append(":");
					dateInfo.append(value);
					dateInfo.append("; ");
				}
			}
		}

		if ("".equals(dateInfo.toString())) {
			return result.toString();
		} else {
			result.append(dateInfo);
			return result.toString();
		}
	}

	/**
	 * 返回modellist的id的Stringbuider
	 * @param modelList 批量对象
	 * @return 一批对象Buider
	 */
	public StringBuilder getIdStringBuilder(List<? extends ABaseModel> modelList) {
		if (modelList.isEmpty()) {
			return new StringBuilder().append("''");
		} else {
			StringBuilder builder = new StringBuilder();
			for (ABaseModel model : modelList) {
				builder.append(model.getId() + ",");
			}
			int index = builder.lastIndexOf(",");
			builder.deleteCharAt(index);
			return builder;
		}
	}

	/**
	 * @param modelList 一批对象
	 * @return StringBuilder
	 */
	public StringBuilder getResourceIdStringBuilder(List<? extends ABaseModel> modelList) {
		if (modelList.isEmpty()) {
			return new StringBuilder().append("''");
		} else {
			StringBuilder builder = new StringBuilder();
			for (ABaseModel model : modelList) {
				builder.append("'" + model.getResourceID() + "',");
			}
			int index = builder.lastIndexOf(",");
			builder.deleteCharAt(index);
			return builder;
		}
	}

	@Override
	public Page<T> findAll(Pageable request) {
		Page<T> pages = baseIdo.findAll(request);
		return pages;
	}
	
	/**
	 * 创建业务主键
	 * @return 返回业务主键
	 */
	@Override
	public String createRid() {
		UUID uuid =UUID.randomUUID();   
        // 去掉"-"符号
        return uuid.toString().replaceAll("-", ""); 
	}
}
