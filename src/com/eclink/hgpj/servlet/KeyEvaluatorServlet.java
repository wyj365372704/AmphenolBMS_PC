package com.eclink.hgpj.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.init.SystemInitServlet;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.EvaluationService;
import com.eclink.hgpj.setting.biz.KeyEvaluatorService;
import com.eclink.hgpj.setting.vo.EvaluationVO;
import com.eclink.hgpj.setting.vo.KeyEvaluatorVO;
import com.eclink.hgpj.user.biz.UserService;
import com.eclink.hgpj.user.vo.UserVO;

/**
 * KeyEvaluatorServlet.java
 *
 * @Title: 按键式评价器接口Servlet
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Jun 18, 2013 10:06:25 AM
 *
 */
public class KeyEvaluatorServlet extends HttpServlet {
	
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(KeyEvaluatorServlet.class);

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取操作action
		String action = request.getParameter("action");
		
		if ("auth".equalsIgnoreCase(action)) { // 铵键式评价器登录
			auth(request, response);
		} else if ("insert".equalsIgnoreCase(action)) { // 新增按键式评价器数据
			insert(request, response);
		}
	}
	
	/**
	 * 按键式评价器登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void auth(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean result = true;
		String message = "";
		OutputStream out = null;
		try {
			response.setContentType("application/json");
			out = response.getOutputStream();
			// 获取请求参数
			String userName = request.getParameter("userName").trim();
			String keyNo = request.getParameter("keyNo").trim();
			if (log.isDebugEnabled()) {
				log.debug("Key evaluator auth...");
				log.debug("userName="+userName);
				log.debug("keyNo="+keyNo);
			}
			
			// 获取用户业务处理对象
			UserService userService = (UserService)SystemInitServlet.WAC.getBean("userService");
			// 检查用户是否在本系统中备案
			UserVO user = userService.queryUserByUserName(userName);
			if (null == user) {
				result = false;
				message = "用户" + userName + "未在本系统中备案！";
				if (log.isDebugEnabled()) {
					log.debug(message);
				}
			} else {
				KeyEvaluatorService keyEvaluatorService = (KeyEvaluatorService) SystemInitServlet.WAC
						.getBean("keyEvaluatorService");
				OrgService orgService = (OrgService) SystemInitServlet.WAC
						.getBean("orgService");
				// 获取按键式评价信息
				KeyEvaluatorVO keyEvaluator = keyEvaluatorService.queryByKeyNo(keyNo);
				// 获取所属海关信息
				if (keyEvaluator != null) {
					OrgVO customs = orgService.queryParentOrgById(keyEvaluator.getOrgId());
					keyEvaluator.setCustomsId(customs.getOrgId());
					keyEvaluator.setCustomsName(customs.getOrgName());
					StringBuffer sb = new StringBuffer();
					sb.append("{\"result\":\"");
					sb.append(result);
					sb.append("\",\"keyNo\":\"");
					sb.append(keyEvaluator.getKeyNo());
					sb.append("\",\"windowId\":\"");
					sb.append(keyEvaluator.getWindowId());
					sb.append("\",\"windowName\":\"");
					sb.append(keyEvaluator.getWindowName());
					sb.append("\",\"orgId\":\"");
					sb.append(keyEvaluator.getOrgId());
					sb.append("\",\"orgName\":\"");
					sb.append(keyEvaluator.getOrgName());
					sb.append("\",\"customsId\":\"");
					sb.append(keyEvaluator.getCustomsId());
					sb.append("\",\"customsName\":\"");
					sb.append(keyEvaluator.getCustomsName());
					sb.append("\"}");
					out.write(sb.toString().getBytes());
					out.flush();
					out.close();
				} else {
					result = false;
					message = "未获取到按键式评价器数据!";
					if (log.isDebugEnabled()) {
						log.debug("Get key evaluator infomation by keyNo error, return null.");
					}
				}
			}
		} catch (Exception e) {
			log.error("Key evaluator auth occurred error.", e);
			result = false;
			message = e.getMessage();
		}
		if (!StringUtils.isBlank(message)) {
			out.write(("{\"result\":\"" + result + "\",\"message\":\"" + message + "\"}").getBytes());
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 新增按键式评价数据
	 * @param request
	 * @throws IOException 
	 */
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		OutputStream out = null;
		try {
			response.setContentType("application/json");
			out = response.getOutputStream();
			// 获取请求参数信息
			String customsId = request.getParameter("customsId").trim();
			String orgId = request.getParameter("orgId").trim();
			String windowId = request.getParameter("windowId").trim();
			String userName = request.getParameter("userName").trim();
			String evalNo = request.getParameter("evalNo").trim();
			String evalResult = request.getParameter("evalResult").trim();
			if (log.isDebugEnabled()) {
				log.debug("Insert key evaluator data...");
				log.debug("customsId="+customsId);
				log.debug("orgId="+orgId);
				log.debug("windowId="+windowId);
				log.debug("userName="+userName);
				log.debug("evalNo="+evalNo);
				log.debug("evalResult="+evalResult);
			}
			
			// 创建评价数据实体对象
			EvaluationVO vo = new EvaluationVO();
			vo.setCustomsId(Integer.parseInt(customsId));
			vo.setOrgId(Integer.parseInt(orgId));
			vo.setWindowId(Integer.parseInt(windowId));
			vo.setUserName(userName);
			vo.setEvalNo(evalNo);
			vo.setEvalType("0");
			vo.setEvalResult(Integer.parseInt(evalResult));
			
			// 获取评价业务处理对象
			EvaluationService evaluationService = (EvaluationService)SystemInitServlet.WAC.getBean("evaluationService");
			evaluationService.insertKeyEvaluation(vo);
			if (log.isDebugEnabled()) {
				log.debug("Insert key evaluator data success.");
			}
			out.write("{\"result\":\"true\"}".getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error("Insert key evaluation data occurred error.", e);
			out.write("{\"result\":\"false\"}".getBytes());
			out.flush();
			out.close();
		}
	}

}
