<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>生产入库限制</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />

</head>
<script type="text/javascript">
	function toModify() {
		//document.getElementById('txt').value = document.getElementById('sel').options[document.getElementById('sel').selectedIndex].value;
		var prslmt = document.getElementsByName("prslmt")[0].value;
		if (isNaN(prslmt)) {
			alert("输入非法");
			return;
		}
		if(prslmt<0.0){
			alert("必须大于0");
			return;
		}
	var aaa =  $.ajax( {  
		       url:'resource/sysOperation!toModify.action',// 跳转到 action  
		       data:{  
		                prslmt : prslmt
		       },  
		      type:'post',  
		      cache:false,  
		      success:function(data) {  
		      	if($.trim(data) =='success'){
		      		 alert("修改成功");
		      		  location.reload();
		      	}else{
		      		 alert("修改失败");
		      	}
		        
		       },  
		       error : function() {  
		            alert("修改失败!");  
		       }  
		  });
	}
</script>
<body class="right_body">
	<s:form action="" method="post" name="makeMark">
		<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 生产入库限制</div>
		<div class="public_div">
			<h2>
				<span class="fl">生产入库限制</span> <span class="fr"></span>
				<!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="public_inner" style="width:98%">
				<table border="0" cellpadding="0" cellspacing="1"
					class="public_table">

					<tr align="center">
						<td>超出限制：<s:textfield name="prslmt" cssClass="input_w"
								cssStyle="width:100px"></s:textfield>%</td>
					</tr>
					<tr align="center">
						<td><font color="#ff0000">输入须>=0.00,示例:10.00%时,PDA生产入库总和将<=订单总数*110%</font>
						</td>
					</tr>
					<tr align="center">
						<td><input  type="button" class="button_m" value="确认" onclick="toModify();" />&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="重置" Class="button_m"></s:reset></td>
					</tr>
				</table>
			</div>
		</div>
	</s:form>
</body>
</html>
