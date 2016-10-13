<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>深圳海关服务评价系统</title>
		<link href="<s:url value="/css/evaluation.css"/>" rel="stylesheet"
			type="text/css" />
	</head>
	<script type="text/javascript">
	function check(){
		var name = document.getElementById('name');
		var sex = document.getElementById('sex');
		var idCardNo = document.getElementById('idCardNo');
		if(name.value == '' || idCardNo.value == ''){
			alert("姓名不能为空！");
			return false;
		}
		if(idCardNo.value == ''){
			alert("身份证不能为空！");
			return false;
		}
		return true;
	}
	</script>
	<body>
		<div id="header">
			<div class="con">
				<img src="<s:url value="/images/logozi.png"/>" />
			</div>
		</div>
		<div class="warp">
			<div class="star01" style="color: white;">
			<form action="evaluation!login.action" method="POST" onsubmit="return check();">
				<center>
				<table>
					<tr>
						<td>姓　名：</td>
						<td><input type="text" name="name" id="name" /></td>
					</tr>
					<tr>
						<td>性　别：</td>
						<td align="left">
						<select name="sex" id="sex">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>身份证：</td>
						<td><input type="text" name="idCardNo" id="idCardNo" /></td>
					</tr>
				</table>
				</center>
				<input type="submit" value="登录">
				</form>
			</div>
		</div>
		

		
	</body>
</html>