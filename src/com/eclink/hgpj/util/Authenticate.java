package com.eclink.hgpj.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.log4j.Logger;

import com.eclink.hgpj.common.HGPJConfig;

public class Authenticate {

	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(Authenticate.class);

	/**
	 * 是否有效的海关域用户
	 * 
	 * @param userName
	 *            用户名
	 * @return
	 * @throws Exception
	 */
	public static Boolean isUserValid(String userName) throws Exception {
		try {
			// 未开启海关域用户验证,直接通过
			if (!HGPJConfig.getInstance().isOpenDomainAuth()) {
				return true;
			}
			Call call = CreateCall();
			QName qname = new QName("http://www.sz-customs.gov.cn/WebService/UserInfoService/","IsUserValid");
			call.setOperationName(qname);
			call.setSOAPActionURI("http://www.sz-customs.gov.cn/WebService/UserInfoService/IsUserValid");
			call.addParameter("logonName", XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(XMLType.XSD_BOOLEAN);
			Boolean result = (Boolean) call.invoke(new Object[] { userName });
			if (log.isDebugEnabled()) {
				log
						.debug("Domain user auth,call web service method [isUserValid],userName="
								+ userName + ",return result " + result);
			}
			return result;
		} catch (Exception e) {
			log.error("Customs domain user authenticate request[IsUserValid] error.", e);
			throw e;
		}
	}

	/**
	 * 域用户与密码是否能正确登录海关域
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 * @throws Exception
	 */
	public static Boolean login(String userName, String password)
			throws Exception {
		try {
			// 未开启海关域用户验证,直接通过
			if (!HGPJConfig.getInstance().isOpenDomainAuth()) {
				return true;
			}
			Call call = CreateCall();
			QName qname = new QName("http://www.sz-customs.gov.cn/WebService/UserInfoService/","SignInCheck");
			call.setOperationName(qname);
			call.setSOAPActionURI("http://www.sz-customs.gov.cn/WebService/UserInfoService/SignInCheck");
			call.addParameter("logonName", XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
			call.addParameter("password", XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(XMLType.XSD_BOOLEAN);
			Boolean result = (Boolean) call.invoke(new Object[] { userName, password });
			log
					.debug("Domain user auth,call web service method [SignInCheck],userName="
							+ userName
							+ ",password=******,return result "
							+ result);
			return result;
		} catch (Exception e) {
			log.error("Customs domain user authenticate request[SignInCheck] error.", e);
			throw e;
		}
	}

	/**
	 * 创建web serivice调用对象
	 * @return
	 * @throws MalformedURLException
	 * @throws ServiceException
	 */
	private static Call CreateCall() throws MalformedURLException,
			ServiceException {
		URL url = new URL(HGPJConfig.getInstance().getDomainUserAuthUrl());
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(url);
		call.setUseSOAPAction(true);
		return call;
	}

}
