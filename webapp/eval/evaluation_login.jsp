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
			<div class="con">
				<img src="<s:url value="/images/logozi.png"/>" />
			</div>
		</div>
		<div class="warp">
			<div class="star01">
				<img src="<s:url value="/images/01.gif"/>" alt="请刷身份证进行身份识别"
					border="0" />
			</div>
		</div>
		<form action="evaluation!login.action" method="POST">
			<input type="hidden" name="name" id="name" />
			<input type="hidden" name="sex" id="sex" />
			<input type="hidden" name="idCardNo" id="idCardNo" />
		</form>
		<OBJECT classid="clsid:10946843-7507-44FE-ACE8-2B3483D179B7"
			id="CVR_IDCard" name="CVR_IDCard" width="0" height="0">
		</OBJECT>
	</body>
		<script language="javascript" type="text/javascript">
		<s:if test="#request.tipMsg != null">
		alert('${tipMsg}');
		</s:if>
		function readCard() {
			var CVR_IDCard = document.getElementById("CVR_IDCard");
			var strReadResult = CVR_IDCard.ReadCard();
			if (strReadResult == "0") {
				document.all['name'].value = CVR_IDCard.Name;
				document.all['sex'].value = CVR_IDCard.Sex;
				document.all['idCardNo'].value = CVR_IDCard.CardNo;
				document.forms[0].submit();
			}
		}
		setInterval(readCard, 1000);
		</script>	
</html>