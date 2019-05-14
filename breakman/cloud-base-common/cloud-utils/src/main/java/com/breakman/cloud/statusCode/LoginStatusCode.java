package com.breakman.cloud.statusCode;

/**
 * ms-login-shiro 服务状态码
 * Created by zhang on 2017/09/07.
 */
public enum LoginStatusCode {
    LOGIN_SUCCESSFUL("000000000", "登录成功"),
    REGISTRATION_SUCCESS("000000000", "注册成功"),
    REGISTRATION_FAILED("100200001", "注册失败"),
    PHONE_NUMBER_ALREADY_EXISTS("100200002", "手机号已注册,请登录"),
    PHONE_NUMBER_CAN_NOT_BE_EMPTY("100200003", "手机号不能为空"),
    UNKNOWN_ERROR("999999999", "未知错误"),
    PARA_FAIL("100100002", "请求参数有误"),
    USER_NAME_AND_PASSWORD_CAN_NOT_BE_EMPTY("100100001", "用户名密码不能为空"),
    THE_USER_NAME_OR_PASSWORD_IS_INCORRECT("100100002","用户名或密码不正确"),
    THE_PASSWORD_DOES_NOT_MATCH_TWICE("100100003","两次密码输入不匹配"),
    USER_IS_LOCKED("100100003","用户被锁定"),
    ;

    private String code;
    private String message;

    LoginStatusCode(String code, String message) {
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

