package com.eclink.hgpj.user.action;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConfig;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.user.biz.UserService;
import com.eclink.hgpj.user.vo.UserVO;
import com.eclink.hgpj.util.Authenticate;

/**
 * DomainAuthAction.java
 *

 * @Description: 

 * @version 1.0
 * @date May 25, 2013 2:53:44 PM
 *
 */
public class DomainAuthAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(DomainAuthAction.class);
	
	/**
	 * 用户业务接口
	 */
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 海关域用户验证
	 * @return
	 * @throws Exception
	 */
	public String auth() throws Exception{
		String message = "";
		boolean result = true;
//		try {
//			// 获取域及用户信息
//			String domain = getRequest().getParameter("domain");
//			String userName = getRequest().getParameter("userName");
//			String password = getRequest().getParameter("password");
//			
//			if (log.isDebugEnabled()) {
//				log.debug("Domain user auth start...");
//				log.debug("domainName="+domain);
//				log.debug("userName="+userName);
//				log.debug("password=******");
//			}
//			
//			// 调用海关域用户鉴权web service
////			if ((StringUtils.isBlank(domain) && Authenticate.login(userName,password))
////					|| (!StringUtils.isBlank(domain)
////							&& isDomainExist(domain) && Authenticate
////							.isUserValid(userName))) {
//				// 域验证通过
//				UserVO user = userService.queryUserByUserName(userName);
//				if (null == user) {
//					result = false;
//					message = "用户'"+userName+"'没有在本系统备案！";
//				}else if (HGPJConstant.USER_STATUS_L.equals(user.getStatus())) {
//					result = false;
//					message = "用户'"+userName+"'已被锁定！";
//				}else if (HGPJConstant.USER_STATUS_D.equals(user.getStatus())) {
//					result = false;
//					message = "用户'"+userName+"'已被删除！";
//				}
////			} else {
////				// 域验证失败
////				result = false;
////				message = "域验证失败！";
////			}
//			
//		} catch (Exception e) {e.printStackTrace();
//			log.error("Customs domain auth occurred error.",e);
//			result = false;
//			message = "系统错误！";
//		}
		return authResultResp(result, message);
	}
	
	/**
	 * 结果响应
	 * @param result
	 * @param message
	 * @return
	 */
	private String authResultResp(boolean result,String message) {
		PrintWriter pw = null;
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/html;charset=UTF-8");
			String content = result + "," + message;
			pw = response.getWriter();
			pw.write(content);
			pw.flush();
		} catch (Exception e) {
			log.error("Domain authenticate response error.", e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		return null;
	}
	
	/**
	 * 检查域名是否存在
	 * @param domainName 域名
	 * @return
	 */
	private boolean isDomainExist(String domainName) {
		boolean isExist = false;
		Set<String> domains = HGPJConfig.getInstance().getCustomsDomain();
		if (!domains.isEmpty()) {
			Iterator<String> it = domains.iterator();
			while(it.hasNext()) {
				String dn = it.next();
				if (dn.equalsIgnoreCase(domainName)) {
					isExist = true;
					break;
				}
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("Is domainName exist,domainName=" + domainName
					+ ",return result=" + isExist);
		}
		return isExist;
	}
}
