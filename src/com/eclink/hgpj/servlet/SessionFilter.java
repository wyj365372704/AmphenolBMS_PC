package com.eclink.hgpj.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.common.UserLoginInfo;
import com.eclink.hgpj.util.Utils;

/**
 * SessionFilter.java
 * 
 * @Title: 会话过滤器
 * @Description: 拦截系统所有请求（排除不做会话检查的URL配置），检查用户是否已经登录系统、是否存在重复登录。
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.

 * @version 1.0
 * @date Nov 24, 2011 2:18:48 PM
 * 
 */
public class SessionFilter implements Filter {

	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(SessionFilter.class);

	/**
	 * 不做会话检查的精确URL(不含通配符*)地址集合
	 */
	private Set<String> excludeSet = new HashSet<String>();
	
	/**
	 * 不做会话检查的正则URL（含通配符*）的地址列表
	 */
	private List<String> excludeRegList = new ArrayList<String>();

	/**
	 * 过滤器销毁
	 */
	public void destroy() {
		this.excludeSet.clear();
	}

	/**
	 * 执行过滤
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 获取用户请求的URL地址
		String servletPath = request.getServletPath();
		// 访问地址不在会话检查排除的URL地址范围内
		if (!match(servletPath)) {
			HttpSession session = request.getSession();
			// 处理开始时间
			long start = System.currentTimeMillis();
			// 从会话中获取用户登录信息
//			UserLoginInfo info = (UserLoginInfo) session.getAttribute(HGPJConstant.SESSION_USER_KEY);
			String username = (String)session.getAttribute("username");
			if ((username == null)) {
				// 未登录重定向至登录页面
				redirectLogin(request, response);
				return;
			}
			if (log.isDebugEnabled()) {
				log.debug("SessionFilter(url=" + request.getServletPath()
						+ ") used:" + (System.currentTimeMillis() - start) + "ms");
			}
		}
		chain.doFilter(req, resp);
	}

	/**
	 * 过滤器初始化
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			// 获取不做会话检查的URL地址
			String sessionCheckExclude = filterConfig.getInitParameter("exclude");
			if (!StringUtils.isBlank(sessionCheckExclude)) {
				// 去除回车、换行、空格等字符串
				sessionCheckExclude = Utils.replaceBlank(sessionCheckExclude);
				StringTokenizer st = new StringTokenizer(sessionCheckExclude, ",");
				while (st.hasMoreElements()) {
					String url = (String) st.nextElement();
					// URL地址中是否包含通配符'*'
					if (url.contains("*")) {
						url = "^"
								+ (url.replaceAll("\\.", "\\\\.").replaceAll(
										"\\*", ".*")) + "$";
						this.excludeRegList.add(url);
					} else {
						this.excludeSet.add(url);
					}
				}
			}
		} catch (Exception e) {
			log.error("Session filter init error.", e);
			throw new ServletException("Session filter init error.", e);
		}
	}

	/**
	 * 重定向至登录页面，并记录用户未登录前访问地址
	 * 
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws IOException
	 */
	private void redirectLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String url = request.getContextPath() + "/login.jsp";
		// 记录用户当时访问的URL地址
		String redirectURL = request.getServletPath();
		url = url + "?redirectURL=" + URLEncoder.encode(redirectURL, "UTF-8");
		if (null != request.getQueryString()) {
			url = url + "&" + request.getQueryString();
		}
		String targetURL = response.encodeRedirectURL(url);
		// 重定向至登录页面
		response.sendRedirect(targetURL);
	}
	
	/**
	 * 重定向至错误提示页面
	 * 
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param msg 错误提示消息
	 * @param backUrl 回退URL
	 * @throws IOException
	 * @throws ServletException
	 */
	private void redirectError(HttpServletRequest request,
			HttpServletResponse response,String msg,
			String backUrl) throws IOException, ServletException {
		String url = request.getContextPath() + "/commons/error.jsp";
		// 在重定向目标地址中添加参数错误提示消息
		if (msg != null) {
			url = url + "?errorMsg="
					+ URLEncoder.encode(msg, "UTF-8") + "&backUrl=" + backUrl
					+ "&top=true";
		}
		response.sendRedirect(url);
	}
	
	/**
	 * 匹配URL
	 * @param url
	 * @return 匹配成功：true,失败：false
	 */
	private boolean match(String url) {
		boolean result = false;
		if (StringUtils.isBlank(url)) {
			return result;
		}
		// 从精确URL地址范围集中匹配
		if(!excludeSet.contains(url)) {
			// 从正则URL列表中匹配
			for (String _regUrl : excludeRegList) {
				Matcher matcher = Pattern.compile(_regUrl).matcher(url);
				if (matcher.find()) {
					result = true;
					break;
				}
			}
		} else {
			result = true;
		}
		return result;
	}

}
