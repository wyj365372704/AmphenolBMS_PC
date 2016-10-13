<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增触摸式评价器设置</title>
	<link href="../css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script src="../js/validator/easy_validator.pack.js" type="text/javascript"></script>    
	<script src="../js/validator/jquery.bgiframe.min.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
	<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<link href="../css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	function checkSubmit(){
		var touchNo = $('#touchNo').val();
		if(touchNo == ''){
		   jAlert('warning', '评价器IP不能为空！', '提示');
		   return false;
		}
		document.forms['myform'].submit();
	}

	</script>
</head>

<body class="right_body">
<s:form action="touchEvaluator!insert.action" method="post" name="myform" >
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 按键式评价器设置&gt; 新增触摸式评价器设置</div>
	<div class="public_div">
		<h2>
			<span class="fl">触摸式评价器设置</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		  	  <tr>
				<td width="13%" class="td_w_s text_r">所属关区：</td>
				<td width="37%">
					<s:if test="#session.loginInfo.user.customsId==1">
						<s:select id="orgId" reg=".+" tip="请选择所属关区" name="touchEvaluator.orgId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_1"></s:select>
					</s:if>
					<s:else>
						<s:select id="orgId" reg=".+" tip="请选择所属关区" name="touchEvaluator.orgId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_1" disabled="true"></s:select>
						<s:hidden name="touchEvaluator.orgId"></s:hidden>
					</s:else>
					<span class="red">*</span>
                </td>
                <td width="13%" class="td_w_s text_r">评价器IP：</td>
				<td width="37%">
					<s:textfield id="touchNo" reg=".+" tip="请填写评价器IP" name="touchEvaluator.touchNo" maxlength="20" cssClass="input_s_1"></s:textfield><span class="red">*</span>
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