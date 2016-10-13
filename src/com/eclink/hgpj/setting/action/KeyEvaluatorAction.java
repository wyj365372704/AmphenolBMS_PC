package com.eclink.hgpj.setting.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.eclink.dfcm.paginator.common.PaginatorUtil;
import com.eclink.dfcm.paginator.tag.PageVO;
import com.eclink.hgpj.base.BaseAction;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.biz.OrgService;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.setting.biz.KeyEvaluatorService;
import com.eclink.hgpj.setting.biz.WindowService;
import com.eclink.hgpj.setting.vo.KeyEvaluatorVO;

/**
 * 按键式设置Action
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
public class KeyEvaluatorAction extends BaseAction {
	private static final Logger log = Logger.getLogger(KeyEvaluatorAction.class);
	private KeyEvaluatorVO keyEvaluator = new KeyEvaluatorVO();
	private List<KeyEvaluatorVO> keyEvaluators;
	private KeyEvaluatorService keyEvaluatorService;
	private WindowService windowService;
	private OrgService orgService;
	
	private void setBase(KeyEvaluatorVO t) {
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
	private void init() throws Exception {
		// 根据当前用户权限取出能设置的所属关区
		List<OrgVO> orgs = orgService.queryCustomsOrg();
		// 判断用户类型，总关查询所有数据，分关只能查询本关数据
		if (!isHeadUser()) {
			keyEvaluator.setCustomsId(getCustomsOfLoginUser().getOrgId());
		}
		
		getRequest().setAttribute("orgs", orgs);
	}
	
	/**
	 * 列表查询
	 *  
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		try {
			// 获取分页信息
			PageVO page = PaginatorUtil.getPaginator(getRequest());
			setPagination(keyEvaluator,page);
			// 初始化，所属关区
			init();
			if(keyEvaluator.getCustomsId() != null){
				List<OrgVO> orgVos = orgService.queryChildOrgByOrgId(keyEvaluator.getCustomsId());
				StringBuilder sb = new StringBuilder();
				for (OrgVO vo : orgVos) {
					sb.append(vo.getOrgId()).append(",");
				}
				sb.append(keyEvaluator.getCustomsId());
//				String ids = sb.toString().replaceAll(",$", "");
				keyEvaluator.setOrgIds(sb.toString());
			}
			
			// 查询总记录数
			if (page.isQueryTotal()) {
				page.setTotalRecord(keyEvaluatorService.queryListCount(keyEvaluator));
			}
			
			// 调用业务方法查询列表
			keyEvaluators = keyEvaluatorService.queryList(keyEvaluator);
			if(keyEvaluators.size() > 0){
				for (KeyEvaluatorVO keyVO : keyEvaluators) {
					if(keyVO.getOrgId() != null){
						OrgVO vo = orgService.queryParentOrgById(keyVO.getOrgId());
						keyVO.setCustomsId(vo.getOrgId());
						keyVO.setCustomsName(vo.getOrgName());
					}
				}
			}
			
			// 分页对象保存至request
			getRequest().setAttribute(HGPJConstant.PAGE_KEY, page);
		} catch (Exception e) {
			log.error("query keyEvaluator error." ,e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 查看
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception{
		try {
			keyEvaluator = keyEvaluatorService.queryById(keyEvaluator.getId());
			OrgVO vo = orgService.queryParentOrgById(keyEvaluator.getOrgId());
			keyEvaluator.setCustomsName(vo.getOrgName());
		} catch (Exception e) {
			log.error("view keyEvaluator error." ,e);
			return ERROR;
		}
		return "view";
	}
	/**
	 * 进入新增页面
	 * @return
	 * @throws Exception
	 */
	public String toInsert() throws Exception{
		try {
			// 初始化，所属关区
			init();
		} catch (Exception e) {
			log.error("toInsert keyEvaluator error." ,e);
			return ERROR;
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
			KeyEvaluatorVO params = new KeyEvaluatorVO();
			params.setKeyNo(keyEvaluator.getKeyNo());
			List<KeyEvaluatorVO> lists = keyEvaluatorService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("评价器编号["+keyEvaluator.getKeyNo()+"]已存在，请重新输入");
				return "error";
			}
			
			setBase(keyEvaluator);
			keyEvaluatorService.insert(keyEvaluator);
		} catch (Exception e) {
			log.error("insert keyEvaluator error." ,e);
			return ERROR;
		}
		
		setBackUrl("/setting/keyEvaluator!list.action");
		return "info";
	}
	/**
	 * 进入修改页面
	 * @return
	 * @throws Exception
	 */
	public String toModify() throws Exception{
		try {
			// 初始化，所属关区
			init();
			keyEvaluator = keyEvaluatorService.queryById(keyEvaluator.getId());
			OrgVO vo = orgService.queryParentOrgById(keyEvaluator.getOrgId());
			keyEvaluator.setCustomsId(vo.getOrgId());
			keyEvaluator.setCustomsName(vo.getOrgName());
		} catch (Exception e) {
			log.error("toModify keyEvaluator error." ,e);
			return ERROR;
		}
		return "modify";
	}
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception{
		try{
			KeyEvaluatorVO params = new KeyEvaluatorVO();
			params.setKeyNo(keyEvaluator.getKeyNo());
			params.setId(keyEvaluator.getId());
			List<KeyEvaluatorVO> lists = keyEvaluatorService.queryList(params);
			
			if(lists != null && lists.size() > 0){
				setErrorMsg("评价器编号["+keyEvaluator.getKeyNo()+"]已存在，请重新输入");
				return "error";
			}
			
			setBase(keyEvaluator);
			keyEvaluatorService.modify(keyEvaluator);
		}catch(Exception e){
			log.error("modify keyEvaluator error." ,e);
			return ERROR;
		}
		setBackUrl("/setting/keyEvaluator!list.action");
		return "info";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		if(keyEvaluator != null && keyEvaluator.getId() != null){
			keyEvaluatorService.delete(keyEvaluator);
		}
		setBackUrl("/setting/keyEvaluator!list.action");
		return "info";
	}

	public KeyEvaluatorVO getKeyEvaluator() {
		return keyEvaluator;
	}

	public void setKeyEvaluator(KeyEvaluatorVO keyEvaluator) {
		this.keyEvaluator = keyEvaluator;
	}

	public List<KeyEvaluatorVO> getKeyEvaluators() {
		return keyEvaluators;
	}

	public void setKeyEvaluators(List<KeyEvaluatorVO> keyEvaluators) {
		this.keyEvaluators = keyEvaluators;
	}
	public void setKeyEvaluatorService(KeyEvaluatorService keyEvaluatorService) {
		this.keyEvaluatorService = keyEvaluatorService;
	}
	public WindowService getWindowService() {
		return windowService;
	}
	public void setWindowService(WindowService windowService) {
		this.windowService = windowService;
	}
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
	
}
