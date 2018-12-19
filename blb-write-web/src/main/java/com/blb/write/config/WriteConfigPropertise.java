package com.blb.write.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="blb")
@PropertySource(value = {"classpath:conf.properties"},encoding="utf-8")
public class WriteConfigPropertise {

	private String baseUrl;
	private String uploadUrl;
	private String uploadUserName;
	private String uploadUserPass;
	private String cachePath;
	private String projectName;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String getUploadUrl() {
		return uploadUrl;
	}
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}
	public String getUploadUserName() {
		return uploadUserName;
	}
	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = uploadUserName;
	}
	public String getUploadUserPass() {
		return uploadUserPass;
	}
	public void setUploadUserPass(String uploadUserPass) {
		this.uploadUserPass = uploadUserPass;
	}
	public String getCachePath() {
		return cachePath;
	}
	public void setCachePath(String cachePath) {
		this.cachePath = cachePath;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
