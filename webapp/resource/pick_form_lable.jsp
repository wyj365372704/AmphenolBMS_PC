<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Amphenol</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.tb{
	    border: solid 1px;
        margin-bottom: 50px;
	}
	.btabel tr td{ 
		border:1px solid;
	}
</style>
<script type="text/javascript">
window.resizeTo(800, 800);
</script>
</head>

<body>
	<!-- 分装标签 -->
	<s:iterator value="results" var="result">
	<table cellpadding="5px" width="400" class="tb"  style='page-break-after: always;'>
		<tbody>
			<tr>
				<td>
					<table width="100%" cellpadding="3px" style="border-collapse: collapse;">
						<tbody>
							<tr>			      		
								<td align="center"><s:property value="ordno"/> / <s:property value="dept"/> (<s:property value="uugam2"/>)</td>
							</tr>
							<tr>
								<td align="center"><s:property value="citem"/> <s:property value="cdesc"/></td>
							</tr>
							<tr>
							
								<td align="center"><fmt:formatNumber value="${result.shqty }" pattern="#0.0000" /></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	
	</s:iterator>
	
</body>

</html>