<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增窗口设置</title>
	<link href="../css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script src="../js/validator/easy_validator.pack.js" type="text/javascript"></script>    
	<script src="../js/validator/jquery.bgiframe.min.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
	<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<link href="../css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	function getChildOrg(){
		var seleVal = "${window.orgId}";
		$("[name='window.orgId']").empty();
		$("[name='window.orgId']").append("<option value=''>--请选择--</option>");  
		$.ajax({
        	type: "POST",
        	url: "<s:url value="/org/org!getChildOrg.action"/>",
        	data: {"org.orgId":$("[name='window.parentOrg']").val()},
        	success:function(data){
        		if(data!=""&&data!=null){
	        		var dataObj = eval("("+data+")");
	        		$.each(dataObj.data,function(idx,item){
	        			var value = item.value;
	                    var label = item.label;
	                    if(seleVal==value){
	    					$("[name='window.orgId']").append("<option value='"+value+"' selected>"+label+"</option>");
	    				}else{
	    					$("[name='window.orgId']").append("<option value='"+value+"'>"+label+"</option>");
	    				}
	        		});
        		}
        	},
        	cache: false
        });
	}
	
	$(document).ready(function(){
		getChildOrg();
	});
	</script>
</head>

<body class="right_body">
<s:form action="window!insert.action" method="post" name="myform">
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 窗口设置&gt; 新增窗口设置</div>
	<div class="public_div">
		<h2>
			<span class="fl">窗口设置</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
			  <tr>
				<td class="text_r">所属关区：</td>
				<td>
					<s:if test="#session.loginInfo.user.customsId==1">
						<s:select reg=".+" tip="请选择所属关区" id="parentOrg" name="window.parentOrg" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_1" onchange="getChildOrg()"></s:select>
					</s:if>
					<s:else>
						<s:select reg=".+" tip="请选择所属关区" id="parentOrg" name="window.parentOrg" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_1" disabled="true"></s:select>
					</s:else>
					<span class="red">*</span>
				</td>
				<td class="text_r">所属科室：</td>
				<td>
					<s:select reg=".+" tip="请选择所属科室" name="window.orgId" cssClass="select_s_1" list="#{}" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--"></s:select><span class="red">*</span>
				</td>
			  </tr>
		  	  <tr>
				<td width="13%" class="td_w_s text_r">窗口名称：</td>
				<td width="37%">
					<s:textfield name="window.name" maxlength="50" reg=".+" tip="窗口名称不能为空" cssClass="input_s_1"></s:textfield><span class="red">*</span>
                </td>
				<td width="13%" class="td_w_s text_r">窗口状态：</td>
				<td width="37%">
					<s:select name="window.status" cssClass="select_s_1" list="#{1:'启用', 0:'禁用'}" listKey="key" listValue="value"></s:select>
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