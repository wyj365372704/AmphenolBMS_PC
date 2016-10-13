package com.eclink.hgpj.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Connection conn = null;
		InputStream is =null;
		Statement stmt = null;
		ResultSet rs = null;
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
			conn=DriverManager.getConnection(properties.getProperty("DBURL"), properties.getProperty("DBUSER"), properties.getProperty("DBPASSWORD"));
			arg0.getServletContext().setAttribute("sluserId", properties.getProperty("SLUSERID"));
			arg0.getServletContext().setAttribute("slpassword", properties.getProperty("SLPASSWORD"));
			arg0.getServletContext().setAttribute("slurl", properties.getProperty("SYSTEM_LINK"));
			String sqlQ="select * from QGPL.ZMMLIST ";
		 	if(conn!=null){
		 		//result="已经成功连接数据库";
		 		File file = new File((this.getClass().getResource("").getPath()+ "/dbconfig.properties"));
		 		os = new FileOutputStream(file); 
			   stmt = (Statement) conn.createStatement();
			   stmt.execute(sqlQ);//执行select语句用executeQuery()方法，执行insert、update、delete语句用executeUpdate()方法。
			   rs=(ResultSet) stmt.getResultSet();
			   int i=0;
			   Map<String, String> envStidMap  = new HashMap<String, String>();
				while(rs.next()){ //当前记录指针移动到下一条记录上
				    String str = rs.getString("ENVID");//得到当前记录的第一个字段(id)的值
			 		String str2 = rs.getString("AMPHLIB");
			 		String str3 = rs.getString("AMFLIB");	 		
			 		String stid  = rs.getString("STID");
			 		arg0.getServletContext().setAttribute(str, i);
			 		arg0.getServletContext().setAttribute("STID", stid);
			 		String out="ENVID"+i+"="+str+"\r\n"+"AMPHLIB"+i+"="+str2+"\r\n"+"AMFLIB"+i+"="+str3+"\r\n"+"STID"+i+"="+stid+"\r\n"+"AMTLIB"+i+"="+rs.getString("AMTLIB")+"\r\n";
			 		os.write(out.getBytes());
			 		System.out.println(out);
			 		envStidMap.put(str, stid);
				    //result=result+"<option value='"+str2+"-"+str3+"-"+str+"'>"+str+"</option>";
				   // String name =rs.getString(2);//得到第二个字段(name)的值
				   // String psw = rs.getString("ppassword");//得到(password)的值
				   // System.out.println(Integer.toString(i)+" "+name+" "+psw);
			 		i++;
			  	 }
				
				arg0.getServletContext().setAttribute("envcount", i);
				arg0.getServletContext().setAttribute("envStidMap", envStidMap);
		 	}
		}catch(Exception e){
			e.printStackTrace();
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

}
