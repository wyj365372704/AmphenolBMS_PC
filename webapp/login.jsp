<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*;"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<style type="text/css">
<!--
body,html {
	height: 100%;
}
<!--
这是针对整个背景自适应高度的样式，不能删
  
-->
-->
</style>
<link href="css/userCenter.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/x-icon"
	href="./images/favicon.ico" />
<link rel="icon" type="image/x-icon" href="./images/favicon.ico" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	function domainAuthenticate(){
		var domainName = getDomainName();
		var userName = getDomainUser();
		$.ajax({
			type: "POST",
        	url: "domainAuth!auth.action",
        	data: {"domain": domainName,"userName":userName},
        	success:function(data){
        		var ret = data.split(",");
        		var result = ret[0];
        		var desc = ret[1];
				if(result=="true"){
					$("#loginName").val(userName);
					$("[name=loginForm]").submit();
				}else{
					$("#domainAuth").hide();
					$("#errMsgText").html(desc);
					$(".loginInfo").show();
					$("#loginName").val("");
					$("#loginName").focus();
					$("#pwd").val("");
				}
        	},
        	cache: false
		});
	}
	
	$(document).ready(function(){
		//让login.jsp页面始终在最上层，不嵌入到别的frame中
		if(parent.document != this){
			top.location.href="<%=request.getContextPath()%>/login.jsp";
		}
		//document.onkeydown = function(e){
		//    var ev = document.all ? window.event : e;
		//    if(ev.keyCode==13) {
		//    	login();
		//    }
		//}
		//$("[name=user.loginName]").focus(function(){
		//	$(this).addClass("inputHighlighted1");
		//}).blur(function(){
		//	$(this).removeClass("inputHighlighted1").addClass("logo_i_1");
		//});
		//$("[name=password]").focus(function(){
		//	$(this).removeClass("logo_i_1").addClass("inputHighlighted1");
		//}).blur(function(){
		//	$(this).removeClass("inputHighlighted1").addClass("logo_i_1");
		//});

		//$(".loginInfo").hide();
		//domainAuthenticate();
	});

	function login() {
		var result = true;
		var loginName = document.getElementById("loginName");
		var pwd = document.getElementById("pwd");
		var msg = "";
		if (loginName.value == "") {
			msg = "用户名不能为空";
			result = false;
		}
		if (pwd.value == "") {
			msg = msg + "\n密码不能为空";
			result = false;
		}
		if (msg != "") {
			alert(msg);
		} else {
			$.ajax({
				type : "POST",
				url : "domainAuth!auth.action",
				data : {
					"userName" : loginName.value,
					"password" : pwd.value
				},
				success : function(data) {
					var ret = data.split(",");
					var result = ret[0];
					var desc = ret[1];
					if (result == "true") {
						$("[name=loginForm]").submit();
					} else {
						$("#domainAuth").hide();
						$("#errMsgText").html(desc);
						$(".loginInfo").show();
						$("#loginName").val("");
						$("#loginName").focus();
						$("#pwd").val("");
					}
				},
				cache : false
			});
		}
	}
</script>
</head>
<body id="IID_SecureWeb_Support">

	<table class="logo_div">
		<form name="loginForm" action="login!userLogin.action" method="post">
			<tr>
				<td>
					<div class="logo_info">
						<table border="0" cellspacing="0" cellpadding="0"
							class="logo_table">
							<tr id="errMsg">
								<td colspan="2"><span id="errMsgText"
									style="color:red;font-weight:bold;">&nbsp;</span>
								</td>
							</tr>
							
							<tr class="loginInfo">
								<td class="text_r">环境：</td>
								<td class="text_l">
						<s:select list="#application.envStidMap" name="env" listValue="key"></s:select>
								</td>
							</tr>
							<tr class="loginInfo">
								<td class="text_r">用户名：</td>
								<td class="text_l"><label><input type="text"
										id="loginName" name="user.userName" class="inputHighlighted1"
										autocomplete="off" maxlength="20" />
								</label></td>
							</tr>
							<tr class="loginInfo">
								<td class="text_r">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
								<td class="text_l"><label><input type="password"
										id="pwd" name="password" class="logo_i_1" maxlength="20" />
								</label></td>
							</tr>
							<tr class="loginInfo">
								<td></td>
								<td class="text_l"><label><input type="button"
										id="sub" class="logo_button" value="" onclick="login();" />
								</label> <label><input type="reset" name="reset" value=""
										class="purge_button" />
								</label></td>
							</tr>
						</table>
					</div></td>
			</tr>
		</form>
	</table>

</body>
</html>