package com.eclink.hgpj.resource.action;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;

/**
 * @Title 打印物料标签
 * @Description 
 * @author miao
 *
 */
public class MaterialTagAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(MaterialTagAction.class);
	
	/**
	 * 物料标签
	 * @return
	 * @throws Exception
	 */
	public String toMaterialTag() throws Exception {
		return "toMaterialTag";
	}
	
	/**
	 * 打印物料标签
	 * @return
	 * @throws Exception
	 */
	public String toPrintMaterialTag() throws Exception {
		return "toPrintMaterialTag";
	}
}
