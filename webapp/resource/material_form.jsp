<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>物料标签</title>
<style type="text/css">
.tb {
	border: solid 1px;
	margin-bottom: 50px;
}

.btabel tr td {
	border: 1px solid;
}
</style>
</head>
<body>
<table cellpadding="5px" class="tb" style='page-break-after: always;border-collapse: collapse;'>
<tr>
<td rowspan="3" align="center" valign="middle"><img src="${qrcodeurl}" width="80px"/></td><td>物料:${fordrji}</td>
</tr>
<tr><td>描述:<s:property value="fds40ji"/></td></tr>
<tr><td>批号:${fblcft9}</td></tr>
<tr><td>数量:${fcout }</td><td>单重:${fweight }${fweight_unit}</td></tr>
<tr><td>净重:${fcout*fweight }${fweight_unit}</td><td>毛重:${totalweight }g</td></tr>
<tr><td>日期:${fdate }</td><td>厂商:${fproducter}</td></tr>
</table>
</body>
</html>