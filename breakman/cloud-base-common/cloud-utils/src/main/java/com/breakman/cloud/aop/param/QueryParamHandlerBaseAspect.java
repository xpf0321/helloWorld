package com.breakman.cloud.aop.param;

import com.breakman.cloud.utils.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * AOP切面基类类
 * @author XiongZhengHai
 * @date 2018/08/09
 * @Description: 对前端传入的参数进行预处理, 1:end日期+1,  2:字符串的trim()
 * //@Aspect
 */
@Component
public abstract class QueryParamHandlerBaseAspect {

    /**
     * 具体类中要覆写pointcut
     *
     *
     * //@Pointcut("execution(* com.anhry.cloud..controller..*.*(..))")
     */
    protected abstract void pointcut();

    /**
     * 具体类中要覆写around
     *
     *
     * //@Around("pointcut()")
     */
    protected abstract Object around(ProceedingJoinPoint pjp) throws Throwable;

    // ---------------------------- 业务方法 begin ----------------------------
    /**
     * 处理所有的入参
     * @param pjp
     * @return
     * @throws Throwable
     */
    protected Object handleParamsAll(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();

        if(args == null || args.length == 0){
            return pjp.proceed(args);
        }

        try {
            // 处理结束日期
            args = handleParamsEndDate(args);

            // 处理字符串前后的空格
            args = handleParamsStringTrim(args);
        } catch (Exception e) {
            e.printStackTrace();
            args = pjp.getArgs();
        }
        return pjp.proceed(args);
    }

    /**
     * 处理字符串前后的空格
     * @param args
     * @return
     * @throws IllegalAccessException
     */
    private Object[] handleParamsStringTrim(Object[] args) throws IllegalAccessException {

        if(args == null || args.length == 0){
            return args;
        }

        Object target = args[0];
        final Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            final Object value = field.get(target);
            if(value instanceof String){
                String newValue = ((String) value).trim();
                field.set(target, newValue);
            }
        }
        return args;
    }

    /**
     * 把参数中的[结束日期]加一天, 解决日期区间查询时,不包括结束日期数据的问题.
     *
     * 范围: controller中方法参数是endTime或endDate.
     *
     * @param args
     */
    private Object[] handleParamsEndDate(Object[] args) throws IllegalAccessException {

        if(args == null || args.length == 0){
            return args;
        }

        List<String> keywords = new LinkedList<>();
        // 这样写准确, 不够灵活
//        keywords.add("endDate");
//        keywords.add("endTime");

        // 下面这样写更灵活, 比如还能匹配到timeEnd. 但有可能出现异常,比如 dayTimeDate (这么起名真的好吗)
        keywords.add("end");
        keywords.add("time");
        keywords.add("date");
        Object target = args[0];

        //获取匹配的属性列表
        final List<Field> fieldNameList = getMatchedFieldList(keywords, target, null);

        if(fieldNameList == null || fieldNameList.isEmpty()){
            return args;
        }

        // 列表中的结束日期+1天
        for(Field field: fieldNameList){
            try {
                final Object value = field.get(target);
                if(value instanceof Date){
                    // 结束日期 + 1天
                    Date newDate = DateUtils.getAfterDay((Date)value);
                    field.set(target, newDate);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return args;
    }
    // ---------------------------- 业务方法 end ----------------------------

    // ---------------------------- 工具方法 begin ----------------------------
    /**
     *
     * 获取匹配关键字的非空属性名List
     * @param keywords 关键字, 比如end, start, name...
     * @param target 目标对象
     * @param matchTimes 目标对象中的属性名与关键字需要匹配的次数, 比如: keywords={"end", "time", "date"}, fieldName == "endTime",
     *                   则 matchTimes == 2. 如果不指定, q 默认值 == keywords.size() -1;
     * @return 在目标对象中查找到的包含关键字的属性名List
     */
    private List<Field> getMatchedFieldList(List<String> keywords, Object target, Integer matchTimes) throws IllegalAccessException {
        List<Field> result = new LinkedList<>();
        if(keywords == null || keywords.size() == 0){
            return result;
        }

        final Field[] declaredFields = target.getClass().getDeclaredFields();
        if(declaredFields == null || declaredFields.length == 0){
            return result;
        }

        for(Field field : declaredFields) {
            if(isContainKeyword(keywords, field.getName(), matchTimes)){
                if(isFieldNotNull(field, target)){
                    result.add(field);
                }
            }
        }
        return result;
    }

    /**
     * 判断属性不为空
     * @param field
     * @param target
     * @return
     */
    private boolean isFieldNotNull (Field field, Object target) throws IllegalAccessException {
        field.setAccessible(true);
        final Object value = field.get(target);
        if(value != null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断是否包含关键字
     * @param keywords 关键字, 比如end, start, name...
     * @param matchTimes 目标对象中的属性名与关键字需要匹配的次数, 比如: keywords={"end", "time", "date"}, fieldName == "endTime",
     *                   则 matchTimes == 2. 如果不指定, 默认值 == keywords.size() -1;
     * @return 在目标对象中查找到的包含关键字的属性名List
     */
    private boolean isContainKeyword(List<String> keywords, String fieldName, Integer matchTimes){
        Integer currentMatchTimes = 0;

        if(keywords == null || keywords.isEmpty()){
            return false;
        }

        for(String keyword: keywords) {
            // 转大写后,再匹配
            if(fieldName.toUpperCase().contains(keyword.toUpperCase())){
                currentMatchTimes++;
            }
        }

        if(matchTimes == null){
            matchTimes = keywords.size() -1;
        }

        if(currentMatchTimes >= matchTimes){
            return true;
        }else {
            return false;
        }
    }
    // ---------------------------- 工具方法 end ----------------------------
}
