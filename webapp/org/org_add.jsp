<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function(){
			<s:if test='org.orgType=="Z"'>
				$("#adminInfo").attr("style","display:block;");
			</s:if>
			$("[name='org.orgType']").bind('change',function(){
				if($(this).val() == 'F'){
					$("#adminInfo").show();
				}else{
					$("#adminInfo").hide();
				}
			});
		});
		
		var isExtendsValidate = true;	
		function extendsValidate(){	
			var extendSubmit=true;
			if($("[name='org.orgType']").val()=='F'){
				if($.trim($("[name='user.userName']").val())=="") {
					errorMessge=errorMessge+menu+".用户名不能为空"+'\n';
					menu++;
					extendSubmit = false;
				}
				if($.trim($("[name='user.realName']").val())=="") {
					errorMessge=errorMessge+menu+".真空姓名不能为空"+'\n';
					menu++;
					extendSubmit = false;
				}
				if($.trim($("[name='user.employeeNumber']").val())=="") {
					errorMessge=errorMessge+menu+".工号不能为空"+'\n';
					menu++;
					extendSubmit = false;
				}
				if($.trim($("[name='user.position']").val())=="") {
					errorMessge=errorMessge+menu+".职务不能为空"+'\n';
					menu++;
					extendSubmit = false;
				}
			}
			if($("[name='org.orgDesc']").val().length > 100) {
				errorMessge=errorMessge+menu+".机构描述不能超过100个字符"+'\n';
				menu++;
				extendSubmit = false;
			}
			if($("[name='orgRes']:checked").length < 1){
				errorMessge=errorMessge+menu+".请为机构授权，至少选择一项功能权限"+'\n';
				menu++;
				extendSubmit = false;
			}			
			return extendSubmit;
		}
	</script>
	
</head>

<body>
		
<s:form action="org!insert.action" method="post" name="myform">	
<div class="public_div">
	<h2>
		<span class="fl">机构基本信息</span>
		<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
	</h2>
	
	<div class="public_inner">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		  <tr>
			<td width="13%" class="text_r">机构名称：</td>
			<td width="37%"><input type="text" name="org.orgName" class="input_s_1" maxlength="50" reg="^\S" tip="机构名称不能为空"/><span class="red">*</span></td>
			<td width="13%" class="text_r">上级机构：</td>
			<td width="37%">
				<input type="text" name="org.parentOrgName" class="input_s_1" value="${org.orgName}" disabled="disabled"/>
				<input type="hidden" name="org.parentOrg" class="input_s_1" value="${org.orgId}" />
			</td>
		  </tr>
		  <tr>
			<td class="text_r">机构类型：</td>
			<td>
				<s:if test='org.orgType=="Z"'>
					<select name="org.orgType" class="select_s_1">
						<option value="F">分关</option>
						<option value="K">科室</option>
					</select>
				</s:if>
				<s:else>
					<select name="org.orgType" class="select_s_1">
						<option value="K">科室</option>
					</select>
				</s:else>
			<span class="red">*</span></td>
			<td class="text_r">&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td class="text_r v_t">机构描述：</td>
			<td colspan="3">
				<label>
			  		<textarea name="org.orgDesc" class="textarea_s_1"></textarea>
				</label>
			</td>
		  </tr>
	  </table>
  </div>
</div>

<div class="public_div" id="adminInfo" style="display:none;">
	<h2>
		<span class="fl">分关管理员</span>
		<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
	</h2>
	
  <div class="public_inner">
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		<tr>
		  <td width="13%" class="td_w_s text_r">用户名：</td>
		  <td width="37%"><input type="text" name="user.userName" class="input_s_1" maxlength="30"/><span class="red">*</span></td>
		  <td width="13%" class="td_w_s text_r">真实姓名：</td>
		  <td width="37%"><input type="text" name="user.realName" class="input_s_1" maxlength="20"/><span class="red">*</span></td>
		</tr>
		<tr>
		  <td class="td_w_s text_r">工号：</td>
		  <td><input type="text" name="user.employeeNumber" class="input_s_1" maxlength="10"/><span class="red">*</span></td>
		  <td class="td_w_s text_r">职务：</td>
		  <td><input type="text" name="user.position" class="input_s_1" maxlength="30"/><span class="red">*</span></td>
		</tr>
		<tr>
		  <td class="td_w_s text_r">邮箱地址：</td>
		  <td><input type="text" name="user.email" class="input_s_1" maxlength="25"/></td>
		  <td class="td_w_s text_r">性别：</td>
		  <td><s:radio name="user.sex" list="user.sexList" listKey="key" listValue="value" value="'U'" label="性别"></s:radio></td>
		</tr>
		<tr>
		  <td class="td_w_s text_r">办公电话：</td>
		  <td><input type="text" name="user.telephone" maxlength="15" class="input_s_1" /></td>
		  <td class="td_w_s text_r">手机号码：</td>
		  <td><input type="text" name="user.mobile" maxlength="15" class="input_s_1" /></td>
		</tr>
	</table>
  </div>
</div>

<div class="public_div">
     <s:include value="../commons/permission.jsp"></s:include>
</div>

<div class="button_div">
	<s:submit value="" cssClass="save_button"></s:submit><s:reset value="" cssClass="purge_button2"></s:reset><input name="back" type="button" class="return_button" onclick="history.go(-1)" />
</div>
</s:form>
</body>
</html>