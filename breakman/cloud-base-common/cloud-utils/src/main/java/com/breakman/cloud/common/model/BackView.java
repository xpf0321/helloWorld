package com.breakman.cloud.common.model;

import java.io.Serializable;

public class BackView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;

	private Object data;

	private String message;


	/**
	 * 响应状态码
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 数据实体,json格式
	 * 
	 * @return
	 */
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 状态说明
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	

	public void setMessage(String message) {
		this.message = message;
	}

}