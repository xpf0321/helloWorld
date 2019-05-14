package com.breakman.cloud.utils;

import com.breakman.cloud.statusCode.IfConstant;
import com.breakman.cloud.statusCode.LoginStatusCode;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回结果
 * Created by ice on 16/10/3.
 */
public class ResultResponse {


    public ResultResponse() {
    }

    /**
     * 构建成功结果响应对象
     *
     * @param data 数据
     * @return 构建成功结果对象
     */
    public static ResultResponse wrap(Object data) {
        return new ResultResponse(data);
    }
    /**
     * 构建失败结果响应对象
     *
     * @param loginStatusCode
     * @return 构建失败结果对象
     */
    public static ResultResponse wrap(LoginStatusCode loginStatusCode) {
        return new ResultResponse(loginStatusCode.getCode(),loginStatusCode.getMessage());
    }


    /**
     * 构建失败结果响应对象
     *
     * @param code    错误代码
     * @param message 错误消息
     * @return 失败结果对象
     */
    public static ResultResponse wrap(String code, String message) {
        return new ResultResponse(code, message);
    }

    /**
     * 构建参数错误失响应对象
     *
     * @param message 错误消息
     * @return 失败结果对象
     */
    public static ResultResponse wrap(String message) {
        return new ResultResponse(message);
    }

    /**
     * 通用
     *
     * @param data 返回数据
     * @param ifc  返回类型
     * @return
     */
    public static ResultResponse wrap(Object data, IfConstant ifc) {
        return new ResultResponse(data, ifc.getCode(), ifc.getMessage());
    }

    public static ResultResponse wrap(Object data ,String message){
        return new ResultResponse(data,message);
    }
    /**
     * 通用返回提示
     *
     * @param ifc 返回类型
     * @return
     */
    public static ResultResponse wrap(IfConstant ifc) {
        return new ResultResponse(ifc.getCode(), ifc.getMessage());
    }

    /**
     * 构建成功结果响应对象
     *
     * @param data 数据
     */
    private ResultResponse(Object data) {
        this.code = IfConstant.SERVER_SUCCESS.getCode();
        this.data = data;
        this.message = IfConstant.SERVER_SUCCESS.getMessage();
    }

    /**
     * 构建失败结果响应对象
     *
     * @param code 错误码
     * @param message 错误信息
     */
    private ResultResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构建失败结果响应对象
     *
     * @param message 错误信息
     */
    private ResultResponse(String message) {
        this.code = IfConstant.PARA_FAIL.getCode();
        this.message = message;
    }
    private ResultResponse(Object object ,String message){
        this.data = object;
        this.message = message;
    }
    private ResultResponse(Object data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }


    /**
     * 错误消息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    /**
     * 消息成功标志
     */
    private String code;

    /**
     * 数据信息
     */
    private Object data;


    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}
