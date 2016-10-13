<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<script type="text/javascript">
	if(this.name != 'exMainTFrame'){
		this.parent.location.href="<%=request.getContextPath()%>/org/org!orgindex.action";
	}
</script>
</head>

<frameset rows="30,*" frameborder="no" border="5" framespacing="0">
  <frame src="org_top.jsp" name="topFrame" scrolling="No" id="topFrame" />
  <frameset rows="*" cols="230,*" id="exFra" name="exFra" frameborder="no" border="5" framespacing="0">
    <frame src="org!treelist.action?org.orgId=1" name="exLeftFrame" scrolling="auto" noresize="noresize" id="exLeftFrame" />
	<frame src="org_alert.jsp" name="exMainTFrame2" scrolling="auto" noresize="noresize" id="exMainTFrame2" />
	</frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>