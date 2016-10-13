package com.eclink.hgpj.resource.biz;

import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZJOBEMPVO;
import com.eclink.hgpj.resource.vo.ZJOBMCHVO;
import com.eclink.hgpj.resource.vo.ZMCHMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;

/**
 * MenuService.java
 *
 * @Title: 菜单业务接口
 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:12:44 PM
 *
 */
public interface ZMOJOBService {
	public List<ZMOJOBVO> queryZmojobByMap(Map map) throws Exception;

	public void addNewJob(ZMOJOBVO vo,List<ZJOBEMPVO> zjobempList ,List<ZJOBMCHVO> zjobmchList) throws Exception;

	public String queryMaxIndex(String string) throws Exception;

	public void finishZmojob(ZMOJOBVO zmojobvo,String step_quantity,String artificial_hours_after,String machine_hours_after,String abnormal_hours,String abnormal_reason)throws Exception;
}
