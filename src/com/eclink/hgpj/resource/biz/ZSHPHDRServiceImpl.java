package com.eclink.hgpj.resource.biz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eclink.hgpj.common.HGPJBizException;
import com.eclink.hgpj.common.HGPJConstant;
import com.eclink.hgpj.organization.dao.OrgDao;
import com.eclink.hgpj.organization.vo.OrgResourceVO;
import com.eclink.hgpj.organization.vo.OrgVO;
import com.eclink.hgpj.resource.dao.MenuDao;
import com.eclink.hgpj.resource.dao.OperationDao;
import com.eclink.hgpj.resource.dao.ZSHPHDRDao;
import com.eclink.hgpj.resource.vo.MenuVO;
import com.eclink.hgpj.resource.vo.OperationVO;
import com.eclink.hgpj.resource.vo.ZSHPBCHVO;
import com.eclink.hgpj.resource.vo.ZSHPHDRVO;
import com.eclink.hgpj.resource.vo.ZSHPITMVO;
import com.eclink.hgpj.role.dao.RoleDao;
import com.eclink.hgpj.role.vo.RoleResourceVO;
import com.eclink.hgpj.role.vo.RoleVO;
import com.eclink.hgpj.util.MenuTreeComparator;
import com.eclink.hgpj.util.OperationComparator;
import com.eclink.hgpj.util.Utils;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZSHPHDRServiceImpl implements ZSHPHDRService {
	
	private ZSHPHDRDao zshphdrDao;


	public ZSHPHDRDao getZshphdrDao() {
		return zshphdrDao;
	}


	public void setZshphdrDao(ZSHPHDRDao zshphdrDao) {
		this.zshphdrDao = zshphdrDao;
	}


	@Override
	public List<ZSHPHDRVO> queryReceipt(String shpno) throws Exception {
		List<ZSHPHDRVO> zshphdrList = zshphdrDao.queryReceipt(shpno);
		List<ZSHPITMVO> list = new ArrayList<ZSHPITMVO>();
		List<ZSHPHDRVO> list2 = new ArrayList<ZSHPHDRVO>();
		ZSHPHDRVO vo = null;
		if(zshphdrList!=null && zshphdrList.size()>0){
			vo = zshphdrList.get(0);
			for(int i =0;i<zshphdrList.size();i++){
				ZSHPHDRVO vot = zshphdrList.get(i);
				List<ZSHPITMVO> subList = vot.getItemsList();
				if(subList!=null && subList.size()>0){
					for(int j =0;j<subList.size();j++){
						list.add(subList.get(j));
					}
				}
				
			}
			vo.setItemsList(list);
			list2.add(vo);
		}
		return list2;
	}


	@Override
	public void updateZshphdr(String shpno) throws Exception {
		this.zshphdrDao.updateZshphdr(shpno);
	}


	@Override
	public void updateZshpitm(String shpno) throws Exception {
		this.zshphdrDao.updateZshpitm(shpno);
	}


	@Override
	public List<ZSHPBCHVO> queryBch(Map map) throws Exception {
		return this.zshphdrDao.queryBch(map);
	}
}
