package com.breakman.cloud.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;

/**
 * 重写BeanUtils.copyProperties
 *
 */
public class BeanUtilsExtends extends BeanUtils {
	static {
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	}

	public static void copyProperties(Object dest, Object orig)
			throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties(dest, orig);
	}
}