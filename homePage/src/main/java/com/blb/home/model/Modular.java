package com.blb.home.model;

import com.blb.base.model.ABaseModel;

/**
 * 
 * @ClassName: Modular
 * @Description: 模块
 * @author bahailong
 * @date 2018年12月21日 下午3:33:09
 *
 */
public class Modular extends ABaseModel {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	
	private String ip;
	private String urlprefix;
	private String code;
	private String name;
	private byte[] menuicon;
	private String port;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUrlprefix() {
		return urlprefix;
	}
	public void setUrlprefix(String urlprefix) {
		this.urlprefix = urlprefix;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(byte[] menuicon) {
		this.menuicon = menuicon;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
}
