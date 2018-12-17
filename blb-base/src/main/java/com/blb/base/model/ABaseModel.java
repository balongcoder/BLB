package com.blb.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class ABaseModel implements Serializable,Comparable<ABaseModel> {
	private static final long serialVersionUID = 1L;

	/** 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(value = "id")
    private Integer id;
	/**
	 * @JsonIgnore
	 */
	@Version
	private int version;
	/**
	 * @JsonIgnore
	 */
	private Date createTime;
	/**
	 * @JsonIgnore
	 */
	private Date editTime;
	/**
	 * @JsonIgnore
	 */
	private boolean isDelete;
	/**
	 * 
	 */
	@JsonProperty(value = "createUser") 
	private String createUser;
	/** 
	 */
	@JsonProperty(value = "editUser")
	/**
	 * 
	 */
	private String editUser;
	/** 
	 */
	@Transient
	/** 
	 */
	protected boolean isLoadContent = false;
	public void setIsLoadContent(boolean isLoadContent){
		this.isLoadContent = isLoadContent;
	}
	/**
	 * 
	 */
	@Transient
	public String errorMsg;
	/**
	 * 
	 */
	@Column(unique=true)
	protected String resourceID;
	@JsonIgnore
	public Integer getId() {
        return id;
    }
	@JsonIgnore
    public void setId(Integer id) {
        this.id = id;
    }
 
	/**
	 * 
	 */
    @PrePersist
	protected void onCreate() {
    	if(createTime ==null)
    		this.createTime = new Date();
    	if(editTime == null)
    		this.editTime = new Date();
	}
    /**
	 * 
	 */
	@PreUpdate
	protected void onUpdate() {
		this.editTime = new Date();
		
		if(this.createTime==null)
			this.createTime=this.editTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}
	public void setEditTime(Date editTime){
		this.editTime = editTime;
	}
	
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@JsonIgnore
	public String getCreateUser() {
		return createUser;
	}
	@JsonIgnore
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	@JsonIgnore
	public String getEditUser() {
		return editUser;
	}
	@JsonIgnore
	public void setEditUser(String editUser) {
		this.editUser = editUser;
	}
	@JsonIgnore
	public int getVersion() {
		return version;
	}
	@JsonIgnore
	private void setVersion(int version) {
		this.version = version;
	}
	public String getResourceID() {
		return resourceID;
	}
	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 
	 * @param businessKeysIndex ҵ������
	 * @return Ψһ��
	 */
	public String getErrorMsgForInsert(Integer businessKeysIndex) {
		return errorMsgs().get(businessKeysIndex);
	}
	/**
	 * 
	 * @param businessKeysIndex ҵ������
	 * @return ������Ϣ
	 */
	public String getErrorMsgForUpdate(Integer businessKeysIndex) {
		return errorMsgForUpdate().get(businessKeysIndex);
	}
	/**
	 * 
	 */
    @Override
	public int hashCode() {
 		return id.hashCode();
	}

	@Override
    public boolean equals(Object object) {
        
        if (object == null) {
            return false;
        }
        if (this == object && this.hashCode() == object.hashCode()) {
            return true;
        }

        if (!(object instanceof ABaseModel)) {
            return false;
        }

        final ABaseModel other = (ABaseModel) object;
        Serializable thisId = this.getId();
        Serializable otherId = other.getId();
        if ((thisId == null && otherId != null) || (thisId != null && !thisId.equals(otherId))) {
            return false;
        }
        return true;
    }
	
	@Override
	public int compareTo(ABaseModel another) {
		
		if(this.getId()>another.getId()){
			
			return -1;
			
		}else if(this.getId()<another.getId()){
			
			return 1;
		}
		
		return 0;
	}

	public String getChineseName(){
		return this.getClass().getSimpleName();
	}
	/**
	 *  ҵ��������
	 * @return �������
	 */
	public List<List<String>> getBusinessKeys(){
		List<List<String>> businessKeyGroup = new ArrayList<List<String>>();
		List<String> businessKeykeys_1 = new ArrayList<String>();
		businessKeykeys_1.add("resourceID");
		businessKeyGroup.add(businessKeykeys_1);
		return businessKeyGroup;
	}
	/**
	 * ���²�����ҪУ���ҵ��������
	 * @return �������
	 */
	public List<List<String>> getBusinessKeysForUpdate(){
		return this.getBusinessKeys();
	}
	/**
	 * ҵ������У��ʧ�ܴ�����Ϣ��˳����ҵ��������˳��һ�£�
	 * @return �������
	 */
	public List<String> errorMsgs(){
		List<String> errorMsgList = new ArrayList<String>();
		String indexOf_0 = getChineseName()+"ҵ���������,resourceID ["+this.resourceID+"] �ڷ������Ѿ�����";
		errorMsgList.add(indexOf_0);
		return errorMsgList;
	}
	/**
	 * ���²���ҵ������У��ʧ�ܴ�����Ϣ��˳����ҵ��������˳��һ�£�
	 * @return �������
	 */
	public List<String> errorMsgForUpdate(){
		return this.errorMsgs();
	}
	/**
	 * @return �������
	 */
	public Map<String,String> getBusinessKeysChineseName(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("resourceID", "resourceID");
		return map;
	}
	/**
	 * @param baseModel ������ 
	 * @return �������
	 */	
	public boolean validIsUpdate(ABaseModel baseModel){
		if(!this.resourceID.equals(baseModel.resourceID))
			return false;
		return true;
	}
	/**
	 *  ֵ������Ϊ�յ�ҵ������ 
	 * @return �������
	 */
	public List<List<String>> getNotNullBusinessKeys(){
		return this.getBusinessKeys();
	}
	@Override
	public String toString() {
		return this.resourceID;
	}
}
