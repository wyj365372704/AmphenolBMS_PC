package com.eclink.hgpj.setting.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.setting.biz.ParameterService;
import com.eclink.hgpj.setting.vo.ParameterVO;

/**
 * 参数设置Action
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:00:40 AM
 *
 */
public class ParameterAction extends BaseAction {
	private static final Logger log = Logger.getLogger(ParameterAction.class);
	private List<ParameterVO> parameters;
	private ParameterService parameterService;
	
	private void setBase(ParameterVO t) {
		Date now = new Date();
		t.setCreateDate(now);
		t.setLastUpdateDate(now);
		if(getLoginUser() != null){
			t.setCreateUser(getLoginUser().getUserName());
			t.setLastUpdateUser(getLoginUser().getUserName());
		}else{
			t.setCreateUser("");
			t.setLastUpdateUser("");
		}
	}
	/**
	 * 进入新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception{
		try{
			parameters = parameterService.queryList(new ParameterVO());
		}catch (Exception e) {
			log.error("初始化失败！", e);
			throw e;
		}
		return "new";
	}
	/**
	 * 增加
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
		
		try {
			// 设置基本属性及添加到列表中
			for (ParameterVO p : parameters) {
				setBase(p);
			}
			
			// 新增、如果存在ID，则修改
			parameterService.insertList(parameters);
		} catch (Exception e) {
			log.error("insert parameter error." ,e);
			return ERROR;
		}
		
		setBackUrl("/setting/parameter!toInsert.action");
		return "info";
	}

	public List<ParameterVO> getParameters() {
		return parameters;
	}

	public void setParameters(List<ParameterVO> parameters) {
		this.parameters = parameters;
	}
	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}
	
	
}
