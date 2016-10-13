<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/userCenter.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/x-icon" href="./images/favicon.ico" />
<title></title>
</head>

<frameset rows="96,*,24" frameborder="no" border="5" framespacing="0" id="IID_SecureWeb_Support">
  <frame src="commons/top.jsp" name="topFrame" scrolling="No" id="topFrame" />
  <frameset rows="*" cols="190,10,*" id="exFra" name="exFra" frameborder="no" border="5" framespacing="0">
   <frame src="login!listResources.action" name="exLeftFrame" scrolling="auto" noresize="noresize" id="exLeftFrame" />
    <frame src="commons/explorer_scroll.jsp" name="exScrollFrame" scrolling="No" noresize="noresize" id="exScrollFrame" />
	<frame src="commons/right.jsp" name="exMainTFrame" scrolling="auto" noresize="noresize" id="exMainTFrame" />
  </frameset>
  <frame src="commons/bottom.html"   name="exMainFrame" id="exMainFrame" frameborder="no"  />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>