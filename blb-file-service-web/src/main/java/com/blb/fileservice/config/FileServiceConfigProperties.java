package com.blb.fileservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="blb")
@PropertySource(value = {"classpath:conf.properties"},encoding="utf-8")
public class FileServiceConfigProperties {

	private String baseUrl;
	private String uploadUserName;
	private String uploadUserPass;
	private String fileSystemPath;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
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
	public String getFileSystemPath() {
		return fileSystemPath;
	}
	public void setFileSystemPath(String fileSystemPath) {
		this.fileSystemPath = fileSystemPath;
	}
	
}
