package com.eclink.hgpj.base;

import java.io.Serializable;

/**
 * BaseVO.java
 *
 * @Title: 值对象基类
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.

 * @version 1.0
 * @date Nov 9, 2011 12:29:19 AM
 *
 */
public class BaseVO implements Serializable{
	
	/** 分页查询时从第几条记录开始 */
	private int from;
	
	/** 分页查询时每页获取的记录数 */
	private int pageSize;

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
