package com.breakman.cloud.utils;

import com.breakman.cloud.common.model.DBBeanAdapter;
import com.breakman.cloud.exception.AppException;
import com.breakman.cloud.exception.MessageContant;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;



/**
 * <p>
 * 通过java的反映射实现bean对象和Map之间的赋值处理. 主要用于DB的Map对象传递.
 * </p>
 * 
 * @author wq
 * 
 */
public class ReflectUtility {

	/**
	 * <p>
	 * <code>ReflectUtility</code> instances should NOT be constructed in
	 * standard programming. Instead, the class should be used as
	 * <code>ReflectUtility.valueObjectToMap(bean);</code>.
	 * </p>
	 *
	 * <p>
	 * This constructor is public to permit tools that require a JavaBean
	 * instance to operate.
	 * </p>
	 */
	private ReflectUtility() {
		super();
	}

	/**
	 * <p>
	 * The Constant bean GET.
	 * </p>
	 */
	public static final String GET = "get";

	/**
	 * <p>
	 * The Constant bean SET.
	 * </p>
	 */
	public static final String SET = "set";

	/**
	 * <p>
	 * The Constant name UNDER_SCORE.
	 * </p>
	 */
	public static final String UNDER_SCORE = "_";

	/**
	 * <p>
	 * 类型转换
	 * </p>
	 * 
	 * @param fieldValue
	 * @return
	 */
	private static Object convertObject(Object fieldValue) {
		if (fieldValue == null) {
			return fieldValue;
		}
		String className = fieldValue.getClass().getName();
		/* java.sql.Timestamp->ComDate */
		if (className.contains("Timestamp")) {
			return new Date(((Timestamp) fieldValue).getTime());
		}else{

		}
		return fieldValue;
	}

	/**
	 * <p>
	 * 类型转换改写
	 * </p>
	 *zhang
	 * @param fieldValue
	 * @return
	 */
	private static Object convertObject(Object fieldValue,String type) {
		if (fieldValue == null) {
			return fieldValue;
		}
		String className = fieldValue.getClass().getName();
		if(type.contains("Long")){
			return Long.valueOf(fieldValue.toString());
		}else if (className.contains("Timestamp")) {
			return new Date(((Timestamp) fieldValue).getTime());
		}
		return fieldValue;
	}

	/**
	 * <p>
	 * 根据一个bean对象返回一个Map对象. Map的Key值是bean的字段名,Value是bean字段对应的值.
	 * </p>
	 * 
	 * @param bean
	 *            bean对象
	 * @param adapter
	 *            适配DB to bean的名称方案;适配bean to DB的名称方案
	 * @param nullToEmpty
	 *            如果值为null时是否匹配为空串
	 * @return bean对象对应的一个Map对象
	 * @throws AppException
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> valueObjectToMap(final Object bean, DBBeanAdapter adapter, boolean nullToEmpty)
			throws AppException {

		if (bean == null) {
			throw new AppException(String.format(MessageContant.PARAM_NULL_ERROR, "valueObjectToMap"));
		}

		Map<String, Object> beanValue = new HashMap<String, Object>();

		Class clazz = bean.getClass();
		try {

			Method[] methods = clazz.getMethods();
			/* get方法都为空参数 */
			Object[] parameters = new Object[] {};
			for (Method method : methods) {

				String methodName = method.getName();

				/* 如果为getXXX方法 */
				if (methodName.substring(0, 3).equals(GET)) {
					/* 根据java的命名规范截取bean对应的字段名 */
					String fieldName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
					switch (adapter) {
					case DB2Bean:
						fieldName = adapterBeanNaming(fieldName);
						break;
					case Bean2DB:
						fieldName = adapterDBNaming(fieldName);
						break;
					case EQ:
						break;
					}
					/* 通过get方法取得该字段的值 */
					Object fieldValue = method.invoke(bean, parameters);
					/* 赋给Map并对该字段的值进行转换 */
					Object fieldVal;
					if (fieldValue == null && nullToEmpty) {
						fieldVal = StringUtils.EMPTY;
					} else {
						fieldVal = convertObject(fieldValue);
					}
					beanValue.put(fieldName, fieldVal);
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			throw new AppException(String.format(MessageContant.REFLECT_ERROR, e.getMessage()));
		}

		return beanValue;
	}

	/**
	 * <p>
	 * 根据一个Map对象返回一个bean对象. Map的Key值是bean的字段名,Value是bean字段对应的值.
	 * </p>
	 * 
	 * @param map
	 *            Map对象
	 * @param voClass
	 *            beanClass
	 * @param adapter
	 *            适配DB to bean的名称方案;适配bean to DB的名称方案
	 * @param nullToEmpty
	 *            如果值为null时是否匹配为空串
	 * @return bean对象
	 * @throws AppException
	 */
	public static <T> T mapToValueObject(Map<String, Object> map, Class<T> voClass, DBBeanAdapter adapter,
			boolean nullToEmpty) throws AppException {

		if (map == null || voClass == null) {
			throw new AppException(String.format(MessageContant.PARAM_NULL_ERROR, "mapToValueObject:map,voClass..."));
		}

		try {
			T voClazz = voClass.newInstance();
			mapToValueObject(map, voClazz, adapter, nullToEmpty);
			return voClazz;
		} catch (IllegalAccessException | InstantiationException e) {
			throw new AppException(e.getMessage());
		}
	}

