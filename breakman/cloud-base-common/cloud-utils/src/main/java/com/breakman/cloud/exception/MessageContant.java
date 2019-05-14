package com.breakman.cloud.exception;

/**
 * 异常类信息
 * 
 * @author wangqiao
 *
 */
public class MessageContant {
    
	/** 文件未找到. */
	public static final String FILE_NOT_FOUND = "未找到文件:%s";
	/** 文件读取异常. */
	public static final String FILE_READ_ERROR = "文件读取异常，文件:%s.";
	/** 文件关闭异常. */
	public static final String FILE_CLOSE_ERROR = "文件关闭异常.文件:%s.";
	/** 参数为空异常. */
	public static final String PARAM_NULL_ERROR = "参数为空异常.方法:%s.";
	/** bean反射异常. */
	public static final String REFLECT_ERROR = "bean反射异常.方法:%s.";
	/** 时间转换错误. 参数1:转换的时间,参数2:转换的格式*/
	public static final String DATE_CONVT_ERROR = "时间转换错误. 时间:%s 格式:%s.";
}
