package com.eclink.hgpj.resource.biz;

import java.util.List;

import com.eclink.hgpj.resource.dao.ZBMSU01Dao;
import com.eclink.hgpj.resource.vo.ZBMSU01VO;

/**
 * MenuServiceImpl.java
 *
 * @Title: 菜单资源业务实现类
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZBMSU01ServiceImpl implements ZBMSU01Service {

	
	private ZBMSU01Dao zbmsu01Dao;

	public ZBMSU01Dao getZbmsu01Dao() {
		return zbmsu01Dao;
	}

	public void setZbmsu01Dao(ZBMSU01Dao zbmsu01Dao) {
		this.zbmsu01Dao = zbmsu01Dao;
	}

	@Override
	public List<ZBMSU01VO> queryZbmsu(ZBMSU01VO vo) throws Exception {
		return zbmsu01Dao.queryZbmsu(vo);
	}

}
