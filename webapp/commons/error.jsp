<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<link href="<%=request.getContextPath()%>/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
onload=function(){
	// 错误页面只能在框架面‘exMainTFrame’、'exMainTFrame2'与脱离框架页显示，用于登录时发生错误
	if(this.name != "exMainTFrame" && this.name != "" && this.name != "exMainTFrame2"){
		if (top.location != self.location){
			top.location=self.location;
		}
	}
	// 页面回车事件处理
	document.onkeydown = function(e){
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	backgo();
	    }
	}
	<%
		String top = request.getParameter("top");
		if (top != null && top.equals("true")) {
			out.println("if (top.location != self.location)top.location=self.location;");
			String errorMsg = request.getParameter("errorMsg");
			String backUrl = request.getParameter("backUrl");
			if (errorMsg != null) {
				errorMsg = new String(errorMsg.getBytes("ISO-8859-1"),"UTF-8");
			}
			request.setAttribute("errorMsg",errorMsg);
			request.setAttribute("backUrl",backUrl);						
		}
		if (request.getAttribute("backUrl") == null && request.getAttribute("errorMsg") == null){
			request.setAttribute("backUrl","/login.jsp");
			request.setAttribute("errorMsg","系统错误，请联系系统管理员！");
		}
	%>
}

function backgo()
{
	var backUrl="${backUrl}";
	if(backUrl == "" || backUrl == "null" || backUrl == "back"){
		// 无指定返回链接，直接后退
		history.back();
	} else if(backUrl == "close"){
		// 直接关闭页面
		window.close();
	} else {
		// 没有以'/'开始
		if(backUrl.substr(0,1) != "/"){
			backUrl="/"+backUrl;
		}
		
		if(backUrl.substr(0,"/login.jsp".length) == "/login.jsp"){
			// 回到登录页，需要脱离整个frame
			top.location.href="<%=request.getContextPath()%>"+backUrl;
		} else {
			location.href="<%=request.getContextPath()%>"+backUrl;
		}
	}
}
//-->
</script>
</head>
<body class="body_bg">
	<div class="error">
		<div class="error_info">
			<h3>${errorMsg}</h3>
			<p>&nbsp;</p>
			<p><input name="" type="button" class="definite_button" onclick="javascript:backgo();"/></p>
		</div>
	</div>
</body>
</html>