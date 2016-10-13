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
		var isExtendsValidate = true;	
		function extendsValidate(){	
			var extendSubmit=true;
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

<s:form action="org!modify.action" method="post" name="myform">	
<div class="public_div">
	<h2>
		<span class="fl">机构基本信息</span>
		<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
	</h2>
	
	<div class="public_inner">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		  <tr>
			<td width="13%" class="text_r">机构名称：</td>
			<td width="37%">
				<input type="text" name="org.orgName" class="input_s_1" value="${org.orgName}" maxlength="50" reg="^\S" tip="机构名称不能为空"/><span class="red">*</span>
				<input type="hidden" name="org.oldOrgName" value="${org.orgName}" />
			</td>
			<td width="13%" class="text_r">上级机构：</td>
			<td width="37%">
				<input type="text" name="org.parentOrgName" class="input_s_1" value="${org.parentOrgName}" disabled="disabled"/>
				<input type="hidden" name="org.parentOrg" class="input_s_1" value="${org.parentOrg}" />
				<input type="hidden" name="org.orgId" class="input_s_1" value="${org.orgId}" />
			</td>
		  </tr>
		  <tr>
			<td class="text_r">机构类型：</td>
			<td>
				<s:select list="org.orgTypeList" listKey="key" listValue="value" value="%{org.orgType}" cssClass="select_s_1" disabled="true"></s:select><span class="red">*</span>
				<s:hidden name="org.orgType"></s:hidden>
			</td>
			<td class="text_r">&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td class="text_r v_t">机构描述：</td>
			<td colspan="3">
				<label>
			  		<textarea name="org.orgDesc" class="textarea_s_1">${org.orgDesc}</textarea>
				</label>
			</td>
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