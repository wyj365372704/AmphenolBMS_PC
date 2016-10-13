package com.eclink.hgpj.init;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.eclink.dfcm.paginator.config.ConfigWatcher;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.dictionary.DictCache;
import com.eclink.hgpj.util.ConfigHelper;
import com.eclink.hgpj.util.Copyright;

/**
 * SystemInitServlet.java
 *
 * @Title: 系统初始化servlet
 * @Description: 

 * @version 1.0
 * @date Nov 8, 2011 1:15:53 PM
 *
 */
public class SystemInitServlet extends HttpServlet{

	private static final long serialVersionUID = 7096419784508127875L;

	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(SystemInitServlet.class);
	
	/** spring应用上下文 */
	public static  WebApplicationContext WAC = null;
	
	public void init() throws ServletException {
		WAC = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		
		// 初始化系统配置文件根路径
		initConfigPath();
		
		// 初始化log4j配置(日志输出目录等)
        initLog4j();
               
		// 分页配置初始化
		ConfigWatcher.runSingleThread();
		
		// 加载数据字典至缓存
//		DictCache.getInstance();
		
		// 输出版本与版权信息
//		String filePath = this.getServletContext().getRealPath("/")+"version.properties";
//		Copyright.showVersion(filePath);
	}
	
	/**
     * 初始化配置文件根目录
     */
    private void initConfigPath() {
    	System.out.println("### [InitConfigPath...]");
    	if (log.isDebugEnabled()) {
    		log.debug("开始初始化系统配置文件根目录...");
    	}
        // 获取用户目录
        String userDir = getUserDir();
        if (StringUtils.isBlank(userDir)) {
        	System.out.println("Init config path error...");
        	log.error("Init config path error,get user.dir is '" + userDir + "'...");
        	return;
        }
        if (log.isDebugEnabled()) {
        	log.debug("用户目录：" + userDir);
        }
        // 获取系统名称
        String systemName = this.getInitParameter("systemName");
        if (log.isDebugEnabled()) {
        	log.debug("系统名称：" + systemName);
        }
        // 构建配置文件根目录：用户目录+系统名称+config
        String configPath = userDir + File.separator + systemName + File.separator + "config";       
        ConfigHelper.setBasePath(configPath);
        System.out.println("  configRootPath：" + configPath);
        System.out.println("initConfigPath success...");
        if (log.isDebugEnabled()) {
        	log.debug("设置系统配置文件根目录成功, 配置文件根目录:" + configPath); 
        }
    }
    
    /**
	 * log4j初始化
	 */
	private void initLog4j(){
		// Log4j配置文件名
		String log4jConfig = this.getInitParameter("log4jConfigFile");
		// 获取完整Log4j配置文件路径及文件名
		String configFile = ConfigHelper.getFullFileName(log4jConfig);
		// 配置文件刷新时间
		String refreshTimeStr = this.getInitParameter("refreshTime");
		int refreshTime = 0;
		try {
			refreshTime = Integer.parseInt(refreshTimeStr);
		} catch (NumberFormatException e) {
			refreshTime = HGPJConstant.LOG4J_REFRESH_TIME;
		}
		// 控制台输出提示信息
		StringBuffer buff = new StringBuffer();
        buff.append("### [Load log4j config...]\n");
        buff.append("  log4jConfigFile：");
        buff.append(configFile);
        buff.append("\n");
        buff.append("  refreshTime(seconds)：");
        buff.append(refreshTime);
        System.out.println(buff);
        // 检查配置文件是否存在
        File file = new File(configFile);
		if (!file.exists()) {
			System.out.println("Log4j config error...log4jConfigFile not found.");
		} else {
			DOMConfigurator.configureAndWatch(configFile, refreshTime);
			System.out.println("Log4j config success...");
		}
	}
	
	/**
     * 获取TOMCAT服务器的用户目录user.dir
     * @return 用户目录user.dir
     */
    private String getUserDir() {
    	// 获取TOMCAT服务器的用户目录,一般位于$TOMCAT_HOME/bin
        String userDir = System.getProperty("user.dir");
        return userDir;
    }

	
}
