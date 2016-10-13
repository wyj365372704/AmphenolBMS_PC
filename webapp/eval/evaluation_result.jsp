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

	<body>
		<div id="header">
			<div class="con02">
				<div class="logo"><img src="<s:url value="/images/logozi.png"/>" /></div>
				<div class="exit"><p>欢迎您，${userMap.name }（${userMap.idCardNo }）</p> <span><a href="evaluation!logout.action">退出</a></span></div>
			</div>
		</div>
		<div class="warp">
			<div class="end04">
				<a href="evaluation!keepon.action"><img src="<s:url value="/images/button_jx.png"/>" alt="继续评价"
						border="0" />
				</a>
				<a href="evaluation!logout.action"><img src="<s:url value="/images/button_tc.png"/>" alt="退出评价"
						width="127" height="38" border="0" />
				</a>
			</div>
		</div>
	</body>
</html>