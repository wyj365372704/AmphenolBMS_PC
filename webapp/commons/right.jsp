<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<style type="text/css">
<!--
body,html{height:99%; _height:95%; }
-->
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> </title>

<link href="../css/userCenter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/timer.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var date = new Date();
		$("#timer").timer({format:"yy年mm月dd日 W"});	
	});
</script>
</head>

<body class="right_body">

<div class="body_div">

	<div class="path">您现在的位置： 首页</div>
	
	<div class="welcome_info">
		<h6>您好，欢迎使用BMS系统！</h6>
		<p>今天是 <span id="timer"></span></p>
	</div>
	
</div>

</body>
</html>