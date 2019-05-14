package com.breakman.cloud.utils;

import java.lang.reflect.Method;
import java.util.List;

public class DistrictUtil {

    /**
     * 将省市区用“-”组装到一起
     * @param list   要转换的list
     * @param object 类
     * @param <T>    泛型
     * @return 组装后的list
     * @throws Exception 异常处理
     */
    public static <T> List<T> formatDistrict(List<T> list, Class object) throws Exception {
        Method getProvinceName = object.getMethod("getProvinceName");
        Method getCityName = object.getMethod("getCityName");
        Method getCountryName = object.getMethod("getCountryName");
        Method getVillageName = object.getMethod("getVillageName");
        Method setDistrictName = object.getMethod("setDistrictName",String.class);
        StringBuilder districtName = new StringBuilder();
        for (T node : list) {
            if((getProvinceName.invoke(node))!=null){
                districtName.append((getProvinceName.invoke(node)).toString());
            }
            if((getCityName.invoke(node))!=null){
                districtName.append("-").append((getCityName.invoke(node)).toString());
            }
            if((getCountryName.invoke(node))!=null){
                districtName.append("-").append((getCountryName.invoke(node)).toString());
            }
            if((getVillageName.invoke(node))!=null){
                districtName.append("-").append((getVillageName.invoke(node)).toString());
            }
            if(districtName != null){
                setDistrictName.invoke(node, districtName.toString());
            }
            districtName = new StringBuilder();
        }
        return list;
    }
}