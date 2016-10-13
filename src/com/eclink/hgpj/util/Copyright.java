package com.eclink.hgpj.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * Copyright.java
 *
 * @Title: 公司LOGO与版权显示
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通
 * @author 张万根
 *
 * @version 1.0
 */
public class Copyright {
	private static final Logger log = Logger.getLogger(Copyright.class);
	private static final int charLength = 37;
	
	/**
	 * 显示LOGO与版权
	 */
	public static void showVersion(String filePath) {
		Properties prop = getVersionProperties(filePath);
		System.out.println(getVersionInfo(prop,makeLogo()));
	}
	
	/**
	 * 构造ECLINK
	 * @return
	 */
	private static String makeLogo() {
        StringBuffer str = new StringBuffer();
        //line 1
        str.append(repeatLetter('#', 2));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('=', 65));
        str.append(repeatLetter('#', 2));
        str.append(Utils.LINE_SEPARATOR);
        //line 2
        str.append(repeatLetter('#', 2));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('E', 10));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('C', 9));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('L', 3));
        str.append(repeatLetter(' ', 7));
        str.append(repeatLetter('I', 5));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 4));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 3));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('K', 4));
        str.append(Utils.LINE_SEPARATOR);
        //line 3
        str.append(repeatLetter('#', 2));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('E', 3));
        str.append(repeatLetter(' ', 9));
        str.append(repeatLetter('C', 3));
        str.append(repeatLetter(' ', 9));
        str.append(repeatLetter('L', 3));
        str.append(repeatLetter(' ', 8));
        str.append(repeatLetter('I', 3));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('N', 4));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 3));
        str.append(repeatLetter(' ', 2));
        str.append(Utils.LINE_SEPARATOR);
        //line 4
        str.append(repeatLetter('#', 2));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('E', 8));
        str.append(repeatLetter(' ', 4));
        str.append(repeatLetter('C', 3));
        str.append(repeatLetter(' ', 9));
        str.append(repeatLetter('L', 3));
        str.append(repeatLetter(' ', 8));
        str.append(repeatLetter('I', 3));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 1));
        str.append(repeatLetter('N', 1));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 6));
        str.append(repeatLetter(' ', 4));
        str.append(Utils.LINE_SEPARATOR);
        //line 5
        str.append(repeatLetter('#', 2));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('E', 3));
        str.append(repeatLetter(' ', 9));
        str.append(repeatLetter('C', 3));
        str.append(repeatLetter(' ', 9));
        str.append(repeatLetter('L', 3));
        str.append(repeatLetter(' ', 8));
        str.append(repeatLetter('I', 3));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('N', 1));
        str.append(repeatLetter(' ', 1));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 3));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 3));
        str.append(repeatLetter(' ', 2));
        str.append(Utils.LINE_SEPARATOR);
        //line 6
        str.append(repeatLetter('#', 2));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('E', 10));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('C', 9));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('L', 8));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('I', 5));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('N', 3));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('N', 4));
        str.append(repeatLetter(' ', 2));
        str.append(repeatLetter('K', 3));
        str.append(repeatLetter(' ', 3));
        str.append(repeatLetter('K', 4));
        str.append(Utils.LINE_SEPARATOR);
        //line 7
        str.append(repeatLetter('#', 2));
        return str.toString();

    }
	
	/**
	 * 构造版权与版本信息
	 * @param versionInfo 版本信息特性对象
	 * @param logo ECLINK字符串
	 * @return
	 */
	private static String getVersionInfo(Properties versionInfo,String logo) {
		StringBuffer result = new StringBuffer();
		// 附加logo
		result.append(logo);
		result.append(Utils.LINE_SEPARATOR);
		// 输出所有者信息
		result.append(repeatLetter('#', 2));
		result.append(repeatLetter(' ', 3));
		result.append(versionInfo.getProperty("OwnerInfo",""));
		result.append(Utils.LINE_SEPARATOR);
		
		//输出警告信息
        String warnInfo = versionInfo.getProperty("WarnInfo","");
        String[] warns = parseLine(warnInfo);
        for (int i = 0; i < warns.length; i++) {
        	result.append(repeatLetter('#', 2));
        	result.append(repeatLetter(' ', 3));
        	result.append(warns[i]);
        	result.append(Utils.LINE_SEPARATOR);
        }
        //输出分隔符
        result.append(repeatLetter('#', 2));
        result.append(repeatLetter(' ', 3));
        result.append(repeatLetter('=', 65));
        result.append(repeatLetter('#', 2));
        result.append(Utils.LINE_SEPARATOR);
        //输出版本ID
        result.append(repeatLetter('#', 2));
        result.append(repeatLetter(' ', 3));
        result.append("版本:");
        result.append(versionInfo.getProperty("VersionID",""));
        result.append(Utils.LINE_SEPARATOR);
        
        return result.toString();
	}
	
	private static Properties getVersionProperties(String filePath) {
		Properties prop = new Properties();
		try {
			InputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			log.error("Load version.properties file error.", e);
		} catch (IOException e) {
			log.error("Load version.properties file error.", e);
		}
		return prop;
	}
	
	private static String repeatLetter(char letter, int len) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            str.append(letter);
        }
        return str.toString();
    }
	
	private static String[] parseLine(String info) {
        ArrayList<String> arr = new ArrayList<String>();
        String tmp = info;
        while (tmp.length() > charLength) {
            String line = tmp.substring(0, charLength);
            arr.add(line);
            tmp = tmp.substring(charLength);
        }
        arr.add(tmp);
        String[] lines = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            lines[i] = (String) arr.get(i);
        }
        return lines;

    }
}
