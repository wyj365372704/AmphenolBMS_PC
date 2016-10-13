package com.eclink.hgpj.util;

import java.util.Comparator;

import com.eclink.hgpj.resource.vo.OperationVO;

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
public class OperationComparator implements Comparator<OperationVO> {

	public int compare(OperationVO obj, OperationVO compObj) {
		if (obj==compObj){
			return 0 ;
		}
		if (!(obj instanceof OperationVO)){
			return -1 ;
		}
		if (!(compObj instanceof OperationVO)){
			return 1 ;
		} 
		OperationVO op = (OperationVO)obj;
		OperationVO opCom =(OperationVO)compObj ;
		return op.getOrderKey()<=opCom.getOrderKey() ? -1 : 1;
	}
	
}
