package com.blb.write.util;

public class ParamUtil {

	private static String baseUrl;
	private static String uploadUrl;
	private static String uploadUserName;
	private static String uploadUserPass;
	private static String cachePath;
	private static String projectName;
	
	public static String getBaseUrl() {
		return baseUrl;
	}
	public static void setBaseUrl(String baseUrl) {
		ParamUtil.baseUrl = baseUrl;
	}
	
	public static String getUploadUrl() {
		return uploadUrl;
	}
	public static void setUploadUrl(String uploadUrl) {
		ParamUtil.uploadUrl = uploadUrl;
	}
	public static String getUploadUserName() {
		return uploadUserName;
	}
	public static void setUploadUserName(String uploadUserName) {
		ParamUtil.uploadUserName = uploadUserName;
	}
	public static String getUploadUserPass() {
		return uploadUserPass;
	}
	public static void setUploadUserPass(String uploadUserPass) {
		ParamUtil.uploadUserPass = uploadUserPass;
	}
	public static String getCachePath() {
		return cachePath;
	}
	public static void setCachePath(String cachePath) {
		ParamUtil.cachePath = cachePath;
	}
	public static String getProjectName() {
		return projectName;
	}
	public static void setProjectName(String projectName) {
		ParamUtil.projectName = projectName;
	}
	
}
