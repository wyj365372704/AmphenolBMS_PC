package com.eclink.hgpj.resource.biz;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eclink.hgpj.resource.dao.ZDELIDADao;
import com.eclink.hgpj.resource.dao.ZDEPTDao;
import com.eclink.hgpj.resource.dao.ZEMPMSTDao;
import com.eclink.hgpj.resource.dao.ZMOJOBDao;
import com.eclink.hgpj.resource.dao.ZWHSUBDao;
import com.eclink.hgpj.resource.vo.ZDELIDAVO;
import com.eclink.hgpj.resource.vo.ZDEPTVO;
import com.eclink.hgpj.resource.vo.ZEMPMSTVO;
import com.eclink.hgpj.resource.vo.ZMOJOBVO;
import com.eclink.hgpj.resource.vo.ZWHSUBVO;
import com.eclink.hgpj.util.Utils;

/**

 * @Description: 

 * @version 1.0
 * @date May 21, 2013 5:18:27 PM
 *
 */
public class ZDELIDAServiceImpl implements ZDELIDAService {

	private ZDELIDADao zdelidaDao;

	
	
	public ZDELIDADao getZdelidaDao() {
		return zdelidaDao;
	}



	public void setZdelidaDao(ZDELIDADao zdelidaDao) {
		this.zdelidaDao = zdelidaDao;
	}



	@Override
	public List<ZDELIDAVO> queryZdelida(Map map) throws Exception {
		return zdelidaDao.queryZdelida(map);
	}



	@Override
	public String auditZdelida(Map map) throws Exception {
		String result = "fail";
		
		ZDELIDAVO vo = new ZDELIDAVO();
		vo.setOrdrji((String) map.get("ordrji"));
		vo.setPisqji(new BigDecimal((String)map.get("pisqji")));
		vo.setBksqji(new BigDecimal((String)map.get("bksqji")));
		vo.setStaus(new BigDecimal((String)map.get("staus")));
		
		zdelidaDao.updateStaus(vo);
		System.out.println("wyj22");
		if(map.get("staus").equals("40")){
			String xaret0 = Utils.systemLinkPOItemVATxn(map);
			String retVal = (String)map.get("systemLinkStr");

			System.out.println("xaret0:"+xaret0);
			System.out.println("um:"+retVal);
			String errorStr1 = retVal.substring(retVal.indexOf("hasErrors"), retVal.indexOf("hasErrors")+17);
			String warnStr2 = retVal.substring(retVal.indexOf("hasWarnings"), retVal.indexOf("hasWarnings")+19);
			if(errorStr1.indexOf("true")>=0){
				throw new RuntimeException();
			}else{
				result = "success";
			}
		}else{
			result = "success";
		}
		System.out.println("wyj33");
		return result;
	}

}
