package com.breakman.cloud.common.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class LongStrObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 4472186021937609428L;

	/**
	 * 序列换成json时,将所有的long变成string 因为js中得数字类型不能包含所有的java long值
	 */
	public LongStrObjectMapper() {
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		super.registerModule(simpleModule);
	}

}