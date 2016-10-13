<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>深圳海关服务评价系统</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<link href="../css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
		<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
		<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
		<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
		<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
		<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<s:form action="resource!modify.action" method="post">
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
							<input type="text" name="menu.parentMenuName" class="input_s_1"
								value="<s:property value='menu.parentMenuName'/>" disabled="true" />
							<input type="hidden" name="menu.menuOrder" value="<s:property value='menu.menuOrder'/>" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单名称：</td>
						<td>
							<input type="text" name="menu.menuName" class="input_s_1" value="<s:property value='menu.menuName'/>" maxlength="10" reg="^\S+$" tip="菜单名称为必填项"/>
							<span class="red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单KEY：</td>
						<td>
							<input type="text" name="menu.menuKey" class="input_s_1" value="<s:property value='menu.menuKey'/>" maxlength="80" reg="^[A-Z]+[A-Z_]*$" tip="菜单KEY为必填项，只能包含大写英文字母与下划线，且只能以大写英文字母开头"/>
							<input type="hidden" name="menu.oldMenuKey" value="<s:property value='menu.menuKey'/>" />
							<input type="hidden" name="menu.menuId" value="<s:property value='menu.menuId'/>" />
							<span class="red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单图标地址：</td>
						<td>
							<input type="text" name="menu.imageUrl" class="input_s_1" value="<s:property value='menu.imageUrl'/>" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">菜单入口访问地址：</td>
						<td>
							<s:if test="%{menu.parentMenuName==null}">
								<input type="text" name="menu.menuUrl" class="input_s_1" value="<s:property value='menu.menuUrl'/>" />
							</s:if>
							<s:else>
								<input type="text" name="menu.menuUrl" class="input_s_1" value="<s:property value='menu.menuUrl'/>" maxlength="128" reg="^\S+$" tip="菜单入口访问地址为必填项"/>
								<span class="red">*</span>
							</s:else>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="button_div">
		  <s:submit value="" cssClass="save_button"></s:submit><s:reset value="" cssClass="purge_button2"></s:reset><input name="back" type="button" class="return_button" onclick="history.go(-1)" />
		</div>
	</s:form>
	</body>
</html>
