package com.breakman.cloud.statusCode;

/**
 * <p>
 * </p>
 *
 * @author wq
 */
public enum IfConstant {
    /**
     * 操作成功
     */
    SERVER_SUCCESS("000000000", "操作成功"),
    UNKNOWN_ERROR("999999999", "未知错误"),
    UNTASK_COUNT("000004444", "只有安全主管部门才有任务数统计"),
    SESSION_EXPIRED("000000001", "会话过期请重新登录"),
    NET_FAIL("100100001", "网络连接失败"),
    PARA_FAIL("100100002", "请求参数有误"),
    PLATFORM_FAIL("100100003", "平台报文校验错误"),
    LOGIN_ERROR("100100005", "用户密码或账号错误"),
    USERNAME_ERROR("100100005", "用户密码或账号错误"),
    MOBILE_CODE_UNUSED("100100006", "短信验证码已经失效请重新发送"),
    MOBILE_CODE_UNRIGHT("100100007", "短信验证码匹配错误"),
    MOBILE_CODE_UNNULL("100100077", "短信验证码不能为空"),
    IMG_CODE_UNRIGHT("100100088", "图片验证码匹配错误"),
    IMG_CODE_UNNULL("100100088", "图片验证码不能为空"),
    LOGINNAME_NOT_EXIST("100100008", "登录名不存在"),
    VERIFICATION_CODE_FAILED_TO_SEND("100100009", "验证码发送失败"),
    USERNAME_IS_EXIST("100100010", "已有用户名，不能再次设置"),
    USERNAME_REPEAT("100100011", "该用户名或手机号已被使用，请重新设置"),
    USERNAME_EXISTED("100100015", "该手机号的用户已存在于您的企业"),
    LOGINNAME_EXISTED("100100088", "登录名已存在"),
    LOGINNAME_FORMAT_ERROR("100100088", "登录名只能是字母和数字"),
    LOGINNAME_FORMAT_GREATER20("100100088", "登录名不能大于20位"),
    PASSWORD_FORMAT_GREATER20("100100088", "密码不能小于8位"),
    PHONE_NOT_REGISTER("100100009", "该手机未注册"),
    PHONE_REGISTERED("100100019", "该手机已注册"),
    PHONE_BIND("100100029", "该手机已被绑定"),
    INVITATION_TIME_OUT("100100016", "邀请码已过期"),
    NO_PERMISSIONS("100100017", "没有权限"),
    FILE_IMAGE_TOOMAX("100100011", "文件大小限制3M"),
    FILE_IMAGE_UPLOAD_FAIL("100100012", "文件上传失败"),
    IMG_VERIFICATION_UNRIGHT("100100013", "验证码匹配错误"),
    OLDPASSWORD_FAIL("100100017", "原密码不正确"),
    iLLEGAL_REQUESTS("10000000","非法请求"),
    PARAM_ID_IS_NOT_NULL("1001000411", "ID不能为空"),

    MOBILE_CODE_UNRIGHT_ONE("100200001", "短信验证码匹配错误"),
    MOBILE_CODE_UNRIGHT_TWO("100200002", "短信验证码匹配错误，再错3次将锁定30分钟"),
    MOBILE_CODE_UNRIGHT_THREE("100200003", "短信验证码匹配错误，再错2次将锁定30分钟"),
    MOBILE_CODE_UNRIGHT_FOUR("100200004", "短信验证码匹配错误，再错1次将锁定30分钟"),
    MOBILE_CODE_UNRIGHT_FIVE("100200005", "短信验证码匹配错误，请30分钟后再试"),
    MOBILE_CODE_UNRIGHT_OTHER("100200006", "账号异常安全拦截，请稍后再试"),

    PARAM_SYSTEM_DICTIONARY_GROUP_NAME_IS_NOT_NULL("2001000001", "数据字典分组名称不能为空"),
    PARAM_SYSTEM_DICTIONARY_GROUP_ID_IS_NOT_NULL("2001000002", "数据字典分组ID不能为空"),
    PARAM_SYSTEM_DICTIONARY_ID_IS_NOT_NULL("2001000111", "数据字典ID不能为空"),

    PARAM_SYSTEM_DICT_DISTRICT_ID_IS_NOT_NULL("2001000112", "行政区域ID不能为空"),
    PARAM_SYSTEM_DICT_DISTRICT_PARENT_ID_IS_NOT_NULL("2001000113", "行政区域父ID不能为空"),

    PARAM_CORP_ID_IS_NOT_NULL("2001000211", "企业ID不能为空"),
    PARAM_CORP_NAME_IS_NOT_REPEAT("2001000222", "企业名称重复，请重新输入"),
    PARAM_CORP_ENABLED_IS_NOT_NULL("2001000212", "启用标识不能为空"),

    PARAM_CORP_DEPT_ID_IS_NOT_NULL("2001000312", "部门ID不能为空"),
    PARAM_CORP_DEPT_NAME_IS_NOT_NULL("2001000313", "部门名称不能为空"),
    PARAM_CORP_DEPT_NAME_IS_NOT_REPEAT("2001000314", "同一父节点下名称不能重复"),
    PARAM_CORP_DEPT_NAME_IS_NOT_LEAF("2001000315", "不是叶子节点"),
    PARAM_CORP_DEPT_STATUSCODE_IS_NOT_NULL("2001000316", "部门状态不能为空"),

