package com.eclink.hgpj.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import com.eclink.hgpj.init.SystemInitServlet;

public class DataSourceUtil {

	
	public DataSourceUtil(){
		
	}
	
	public static void setDataSource (String url,int idx) {  
	    // 获取配置文件  
	    InputStream configInStream = null;  
	    Properties properties = new Properties();  
	    try {  
	    	configInStream = new BufferedInputStream(new FileInputStream(url));
			
	        properties.load(configInStream);  
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
	    // 根据数据库连接配置来设置数据源对象  
	    BasicDataSource basicDS = (BasicDataSource) SystemInitServlet.WAC.getBean("dataSource");  
	    String driverClassName=basicDS.getDriverClassName();
	    String durl = basicDS.getUrl();
	    String newUrl ="";
	    String[] durls = durl.split("/");
	    for(int i=0;i<durls.length-1;i++){
	    	newUrl=newUrl+durls[i]+"/";
	    }
	    newUrl=newUrl+properties.getProperty("AMPHLIB"+idx);
	    String username =basicDS.getUsername();
	    String password=basicDS.getPassword();
	    long maxwait = basicDS.getMaxWait();
	    try {  
	        // 这里需要先关闭数据源，才可以使新的数据源设置生效  
	        basicDS.close();   
	    } catch (SQLException e) {  
//	        log.warn("关闭从Spring获取的数据源时出现异常！", e);  
	    }  
	    basicDS.setDriverClassName(driverClassName);  
	    basicDS.setUrl(newUrl);  
	    basicDS.setUsername(username);  
	    basicDS.setPassword(password);  
	    basicDS.setMaxWait(maxwait);  
	}  
	public static void main(String[] args){
		String s = "1://123/ss";
		System.out.println(s.split("/").length);
	}
}
