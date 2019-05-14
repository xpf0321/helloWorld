package com.breakman.cloud.utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * 排序工具
 */
public class SortListUtil {

    public static final String DESC = "desc";   //降序
    public static final String ASC = "asc";     //升序

    /**
     * 对list中的元素按升序排列.
     *
     * @param list  排序集合
     * @param field 排序字段
     * @return 排序后的List
     */
    public static List<?> sort(List<?> list, final String field) {
        return sort(list, field, null);
    }

    /**
     * 对list中的元素进行排序
     *
     * @param list  排序集合
     * @param field 排序字段
     * @param sort  排序方式: SortListUtil.DESC(降序) SortListUtil.ASC(升序).
     * @return 排序后的List
     */
    public static List<?> sort(List<?> list, final String field,
                               final String sort) {
        list.sort((a, b) -> {
            int ret = 0;
            try {
                Field f = a.getClass().getDeclaredField(field);
                f.setAccessible(true);
                Class<?> type = f.getType();

                if (type == int.class) {
                    ret = ((Integer) f.getInt(a)).compareTo(f
                        .getInt(b));
                } else if (type == double.class) {
                    ret = ((Double) f.getDouble(a)).compareTo(f
                        .getDouble(b));
                } else if (type == long.class) {
                    ret = ((Long) f.getLong(a)).compareTo(f
                        .getLong(b));
                } else if (type == float.class) {
                    ret = ((Float) f.getFloat(a)).compareTo(f
                        .getFloat(b));
                } else if (type == Date.class) {
                    ret = ((Date) f.get(a)).compareTo((Date) f.get(b));
                } else if (isImplementsOf(type, Comparable.class)) {
                    ret = ((Comparable) f.get(a)).compareTo(f
                        .get(b));
                } else {
                    ret = String.valueOf(f.get(a)).compareTo(
                        String.valueOf(f.get(b)));
                }

            } catch (SecurityException | NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
                e.printStackTrace();
            }
            if (sort != null && sort.toLowerCase().equals(DESC)) {
                return -ret;
            } else {
                return ret;
            }

        });
        return list;
    }

    /**
     * 判断对象实现的所有接口中是否包含szInterface
     *
     * @param clazz       对象
     * @param szInterface szInterface
     * @return boolean
     */
    private static boolean isImplementsOf(Class<?> clazz, Class<?> szInterface) {
        boolean flag = false;
        Class<?>[] face = clazz.getInterfaces();
        for (Class<?> c : face) {
            flag = c == szInterface || isImplementsOf(c, szInterface);
        }
        if (!flag && null != clazz.getSuperclass()) {
            return isImplementsOf(clazz.getSuperclass(), szInterface);
        }

        return flag;
    }
}
