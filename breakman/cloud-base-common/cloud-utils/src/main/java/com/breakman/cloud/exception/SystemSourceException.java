package com.breakman.cloud.exception;

/**
 * <p>
 * 封装应用异常类.
 * </p>
 * 
 * @author wq
 *
 */
public class SystemSourceException extends Exception {

	private static final long serialVersionUID = -4396751563306893187L;

	/**
	 * Instantiates a new common exception.
	 */
	public SystemSourceException() {
		super();
	}

	/**
	 * Instantiates a new common exception.
	 *
	 * @param msg
	 *            异常信息
	 */
	public SystemSourceException(final String msg) {
		super(msg);
	}
}
