<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统消息</title>
<link href="<%=request.getContextPath()%>/css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
// 页面回车事件处理
document.onkeydown = function(e){
    var ev = document.all ? window.event : e;
    if(ev.keyCode==13) {
    	backgo();
    }
}
	
function backgo(){
	var backUrl="${backUrl}";
	if(backUrl == "" || backUrl == "null" || backUrl == "back"){
		// 无指定返回链接，直接后退
		history.back();
	} else if(backUrl != "" && backUrl != "null" && backUrl != "close") {
		if(backUrl.substr(0,1) != "/"){
			backUrl="/"+backUrl;
		}
		// 回退到指定URL地址
		location.href="<%=request.getContextPath()%>"+backUrl;
	} else {
		// 关闭窗口
		window.close();
	}
}
//-->
</script>
</head>

<body class="right_body">
	<div class="prompt">
		<div class="prompt_info">
			<h3>${infoMsg}</h3>
			<p>&nbsp;</p>
			<p><input name="" type="button" class="definite_button" onclick="javascript:backgo();"/></p>
		</div>
	</div>
</body>
</html>