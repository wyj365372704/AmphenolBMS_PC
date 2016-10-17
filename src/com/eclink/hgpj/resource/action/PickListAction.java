package com.eclink.hgpj.resource.action;


import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;


/**
 * @Title: 打印领料单控制类
 * @Description: 
 * @author miao
 *
 */
public class PickListAction extends BaseAction {
	/**
	 * 日志对象
	 */
	private static final Logger log = Logger.getLogger(PickListAction.class);

	/**
	 * 领料单查询
	 * @return
	 * @throws Exception
	 */
	public String toPickList() throws Exception {
		try {
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			// setPagination(role,page);
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(0);
			}
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toPickList";
	}
	
	public String pickPrint() throws Exception {
		try {
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			// setPagination(role,page);
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(0);
			}
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "pickPrint";
	}
	
	public String toPrintPick() throws Exception {
		try {
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			// setPagination(role,page);
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(0);
			}
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {e.printStackTrace();
			log.error("Go to admin resource operation grant page occured error.", e);
			return ERROR;
		}
		return "toPrintPick";
	}
}