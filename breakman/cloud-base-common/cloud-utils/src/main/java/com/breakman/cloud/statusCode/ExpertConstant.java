package com.breakman.cloud.statusCode;

/**
 * Created by XiongZhengHai on 2018/1/23.
 */
public enum  ExpertConstant {

    LOGIN_SUCCESSFUL("000000000", "验证成功"),
    LOGIN_FAILED("100000000", "验证失败"),
    EXPERT_EXISTED("100000001", "专家已存在"),


    ;


    private String code;
    private String message;

    ExpertConstant(String code, String message) {
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
