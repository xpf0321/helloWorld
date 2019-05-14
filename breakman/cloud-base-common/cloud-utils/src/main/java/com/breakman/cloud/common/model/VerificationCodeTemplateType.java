package com.breakman.cloud.common.model;

/**
 * 验证码模板类型
 */
public enum VerificationCodeTemplateType {

	REGISTER_SMS(2,"注册验证码"),
    CHANGE_PHONE_SMS(6,"更换手机绑定验证码");

	private Integer templateType;   //模板类型
	private String templateName;    //模板名称

    VerificationCodeTemplateType(Integer templateType, String templateName) {
        this.templateType = templateType;
        this.templateName = templateName;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}