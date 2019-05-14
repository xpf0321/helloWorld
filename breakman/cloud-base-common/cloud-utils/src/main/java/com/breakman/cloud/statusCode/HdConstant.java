package com.breakman.cloud.statusCode;

/**
 * Created by Administrator on 2018/3/8.
 */
public enum HdConstant {

    FREQUENCY_CHECK_YEAR("6", "年"),
    FREQUENCY_CHECK_QUARTER("5", "季"),
    FREQUENCY_CHECK_MONTH("4", "月"),
    FREQUENCY_CHECK_WEEK("3", "周"),
    FREQUENCY_CHECK_DAY("2", "日"),
    LOGIN_FAILED("100000000", "验证失败"),
    EXPERT_EXISTED("100000001", "专家已存在"),
    STANDARD_TYPE_FIRST_BASICS("1006", "基础管理"),
    STANDARD_TYPE_FIRST_SCENE("1071", "现场管理"),


    ;


    private String code;
    private String message;

    HdConstant(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
