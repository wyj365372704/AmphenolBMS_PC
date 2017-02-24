package com.eclink.hgpj.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.ProgramCall;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Utils.java
 * 
 * @Title: 工具类
 * @Description:
 * @version 1.0
 * @date Nov 9, 2011 12:42:46 PM
 * 
 */
public class Utils {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(Utils.class);

	/** 文件分隔符 */
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	/** 行分隔符 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public Utils(){

	}
	/**
	 * 获取用户真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 转换字符串为MD5字符串
	 * 
	 * @param data
	 * @return
	 */
	public static final String toMd5(String data) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ne) {
			log.error("failed to load the MD5 MessageDigest.", ne);
		}
		// 计算哈希数据
		digest.update(data.getBytes());
		return encodeHex(digest.digest());
	}

	/**
	 * 将字节数组转换为十六进制大写字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static final String encodeHex(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString().toUpperCase();
	}

	/**
	 * 合并list
	 * @param list
	 * @param mergerList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static  final List mergerList(List list,List mergerList){
		List tempList=new ArrayList();
		tempList.addAll(list);
		list.removeAll(mergerList);
		mergerList.retainAll(tempList);
		list.addAll(mergerList);
		return list;
	}

	/**
	 * 字符串还原,将特殊字符还原为'&'与'<'
	 * @param source 字符串
	 * @return
	 */
	public static String restitute(String source) {
		if ((source == null) || (source.length() == 0)) {
			return source;
		}
		int len = source.length();
		char[] val = new char[len];
		source.getChars(0, len, val, 0);
		int i = -1;
		while (true) {
			i++;
			if ((i >= len) || (val[i] == 'ù')) {
				break;
			}
			if (val[i] != 'ú') {
				continue;
			}
		}
		if (i < len) {
			char[] buf = new char[len];
			for (int j = 0; j < i; j++) {
				buf[j] = val[j];
			}
			while (i < len) {
				char c = val[i];
				if (c == 'ù') {
					buf[i] = '&';
				} else if (c == 'ú') {
					buf[i] = '<';
				} else {
					buf[i] = c;
				}
				i++;
			}
			return new String(buf);
		}
		return source;
	}

	/**
	 * 字符串替换,将'&'与'<'替换为特殊字符
	 * @param source 字符串
	 * @return
	 */
	public static String replace(String source) {
		if ((source == null) || (source.length() == 0)) {
			return source;
		}
		int len = source.length();
		char[] val = new char[len];
		source.getChars(0, len, val, 0);
		int i = -1;
		while (true) {
			i++;
			if ((i >= len) || (val[i] == '&'))
				break;
			if (val[i] == '<') {
				break;
			}
		}
		if (i < len) {
			char[] buf = new char[len];
			for (int j = 0; j < i; j++)
				buf[j] = val[j];
			while (i < len) {
				char c = val[i];
				if (c == '&')
					buf[i] = 'ù';
				else if (c == '<')
					buf[i] = 'ú';
				else {
					buf[i] = c;
				}
				i++;
			}
			return new String(buf);
		}
		return source;
	}

	/**
	 * 去除字符串中的空格、回车、换行字符
	 * @param source
	 * @return
	 */
	public static String replaceBlank(String source) {
		if (null == source) {
			return null;
		}
		Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(source);
		if (matcher.find()) {
			return matcher.replaceAll("");
		}
		return source;
	}

	/**
	 * 获取主机IP
	 * @return
	 */
	public static String getHostIP() {
		String hostIP = "";
		try {
			hostIP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			hostIP = "UNKNOW";
		}
		return hostIP;
	}

	/**
	 * 获取用户路径
	 * @return
	 */
	public static String getUserPath() {
		String path = "";
		File file = new File(".");
		try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			log.error("Get user path occurred error.",e);
		}
		return path;
	}

	/**
	 * 格式化日期为指定格式
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if (null == date){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(date);
	}

	/**
	 * 格式化日期为指定格式
	 * @param date 日期,当为null时获取系统当前时间
	 * @param formate 格式字符串,当为空时使用yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String formateDate(Date date,String formate) {
		if (null == date) {
			date = new Date();
		}
		if (StringUtils.isBlank(formate)) {
			formate = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(date);
	}

	/**
	 * 日期计算
	 * @param dateStr 日期字符串
	 * @param amount 数字
	 * @return
	 */
	public static String addDate(String dateStr,int amount) {
		SimpleDateFormat sdf;
		Calendar cal;
		Date date;
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (StringUtils.isBlank(dateStr)) {
				date = new Date();
			} else {
				date = sdf.parse(dateStr);
			}
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, amount);
		} catch (ParseException e) {
			log.error("Parse date error.", e);
			return dateStr;
		}
		return sdf.format(cal.getTime());		
	}
	/*
	 * 调用SystemLink更新XA系统的采购单数据
	 * 数据、访问用户名密码及请求地址均放入map
	 * */
	public static String systemLinkRp(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'receiveScheduleReceipt' domainClass='com.mapics.mm.ReceiveScheduledReceiptTxn'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='scheduledReceiptToken'><Value><![CDATA[");
		sbuff.append(map.get("scheduledReceiptToken"));
		sbuff.append("]]></Value>               </Property></Key>");
		if(map.get("goodsReceivedNote")==null || ((String)map.get("goodsReceivedNote")).trim().equals("") ){
			sbuff.append("<Property path='grnInvoiceFlag'>               <Value><![CDATA[");
			sbuff.append("false");
			sbuff.append("]]></Value>               </Property>");
		}else{
			sbuff.append("<Property path='grnInvoiceFlag'>               <Value><![CDATA[");
			sbuff.append(map.get("grnInvoiceFlag"));
			sbuff.append("]]></Value>               </Property>");
		}


		sbuff.append("<Property path='batchLot'>               <Value><![CDATA[");
		sbuff.append(map.get("batchLot"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockWarehouseLocation'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockWarehouseLocation"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='reference'>               <Value><![CDATA[");
		sbuff.append(map.get("reference"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='unitOfMeasure'>               <Value><![CDATA[");
		sbuff.append(map.get("unitOfMeasure"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='setScheduledReceiptStatus'>               <Value><![CDATA[");
		sbuff.append(map.get("setScheduledReceiptStatus"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='transactionDate'>               <Value><![CDATA[");
		sbuff.append(map.get("transactionDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockFlag'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockFlag"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='goodsReceivedNote'>               <Value><![CDATA[");
		sbuff.append(map.get("goodsReceivedNote"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockQuantity'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockQuantity"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockReason'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockReason"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkTw(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name='createTransferItemTxn' domainClass='com.mapics.mm.TransferItemTxn'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='fromWarehouse'><Value><![CDATA[");
		sbuff.append(map.get("fromWarehouse"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='item'>               <Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='postedDate'>               <Value><![CDATA[");
		sbuff.append(map.get("postedDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='postedTime'>               <Value><![CDATA[");
		sbuff.append(map.get("postedTime"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='token'>               <Value><![CDATA[");
		sbuff.append(map.get("token"));
		sbuff.append("]]></Value>               </Property></Key>");

		sbuff.append("<Property path='fromLocation'>               <Value><![CDATA[");
		sbuff.append(map.get("fromLocation"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='toWarehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("toWarehouse"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='toLocation'>               <Value><![CDATA[");
		sbuff.append(map.get("toLocation"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='quantity'>               <Value><![CDATA[");
		sbuff.append(map.get("quantity"));
		sbuff.append("]]></Value>               </Property>");
		if((String)map.get("batchlot")!=null && !((String)map.get("batchlot")).trim().equals("")){
			sbuff.append("<Property path='batchLot'>               <Value><![CDATA[");
			sbuff.append(map.get("batchlot"));
			sbuff.append("]]></Value>               </Property>");
		}
		sbuff.append("<Property path='reference'>               <Value><![CDATA[");
		sbuff.append(map.get("reference"));
		sbuff.append("]]></Value>               </Property>");
		if((String)map.get("reason")!=null && !((String)map.get("reason")).trim().equals("")){
			sbuff.append("<Property path='reason'>               <Value><![CDATA[");
			sbuff.append(map.get("reason"));
			sbuff.append("]]></Value>               </Property>");
		}


		sbuff.append("<Property path='transactionDate'>               <Value><![CDATA[");
		sbuff.append(map.get("transactionDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='scheduledReceipt'>               <Value><![CDATA[");
		sbuff.append(map.get("scheduledReceipt"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='inTransitOption'>               <Value><![CDATA[");
		sbuff.append(map.get("inTransitOption"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='inspectOnReceipt'>               <Value><![CDATA[");
		sbuff.append(map.get("inspectOnReceipt"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		System.out.println("Tw:"+sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkUw(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name='updateObject_ItemRevision' domainClass='com.mapics.epdm.ItemRevision'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='site'><Value><![CDATA[");
		sbuff.append(map.get("site"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='item'>               <Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='revision'>               <Value><![CDATA[");
		sbuff.append(map.get("revision"));
		sbuff.append("]]></Value>               </Property> </Key>");
		if(((String)map.get("weightUm")).trim().equals("GM")){
			sbuff.append("<Property path='weightUm'>               <Value><![CDATA[");
			sbuff.append(map.get("weightUm"));
			sbuff.append("]]></Value>               </Property>");
		}
		sbuff.append("<Property path='unitWeight'>               <Value><![CDATA[");
		sbuff.append(map.get("unitWeight"));
		sbuff.append("]]></Value>               </Property>");


		sbuff.append("</DomainEntity>     </Update> </Request><Logout sessionHandle='*current'/></System-Link>");
		System.out.println("systemLinkUw:"+sbuff.toString()+"...systemLinkUw");
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkHouse(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name='updateObject_ItemWarehouse' domainClass='com.mapics.epdm.ItemWarehouse'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='warehouse'><Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='item'>               <Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value>               </Property></Key>");

		sbuff.append("<Property path='relatedItemWarehouseExtension2.whsub2'>               <Value><![CDATA[");
		sbuff.append(map.get("whsub2"));
		sbuff.append("]]></Value>               </Property> ");


		sbuff.append("<Property path='relatedItemWarehouseExtension2.llocn2'>               <Value><![CDATA[");
		sbuff.append(map.get("llocn2"));
		sbuff.append("]]></Value>               </Property>");


		sbuff.append("</DomainEntity>     </Update> </Request><Logout sessionHandle='*current'/></System-Link>");
		//		System.out.println("systemLinkUw:"+sbuff.toString()+"...systemLinkUw");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());

		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkOrder(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_ManufacturingOrder'  domainClass = 'com.mapics.obpm.ManufacturingOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property></Key>");
		sbuff.append("<Property path='userFieldSwitchA'>               <Value><![CDATA[");
		sbuff.append("1");
		sbuff.append("]]></Value>               </Property>");		
		sbuff.append("</DomainEntity>     </Update> </Request><Logout sessionHandle='*current'/></System-Link>");

		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkIA(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name= 'adjustItemTxn' domainClass = ' com.mapics.mm.AdjustItemTxn '>");
		sbuff.append("<DomainEntity>");
		sbuff.append("<Key>");
		sbuff.append("<Property path='warehouse'><Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='order'><Value><![CDATA[]]></Value></Property>");		
		sbuff.append("<Property path='token'><Value><![CDATA[]]></Value></Property>");		
		sbuff.append("<Property path='item'><Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='postedDate'><Value><![CDATA[");
		sbuff.append(map.get("postedDate"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='postedTime'><Value><![CDATA[");
		sbuff.append(map.get("postedTime"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("</Key>");
		sbuff.append("<Property path='location'><Value><![CDATA[");
		sbuff.append(map.get("location"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='batchlot'><Value><![CDATA[");
		sbuff.append(map.get("batchlot"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='transactionQuantity'><Value><![CDATA[");
		sbuff.append(map.get("transactionQuantity"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='referenceNumber'><Value><![CDATA[");
		sbuff.append(map.get("referenceNumber"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='reason'><Value><![CDATA[");
		sbuff.append(map.get("reason"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("<Property path='transactionDate'><Value><![CDATA[");
		sbuff.append(map.get("transactionDate"));
		sbuff.append("]]></Value></Property>");
		sbuff.append("</DomainEntity>     </Create> </Request><Logout sessionHandle='*current'/></System-Link>");

		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkRm(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name='createMoReceiptTxn' domainClass='com.mapics.obpm.MoReceiptOfMaterialTxn'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='item'><Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='warehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property></Key>");

		sbuff.append("<Property path='order'>               <Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='reference'>               <Value><![CDATA[");
		sbuff.append(map.get("reference"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='location'>               <Value><![CDATA[");
		sbuff.append(map.get("location"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='batchLot'>               <Value><![CDATA[");
		sbuff.append(map.get("batchLot"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='transactionDate'>               <Value><![CDATA[");
		sbuff.append(map.get("transactionDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='reason'>               <Value><![CDATA[");
		sbuff.append(map.get("reason"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='transactionQuantity'>               <Value><![CDATA[");
		sbuff.append(map.get("transactionQuantity"));
		sbuff.append("]]></Value>               </Property>");


		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		System.out.println("Tw:"+sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	/**
	 * 采购退货systemlink
	 * @param map
	 * @return
	 */
	public static String systemLinkPurchaseReturn(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'receiveScheduleReceipt' domainClass='com.mapics.mm.ReceiveScheduledReceiptTxn'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='scheduledReceiptToken'><Value><![CDATA[");
		sbuff.append(map.get("scheduledReceiptToken"));
		sbuff.append("]]></Value>               </Property></Key>");

		sbuff.append("<Property path='grnInvoiceFlag'><Value><![CDATA[false]]></Value></Property>");

		sbuff.append("<Property path='batchLot'>               <Value><![CDATA[");
		sbuff.append(map.get("batchLot"));
		sbuff.append("]]></Value>               </Property>");
		//		
		sbuff.append("<Property path='receivedToStockWarehouseLocation'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockWarehouseLocation"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='reference'>               <Value><![CDATA[");
		sbuff.append(map.get("reference"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='unitOfMeasure'>               <Value><![CDATA[");
		sbuff.append(map.get("unitofMeasure"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='setScheduledReceiptStatus'>               <Value><![CDATA[");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='transactionDate'>               <Value><![CDATA[");
		sbuff.append(map.get("transactionDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockFlag'>               <Value><![CDATA[");
		sbuff.append("true");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='goodsReceivedNote'>               <Value><![CDATA[");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockQuantity'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockQuantity"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockReason'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockReason"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	/**
	 * 修改交期systemlink
	 * @param map
	 * @return
	 */
	public static String systemLinkPOItemVATxn(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		if("0".equals(map.get("bksqji"))){
			sbuff.append("<Create name = 'POItemVATxn' "); 
		}else{
			sbuff.append("<Create name = 'POReleaseVATxn' "); 
		}
		sbuff.append("domainClass='com.mapics.mm.PurchaseOrderItemVendorAcceptTxn'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("ordrji"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='line'><Value><![CDATA[");
		sbuff.append(map.get("pisqji"));
		sbuff.append("]]></Value>               </Property>");
		//		
		if(!"0".equals(map.get("bksqji"))){
			sbuff.append("<Property path='release'><Value><![CDATA[");
			sbuff.append(map.get("bksqji"));
			sbuff.append("]]></Value>               </Property>");
		}
		sbuff.append("</Key>");

		sbuff.append("<Property path='promisedDate'>               <Value><![CDATA[");
		sbuff.append(map.get("wkdtji"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='transactionDate'>               <Value><![CDATA[");
		sbuff.append(map.get("currentDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='reprintPo'>               <Value><![CDATA[");
		sbuff.append("false");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='shipViaDescription'>               <Value><![CDATA[");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='poComments1st40'>               <Value><![CDATA[");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='poComments2nd40'>               <Value><![CDATA[");
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");

		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkRpo(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'receiveScheduleReceipt' domainClass='com.mapics.mm.ReceiveScheduledReceiptTxn'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='scheduledReceiptToken'><Value><![CDATA[");
		sbuff.append(map.get("scheduledReceiptToken"));
		sbuff.append("]]></Value>               </Property></Key>");
		if(map.get("goodsReceivedNote")==null || ((String)map.get("goodsReceivedNote")).trim().equals("") ){
			sbuff.append("<Property path='grnInvoiceFlag'>               <Value><![CDATA[");
			sbuff.append("false");
			sbuff.append("]]></Value>               </Property>");
		}else{
			sbuff.append("<Property path='grnInvoiceFlag'>               <Value><![CDATA[");
			sbuff.append(map.get("grnInvoiceFlag"));
			sbuff.append("]]></Value>               </Property>");
		}

		//		
		//		sbuff.append("<Property path='batchLot'>               <Value><![CDATA[");
		//		sbuff.append(map.get("batchLot"));
		//		sbuff.append("]]></Value>               </Property>");
		//		
		//		sbuff.append("<Property path='receivedToStockWarehouseLocation'>               <Value><![CDATA[");
		//		sbuff.append(map.get("receivedToStockWarehouseLocation"));
		//		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='reference'>               <Value><![CDATA[");
		sbuff.append(map.get("reference"));
		sbuff.append("]]></Value>               </Property>");

		//		sbuff.append("<Property path='unitOfMeasure'>               <Value><![CDATA[");
		//		sbuff.append(map.get("unitOfMeasure"));
		//		sbuff.append("]]></Value>               </Property>");

		//		sbuff.append("<Property path='setScheduledReceiptStatus'>               <Value><![CDATA[");
		//		sbuff.append(map.get("setScheduledReceiptStatus"));
		//		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='transactionDate'>               <Value><![CDATA[");
		sbuff.append(map.get("transactionDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockFlag'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockFlag"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='goodsReceivedNote'>               <Value><![CDATA[");
		sbuff.append(map.get("goodsReceivedNote"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockQuantity'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockQuantity"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='receivedToStockReason'>               <Value><![CDATA[");
		sbuff.append(map.get("receivedToStockReason"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkMcc(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId="+(String)map.get("env")+",com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'createCustomerOrder' domainClass='com.mapics.csm.CustomerOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='company'><Value><![CDATA[");
		sbuff.append(map.get("company"));
		sbuff.append("]]></Value>               </Property></Key>");

		sbuff.append("<Property path='customer'><Value><![CDATA[");
		sbuff.append(map.get("customer"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='relatedCustomerOrderExtension.fdcust'><Value><![CDATA[");
		sbuff.append(map.get("fdcust"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='shipToInternal'>               <Value><![CDATA[");
		sbuff.append(map.get("shipToInternal"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='relatedSalesOrderExtension.manufacturingDueDate'>               <Value><![CDATA[");
		sbuff.append(map.get("manufacturingDueDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderDate'>               <Value><![CDATA[");
		sbuff.append(map.get("orderDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='warehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='relatedSalesOrderExtension.purchaseOrder'>               <Value><![CDATA[");
		sbuff.append(map.get("purchaseOrder"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='requestDate'>               <Value><![CDATA[");
		sbuff.append(map.get("requestDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='salesrep'>               <Value><![CDATA[");
		sbuff.append(map.get("salesrep"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='userFieldCodeA'>               <Value><![CDATA[");
		sbuff.append(map.get("userFieldCodeA"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderReference'>               <Value><![CDATA[");
		sbuff.append(map.get("orderReference"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkMccd(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=MC,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'CoLineItem' domainClass='com.mapics.csm.CoLineItem'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='company'><Value><![CDATA[");
		sbuff.append(map.get("company"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");

		sbuff.append("<Property path='entryCurrencyType'><Value><![CDATA[");
		sbuff.append(map.get("entryCurrencyType"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='internalItem'><Value><![CDATA[");
		sbuff.append(map.get("internalItem"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='warehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='manufacturingDueDate'>               <Value><![CDATA[");
		sbuff.append(map.get("manufacturingDueDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='allocationType'>               <Value><![CDATA[");
		sbuff.append(map.get("allocationType"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderUnitOfMeasure'>               <Value><![CDATA[");
		sbuff.append(map.get("orderUnitOfMeasure"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='requestDate'>               <Value><![CDATA[");
		sbuff.append(map.get("requestDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='promiseDate'>               <Value><![CDATA[");
		sbuff.append(map.get("promiseDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='userEnteredSequenceNumber'>               <Value><![CDATA[");
		sbuff.append(map.get("userEnteredSequenceNumber"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='sellingPrice'>               <Value><![CDATA[");
		sbuff.append(map.get("sellingPrice"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='priceSource'>               <Value><![CDATA[");
		sbuff.append(map.get("priceSource"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderQuantityInOrderUnitOfMeasure'>               <Value><![CDATA[");
		sbuff.append(map.get("orderQuantityInOrderUnitOfMeasure"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkMcu(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=MC,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_CustomerOrder' domainClass='com.mapics.csm.CustomerOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='company'><Value><![CDATA[");
		sbuff.append(map.get("company"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderType'><Value><![CDATA[");
		sbuff.append(map.get("orderType"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");

		sbuff.append("<Property path='requestDate'><Value><![CDATA[");
		sbuff.append(map.get("requestDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='relatedSalesOrderExtension.manufacturingDueDate'><Value><![CDATA[");
		sbuff.append(map.get("manufacturingDueDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='relatedSalesOrderExtension.purchaseOrder'>               <Value><![CDATA[");
		sbuff.append(map.get("purchaseOrder"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderReference'>               <Value><![CDATA[");
		sbuff.append(map.get("orderReference"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='relatedCustomerOrderExtension.fdcust'>               <Value><![CDATA[");
		sbuff.append(map.get("fdcust"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Update>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkMcud(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=MC,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_COLineItem' domainClass='com.mapics.csm.CoLineItem'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='company'><Value><![CDATA[");
		sbuff.append(map.get("company"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='orderType'><Value><![CDATA[");
		sbuff.append(map.get("orderType"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='lineItemSequence'><Value><![CDATA[");
		sbuff.append(map.get("lineItemSequence"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");

		sbuff.append("<Property path='userEnteredSequenceNumber'><Value><![CDATA[");
		sbuff.append(map.get("userEnteredSequenceNumber"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderQuantityInOrderUnitOfMeasure'><Value><![CDATA[");
		sbuff.append(map.get("orderQuantityInOrderUnitOfMeasure"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='entryCurrencyType'>               <Value><![CDATA[");
		sbuff.append(map.get("entryCurrencyType"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='priceSource'>               <Value><![CDATA[");
		sbuff.append(map.get("priceSource"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='sellingPrice'>               <Value><![CDATA[");
		sbuff.append(map.get("sellingPrice"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='requestDate'>               <Value><![CDATA[");
		sbuff.append(map.get("requestDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='promiseDate'>               <Value><![CDATA[");
		sbuff.append(map.get("promiseDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='manufacturingDueDate'>               <Value><![CDATA[");
		sbuff.append(map.get("manufacturingDueDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Update>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkMcd(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=MC,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append(" <Delete name='deleteObject_CustomerOrder' domainClass='com.mapics.csm.CustomerOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='company'><Value><![CDATA[");
		sbuff.append(map.get("company"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='orderType'><Value><![CDATA[");
		sbuff.append(map.get("orderType"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");


		sbuff.append("</DomainEntity>      </Delete>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkMcdd(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=MC,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append(" <Delete name='deleteObject_COLineItem' domainClass='com.mapics.csm.CoLineItem'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='company'><Value><![CDATA[");
		sbuff.append(map.get("company"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='orderType'><Value><![CDATA[");
		sbuff.append(map.get("orderType"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='lineItemSequence'><Value><![CDATA[");
		sbuff.append(map.get("lineItemSequence"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");


		sbuff.append("</DomainEntity>      </Delete>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4c(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId="+(String)map.get("env")+",com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'createPurchaseOrder' domainClass='com.mapics.pm.PurchaseOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("</Key>");

		sbuff.append("<Property path='billToId'><Value><![CDATA[");
		sbuff.append(map.get("billToId"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='currency'><Value><![CDATA[");
		sbuff.append(map.get("currency"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='shipToId'>               <Value><![CDATA[");
		sbuff.append(map.get("shipToId"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='userFieldCodeA'>               <Value><![CDATA[");
		sbuff.append(map.get("userFieldCodeA"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='warehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='vendor'>               <Value><![CDATA[");
		sbuff.append(map.get("vendor"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='buyer'>               <Value><![CDATA[");
		sbuff.append(map.get("buyer"));
		sbuff.append("]]></Value>               </Property>");


		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4cd(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId="+(String)map.get("env")+",com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'createPoItem' domainClass='com.mapics.pm.PoItem'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");

		sbuff.append("<Property path='blanketItem'><Value><![CDATA[");
		sbuff.append(map.get("blanketItem"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='dueToDockDate'><Value><![CDATA[");
		sbuff.append(map.get("dueToDockDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='dueToStockDate'>               <Value><![CDATA[");
		sbuff.append(map.get("dueToStockDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='item'>               <Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderUm'>               <Value><![CDATA[");
		sbuff.append(map.get("orderUm"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='warehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='orderQuantityRequested'>               <Value><![CDATA[");
		sbuff.append(map.get("orderQuantityRequested"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='unitPriceRequested'>               <Value><![CDATA[");
		sbuff.append(map.get("unitPriceRequested"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4cr(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId="+(String)map.get("env")+",com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Create name = 'createPoItemRelease' domainClass='com.mapics.pm.PoItemRelease'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='line'><Value><![CDATA[");
		sbuff.append(map.get("line"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");

		sbuff.append("<Property path='unitPrice'><Value><![CDATA[");
		sbuff.append(map.get("unitPrice"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='item'>               <Value><![CDATA[");
		sbuff.append(map.get("item"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='releaseQuantity'>               <Value><![CDATA[");
		sbuff.append(map.get("releaseQuantity"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='warehouse'>               <Value><![CDATA[");
		sbuff.append(map.get("warehouse"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='dueToStockDate'>               <Value><![CDATA[");
		sbuff.append(map.get("dueToStockDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='userFieldCodeA'>               <Value><![CDATA[");
		sbuff.append(map.get("userFieldCodeA"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Create>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4u(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M4,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_PurchaseOrder' domainClass='updateObject_PurchaseOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");		

		sbuff.append("</Key>");

		sbuff.append("<Property path='buyer'><Value><![CDATA[");
		sbuff.append(map.get("buyer"));
		sbuff.append("]]></Value>               </Property>");


		sbuff.append("</DomainEntity>      </Update>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4ud(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M4,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_PurchaseOrderItem' domainClass='com.mapics.pm.PoItem'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='line'><Value><![CDATA[");
		sbuff.append(map.get("line"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("</Key>");

		sbuff.append("<Property path='orderQuantityRequested'><Value><![CDATA[");
		sbuff.append(map.get("orderQuantityRequested"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='unitPriceRequested'><Value><![CDATA[");
		sbuff.append(map.get("unitPriceRequested"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='dueToStockDate'>               <Value><![CDATA[");
		sbuff.append(map.get("dueToStockDate"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</DomainEntity>      </Update>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}


	public static String systemLinkUpdateObjectPurchaseOrder(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M1,com.pjx.cas.domain.SystemName=S844DD1W,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_PurchaseOrder' domainClass='com.mapics.pm.PurchaseOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("</Key>");
		
		sbuff.append("<Property path='userFieldSwitchA'><Value><![CDATA[1]]></Value></Property>");
	

		sbuff.append("</DomainEntity>      </Update>   </Request></System-Link>");
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}
	public static String systemLinkM4ur(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M4,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append("<Update name = 'updateObject_PoItemRelease' domainClass='com.mapics.pm.PoItemRelease'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='line'><Value><![CDATA[");
		sbuff.append(map.get("line"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='release'><Value><![CDATA[");
		sbuff.append(map.get("release"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("</Key>");

		sbuff.append("<Property path='releaseQuantity'><Value><![CDATA[");
		sbuff.append(map.get("releaseQuantity"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("<Property path='dueToStockDate'><Value><![CDATA[");
		sbuff.append(map.get("dueToStockDate"));
		sbuff.append("]]></Value>               </Property>");


		sbuff.append("</DomainEntity>      </Update>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4d(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M4,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append(" <Delete name='deletePurchaseOrder' domainClass='com.mapics.pm.PurchaseOrder'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");


		sbuff.append("</DomainEntity>      </Delete>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4dd(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M4,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append(" <Delete name='deletePoItem' domainClass='com.mapics.pm.PoItem'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='line'><Value><![CDATA[");
		sbuff.append(map.get("line"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");


		sbuff.append("</DomainEntity>      </Delete>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	public static String systemLinkM4dr(Map map){
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("<?xml version='1.0' encoding='UTF-8'?>");
		sbuff.append("<!DOCTYPE System-Link SYSTEM 'SystemLinkRequest.dtd'>");
		sbuff.append("<System-Link>");
		sbuff.append("<Login userId='");
		sbuff.append(map.get("sluserId"));
		sbuff.append("' password='");
		sbuff.append(map.get("slpassword"));
		sbuff.append("' maxIdle='900000' properties='com.pjx.cas.domain.EnvironmentId=M4,com.pjx.cas.domain.SystemName=SZERP.MARKWINS.COM,com.pjx.cas.user.LanguageId=zh'/>");
		sbuff.append("<Request sessionHandle='*current' workHandle='*new' broker='EJB' maxIdle='1000'>");
		sbuff.append(" <Delete name='DeleteObject_PoItemRelease' domainClass='com.mapics.pm.PoItemRelease'>");
		sbuff.append("<DomainEntity>            <Key>");
		sbuff.append("<Property path='order'><Value><![CDATA[");
		sbuff.append(map.get("order"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='line'><Value><![CDATA[");
		sbuff.append(map.get("line"));
		sbuff.append("]]></Value>               </Property>");
		sbuff.append("<Property path='release'><Value><![CDATA[");
		sbuff.append(map.get("release"));
		sbuff.append("]]></Value>               </Property>");

		sbuff.append("</Key>");


		sbuff.append("</DomainEntity>      </Delete>   </Request><Logout sessionHandle='*current'/></System-Link>");
		//		map.put("systemLinkStr", sbuff.toString());
		//		return postXMLRequest((String)map.get("slurl"), sbuff.toString());
		String retStr = postXMLRequest((String)map.get("slurl"), sbuff.toString());
		System.out.println( sbuff.toString());
		map.put("systemLinkStr", retStr);
		return sbuff.toString();
	}

	/**
	 * 
	 * @Description: 发送XML请求
	 * @param xml
	 * @return String
	 */
	public static String postXMLRequest(String url, String xml){
		String responseStr = null;
		StringBuffer responseStrBuffer = new StringBuffer();

		OutputStream os = null;
		HttpURLConnection httpConn = null;
		InputStream is = null;
		if(!StringUtils.isEmpty(url) && !StringUtils.isEmpty(xml)){
			try {
				//1、得到http连接
				httpConn = (HttpURLConnection) new URL(url).openConnection();

				//2、设置http请求参数
				httpConn.setRequestMethod("POST");
				httpConn.setDoInput(true);
				httpConn.setDoOutput(true);
				httpConn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8"); 

				//3、通过http连接服务器
				httpConn.connect();

				//4、向服务器发送xml数据
				os = httpConn.getOutputStream();
				os.write(xml.getBytes());
				os.flush();

				//5、得到http请求后，服务器返回的响应
				if(200 == httpConn.getResponseCode()){
					is = httpConn.getInputStream();
					int length = 0;
					byte[] buffer = new byte[1024];
					while((length=is.read(buffer)) != -1){
						String s = new String(buffer,0,length, "utf-8");
						responseStrBuffer.append(s);
						System.out.println(responseStrBuffer.toString());
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(responseStrBuffer.length() > 1){
					responseStr = responseStrBuffer.toString();
				}

				try {
					if(os != null){
						os.close();
						os = null;
					}
					if(httpConn != null){
						httpConn.disconnect();
						httpConn = null;
					}
					if(is != null){
						is.close();
						is = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return responseStr;
	}

	public static String getDataSourceS (String url,String index) {  
		// 获取配置文件  
		InputStream configInStream = null;  
		Properties properties = new Properties();  
		String retval = "";
		try {  
			configInStream = new BufferedInputStream(new FileInputStream(url));

			properties.load(configInStream);
			retval=properties.getProperty(index);
		} catch (IOException e) {  
			e.printStackTrace();  
		}finally{
			if(configInStream!=null){
				try {
					configInStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		return retval;
	}
	public static BigDecimal round(BigDecimal source,int preci,String method){
		BigDecimal src = BigDecimal.valueOf(0);
		if("1".equals(method)){
			src = source.setScale(preci, BigDecimal.ROUND_UP);
		}else if("2".equals(method)){
			src = source.setScale(preci, BigDecimal.ROUND_DOWN);
		}else if("3".equals(method)){
			src = source.setScale(preci, BigDecimal.ROUND_HALF_UP);
		}
		//		if(preci==0){
		//			
		//		}else if(preci==1){
		//			if("1".equals(method)){
		//				
		//			}else if("2".equals(method)){
		//				
		//			}else if("3".equals(method)){
		//				
		//			}
		//		}else if(preci==2){
		//			if("1".equals(method)){
		//				
		//			}else if("2".equals(method)){
		//				
		//			}else if("3".equals(method)){
		//				
		//			}
		//		}else if(preci==3){
		//			if("1".equals(method)){
		//				
		//			}else if("2".equals(method)){
		//				
		//			}else if("3".equals(method)){
		//				
		//			}
		//		}
		return src;
	}
	public static String getZiphdrType(String type){
		String typeS="";
		if("1".equals(type.trim())){
			typeS="正常领料单";
		}else if("2".equals(type.trim())){
			typeS="超发领料单";
		}else if("3".equals(type.trim())){
			typeS="退料领料单";
		}
		return typeS;
	}
	public static String getZiphdrStatus(String type){
		String typeS="";
		if("05".equals(type.trim())){
			typeS="创建中";
		}else if("10".equals(type.trim())){
			typeS="已创建";
		}else if("50".equals(type.trim())){
			typeS="领料已经完成";
		}
		return typeS;
	}
	public  boolean insertTrdata(String lib,String env,List<Map> lists,String lib1) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		ResultSet rs = null;
		int count = 0;
		long idx = 1000000;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			String sql="SELECT MAX(TRNNO) as trnno FROM TRDATA";
			if(conn!=null){
				conn.setAutoCommit(false);
				//System.out.println("insertsql="+insertsql);
				stmt = (Statement) conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					idx=rs.getLong("trnno");
				}

				if(lists!=null && lists.size()>0){
					for(int i=0;i<lists.size();i++){
						idx++;
						Map map=lists.get(i);
						String insertsql="insert into TRDATA(ACREC,APCOD,BADGE,CRWYN,CTLID,ENSTN,HDEPT,IPLOC,ITNBR,LBHNO,LLOCN,"
								+"LPLID,LPQC1,ORDNO,PARNT,QUEUE,REASN,REFNO,SEQNM,SHFTC,TDATE,TRFMT,TRNNO,TRQTY,TSTAT,TTIME,WSID,USRSQ,TURNA,TURNN,TURNC"
								+") values('Y','I','"+(map.get("badge"))+"','N','*','0','"+((String)map.get("hdept"))+"','"+((String)map.get("iploc"))+"','"+((String)map.get("itnbr"))+"','" +
								((String)map.get("lbhno"))+"','"+((String)map.get("lloc"))+"','D',0,'"+((String)map.get("ordno"))+"',0,1,'"+((String)map.get("reasn"))+"','"+((String)map.get("refno"))+"',"+((BigDecimal)map.get("seqnm")).intValue()+","
								+"1,"+((BigDecimal)map.get("tdate")).longValue()+",'IP',"+(idx)+","+((BigDecimal)map.get("trqty")).longValue()+",2,"+((BigDecimal)map.get("ttime")).longValue()+","
								+"'"+((String)map.get("wsid"))+"','"+((String)map.get("usrsq"))+"',"+((BigDecimal)map.get("turna")).longValue()+","+((BigDecimal)map.get("turnn")).longValue()+","+((BigDecimal)map.get("turnc")).longValue()+")";
						System.out.println("insertsql="+insertsql);
						count=count+stmt.executeUpdate(insertsql);
					}
				}

				conn.commit();
				conn.setAutoCommit(true);
			}
			this.CallTamjuc(dbip, properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"), lib1);
		}catch(Exception e){
			if(conn!=null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			count=0;
			throw e;
			//			e.printStackTrace();
			//			return false;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		return count>0;
	}


	public  boolean insertOffShip(String lib, String env, List<Map> pmaps, String lib1) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		ResultSet rs = null;
		int count = 0;
		long idx = 1000000;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			String sql = "SELECT count(*) as ct FROM  OSAAREP";
			if(conn!=null){
				conn.setAutoCommit(false);
				//System.out.println("insertsql="+insertsql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					idx = rs.getLong("ct");
				}
				rs.close();
				if (pmaps != null) {
					for (int i = 0; i < pmaps.size(); i++)
					{
						Map pmap = (Map)pmaps.get(i);
						String shipNumber = (idx + i + 1L + "0000000").substring(0, 7);
						Object osaarep = pmap.get("osaarep");
						if (osaarep != null)
						{
							Map osaarepmap = (Map)osaarep;
							String insertsql = "insert into OSAAREP(MXNWCD,MXAJSS,MXNTCD,MXAENB,MXA3CD,MXDCCD,MXCVNB) values('" + (
									idx + 1L) + "','03','" + shipNumber + "'," + (Long)osaarepmap.get("company") + ",'" + (String)osaarepmap.get("house") + "','1','" + (String)osaarepmap.get("orderno") + "')";
							System.out.println("insertsql=" + insertsql);
							count += stmt.executeUpdate(insertsql);
						}
						Object osabccp = pmap.get("osabccp");
						if (osabccp != null)
						{
							List osabccplist = (List)osabccp;
							for (int j = 0; j < osabccplist.size(); j++)
							{
								Map osabccpmap = (Map)osabccplist.get(j);
								String insertsql2 = "insert into  OSABCPP (MYNWCD,MYAJSS,MYNTCD,MYX2NB,MYDCCD,MYCVNB,MYFCNB,MYDRNB,MYAITX,MYAAYN,MYARQT,MYAAFX) values('" + (
										idx + 1L) + "','03','" + shipNumber + "'," + (Integer)osabccpmap.get("myx2nb") + ",'1','" + (String)osabccpmap.get("mycvnb") + "'," + (Long)osabccpmap.get("myfcnb") + ",'" + (Long)osabccpmap.get("mydrnb") + "','" + (String)osabccpmap.get("myaitx") + "','1'," + (Long)osabccpmap.get("myarqt") + "," + (Float)osabccpmap.get("myaafx") + ")";
								System.out.println("insertsql2=" + insertsql2);
								count += stmt.executeUpdate(insertsql2);
								Object osaccpp = osabccpmap.get("osaccpp");
								if (osaccpp != null)
								{
									List osaccpplist = (List)osaccpp;
									for (int k = 0; k < osaccpplist.size(); k++)
									{
										Map osaccpppmap = (Map)osaccpplist.get(k);
										String insertsql3 = "insert into OSACCPP(AANWCD,AAAJSS,AANTCD,AAX2NB,AAAASZ,AADQNB,AADCCD,AACVNB,AAFCNB,AADRNB,AACKTX,AACRCD,AAF3VA) values('" + (
												idx + 1L) + "','03','" + shipNumber + "'," + (Integer)osabccpmap.get("myx2nb") + "," + (Long)osaccpppmap.get("aaaasz") + "," + (Long)osaccpppmap.get("aadqnb") + ",'1','" + (String)osaccpppmap.get("aacvnb") + "'," + (Long)osaccpppmap.get("aafcnb") + ",'" + (Long)osaccpppmap.get("aadrnb") + "','" + (String)osaccpppmap.get("aacktx") + "','" + (String)osaccpppmap.get("aacrcd") + "'," + (Float)osaccpppmap.get("aaf3va") + ")";
										System.out.println("insertsql3=" + insertsql3);
										count += stmt.executeUpdate(insertsql2);
									}
								}
							}
						}
					}
				}
				conn.commit();
				conn.setAutoCommit(true);
			}
			this.CallTamjuc(dbip, properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"), lib1);
		}catch(Exception e){
			if(conn!=null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			count=0;
			throw e;
			//			e.printStackTrace();
			//			return false;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		return count>0;
	}

	public  void createShpdsk(String lib,String env,String lib1) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];

			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				try {
					conn.setAutoCommit(false);
					String sql = "select count(*) as ct from sysibm.TABLES where table_name='SHPDSK' and table_schema='"+lib1.trim().toUpperCase()+"'";
					System.out.println("find is "+sql);
					stmt = (Statement) conn.createStatement();
					ResultSet executeQuery = stmt.executeQuery(sql);
					if(executeQuery.next()){
						int count = executeQuery.getInt("ct");
						executeQuery.close();
						stmt.close();
						if(count==0){
							sql="CREATE TABLE "+lib1.trim().toUpperCase()+".SHPDSK (RCDCD CHAR(2),ORDNO CHAR(7),OPSEQ CHAR(4),RUNCD CHAR(1)," +
									"LBTIM NUMERIC(7,2),MATIM NUMERIC(7,2),QCOMP NUMERIC(10,3),QSCRP NUMERIC(10,3)," +
									"RESN NUMERIC(6),RFNO CHAR(10),OCMPC CHAR(1),AWKCT CHAR(5),EMPNO NUMERIC(5,0)," +
									"ERATE NUMERIC(5,3),SHIFT CHAR(1),TCOST NUMERIC(13,2),TDATE NUMERIC(6,0))  NOT   LOGGED   INITIALLY";
							stmt = (Statement) conn.createStatement();
							stmt.execute(sql);
							stmt.close();
							conn.commit();
							System.out.println("CallJournal:start");
							this.CallJournal(dbip, properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"), lib1);
							System.out.println("CallJournal:finish");

						}	
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				throw new Exception("conn is null");	
			}

		}catch(Exception e){
			if(conn!=null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			throw e;
			//			return false;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	public  Map getZCOEXT(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			Map rmap = new HashMap();
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				String sql = "select * from ZCOEXT where C6AENB="+pmap.get("C6AENB")+" and C6DCCD='"+(String)pmap.get("C6DCCD")+"' and C6CVNB='"+(String)pmap.get("C6CVNB")+"'";
				System.out.println("find is "+sql);
				stmt = (Statement) conn.createStatement();
				ResultSet executeQuery = stmt.executeQuery(sql);
				if(executeQuery.next()){
					rmap.put("FDCUST", executeQuery.getString("FDCUST"));
					rmap.put("MLCODE", executeQuery.getString("MLCODE"));
					rmap.put("MLSTS", executeQuery.getString("MLSTS"));
					rmap.put("MLUS", executeQuery.getString("MLUS"));
					rmap.put("CMMT", executeQuery.getString("CMMT"));
				}

			}else{
				throw new Exception("conn is null");	
			}
			return rmap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	public  Map getZMLDTL(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			Map rmap = new HashMap();
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				String sql = "select d.*,h.TPCENT from ZMLDTL d inner join ZMLHDR h on d.MLCODE=h.MLCODE where MLCODE='"+(String)pmap.get("MLCODE")+"'";
				System.out.println("find is "+sql);
				stmt = (Statement) conn.createStatement();
				ResultSet executeQuery = stmt.executeQuery(sql);
				if(executeQuery.next()){
					rmap.put("MLSEQ", executeQuery.getString("MLSEQ"));
					rmap.put("MLSID", executeQuery.getString("MLSID"));
					rmap.put("POENV", executeQuery.getString("POENV"));
					rmap.put("POWHS", executeQuery.getString("POWHS"));
					rmap.put("POVND", executeQuery.getString("POVND"));
					rmap.put("POCUR", executeQuery.getString("POCUR"));
					rmap.put("POBUY", executeQuery.getString("POBUY"));
					rmap.put("COENV", executeQuery.getString("COENV"));
					rmap.put("COCMPY", executeQuery.getString("COCMPY"));
					rmap.put("COWHS", executeQuery.getString("COWHS"));
					rmap.put("COCUS", executeQuery.getString("COCUS"));
					rmap.put("COCUR", executeQuery.getString("COCUR"));
					rmap.put("TPCENT", executeQuery.getString("TPCENT"));
				}


			}else{
				throw new Exception("conn is null");	
			}
			return rmap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}


	public  double getItemPrecIncome(String lib,String stid,String itnbr) throws Exception{
		double result = 0;
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];

			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				try {
					String sql = "SELECT AMPHLIB1.getItemPrecIncome('"+stid+"','"+itnbr+"') as gg FROM SYSIBM.SYSDUMMY1";
					stmt = (Statement) conn.createStatement();
					ResultSet executeQuery = stmt.executeQuery(sql);
					if(executeQuery.next()){
						result = executeQuery.getDouble("gg");
						executeQuery.close();
						stmt.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				throw new Exception("conn is null");	
			}

		}catch(Exception e){
			if(conn!=null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			throw e;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return result;
		}
	}


	public  Map getMBC6REP(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			Map rmap = new HashMap();
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				String sql = "select * from MBC6REP where C6AENB="+(Integer)pmap.get("C6AENB")+" and C6DCCD='"+(String)pmap.get("C6DCCD")+"' and C6CVNB='"+(String)pmap.get("C6CVNB")+"'";
				System.out.println("find is "+sql);
				stmt = (Statement) conn.createStatement();
				ResultSet executeQuery = stmt.executeQuery(sql);
				if(executeQuery.next()){
					rmap.put("C6AENB", executeQuery.getInt("C6AENB"));
					rmap.put("C6DCCD", executeQuery.getString("C6DCCD"));
					rmap.put("C6CVNB", executeQuery.getString("C6CVNB"));
					rmap.put("C6ACDT", executeQuery.getInt("C6ACDT"));
					rmap.put("C6CHNB", executeQuery.getString("C6CHNB"));
					rmap.put("C6D0NB", executeQuery.getInt("C6D0NB"));
					rmap.put("C6BRCD", executeQuery.getInt("C6BRCD"));
				}


			}else{
				throw new Exception("conn is null");	
			}
			return rmap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	public  Map getBKD5NB(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			Map rmap = new HashMap();
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				String sql = "select * from YABKREP where BKF3CD='MAPICS' and BKI5CD ='"+(String)pmap.get("hkcocurrency")+"' and BKI6CD ='"+(String)pmap.get("POCUR")+"' order by BKA6DT desc";
				System.out.println("find is "+sql);
				stmt = (Statement) conn.createStatement();
				ResultSet executeQuery = stmt.executeQuery(sql);
				if(executeQuery.next()){
					rmap.put("BKD5NB", executeQuery.getFloat("BKD5NB"));
				}


			}else{
				throw new Exception("conn is null");	
			}
			return rmap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	public  int insertZMLTRN(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		int count=0;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				stmt=conn.createStatement();
				String sql = "insert into ZMLTRN(MLENV,MLCODE,MLSEQ,MLTYPE,MLCMPY,MLCTYP,MLCNUM,MLCCUS,MLPNUM,MLPVND,MLWHS,POENV,POWHS,POORD,POVNDR,COENV,COCMPY,COITYP,COORD,COCUS) values(";
				sql=sql+"'"+(String)pmap.get("MLENV")+"','"+(String)pmap.get("MLCODE")+"',"+(Integer)pmap.get("MLSEQ")+",";
				sql=sql+"'"+(String)pmap.get("MLTYPE")+"',"+(Integer)pmap.get("MLCMPY")+",'"+(String)pmap.get("MLCTYP")+"',";
				sql=sql+"'"+(String)pmap.get("MLCNUM")+"',"+(Integer)pmap.get("MLCCUS")+",'"+(String)pmap.get("MLPNUM")+"',";
				sql=sql+"'"+(String)pmap.get("MLPVND")+"','"+(String)pmap.get("MLWHS")+"','"+(String)pmap.get("POENV")+"',";
				sql=sql+"'"+(String)pmap.get("POWHS")+"','"+(String)pmap.get("POORD")+"','"+(String)pmap.get("POVNDR")+"',";
				sql=sql+"'"+(String)pmap.get("COENV")+"',"+(Integer)pmap.get("COCMPY")+",'"+(String)pmap.get("COITYP")+"',";
				sql=sql+"'"+(String)pmap.get("COORD")+"',"+(Integer)pmap.get("COCUS");
				sql=sql+")";
				System.out.println("insertZMLTRN is "+sql);
				stmt.executeUpdate(sql);

			}else{
				throw new Exception("conn is null");	
			}
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}
	public  Map getZMLTRN(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			Map rmap = new HashMap();
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				String sql = "select * from ZMLTRN where 1=1 ";
				if(pmap.get("MLCNUM")!=null){
					sql=sql+" and MLCNUM='"+(String)pmap.get("MLCNUM")+"'";
				}
				if(pmap.get("POORD")!=null){
					sql=sql+" and POORD='"+(String)pmap.get("POORD")+"'";
				}
				System.out.println("find is "+sql);
				stmt = (Statement) conn.createStatement();
				ResultSet executeQuery = stmt.executeQuery(sql);
				if(executeQuery.next()){
					rmap.put("MLENV", executeQuery.getString("MLENV"));
					rmap.put("MLCODE", executeQuery.getString("MLCODE"));
					rmap.put("MLSEQ", executeQuery.getString("MLSEQ"));
					rmap.put("MLTYPE", executeQuery.getString("MLTYPE"));
					rmap.put("MLCMPY", executeQuery.getString("MLCMPY"));
					rmap.put("MLCTYP", executeQuery.getString("MLCTYP"));
					rmap.put("MLCNUM", executeQuery.getString("MLCNUM"));
					rmap.put("MLCCUS", executeQuery.getString("MLCCUS"));
					rmap.put("MLPNUM", executeQuery.getString("MLPNUM"));
					rmap.put("MLPVND", executeQuery.getString("MLPVND"));
					rmap.put("MLWHS", executeQuery.getString("MLWHS"));
					rmap.put("POENV", executeQuery.getString("POENV"));


					rmap.put("POWHS", executeQuery.getString("POWHS"));
					rmap.put("POORD", executeQuery.getString("POORD"));
					rmap.put("POVNDR", executeQuery.getString("POVNDR"));
					rmap.put("COENV", executeQuery.getString("COENV"));
					rmap.put("COCMPY", executeQuery.getString("COCMPY"));
					rmap.put("COITYP", executeQuery.getString("COITYP"));
					rmap.put("COORD", executeQuery.getString("COORD"));
					rmap.put("COCUS", executeQuery.getString("COCUS"));
				}


			}else{
				throw new Exception("conn is null");	
			}
			return rmap;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	public  List getMlCO(String lib,Map pmap) throws Exception{
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		OutputStream os = null;
		List results = new ArrayList();
		try{
			is = new BufferedInputStream(new FileInputStream(this.getClass().getResource("").getPath()+ "/config.properties"));
			Properties properties = new Properties();
			properties.load(is);
			//			Class.forName("");
			Class.forName(properties.getProperty("DRIVER_NAME"));
			java.sql.DriverManager.registerDriver (new com.ibm.as400.access.AS400JDBCDriver ()); 
			//			Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
			//			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/QGPL", "", "");
			String dburl=properties.getProperty("DBURL");
			String dbip=dburl.split("/")[2];
			Map rmap = null;
			conn=DriverManager.getConnection("jdbc:as400://"+dbip+"/"+lib+";translate binary=true", properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			if(conn!=null){
				String sql = "select c.*,d.ADBIDT,d.ADAAN7 from MBCDREP c inner join MBADREP d on c.CDAENB=d.ADAENB and c.CDDCCD=d.ADDCCD and c.CDCVNB=d.ADCVNB and c.CDFCNB=d.ADFCNB where 1=1 ";
				if(pmap.get("CDAENB")!=null){
					sql=sql+" and c.CDAENB="+(Integer)pmap.get("CDAENB");
				}
				if(pmap.get("CDDCCD")!=null){
					sql=sql+" and c.CDDCCD='"+(String)pmap.get("CDDCCD")+"'";
				}
				if(pmap.get("CDCVNB")!=null){
					sql=sql+" and c.CDCVNB='"+(String)pmap.get("CDCVNB")+"'";
				}
				if(pmap.get("CDFCNB")!=null){
					sql=sql+" and c.CDFCNB="+(Integer)pmap.get("CDFCNB");
				}
				sql=sql+" order by c.CDFCNB ";
				System.out.println("find is "+sql);
				stmt = (Statement) conn.createStatement();
				ResultSet executeQuery = stmt.executeQuery(sql);
				while(executeQuery.next()){
					rmap = new HashMap();
					rmap.put("CDFCNB", executeQuery.getInt("CDFCNB"));
					rmap.put("CDKTNB", executeQuery.getString("CDKTNB"));
					rmap.put("CDACQT", executeQuery.getFloat("CDACQT"));
					rmap.put("CDH3ST", executeQuery.getString("CDH3ST"));
					rmap.put("CDFXVA", executeQuery.getFloat("CDFXVA"));
					rmap.put("CDAITX", executeQuery.getString("CDAITX"));
					rmap.put("CDDHCD", executeQuery.getString("CDDHCD"));
					rmap.put("CDA3CD", executeQuery.getString("CDA3CD"));
					rmap.put("ADBIDT", executeQuery.getInt("ADBIDT"));
					rmap.put("ADAAN7", executeQuery.getInt("ADAAN7"));
					rmap.put("ADAJDT", executeQuery.getInt("ADAAN7"));
					rmap.put("ADAIDT", executeQuery.getInt("ADAAN7"));
					rmap.put("CDDOVA", executeQuery.getFloat("CDDOVA"));
					results.add(rmap);
				}


			}else{
				throw new Exception("conn is null");	
			}
			return results;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(os!=null){
					os.close();
				}
				if(is!=null){
					is.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	// 生产发料 PMC/TRDATA 触发更新
	public  void CallTamjuc(String host,String userName,String password,String env) throws Exception{

		AS400 as400 = null; 
		ProgramCall pgm; 

		String progname = "/QSYS.LIB/"+env.trim()+".lib/TAMJUC.pgm";

		as400 = new AS400(host, userName, password);

		try{
			as400.connectService(AS400.COMMAND);
		} catch(Exception e) 
		{ System.out.println("连接AS/400服务失败！"); 
		System.exit(0); 
		} 

		pgm=new ProgramCall(as400); 
		//设置参数，并转换为AS/400格式 

		try 
		{ 

			pgm.setProgram(progname); 
		} 
		catch(Exception e) 
		{ System.out.println("设置参数失败！"); 
		} 
		try 
		{ if(pgm.run() == true) 
		{  

			System.out.println("远程调用成功！"); 
		} 
		else 
		{  System.out.println("远程调用失败！"); 
		} 
		} 
		catch(Exception e) 
		{ 
			System.out.println("远程调用异常！"); 
			e.printStackTrace(); 
		} 
	} 

	// b.	通过JAVA程序增加Journal控制
	public  void CallJournal(String host,String userName,String password,String env) throws Exception{

		AS400 as400 = null; 
		ProgramCall pgm; 

		String progname = "/QSYS.LIB/"+env.trim()+".lib/TSHPDSK.pgm";
		System.out.println("progname:"+progname);
		as400 = new AS400(host, userName, password);

		try{
			as400.connectService(AS400.COMMAND);
		} catch(Exception e) 
		{ System.out.println("连接AS/400服务失败！"); 
		System.exit(0); 
		} 

		pgm=new ProgramCall(as400); 
		//设置参数，并转换为AS/400格式 

		try 
		{ 

			pgm.setProgram(progname); 
		} 
		catch(Exception e) 
		{ System.out.println("设置参数失败！"); 
		} 
		try 
		{ if(pgm.run() == true) 
		{  

			System.out.println("远程调用成功！"); 
		} 
		else 
		{  System.out.println("远程调用失败！"); 
		} 
		} 
		catch(Exception e) 
		{ 
			System.out.println("远程调用异常！"); 
			e.printStackTrace(); 
		} 
	} 

	public static String db2DateFormat(int db2Date){
		try{
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
			Date parse = sf.parse(String.valueOf(db2Date));
			sf = new SimpleDateFormat("yyyy-MM-dd");
			return sf.format(parse);
		}catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}


	public static String db2TimeFormat(int db2Time){
		try{
			SimpleDateFormat sf = new SimpleDateFormat("HHmmss");
			Date parse = sf.parse(String.valueOf(db2Time));
			sf = new SimpleDateFormat("HH:mm:ss");
			return sf.format(parse);
		}catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}


	public static void main(String[] args) {
		//		String password = toMd5("admin" + "888888");
		System.out.println("abcdefg".substring("abcdefg".indexOf("cd")+2));
		System.out.println(round(BigDecimal.valueOf(1.36),1,"3"));
		//		Map map = new HashMap();
		//		Utils.systemLinkHouse(map);
		//		String a="<Response sessionHandle='1476acad:1561652add9:-7e9b' workHandle='1476acad:1561652add9:-7e9a' systemTimestamp='2016-07-23 17:41:30.229' systemTimeZoneOffset='+8:00' hasErrors='false' hasWarnings='true'><UpdateResponse";
		//		String retStr1 = a.substring(a.indexOf("hasErrors"), a.indexOf("hasErrors")+17);
		//		System.out.println(retStr1.indexOf("false"));
		//		Utils u = new Utils();
		//		Map map = new HashMap();
		//		u.insertTrdata("AMTLIB1", map);
	}

}
