package com.eclink.hgpj.user.action;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;

/**
 * LogoutAction.java
 *
 * @Title: 用户注销Action
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @version 1.0
 * @date May 25, 2013 7:28:22 PM
 *
 */
public class LogoutAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(LogoutAction.class);

	/**
	 * 用户注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		HttpSession session = logoutGetSession();
		if (session != null) {
			// 清除会话
			getSession().invalidate();
		}
		return SUCCESS;
	}
}
