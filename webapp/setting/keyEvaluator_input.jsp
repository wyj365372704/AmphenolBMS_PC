<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增按键式评价器设置</title>
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
		var seleVal = "${keyEvaluator.orgId}";
		$("[name='keyEvaluator.orgId']").empty();
		$("[name='keyEvaluator.orgId']").append("<option value=''>--请选择--</option>");  
		$("[name='keyEvaluator.windowId']").empty();
		$("[name='keyEvaluator.windowId']").append("<option value=''>--请选择--</option>"); 
		$.ajax({
        	type: "POST",
        	url: "<s:url value="/org/org!getChildOrg.action"/>",
        	data: {"org.orgId":$("[name='keyEvaluator.customsId']").val()},
        	success:function(data){
        		if(data!=""&&data!=null){
	        		var dataObj = eval("("+data+")");
	        		$.each(dataObj.data,function(idx,item){
	        			var value = item.value;
	                    var label = item.label;
	                    if(seleVal==value){
	    					$("[name='keyEvaluator.orgId']").append("<option value='"+value+"' selected>"+label+"</option>");
	    					getChildWindow();
	    				}else{
	    					$("[name='keyEvaluator.orgId']").append("<option value='"+value+"'>"+label+"</option>");
	    				}
	        		});
        		}
        	},
        	cache: false
        });
	}
	function getChildWindow(){
		var seleVal = "${keyEvaluator.windowId}";
		$("[name='keyEvaluator.windowId']").empty();
		$("[name='keyEvaluator.windowId']").append("<option value=''>--请选择--</option>");
		var orgId = $("[name='keyEvaluator.orgId']").val();
		if(orgId != ''){  
			$.ajax({
	        	type: "POST",
	        	url: "<s:url value="/setting/window!getChildWindow.action"/>",
	        	data: {"window.orgId": orgId},
	        	success:function(data){
	        		if(data!=""&&data!=null){
		        		var dataObj = eval("("+data+")");
		        		$.each(dataObj.data,function(idx,item){
		        			var value = item.value;
		                    var label = item.label;
		                    if(seleVal==value){
		    					$("[name='keyEvaluator.windowId']").append("<option value='"+value+"' selected>"+label+"</option>");
		    				}else{
		    					$("[name='keyEvaluator.windowId']").append("<option value='"+value+"'>"+label+"</option>");
		    				}
		        		});
	        		}
	        	},
	        	cache: false
	        });
        }
	}
	
	$(document).ready(function(){
		getChildOrg();
	});
	</script>
</head>

<body class="right_body">
<s:form action="keyEvaluator!insert.action" method="post" name="myform">
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 按键式评价器设置&gt; 新增按键式评价器设置</div>
	<div class="public_div">
		<h2>
			<span class="fl">按键式评价器设置</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		  	  <tr>
				<td width="13%" class="td_w_s text_r">所属关区：</td>
				<td width="37%">
					<s:if test="#session.loginInfo.user.customsId==1">
						<s:select reg=".+" tip="请选择所属关区" id="customsId" name="keyEvaluator.customsId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_1" onchange="getChildOrg()"></s:select>
					</s:if>
					<s:else>
						<s:select reg=".+" tip="请选择所属关区" id="customsId" name="keyEvaluator.customsId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" cssClass="select_s_1" disabled="true"></s:select>
					</s:else>
					<span class="red">*</span>
                </td>
                <td width="13%" class="td_w_s text_r">所属科室：</td>
				<td width="37%">
					<s:select reg=".+" tip="请选择所属科室" name="keyEvaluator.orgId" cssClass="select_s_1" list="#{}" listKey="orgId" listValue="orgName" headerKey="" headerValue="--请选择--" onchange="getChildWindow()"></s:select><span class="red">*</span>
			    </td>
		  	  </tr>
		  	  <tr>
				<td width="13%" class="td_w_s text_r">所属窗口：</td>
				<td width="37%">
					<s:select cssClass="select_s_1" name="keyEvaluator.windowId" reg=".+" tip="请选择所属窗口" list="#{}" listKey="id" listValue="name" headerKey="" headerValue="--请选择--"></s:select><span class="red">*</span>
                </td>
                <td width="13%" class="td_w_s text_r">评价器编号：</td>
				<td width="37%">
					<s:textfield id="keyNo" name="keyEvaluator.keyNo" maxlength="20" reg=".+" tip="评价器编号不能为空" cssClass="input_s_1"></s:textfield><span class="red">*</span>
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