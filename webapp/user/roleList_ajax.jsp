<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="data_list">
	<h2>
		<span class="fl">用户角色</span>
		<span class="fr"></span>
	</h2>
	
	<div class="list_inner" id="roleInner">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
		  <tr>
		    <th><input name="Input2" type="checkbox" value="" onclick="checkAll(this)"/></th>
			<th>角色名称</th>
		  </tr>
		  <s:iterator value="roleList">
			<tr>
				<td><input name="roleIds" type="checkbox" value="<s:property value='roleId'/>" /></td>
				<td><s:property value="roleName"/></td>
			</tr>
		 </s:iterator>
		</table>
	</div>
</div>