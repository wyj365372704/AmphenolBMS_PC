package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.CustomsServiceDao;
import com.eclink.hgpj.setting.vo.CustomsServiceVO;

/**
 * 业务设置Service实现
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
public class CustomsServiceServiceImpl implements CustomsServiceService {
	private CustomsServiceDao customsServiceDao;

	public void setCustomsServiceDao(CustomsServiceDao customsServiceDao) {
		this.customsServiceDao = customsServiceDao;
	}

	@Override
	public void deleteServiceByOrgId(int orgId) throws Exception {
		customsServiceDao.deleteServiceByOrgId(orgId);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		CustomsServiceVO customsServiceVO = (CustomsServiceVO)vo;
		Integer[] serviceIds = customsServiceVO.getServiceIds();
		if(serviceIds != null && serviceIds.length > 0){
			for (Integer sid : serviceIds) {
				CustomsServiceVO csVo = new CustomsServiceVO();
				csVo.setOrgId(customsServiceVO.getOrgId());
				csVo.setServiceId(sid);
				customsServiceDao.insert(csVo);
			}
		}
		return 0;
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		CustomsServiceVO customsServiceVO = (CustomsServiceVO)vo;
		// 先根据关区删除其关联的所有业务
		customsServiceDao.deleteServiceByOrgId(customsServiceVO.getOrgId());
		// 新增
		insert(vo);
	}

	@Override
	public List<CustomsServiceVO> queryList(CustomsServiceVO vo) throws Exception {
		return customsServiceDao.queryList(vo);
	}

	@Override
	public CustomsServiceVO queryEvaluationByOrgIdAndServiceId(CustomsServiceVO vo) throws Exception {
		return customsServiceDao.queryEvaluationByOrgIdAndServiceId(vo);
	}

	@Override
	public List<CustomsServiceVO> queryEvaluationList(Integer orgId) throws Exception {
		return customsServiceDao.queryEvaluationList(orgId);
	}

	@Override
	public int queryListCount(CustomsServiceVO vo) throws Exception {
		return customsServiceDao.queryListCount(vo);
	}

	@Override
	public List<CustomsServiceVO> queryByOrgId(int id) throws Exception {
		return customsServiceDao.queryByOrgId(id);
	}

}
