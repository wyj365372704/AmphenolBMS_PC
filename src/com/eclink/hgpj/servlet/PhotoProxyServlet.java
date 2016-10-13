package com.eclink.hgpj.servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.util.Utils;

/**
 * KeyEvaluatorServlet.java
 *
 * @Title: 关员图片查看代理Servlet
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Jun 26, 2013 06:12:25 PM
 *
 */
public class PhotoProxyServlet extends HttpServlet {
	
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(PhotoProxyServlet.class);

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
		// 获取请求的图片文件名
		String photoName = request.getParameter("photoName");
		
		// 获取关员图片详细路径信息（保存在$TOMCAT_HOME/bin/HGPJ/photo下）
		String photoPath = Utils.getUserPath() + File.separator
				+ HGPJConstant.DEFAULT_HGPJ_SYSTEMCODE + File.separator
				+ "photo" + File.separator + photoName;
		
		if (log.isDebugEnabled()) {
			log.debug("图片代理访问Servlet接收请求，开始处理...");
			log.debug("请求图片文件名：" + photoName);
			log.debug("图片完整保存路径：" + photoPath);
		}
		
		// 检查文件是否存在
		File photoFile = new File(photoPath);
		if (photoFile.exists()) {
			FileInputStream bis =  new FileInputStream(photoFile);			
			response.setContentLength(bis.available());
			ServletOutputStream sos = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(sos);
			byte buffer[] = new byte[1024];			
			int datalength = 0;
			try {
				while ((datalength = bis.read(buffer, 0, 1024)) > 0) {
					bos.write(buffer, 0, datalength);
				}
				bos.flush();
				if (log.isDebugEnabled()) {
					log.debug("图片代理访问Servlet成功读取文件并响应，处理结束.");
				}
			} catch (Exception e) {
				log.error("图片代理访问servlet响应请求端内容错误。",e);
			}finally{
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
				}
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("图片文件不存在，处理结束.");
			}
		}
	}

}
