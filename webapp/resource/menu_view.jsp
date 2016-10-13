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
			function del(resourceId,name){
		          jConfirm("即将删除菜单'"+name+"'，同时级联删除菜单下的所有子菜单与操作，数据删除后不可恢复，您确认吗？", "提示框", function(r) {
		          		if(r)
		                 window.location.href="resource!delete.action?menu.menuId="+resourceId;
		          });
			}
		</script>
	</head>

	<body>
		<div class="top_button_div">
			<s:if test="%{menu==null}">
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="ADD" styleCss="common_button2"><input type="button" value="  新增菜单" class="common_button" onclick=location="resource!toInsert.action" /></hgpj:operation>
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="SORT" styleCss="common_button2"><input type="button" value="  排序菜单" class="common_button" onclick=location="resource!toSort.action" /></hgpj:operation>
			</s:if>
			<s:elseif test="%{menu.parentMenuName==null}">
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="ADD" styleCss="common_button2"><input type="button" value="  新增菜单" class="common_button" onclick=location="resource!toInsert.action?menu.menuId=${menu.menuId }&menu.parentMenuName=${menu.menuName }" /></hgpj:operation>
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="SORT" styleCss="common_button2"><input type="button" value="  排序菜单" class="common_button" onclick=location="resource!toSort.action?menu.parentMenu=${menu.menuId }" /></hgpj:operation>
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="MODIFY" styleCss="common_button2"><input type="button" value="  修改菜单" class="common_button" onclick=location="resource!toModify.action?menu.menuId=${menu.menuId }" /></hgpj:operation>
			<hgpj:operation resourceKey="MENU_MANAGER" operKey="DELETE" styleCss="common_button2"><input type="button" value="  删除菜单" class="common_button" onclick="del('<s:property value='menu.menuId'/>','<s:property value='menu.menuName'/>')" /></hgpj:operation>
			</s:elseif>
			<s:else>
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="ADD_OPER" styleCss="common_button2"><input type="button" value="  新增操作" class="common_button" onclick=location="<%=request.getContextPath() %>/operation/operation!toInsert.action?oper.menuId=${menu.menuId }&oper.menuName=${menu.menuName }" /></hgpj:operation>
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="SORT_OPER" styleCss="common_button2"><input type="button" value="  排序操作" class="common_button" onclick=location="<%=request.getContextPath() %>/operation/operation!toSort.action?oper.menuId=${menu.menuId }" /></hgpj:operation>
				<hgpj:operation resourceKey="MENU_MANAGER" operKey="MODIFY" styleCss="common_button2"><input type="button" value="  修改菜单" class="common_button" onclick=location="resource!toModify.action?menu.menuId=${menu.menuId }" /></hgpj:operation>
			<hgpj:operation resourceKey="MENU_MANAGER" operKey="DELETE" styleCss="common_button2"><input type="button" value="  删除菜单" class="common_button" onclick="del('<s:property value='menu.menuId'/>','<s:property value='menu.menuName'/>')" /></hgpj:operation>
			</s:else>
		</div>
		<div class="public_div">
			<h2>
				<span class="fl">菜单资源信息</span>
				<span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tr>
						<td class="td_w_s text_r">菜单级别：</td>
						<td>
							<s:if test="%{menu==null||menu.parentMenuName==null}">
								<input type="text" class="input_s_1" value="一级菜单" disabled="true"/>
							</s:if>
							<s:else>
								<input type="text" class="input_s_1" value="二级菜单" disabled="true"/>
							</s:else>
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">上级菜单：</td>
						<td>
							<input type="text" name="menu.parentMenu" class="input_s_1"
								value="<s:property value='menu.parentMenuName'/>"
								disabled="true" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单名称：</td>
						<td>
							<input type="text" name="menu.menuName" class="input_s_1"
								value="<s:property value='menu.menuName'/>" disabled="true" />
						</td>
					</tr>
					<tr>
						 <td class="td_w_s text_r">菜单KEY：</td>
						<td>
							<input type="text" name="menu.menuKey" class="input_s_1"
								value="<s:property value='menu.menuKey'/>" disabled="true" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单图标地址：</td>
						<td>
							<input type="text" name="menu.imageUrl" class="input_s_1"
								value="<s:property value='menu.imageUrl'/>" disabled="true" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单入口访问地址：</td>
						<td>
							<input type="text" name="menu.menuUrl" class="input_s_1"
								value="<s:property value='menu.menuUrl'/>" disabled="true" />
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="button_div">
		  <input name="back" type="button" class="return_button" onclick="history.go(-1)" />
		</div>
	</body>
</html>
