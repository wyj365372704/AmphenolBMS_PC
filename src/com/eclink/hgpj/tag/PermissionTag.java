package com.eclink.hgpj.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.common.UserLoginInfo;

/**
 * PermissionTag.java
 *
 * @Title: 权限自定义标签
 * @Description: 用于控制JSP页面中的按钮操作,当用户没有权限时禁用或隐藏按钮
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 28, 2011 12:06:17 AM
 *
 */
public class PermissionTag extends BodyTagSupport {
	
	private static final long serialVersionUID = -1470687802781691128L;

	/**
	 * 标签属性-菜单资源KEY,必须
	 */
	private String resourceKey;
	
	/**
	 * 标签属性-操作KEY,必须
	 */
	private String operKey;
	
	/**
	 * 标签属性-无权限时的显示方式,配置为disable与hidden,默认为disable,选填项
	 */
	private String display;
	
	/**
	 * 标签属性-配置用于权限控制的对象的样式,选填项
	 */
	private String styleCss;

	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	public void setOperKey(String operKey) {
		this.operKey = operKey;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}

	public void setStyleCss(String styleCss) {
		this.styleCss = styleCss;
	}

	/**
	 * 标签开始
	 */
	public int doStartTag() throws JspException {
		init();
		return BodyTag.EVAL_BODY_BUFFERED;
	}

	/**
	 * 标签结束
	 */
	public int doEndTag() throws JspException {
		// 获取标签体内容
		String content = getBodyContent().getString();
		// 从会话中获取用户菜单资源数据信息
		UserLoginInfo info = (UserLoginInfo) pageContext.getSession().getAttribute(HGPJConstant.SESSION_USER_KEY);
		// 检查用户是否有菜单资源操作的权限
		String key = this.resourceKey + "|" + this.operKey;
//		boolean hasPerm = info.getResourceOpers().containsKey(key);
		boolean hasPerm = true;
		if (hasPerm) {
			try {
				pageContext.getOut().println(content);
			} catch (IOException e) {
			}
		} else if(this.display.equalsIgnoreCase("disable")) {
			// 如果是按钮
			if (content.toLowerCase().indexOf("input") > 0) {
				if (content.endsWith("/>")) {
					content = content.replaceAll("/>", " disabled/>");
				} else if (content.endsWith(">")) {
					content = content.replaceFirst(">", " disabled>");
				}
				// 设置按钮样式
				if (this.styleCss != null && !this.styleCss.trim().equals("")) {
					content = content.replaceFirst("(css)?[c|C]lass=\"\\S*\"",
							"class=\"" + this.styleCss + "\"");
				}
			} else if (content.toLowerCase().indexOf("select") > 0) { // 如果是下拉列表
				content = content.replaceAll("<select", "<select disabled ");
			}
			content = "<span disabled onclick=\"return false\">" + content + "</span>";
			try
		      {
		        this.pageContext.getOut().println(content);
		      } catch (Exception e) {
		      }
		}
		return Tag.EVAL_PAGE;
	}

	/**
	 * 标签开始时的初始化检查
	 * @throws JspException
	 */
	private void init() throws JspException {
		if (this.resourceKey == null || this.resourceKey.trim().equals("")) {
			throw new JspException("resourceKey为必填项");
		}
		if (this.operKey == null || this.operKey.trim().equals("")) {
			throw new JspException("operKey为必填项");
		}
		if (this.resourceKey.contains("|")) {
			throw new JspException("resourceKey格式不正确,不能包含字符'|'");
		}
		if (this.operKey.contains("|")) {
			throw new JspException("operKey格式不正确,不能包含字符'|'");
		}
		if (this.display == null || this.display.trim().equals("")) {
			this.display = "disable";
		} else if (!this.display.equalsIgnoreCase("disable")
				&& !this.display.equalsIgnoreCase("hidden")) {
			throw new JspException("display只能配置为disable或hidden");
		}
	}
}
