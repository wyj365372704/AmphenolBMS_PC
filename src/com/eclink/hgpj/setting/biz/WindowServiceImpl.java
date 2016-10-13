package com.eclink.hgpj.setting.biz;

import java.util.List;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.setting.dao.WindowDao;
import com.eclink.hgpj.setting.vo.WindowVO;

/**
 * 窗口Service实现
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
public class WindowServiceImpl implements WindowService {
	private WindowDao windowDao;
	
	public void setWindowDao(WindowDao windowDao) {
		this.windowDao = windowDao;
	}

	@Override
	public void delete(BaseVO vo) throws Exception {
		windowDao.delete(vo);
	}

	@Override
	public int insert(BaseVO vo) throws Exception {
		return windowDao.insert(vo);
	}

	@Override
	public void modify(BaseVO vo) throws Exception {
		windowDao.modify(vo);
	}

	@Override
	public WindowVO queryById(int id) throws Exception {
		return windowDao.queryById(id);
	}

	@Override
	public List<WindowVO> queryList(WindowVO vo) throws Exception {
		return windowDao.queryList(vo);
	}

	@Override
	public int queryListCount(WindowVO vo) throws Exception {
		return windowDao.queryListCount(vo);
	}

}
