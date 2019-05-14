package com.breakman.cloud.common.constant;

/**
 * 账号常量
 */
public enum AccountConstant {

	ACCOUNT_TYPE_PERSONAL (1,"个人账号"),
    ACCOUNT_TYPE_GOVERNMENT(4,"政府账号"),
    ACCOUNT_TYPE_OPERATE(8,"运营账号")
    ;

	private Integer key;   //账号类型
	private String value;    //类型名称

    AccountConstant(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}