    PARAM_CORP_JOB_ID_IS_NOT_NULL("2001000411", "岗位ID不能为空"),
    PARAM_CORP_JOB_NAME_IS_NOT_NULL("2001000412", "岗位名称不能为空"),
    PARAM_CORP_JOB_NAME_IS_NOT_REPEAT("2001000413", "岗位名称不能重复"),
    PARAM_CORP_JOB_STATUSCODE_IS_NOT_NULL("2001000414", "岗位状态不能为空"),

    PARAM_CORP_POSITION_ID_IS_NOT_NULL("2001000511", "职务ID不能为空"),
    PARAM_CORP_POSITION_NAME_IS_NOT_NULL("2001000512", "职务名称不能为空"),
    PARAM_CORP_POSITION_NAME_IS_NOT_REPEAT("2001000513", "职务名称不能重复"),
    PARAM_CORP_POSITION_STATUSCODE_IS_NOT_NULL("2001000514", "职务状态不能为空"),

    PARAM_CORP_LEVEL_ID_IS_NOT_NULL("2001000531", "隐患级别ID不能为空"),
    PARAM_CORP_LEVEL_NAME_IS_NOT_NULL("2001000532", "隐患级别名称不能为空"),
    PARAM_CORP_LEVEL_NAME_IS_NOT_REPEAT("2001000533", "隐患级别名称不能重复"),
    PARAM_CORP_LEVEL_STATUSCODE_IS_NOT_NULL("2001000534", "隐患级别状态不能为空"),

    PARAM_CORP_USER_ID_IS_NOT_NULL("2001000611", "用户ID不能为空"),

    PARAM_PERMISSION_ID_IS_NOT_NULL("2001001711", "菜单ID不能为空"),

    PARAM_CORP_INSTITUTION_ID_IS_NOT_NULL("2001000711", "制度ID不能为空"),
    PARAM_CORP_INSTITUTION_NAME_IS_NOT_NULL("2001000712", "制度名称不能为空"),
    PARAM_CORP_INSTITUTION_NAME_IS_NOT_REPEAT("2001000713", "制度名称不能重复"),
    PARAM_CORP_INSTITUTION_STATUSCODE_IS_NOT_NULL("2001000714", "制度状态不能为空"),
    PARAM_CORP_INSTITUTION_FILE_IS_NULL("2001000715", "附件为空"),
    PARAM_CORP_INSTITUTION_FILE_PATH_IS_NOT_NULL("2001000716", "文件路径不能为空"),
    PARAM_CORP_RELATION_ID_IS_NOT_NULL("2001000811", "企业黑名单ID不能为空"),

    PARAM_STATUSCODE_IS_NOT_NULL("2001000777", "状态不能为空"),

    PARAM_CORP_APPLY_ID_IS_NOT_NULL("2001000911", "企业邀请ID不能为空"),
    PARAM_CORP_APPLY_INITIATECORPId_IS_NOT_NULL("2001000912", "发起企业ID不能为空"),
    PARAM_CORP_APPLY_INVITEDCORPID_IS_NOT_NULL("2001000913", "受邀企业ID不能为空"),
    PARAM_CORP_APPLY_STATUSCODE_IS_NOT_NULL("2001000914", "状态码不能为空"),
    PARAM_CORP_APPLY_RELATION("2001000915", " 无法邀请该企业，该企业已将您拉入黑名单"),
    PARAM_CORP_APPLY_RELATION_OR_BLACKLIST ("2001000916", "不能邀请自己的上级企业"),
    PARAM_CORP_APPLY_ALREADY ("2001000917", "已发送邀请，请耐心等待"),
    PARAM_CORP_APPLY_ALREADY_PARENT ("2001000918", "被邀请企业已存在上级企业，不能被邀请"),
    PARAM_CORP_APPLY_ALREADY_INDIRECT_PARENT ("2001000919", "与邀请企业已经存在间接上下级关系，不能被邀请"),
    PARAM_CORP_APPLY_IS_RELATION ("2001000920", "已邀请，请勿重新邀请"),

    PARAM_CORP_USER_ROLE_ID_IS_NOT_NULL("2001001011", "企业用户角色ID不能为空"),
    PARAM_CORP_USER_ROLE_NAME_IS_NOT_NULL("2001001012", "企业用户角色名称不能为空"),
    PARAM_CORP_USER_ROLE_NAME_IS_NOT_REPEAT("2001001013", "企业用户角色名称不能重复"),
    PARAM_CORP_USER_ROLE_PERMISSION_IS_NOT_NULL("2001001014", "权限不能为空"),
    PARAM_CORP_USER_ROLE_STATUSCODE_IS_NOT_NULL("2001001015", "企业用户角色状态不能为空"),

    PARAM_HD_ID_IS_NOT_NULL("2001001111", "隐患ID不能为空"),
    PARAM_HD_FILETYPE_NOT_NULL("2001001112", "文件类型不能为空"),
    PARAM_HD_FILE_INFO_ID_NOT_NULL("2001001112", "附件ID不能为空"),

