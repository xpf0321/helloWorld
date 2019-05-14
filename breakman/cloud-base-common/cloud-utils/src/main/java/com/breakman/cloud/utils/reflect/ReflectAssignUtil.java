package com.breakman.cloud.utils.reflect;

import java.lang.reflect.Field;

/**
 * @author XiongZhengHai
 * @date 2018/04/20
 * @Description:
 */
public class ReflectAssignUtil {

    /**
     *
     * 方法描述 : 反射覆写bean的属性值
     * 		   用source的class的属性 覆写 target的class相同的属性
     *
     * @param source
     * @param target
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     *
     */
    public static String overwriteSameLevelProperty(Object source, Object target) throws IllegalArgumentException, IllegalAccessException{

        if(source == null || target == null){
            return "";
        }

        StringBuffer diff = new StringBuffer(target.getClass().getSimpleName()+"-修改的内容如下:");
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        // loop source fields
        for(Field sf : sourceFields){
            sf.setAccessible(true);

            // loop target fields
            for(Field tf : targetFields){
                tf.setAccessible(true);

                String sfName = sf.getName();
                String tfName = tf.getName();

                if(sf.get(source) == null){
                    continue;
                }

                if(sfName.equals(tfName) && !sf.get(source).equals(tf.get(target))){
                    diff.append(sf.getName()+" "+ tf.get(target)+" --> "+sf.get(source)+ ", ");
                    tf.set(target, sf.get(source));
                }

            }
        }
        return diff.toString();
    }


    /**
     *
     * 方法描述 : 反射覆写bean的属性值
     * 		   用source的class的属性 覆写 target的superClass相同的属性
     *
     * @param source
     * @param target
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     *
     */
    public static String overwriteTargetSuperClassFields(Object source, Object target) throws IllegalArgumentException, IllegalAccessException{

        if(source == null || target == null){
            return "";
        }

        StringBuffer diff = new StringBuffer(target.getClass().getSimpleName()+"-修改的内容如下:");
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getSuperclass().getDeclaredFields();

        // loop source fields
        for(Field sf : sourceFields){
            sf.setAccessible(true);
            String sfName = sf.getName();

            for(Field tf : targetFields){
                tf.setAccessible(true);

                String tfName = tf.getName();

                if(sf.get(source) == null){
                    continue;
                }

                //当属性名相同
                if(sfName.equals(tfName) && !sf.get(source).equals(tf.get(target))){

                    diff.append(sf.getName()+" "+ tf.get(target)+" --> "+sf.get(source)+ ", ");
                    tf.set(target, sf.get(source));
                }

            }

        }

        return diff.toString();
    }


    /**
     *
     * 方法描述 : 反射覆写bean的属性值
     * 		   用source的superClass的属性 覆写 target的superClass相同的属性
     *
     * @param source 源实体类
     * @param target 目标实体类
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     *
     */
    public static String overwriteSuperClassFields(Object source, Object target) throws IllegalArgumentException, IllegalAccessException{

        if(source == null || target == null){
            return "";
        }

        StringBuffer diff = new StringBuffer(target.getClass().getSimpleName()+"-修改的内容如下:");
        Field[] sourceFields = source.getClass().getSuperclass().getDeclaredFields();
        Field[] targetFields = target.getClass().getSuperclass().getDeclaredFields();

        // loop source fields
        for(Field sf : sourceFields){
            sf.setAccessible(true);
            String sfName = sf.getName();

            for(Field tf : targetFields){
                tf.setAccessible(true);

                String tfName = tf.getName();

                if(sf.get(source) == null){
                    continue;
                }

                //当属性名相同
                if(sfName.equals(tfName) && !sf.get(source).equals(tf.get(target))){

                    diff.append(sf.getName()+" "+ tf.get(target)+" --> "+sf.get(source)+ ", ");
                    tf.set(target, sf.get(source));
                }

            }

        }

        return diff.toString();
    }
}
