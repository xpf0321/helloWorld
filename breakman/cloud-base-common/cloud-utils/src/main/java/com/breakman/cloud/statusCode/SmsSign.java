package com.breakman.cloud.statusCode;

/**
 * 腾讯云平台 短信签名模板
 * @author：Pengfei Wang
 * @date： 2018/4/27
 * @description：
 **/
public enum SmsSign {

    /**
     * 安宏睿业
     */
    ANHRY_SIGN("安宏睿业"),
    /**
     * 企安通
     */
    QYPT_SIGN("企安通"),
    ;


    private final String name;

    SmsSign(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        System.out.print(SmsSign.ANHRY_SIGN.getName());
    }
}