    PARAM_NAME_IS_NOT_REPEAT("2001000314", "名称不能重复"),
    PARAM_NAME_CODE_IS_NOT_REPEAT("2001000315", "名称或编码不能重复"),

    COMPANY_NAME_ALREADY_EXISTS("3001000001", "该企业名称或手机号已经注册"),
    NO_QUERY_TO_ENTERPRISE_INFORMATION("3001000002", "没有查询到企业信息"),
    DID_NOT_QUERY_THE_CORPORAT_LICENSE_INFORMATION("3001000003", "没有查询到证照信息"),

    PERSON_NAME_ALREADY_EXISTS("3001000004", "该用户名称或手机号已经注册"),
    FILE_BYTES_NOT_EXIST("100100018", "文件上传失败"),
    NO_ATTACHMENTS("100100019", "附件不能为空"),
    SYSTEM_TIMES_OUT_VERIFY_AGAIN("100100020", "系统超时请重新验证"),
    DEPARTMENT_OF_STAFF_IS_NOT_EMPTY_CAN_NOT_BE_DELETED("100100023", "部门下的人员不为空，无法删除"),
    THE_FORMAT_IS_INCORRECT("100100024", "名称含有非法字符"),
    INCORRECT_FILE_FORMAT("100100025","文件格式不正确"),


    //--------------------------------------------- 政府平台 start ------------------------------------------

    /**
     * 监管分类验证
     */
    PARAM_GOV_REGULATORY_ID_IS_NOT_NULL("3001000312", "监管分类ID不能为空"),
    PARAM_GOV_REGULATORY_TYPE_NAME_IS_NOT_NULL("3001000313", "监管分类名称不能为空"),
    PARAM_GOV_REGULATORY_TYPE_NAME_IS_NOT_REPEAT("3001000314", "同一父节点下名称不能重复"),
    PARAM_GOV_REGULATORY_TYPE_NAME_IS_NOT_LEAF("3001000315", "不是叶子节点"),
    GOV_REGULATORY_TYPE_OF_CORP_IS_NOT_EMPTY_CAN_NOT_BE_DELETED("3001000316", "该监管分类下的企业不为空，无法删除"),

    //--------------------------------------------- 政府平台 end ------------------------------------------



    /**
     * 营业执照验证
     */
    VALIDATE_FAILED_LICENSES_CODE_EXIST("200000001","统一社会信用代码已被占用，请联系平台客服处理"),
    VALIDATE_FAILED_LICENSES_CODE_INVALID("200000002","统一社会信用代码不正确，请重新输入"),

    /**
     * 专家手机号验证
     */
    VALIDATE_SUCCESSFUL_ACCOUNT_NOT_EXISTED("000000000", "验证成功,账户未注册"),
    VALIDATE_SUCCESSFUL_UNRELATED("000000001", "验证成功,专家存在,但与本中介机构无关"),
    VALIDATE_SUCCESSFUL_CORPUSER_NOT_EXISTED("000000002", "验证成功,用户未生成"),
    VALIDATE_FAILED_EXPERT_DELETED("100000000", "验证失败,专家已解除关系"),
    VALIDATE_FAILED_EXPERT_EXISTED("100000001", "验证失败,专家已在[专家台账]中"),
    VALIDATE_FAILED_EXPERT_UNAUDITED("100000002", "验证失败,专家已在[待审核]中"),
    VALIDATE_FAILED_EXPERT_INVATED("100000003", "验证失败,专家已被邀请, 等待对方审核"),
    VALIDATE_FAILED_EXPERT_REFUSED("100000004", "验证失败,专家拒绝邀请, 请从[邀请记录]中重新邀请"),
    VALIDATE_FAILED_BACKSTAGE("100000005", "验证失败,新增或邀请专家时后台验证失败"),

    /**
     * 中介机构
     */
    EXPERT_INVATE_SUCCESSFULLY("000000000", "专家邀请成功!"),
    EXPERT_ADD_SUCCESSFULLY("000000000", "专家新增成功!"),
    ADMIN_CANNOT_BE_DELETED("000000001", "删除成功,但中介机构管理员不能被删除"),

    SERVER_FAILED("100000000", "操作失败"),

    IMPORT_EXCEL_WRONG_POSTFIX("1000000000", "只能导入.xlsx格式的excel!"),


    /**
     * 风险源
     */
    QRCORD_SCAN_NOT_EXIST_CKECKCONTENT("20020001", "二维码扫入不存在检查内容"),
    /**
     * 手机登录验证该注册用户是否加入或注册过企业/中介
     */
    ACCOUNT_NOT_CORP_ACCESS_AUTHORITY("1001000412", "登录失败，该帐号未注册或加入过企业!"),
    ACCOUNT_NOT_INTERMEDIARY_ACCESS_AUTHORITY("2001000921", "登录失败，该帐号未注册或加入过中介机构!")
    ;

    private String code;
    private String message;

    IfConstant(String cd, String msg) {
        this.code = cd;
        this.message = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}