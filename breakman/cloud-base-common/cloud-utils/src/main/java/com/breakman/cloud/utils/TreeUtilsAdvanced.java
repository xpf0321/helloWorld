package com.breakman.cloud.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TreeUtilsAdvanced {

    /**
     * 格式化树形
     *
     * @param list   要转换的list
     * @param object 类
     * @param <T>    泛型
     * @return 树形list
     * @throws Exception 异常处理
     */
    public static <T> List<T> formatTree(List<T> list, Class object) throws Exception {
        Method getIdMethod;
        if (object.getSimpleName().equals("ListDto")) {
            getIdMethod = object.getMethod("getValue");
        } else {
            getIdMethod = object.getMethod("getId");
        }
        Method getParentIdMethod = object.getMethod("getParentId");
        Method getChildrenMethod = object.getMethod("getChildren");
        Method setChildrenMethod = object.getMethod("setChildren", List.class);
        List<T> nodeList = new ArrayList<T>();
        for (T node1 : list) {
            boolean mark = false;
            for (T node2 : list) {
                if (getParentIdMethod.invoke(node1) != null && getParentIdMethod.invoke(node1).equals(getIdMethod.invoke(node2))) {
                    mark = true;
                    if (getChildrenMethod.invoke(node2) == null) {
                        setChildrenMethod.invoke(node2, new ArrayList<T>());
                    }
                    ArrayList<T> arrayList = (ArrayList<T>) getChildrenMethod.invoke(node2);
                    arrayList.add(node1);
                }
            }
            if (!mark) {
                nodeList.add(node1);
            }
        }
        return nodeList;
    }
}