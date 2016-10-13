package com.eclink.hgpj.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

import com.eclink.hgpj.common.HGPJConfig;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.common.UserLoginInfo;
import com.eclink.hgpj.util.Utils;

/**
 * PermFilter.java
 *
 * @Title: 权限过滤器
 * @Description: 用于UC系统中，拦截所有对UC系统保护资源的请求，判断用户是否具有该URL地址的访问权限
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.

 * @version 1.0
 * @date Nov 25, 2011 4:18:31 PM
 *
 */
public class PermFilter implements Filter {
	
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(PermFilter.class);
	
	/**
	 * 不做权限检查的精确URL(不含通配符*)地址范围集
	 */
	private Set<String> permExcludeSet = new HashSet<String>();
	
	/**
	 * 不做权限检查的正则URL（含通配符*）的地址列表
	 */
	private List<String> permExcludeRegList = new ArrayList<String>();
	

	/**
	 * 过滤器销毁方法
	 */
	public void destroy() {
		this.permExcludeSet.clear();
	}

	/**
	 * 执行过滤器
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 是否开启权限检查
		if (HGPJConfig.getInstance().isOpenPermCheck()) {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			HttpSession session = request.getSession();

			// 获取请求URL地址
			String servletPath = request.getServletPath();
			if (log.isDebugEnabled()) {
				log.debug("PermFilter(url=" + servletPath + ") process start.");
			}
			// 请求的URL地址是否需要进行权限检查
			boolean permCheck = !match(servletPath);
			if (log.isDebugEnabled()) {
				log
						.debug("PermFilter(url="
								+ servletPath
								+ ") "
								+ (permCheck ? "need to check."
										: "not need to check."));
			}
			if (permCheck) {
				// 处理开始时间
				long start = System.currentTimeMillis();
				// 从缓存中获取用户登录信息
//				UserLoginInfo info = (UserLoginInfo) session.getAttribute(HGPJConstant.SESSION_USER_KEY);
//				if ((info == null) || (info.getUser().getUserName() == null)) {
//					if (log.isDebugEnabled()) {
//						log.debug("PermFilter(url="+servletPath+"),NO LOGIN,用户未登录.");
//					}
//					// 重定向至错误提示页面
//			        redirect(request, response, request.getContextPath()
//							+ "/commons/error.jsp", "用户未登录！",null);
//			        return;
//				}
//				// 获取用户可以访问的URL地址
//				Map<String, Object> urls = info.getUrls();
//				if (!urls.containsKey(servletPath)) {
//					if (log.isDebugEnabled()) {
//						log.debug("PermFilter(url=" + servletPath
//								+ ",userName="
//								+ info.getUser().getUserName()
//								+ "),NO PERM,没有权限.");
//					}
//					// 重定向至错误提示页面
//			        redirect(request, response, request.getContextPath()
//							+ "/commons/error.jsp", "您没有该资源的访问权限！","/index.jsp");
//			        return;
//				}
				if (log.isDebugEnabled()) {
					log.debug("PermFilter(url=" + servletPath + ") process end. used:"
							+ (System.currentTimeMillis() - start) + "ms");
				}
			}
		}
		chain.doFilter(req, resp);
	}

	/**
	 * 初始化
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			// 获取不做权限检查的URL地址
			String permCheckExclude = filterConfig.getInitParameter("exclude");
			if (!StringUtils.isBlank(permCheckExclude)) {
				// 去除回车、换行、空格等字符串
				permCheckExclude = Utils.replaceBlank(permCheckExclude);
				StringTokenizer st = new StringTokenizer(permCheckExclude, ",");
				while (st.hasMoreElements()) {
					String url = (String) st.nextElement();
					// URL地址中是否包含通配符'*'
					if (url.contains("*")) {
						url = "^"
								+ (url.replaceAll("\\.", "\\\\.").replaceAll(
										"\\*", ".*")) + "$";
						this.permExcludeRegList.add(url);
					} else {
						this.permExcludeSet.add(url);
					}
				}
			}
		} catch (Exception e) {
			log.error("Permission filter init error.", e);
			throw new ServletException("Permission filter init error.", e);
		}
	}
	
	/**
	 * 重定向
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param url 目标URL地址
	 * @param msg 错误提示消息
	 * @throws IOException
	 */
	private void redirect(HttpServletRequest request,
			HttpServletResponse response, String url, String msg, String backUrl)
			throws IOException {
		String targetURL = url + "?__URL__=" + request.getServletPath();
		// 在重定向目标地址中添加参数错误提示消息
		if (msg != null) {
			targetURL = targetURL + "&errorMsg="
					+ URLEncoder.encode(msg, "UTF-8") + "&backUrl=" + backUrl
					+ "&top=true";
		}
		response.sendRedirect(targetURL);
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
		if(!permExcludeSet.contains(url)) {
			// 从正则URL列表中匹配
			for (String _regUrl : permExcludeRegList) {
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
