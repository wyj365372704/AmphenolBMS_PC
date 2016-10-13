package com.eclink.hgpj.common;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.eclink.hgpj.util.ConfigHelper;

/**
 * HGPJConfig.java
 *
 * @Title: 系统配置类
 * @Description: 通过配置帮助类，对外提代获取配置文件值的方法
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Nov 17, 2011 4:37:41 PM
 *
 */
public class HGPJConfig {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(HGPJConfig.class);
	
	/**
     * 配置文件接口
     */
    private static Configuration configuration = null;
    
    /**
     * 用户中心系统默认配置文件名
     */
    private static String configFileName = HGPJConstant.DEFAULT_HGPJ_CONFIG_FILENAME;
	
	/**
	 * 用户中心系统配置对象
	 */
	private static HGPJConfig config;
	
	/**
	 * 私有构造函数，防止外部创建实例
	 */
	private HGPJConfig() {
		if (null == config) {
			load();
		}
	}
	
	/**
	 * 获取用户中心系统配置对象
	 * @return 用户中心系统配置对象
	 */
	public static HGPJConfig getInstance() {
        if (config == null) {
            config = new HGPJConfig();
        }
        return config;
    }
	
	 /**
     * 加载配置文件
     */
    private static void load() {
        configuration = ConfigHelper.getConfiguration(configFileName,10000);
        if (configuration == null) {
            log.error("读UC配置文件失败, 配置文件：" + configFileName);
        }
    }
    
    /**
     * 是否开启海关域用户登录鉴权
     * @return true|false
     */
    public boolean isOpenDomainAuth() {
    	if (null == configuration) {
    		return true;
    	}
    	String isOpen = configuration.getString("isOpenDomainAuth");
    	if (StringUtils.isBlank(isOpen)) {
    		return true;
    	}
    	return "true".equals(isOpen);
    }
    
    /**
     * 获取海关网络域名称集合
     * @return
     */
    public Set<String> getCustomsDomain() {
    	Set<String> customsDomainSet = new HashSet<String>();
    	try {
			String customsDomain = configuration.getString("customsDomain");
			if (StringUtils.isBlank(customsDomain)) {
				return customsDomainSet;
			}
			StringTokenizer st = new StringTokenizer(customsDomain, "|");
			while (st.hasMoreElements()) {
				customsDomainSet.add(st.nextToken());
			}
		} catch (Exception e) {
			log.error("Get hgpj config[customsDomain] error.", e);
		}
    	return customsDomainSet;
    }
    
    /**
     * 获取海关域用户验证web service访问地址
     * @return
     */
    public String getDomainUserAuthUrl() {
    	String domainUserAuthUrl = configuration.getString("domainUserAuthUrl");
    	if (StringUtils.isBlank(domainUserAuthUrl)) {
    		domainUserAuthUrl = "";
    	}
    	return domainUserAuthUrl;
    }
    
    /**
     * 是否开启资源鉴权
     * @return
     */
    public boolean isOpenPermCheck() {
    	if (null == configuration) {
    		return true;
    	}
    	String isOpenPermCheck = configuration.getString("isOpenPermCheck");
    	if (StringUtils.isBlank(isOpenPermCheck)) {
    		return true;
    	}
    	return "true".equals(isOpenPermCheck);
    }
    
    /**
     * 获取应用部署的另外一台服务器
     * @return
     */
    public String getDeployServers() {
		String deployServers = configuration.getString("deployServers");
		if (StringUtils.isBlank(deployServers)) {
			deployServers = "";
		}
    	return deployServers;
    }
}