	/**
	 * <p>
	 * 根据一个Map对象返回一个bean对象. Map的Key值是bean的字段名,Value是bean字段对应的值.
	 * </p>
	 * 
	 * @param map
	 *            Map对象
	 * @param voClassObj
	 *            beanClass对象
	 * @param adapter
	 *            适配DB to bean的名称方案;适配bean to DB的名称方案
	 * @param nullToEmpty
	 *            如果值为null时是否匹配为空串
	 * @return bean对象
	 * @throws AppException
	 */
	public static void mapToValueObject(Map<String, Object> map, Object voClassObj, DBBeanAdapter adapter,
			boolean nullToEmpty) throws AppException, IllegalArgumentException {

		if (map == null || voClassObj == null) {
			throw new AppException(
					String.format(MessageContant.PARAM_NULL_ERROR, "mapToValueObject:map,voClassObj..."));
		}

		try {
			Class<? extends Object> obj = voClassObj.getClass();

			Method[] methods = obj.getDeclaredMethods();
			Set<String> refFieldSet = map.keySet();

			for (Method method : methods) {

				String methodName = method.getName();
				String methodType = methodName.substring(0, 3);
				String propertiesName  = methodName.substring(3);
				String propertiesName2 = new StringBuilder().append(Character.toLowerCase(propertiesName.charAt(0)))
						.append(propertiesName.substring(1)).toString();
				Field field = obj.getDeclaredField(propertiesName2);
				String type = field.getType().toString();
				/* 如果为setXXX方法 */
				if (methodType.equals(SET)) {
					String mapKey = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
					switch (adapter) {
					case DB2Bean:
						mapKey = adapterBeanNaming(mapKey);
						break;
					case Bean2DB:
						mapKey = adapterDBNaming(mapKey);
						break;
					case EQ:
						break;
					}
					/* 找到包含的字段 */
					if (refFieldSet.contains(mapKey)) {

						Object fieldValue = map.get(mapKey);

						/* 赋给Map并对该字段的值进行转换 */
						Object fieldVal;
						if (fieldValue == null && nullToEmpty) {
							fieldVal = StringUtils.EMPTY;
						} else {
							fieldVal = convertObject(fieldValue,type);
						}
						method.invoke(voClassObj, fieldVal);
					}
				}
			}
		} catch (SecurityException | IllegalAccessException | InvocationTargetException e) {
			throw new AppException(e.getMessage());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * List map to list vo.
	 * </p>
	 * 
	 * @param listMap
	 *            list map
	 * @param beanType
	 *            bean type
	 * @param adapter
	 *            适配DB to bean的名称方案;适配bean to DB的名称方案
	 * @param nullToEmpty
	 *            如果值为null时是否匹配为空串
	 * @return list bean
	 * @throws AppException
	 */
	public static <T> List<T> listMapToListBean(List<Map<String, Object>> listMap, Class<T> beanType,
			DBBeanAdapter adapter, boolean nullToEmpty) throws AppException {

		List<T> list = new ArrayList<T>();
		for (Map<String, Object> map : listMap) {
			list.add(mapToValueObject(map, beanType, adapter, nullToEmpty));
		}

		return list;
	}

	/**
	 * <p>
	 * List bean to list map.
	 * </p>
	 * 
	 * @param listBean
	 *            list bean
	 * @param adapter
	 *            适配DB to bean的名称方案;适配bean to DB的名称方案
	 * @param nullToEmpty
	 *            如果值为null时是否匹配为空串
	 * @return list map
	 * @throws AppException
	 */
	public static List<Map<String, Object>> listBeanToListMap(List<?> listBean, DBBeanAdapter adapter,
			boolean nullToEmpty) throws AppException {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Object obj : listBean) {
			list.add(valueObjectToMap(obj, adapter, nullToEmpty));
		}

		return list;
	}

	/**
	 * <p>
	 * 将一个字段名转成DB命名风格的字段名. abcdEfg -> abcd_efg
	 * </p>
	 * 
	 * @param fieldName
	 *            字段名
	 * @return DB命名风格的字段名
	 */
	public static String adapterDBNaming(final String fieldName) {

		char[] fieldNameChars = fieldName.toCharArray();
		StringBuffer returnValue = new StringBuffer();

		for (char c : fieldNameChars) {
			/* A~Z */
			if (c > 64 && c < 91) {
				/* 变小写 */
				c += 32;
				returnValue.append(UNDER_SCORE);
			}
			returnValue.append(c);
		}

		return returnValue.toString();
	}

	/**
	 * <p>
	 * 将DB命名风格的字段转成bean命名的字段名. abcd_efg -> abcdEfg
	 * </p>
	 * 
	 * @param fieldName
	 *            字段名
	 * @return bean命名风格的字段名
	 */
	public static String adapterBeanNaming(final String fieldName) {

		char[] fieldNameChars = fieldName.toCharArray();

		StringBuffer returnValue = new StringBuffer();

		for (int i = 0; i < fieldNameChars.length; i++) {

			char c = fieldNameChars[i];
			/* '_' && 最后1位不做判断 */
			if (c == 95 && i < fieldNameChars.length - 1) {
				c = fieldNameChars[++i];
				c -= 32;
			}

			returnValue.append(c);
		}

		return returnValue.toString();
	}
}
