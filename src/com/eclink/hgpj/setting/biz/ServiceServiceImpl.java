package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.ServiceDao;
import com.eclink.hgpj.setting.vo.ServiceVO;

/**
 * 业务Service实现
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 1997-2013 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 周灵舟
 * @version 1.0
 * @date May 16, 2013 11:02:57 AM
 *
 */
public class ServiceServiceImpl implements ServiceService {
	private ServiceDao serviceDao;
	
	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public void delete(BaseVO vo) throws Exception {
		serviceDao.delete(vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return serviceDao.insert(vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		serviceDao.modify(vo);
	}

	@Override
	public ServiceVO queryById(int id) throws Exception {
		return serviceDao.queryById(id);
	}

	@Override
	public List<ServiceVO> queryList(ServiceVO vo) throws Exception {
		return serviceDao.queryList(vo);
	}

	@Override
	public int queryListCount(ServiceVO vo) throws Exception {
		return serviceDao.queryListCount(vo);
	}

}
