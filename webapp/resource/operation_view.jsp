<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>深圳海关服务评价系统</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<link href="../css/global.css" rel="stylesheet" type="text/css" />
		<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
		<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
		<script src="../js/common.js" type="text/javascript"></script>
		<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function del(menuId,operKey,operName){
		          jConfirm("即将删除资源操作'"+operName+"'，同时级联删除操作下的所有操作地址，数据删除后不可恢复，您确认吗？", "提示框", function(r) {
		          		if(r)
		                 window.location.href="<%=request.getContextPath() %>/operation/operation!delete.action?oper.menuId="+menuId+"&oper.operKey="+operKey+"&oper.operName="+operName;
		          });
			}
		</script>
	</head>

	<body>
		<div class="top_button_div">
			<hgpj:operation resourceKey="MENU_MANAGER" operKey="MODIFY_OPER" styleCss="common_button2"><input name="" value="  修改操作" type="button" class="common_button" onclick='location="<%=request.getContextPath() %>/operation/operation!toModify.action?oper.menuId=${oper.menuId }&oper.operKey=${oper.operKey }"' /></hgpj:operation>
			<hgpj:operation resourceKey="MENU_MANAGER" operKey="DELETE_OPER" styleCss="common_button2"><input name="" value="  删除操作" type="button" class="common_button" onclick="del('${oper.menuId }','${oper.operKey }','${oper.operName }')" /></hgpj:operation>
		</div>
		<div class="public_div">
			<h2>
				<span class="fl">操作信息</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tr>
						<td class="td_w_s text_r">所属菜单：</td>
						<td>
							<input type="text" name="oper.menuName" class="input_s_1"
								value="<s:property value='oper.menuName'/>" disabled="true" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">操作名称：</td>
						<td>
							<input type="text" name="oper.operName" class="input_s_1"
								value="<s:property value='oper.operName'/>" disabled="true" />
						</td>
					</tr>
					<tr>
						 <td class="td_w_s text_r">操作KEY：</td>
						<td>
							<input type="text" name="oper.operKey" class="input_s_1"
								value="<s:property value='oper.operKey'/>" disabled="true" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">依赖操作KEY：</td>
						<td>
							<input type="text" name="oper.preKey" class="input_s_1"
								value="<s:property value='oper.preKey'/>"
								disabled="true" />
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="data_list">
			<h2>
				<span class="fl">操作地址列表</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
				  <tr>
					<th>序号</th>
					<th>地址名称</th>
					<th>地址URL</th>
			      </tr>
			      <s:iterator value="oper.addressList" status="st">
			       <s:if test="#st.Even">
			      		<tr class="td_bgcolor">
			      	</s:if>
			      	<s:else>
			      		<tr>
			      	</s:else>
						<td>${st.index+1 }</td>
						<td><s:property value="addressName"/></td>
					    <td><s:property value="addressUrl"/></td>
				      </tr>
			      </s:iterator>
			  </table>	
			</div>
		</div>
		
		<div class="button_div">
		  <input name="back" type="button" class="return_button" onclick="history.go(-1)" />
		</div>
	</body>
</html>
