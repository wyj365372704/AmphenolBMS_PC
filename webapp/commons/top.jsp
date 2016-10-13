<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳安费诺BMS系统</title>
<link href="../css/userCenter.css" rel="stylesheet" type="text/css" />
<uc:fdolvip>
<style type="text/css">
.logo .left{ width:120px; float:left; margin:9px 0 0 3px;}
.logo .rzi{ width:260px; float:left; font-size:18px; font-family:微软雅黑,黑体; color:#fff; line-height:18px; padding:20px 0 0 0;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}
</style>
</uc:fdolvip>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/timer.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var date = new Date();
		$("#timer").timer({format:"yy年mm月dd日 W"});	
		$("ul li a").bind('click',function(){
			$("ul li a").removeClass("tabs_s");
			$(this).addClass("tabs_s");
		});
	});
</script>
</head>

<body class="head_body_bg">

<div class="head">

	<div class="head_top">
	
		
		<div class="head_top_r">
			<p class="p_t">
				<a href="#" onclick="parent.location.href='<%=request.getContextPath()%>/logout!logout.action'" class="logout">退出</a>
				<a href="<%=request.getContextPath() %>/user!toModifyUserInfo.action" class="personaldata" target="exMainTFrame">个人资料</a>  
				<a href="<%=request.getContextPath() %>/commons/right.jsp" class="home" target="exMainTFrame">系统首页</a>
			</p>
			<p class="p_b">
				<span class="time fr" id="timer"></span>
				<span class="welcome fr"><b>欢迎您：<s:property value="#session.username"/> 
				</span>
			</p>
			<p class="p_b">
			</p>
		</div>
	</div>
	<div class="clear"></div>

</div>

</body>
</html>
