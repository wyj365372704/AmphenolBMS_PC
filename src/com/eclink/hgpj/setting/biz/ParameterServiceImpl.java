package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.ParameterDao;
import com.eclink.hgpj.setting.vo.ParameterVO;

/**
 * 参数Service实现
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
public class ParameterServiceImpl implements ParameterService {
	private ParameterDao parameterDao;
	
	public void setParameterDao(ParameterDao parameterDao) {
		this.parameterDao = parameterDao;
	}

	@Override
	public void delete(BaseVO vo) throws Exception {
		parameterDao.delete(vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return parameterDao.insert(vo);
	}

	@Override
	public void insertList(List<ParameterVO> vos) throws Exception {
		if(vos != null && vos.size() > 0){
			for (ParameterVO vo : vos) {
				if(vo.getId() == null){
					// 新增
					parameterDao.insert(vo);
				}else{
					// 修改
					parameterDao.modify(vo);
				}
			}
		}
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		parameterDao.modify(vo);
	}

	@Override
	public ParameterVO queryById(int id) throws Exception {
		return parameterDao.queryById(id);
	}

	@Override
	public ParameterVO queryByName(String name) throws Exception {
		return parameterDao.queryByName(name);
	}

	@Override
	public List<ParameterVO> queryList(ParameterVO vo) throws Exception {
		return parameterDao.queryList(vo);
	}

	@Override
	public int queryListCount(ParameterVO vo) throws Exception {
		return parameterDao.queryListCount(vo);
	}

}
