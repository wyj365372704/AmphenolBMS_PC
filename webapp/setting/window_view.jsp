<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查看窗口设置</title>
	
	<link href="../css/global.css" rel="stylesheet" type="text/css" />
</head>

<body class="right_body">
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 窗口设置&gt; 查看窗口设置</div>
	<div class="public_div">
		<h2>
			<span class="fl">窗口设置</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
			  <tr>
				<td class="text_r">所属关区：</td>
				<td>
					<s:textfield name="window.parentOrgName" cssClass="input_s_1" disabled="true"></s:textfield>
				</td>
				<td class="text_r">所属科室：</td>
				<td>
					<s:textfield name="window.orgName" cssClass="input_s_1" disabled="true"></s:textfield>
				</td>
			  </tr>
		  	  <tr>
				<td width="13%" class="td_w_s text_r">窗口名称：</td>
				<td width="37%">
					<s:textfield name="window.name" cssClass="input_s_1" disabled="true"></s:textfield>
                </td>
				<td width="13%" class="td_w_s text_r">窗口状态：</td>
				<td width="37%">
					<input type="text" value='${window.status == 1?"启用":"禁用" }' class="input_s_1" disabled="true"/>
			    </td>
		  	  </tr>
		</table>
	  </div>
	</div>
	
	<div class="button_div">
		<input name="" type="button" class="return_button" onclick="history.go(-1);" />
	</div>
</body>
</html>