package com.eclink.hgpj.resource.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.eclink.hgpj.base.BaseVO;
import com.eclink.hgpj.resource.vo.AddressVO;
import com.eclink.hgpj.resource.dao.AddressDao;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * AddressDaoImpl.java
 *
 * @Title:
 * @Description: 
 * @Copyright: Copyright (c) 2011-2012 ECLink, Inc.
 * @Company: 易网通公司 
 * @author 张万根
 * @version 1.0
 * @date Mar 8, 2012 4:47:43 PM
 *
 */
public class AddressDaoImpl extends SqlMapClientDaoSupport implements
		AddressDao {
	
	/**
     * 删除操作地址
     * @param vo 操作地址对象
     * @return 
     */
	public void delete(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().delete("Address.deleteAddressByResourceIdAndOperKey", vo);
	}

	/**
     * 插入操作地址
     * @param vo 操作地址对象
     * @return 
     */
	public int insert(BaseVO vo) throws Exception {
		this.getSqlMapClientTemplate().insert("Address.insertOperationAddress", vo);
		return 0;
	}

	/**
     * 修改操作地址
     * @param vo 操作地址对象
     * @return 
     */
	public void modify(BaseVO vo) throws Exception {
		
	}

	/**
     * 查询操作地址列表(通过资源ID与操作KEY)
     * @param resourceId 资源ID
     * @param operationKey 操作key
     * @return 操作地址VO列表
     */
	public List<AddressVO> listOperationAddress(Integer resourceId,
			String operationKey) {
		AddressVO tmpAddress = new AddressVO();
        tmpAddress.setMenuId(resourceId);
        tmpAddress.setOperKey(operationKey);
        List<AddressVO> list = getSqlMapClientTemplate().queryForList(
                "Address.listOperationAddress", tmpAddress);
        return list;
	}

	/**
     * 批量插入操作地址
     * @param addresses 操作地址列表
     * @throws Exception
     */
	public void batchInsertAddress(final List<AddressVO> addresses) throws Exception {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				if (addresses != null && addresses.size() > 0) {
					for (AddressVO address : addresses) {
						executor.insert("Address.insertOperationAddress", address);
					}
				}
				executor.executeBatch();
				return null;
			}
		});
	}
}
