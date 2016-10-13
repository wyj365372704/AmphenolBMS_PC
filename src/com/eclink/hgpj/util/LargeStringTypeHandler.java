package com.eclink.hgpj.util;

import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ibatis.sqlmap.engine.type.StringTypeHandler;

/**
 * LargeStringTypeHandler.java
 *
 * @Title: Ibatis超长字符串处理类
 * @Description: 使用该类，必须在SqlMapConfig.xml中添加<typeHandler javaType="java.lang.String" callback="com.eclink.uc.util.LargeStringTypeHandler"/>
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Oct 11, 2012 1:36:03 PM
 *
 */ 

public class LargeStringTypeHandler extends StringTypeHandler {

	public void setParameter(PreparedStatement ps, int i, Object parameter,
			String jdbcType) throws SQLException {
		String s = (String) parameter;
		if (s.length() < 667) {
			//assume that all characters are chinese characters.  
			super.setParameter(ps, i, parameter, jdbcType);
		} else {
			//use setCharacterStream can insert more characters.  
			ps.setCharacterStream(i, new StringReader(s), s.length());
		}
	}

}
