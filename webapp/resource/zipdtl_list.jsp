<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="<%=request.getContextPath() %>/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/js/alert/alerts.css" rel="stylesheet" type="text/css" />

			<table width="100%"  border="0" cellspacing="1" cellpadding="0" class="list_table_s" >
			  <tr>
				<th>单号</th>
				<th>工单</th>
				<th>行号</th>
				<th>物料</th>
				<th>描述</th>
				<th>数量</th>
				<th>单位</th>
				<th>默认仓库</th>
				<th>默认子库</th>
				<th>默认库位</th>
				<th>打印状态</th>
				<th>实发</th>
				<th>状态</th>
				<th>操作</th> 
				<!-- -->
			  </tr>
			<s:iterator value="dresults" id="dresults" status="dst">
  				 <s:if test="#st.Even">
		      		<tr class="td_bgcolor" >
		      	</s:if>
		      	<s:else>
		      		<tr class="td_bgcolor2" >
		      	</s:else>
	  				<td><s:property value="ipdno"/></td>
	  				<td><s:property value="ordno"/></td>
	  				<td><s:property value="ipdln"/></td>
	  				<td><s:property value="citem"/></td>
	  				<td></td>
	  				<td><s:property value="shqty"/></td>
	  				<td><s:property value="cuom"/></td>
	  				<td><s:property value="house"/></td>
	  				<td><s:property value="whsub"/></td>
	  				<td><s:property value="llocn"/></td>
	  				<td>
	  				<s:if test="lprt==1">
	  					是
	  				</s:if>
	  				<s:else>
	  					否
	  				</s:else>
	  				</td>
	  				<td><s:property value="acqty"/></td>
	  				<td>
	  				<s:if test="lstat==05">
	  					创建中
	  				</s:if>
	  				<s:if test="lstat==10">
	  					已创建
	  				</s:if>
	  				<s:if test="lstat==50">
	  					已完成
	  				</s:if>
	  				<s:if test="lstat==60">
	  					已关闭
	  				</s:if>
	  				</td>
	  				<td>
	  				<s:if test="lstat==05">
	  					<input type="button" id="editbtn" value="编辑" class="gray_button" onclick="goedit('<s:property value="ipdno"/>','<s:property value="ipdln"/>');"/>
	  					<input type="button" id="deletebtn" value="删除" class="gray_button" onclick="godelete('<s:property value="ipdno"/>','<s:property value="ipdln"/>');"/>
	  				
	  				</s:if>
	  				
	  				
	  				</td>
</tr>
  			</s:iterator>
		  </table>