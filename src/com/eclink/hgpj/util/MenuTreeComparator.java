package com.eclink.hgpj.util;

import java.util.Comparator;

import com.eclink.hgpj.resource.vo.MenuVO;

/**
 * @Title:  
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author lweifeng
 * @version 1.0
 * @date Nov 9, 2011 12:43:15 AM
 *
 */
public class MenuTreeComparator implements Comparator {
		public int compare(Object obj, Object compObj) {
			if (obj==compObj){
				return 0 ;
			}
			if (!(obj instanceof MenuVO)){
				return -1 ;
			}
			if (!(compObj instanceof MenuVO)){
				return 1 ;
			} 
			MenuVO res = (MenuVO)obj;
			MenuVO resCom =(MenuVO)compObj ;
			return res.getMenuOrder()<=resCom.getMenuOrder() ? -1 : 1;
		}
}
