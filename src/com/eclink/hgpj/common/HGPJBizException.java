package com.eclink.hgpj.common;
/**
 * HGPJBizException.java
 *
 * @Title: 海关评价系统业务异常类
 * @Description: 海关评价系统业务处理时，发生的任何异常，均向上抛出HGPJBizException.
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 9, 2011 2:48:33 PM
 *
 */
public class HGPJBizException extends Exception{
	
	private static final long serialVersionUID = -7932931643416769481L;

	public HGPJBizException() {
		super();
	}

	public HGPJBizException(String message) {
		super(message);
	}

	public HGPJBizException(Throwable cause) {
		super(cause);
	}

	public HGPJBizException(String message, Throwable cause) {
		super(message, cause);
	}
}
