package com.eclink.hgpj.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

/**
 * ConfigHelper.java
 * 
 * @Title: 配置文件帮助类
 * @Description: 由系统初始化类设置配置文件根目录，对外提供根据配置文件名获取配置对象，并定时刷新指定文件方法
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司
 * @author 张万根
 * @version 1.0
 * @date Nov 17, 2011 10:27:37 AM
 * 
 */
public class ConfigHelper {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(ConfigHelper.class);

	/**
	 * XML文件后缀名
	 */
	private static final String XML = ".xml";

	/**
	 * PROPERTIES文件后缀名
	 */
	private static final String PROPERTIES = ".properties";

	/**
	 * 配置文件根目录
	 */
	private static String basePath = null;

	/**
	 * 私有构造函数，防止被外部构造
	 */
	private ConfigHelper() {

	}

	/**
	 * 设置配置文件根目录
	 * 
	 * @param basePath 根目录
	 */
	public static void setBasePath(String basePath) {
		ConfigHelper.basePath = basePath;
	}

	/**
	 * 获取配置文件根目录
	 * 
	 * @return 根目录
	 */
	public static String getBasePath() {
		if (basePath == null) {
			return System.getProperty("user.dir");
		}
		return basePath;
	}

	/**
	 * 根据配置文件名得到配置文件流
	 * 
	 * @param configFileName 配置文件名
	 * @return 配置文件流
	 */
	public static InputStream readConfiguration(String configFileName) {
		if (configFileName == null) {
			return null;
		}
		// 得到配置文件全路径名（如果设置了basePath，fileName=basePath+configFileName）
		String fileName = getFullFileName(configFileName);

		try {
			File file = new File(fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			return fileInputStream;
		} catch (FileNotFoundException e) {
			log.error("打开配置文件失败，filename=" + fileName);
		}
		return null;
	}

	/**
	 * 根据配置文件名得到配置对象
	 * 
	 * @param configFileName 配置文件名
	 * @return 配置对象
	 */
	public static Configuration getConfiguration(String configFileName) {
		return getConfiguration(configFileName, 0);
	}

	/**
	 * 根据配置文件名得到配置对象
	 * 
	 * @param configFileName 配置文件名
	 * @param refreshDelay 刷新时间(微秒单位)
	 * @return 配置对象
	 */
	public static Configuration getConfiguration(String configFileName,
			long refreshDelay) {
		if (configFileName == null) {
			return null;
		}

		// 得到配置文件全路径名（如果设置了basePath，fileName=basePath+configurationFileName）
		String fileName = getFullFileName(configFileName);

		// 检查配置文件类型
		boolean isXmlFile = false;
		if (configFileName.lastIndexOf(XML) > 0) {
			isXmlFile = true;
		} else if (configFileName.lastIndexOf(PROPERTIES) > 0) {
			isXmlFile = false;
		} else {
			return null;
		}

		if (isXmlFile) {
			XMLConfiguration xmlConfiguration = null;
			try {
				xmlConfiguration = new XMLConfiguration(fileName);
			} catch (ConfigurationException e) {
				log.error("打开配置文件失败，filename=" + fileName);
			}

			// 如果需要定时刷新,设置刷新策略
			if (refreshDelay > 0) {
				FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
				fileChangedReloadingStrategy.setConfiguration(xmlConfiguration);
				fileChangedReloadingStrategy.setRefreshDelay(refreshDelay);
				xmlConfiguration
						.setReloadingStrategy(fileChangedReloadingStrategy);
			}
			return xmlConfiguration;
		} else {
			PropertiesConfiguration propertiesConfiguration = null;
			try {
				propertiesConfiguration = new PropertiesConfiguration(fileName);
			} catch (ConfigurationException e) {
				log.error("打开配置文件失败，filename=" + fileName);
			}

			// 如果需要定时刷新,设置刷新策略
			if (refreshDelay > 0) {
				FileChangedReloadingStrategy reloadingStrategy = new FileChangedReloadingStrategy();
				reloadingStrategy.setConfiguration(propertiesConfiguration);
				reloadingStrategy.setRefreshDelay(refreshDelay);
				propertiesConfiguration.setReloadingStrategy(reloadingStrategy);

			}
			return propertiesConfiguration;
		}

	}


	/**
	 * 得到配置文件全路径名
	 * 
	 * @param fileName 配置文件名
	 * @return 全路径名
	 */
	public static String getFullFileName(String fileName) {
		if (basePath != null) {
			return basePath + File.separator + fileName;
		}
		return fileName;
	}

}
