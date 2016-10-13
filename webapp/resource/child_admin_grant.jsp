<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
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
<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
var type=0;
var isExtendsValidate = true;	
function extendsValidate(){	
   var extendSubmit=true;
		
	if($("[name='orgRes']:checked").length < 1){
		errorMessge=errorMessge+menu+".请选择资源权限"+'\n';
		extendSubmit = false;
	}
	return extendSubmit;
	
}

function changeOperate(value){
	type=value;
	var obj = document.getElementsByTagName("input");
	for(var i=0;i<obj.length;i++){
		if(obj[i].type=="checkbox"){
			obj[i].checked=false;
		}
	}
}
</script>
</head>

<body class="right_body">

<s:form action="grant!childAdminGrant.action" method="post" name="myform">

	<div class="path">您现在的位置： 首页 &gt; 模块管理 &gt; 分关管理员授权</div>
		
	<div class="public_div">
		<h2>
			<span class="fl">操作信息</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="public_table">
		  <tr>
			<td class="td_w_s text_r">关区：</td>
			<td>
				<s:select cssClass="select_s_1" name="orgId" list="customsOrg" 
				listKey="orgId" listValue="orgName"  headerKey="-1" headerValue="所有关区" ></s:select>
		    	<span class="red">*</span>
		    </td>
			<td class="td_w_s text_r"><span class="text_r">操作：</span></td>
			<td>
				<select name="operate" class="select_s_1"  reg="[^0]" tip="请选择操作"  onchange="changeOperate(this.value)">
                       		<option value="">---请选择---</option>
                       		<option value="1">添加权限</option>
                       		<option value="2">移除权限</option>
                     	</select>
		    	<span class="red">*</span>
		    </td>
		  </tr>
		</table>
	    </div>
	</div>
	
<div class="public_div" id="include">
	<div id="permission">
		<s:include value="../commons/permission_batch.jsp"></s:include>
	</div>
</div>
			
			
<div class="button_div">
	<s:submit value="" cssClass="save_button"></s:submit>
</div>


</s:form>
</body>
</html>