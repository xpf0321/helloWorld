package com.breakman.cloud.common.model;
/**
 * <p>
 * 枚举 DB对象到bean;bean对象到DB
 * </p>
 * 
 * @author wq
 *
 */
public enum DBBeanAdapter {
	/**
	 * <p>DB命名规范转为bean命名规范</p>
	 */
	DB2Bean,
	/**
	 * <p>bean命名规范转为DB命名规范</p>
	 */
	Bean2DB,
	/**
	 * <p>不转换</p>
	 */
	EQ;
}