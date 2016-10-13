<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增业务设置</title>
	<link href="../css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script src="../js/validator/easy_validator.pack.js" type="text/javascript"></script>    
	<script src="../js/validator/jquery.bgiframe.min.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
	<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<link href="../css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	var isExtendsValidate = true;	//必须这么写
	function extendsValidate(){	//必须这么写
	   var extendSubmit=true;
		if( $(':checkbox[name="customsService.serviceIds"]:checked').length == 0 ){
			//增加提示信息 menu为提示序列号
			errorMessge=errorMessge+menu+".请至少选择一项业务"+'\n';
			menu++;
			extendSubmit = false;
		}
		return extendSubmit;
		
	}
	</script>
</head>

<body class="right_body">
<s:form action="customsService!insert.action" method="post" name="myform">
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 业务设置&gt; 新增业务设置</div>
	<div class="public_div">
		<h2>
			<span class="fl">业务设置</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		  	  <tr>
				<td class="td_w_s text_r">所属关区：</td>
				<td>
					<s:if test="#session.loginInfo.user.customsId==1">
						&nbsp;<s:select reg=".+" tip="请选择所属关区" id="orgId" name="customsService.orgId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_2"></s:select>
					</s:if>
					<s:else>
						&nbsp;<s:select reg=".+" tip="请选择所属关区" id="orgId" name="customsService.orgId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_2" disabled="true"></s:select>
						<s:hidden name="customsService.orgId"></s:hidden>
					</s:else>
					<span class="red">*</span>
			    </td>
		  	  </tr>
		  	  <tr>
		  	  	<td class="td_w_s text_r">业务列表：</td>
				<td>
					<s:checkboxlist name="customsService.serviceIds" list="#request.services" listKey="id" listValue="name"></s:checkboxlist>
                </td>
		  	  </tr>
		  </table>
	  </div>
	</div>
	
	<div class="button_div">
		<s:submit value="" cssClass="save_button"></s:submit>
		<input name="" type="button" class="purge_button2" onclick="this.form.reset();" />
		<input name="" type="button" class="return_button" onclick="history.go(-1);" />
	</div>
</s:form>
</body>
</html>