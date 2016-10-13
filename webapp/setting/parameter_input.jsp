<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>参数设置</title>
	<link href="../css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script src="../js/validator/easy_validator.pack.js" type="text/javascript"></script>    
	<script src="../js/validator/jquery.bgiframe.min.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
	<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<link href="../css/validate.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">

	</script>
</head>

<body class="right_body">
<s:form action="parameter!insert.action" method="post" name="myform">
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 参数设置</div>
	<div class="public_div">
		<h2>
			<span class="fl">参数设置</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner">
		<form>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
				<th width="30%">参数名称</th>
				<th width="20%">参数值</th>
				<th width="50%">描述</th>
			  </tr>
			  <s:iterator value="parameters" status="s">
		  	  <tr>
				<td>
					${paraName }
					<input name="parameters[${s.index }].id" value="${id }" type="hidden"/>
				</td>
				<td>
					<input name="parameters[${s.index }].paraValue" reg="^[1-9]+[0-9]*$" tip="请填写大于0的正整数！" maxlength="5" value="${paraValue }" class="input_s_1"/>
			    </td>
				<td>
					${paraDesc }
					<input name="parameters[${s.index }].paraDesc" value="${paraDesc }" type="hidden"/>
                </td>
		  	  </tr>
		  	  </s:iterator>
		  </table>
	  </div>
	</div>
	<div class="button_div">
		<s:submit value="" cssClass="save_button"></s:submit>
	</div>
</s:form>
</body>
</html>