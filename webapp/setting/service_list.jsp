<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>业务管理</title>
	<link href="../css/global.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
	<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
	<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
	<script src="../js/common.js" type="text/javascript"></script>
	<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
	<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	function clearForm(){
		$('#name').val('');
		$('#status').val('');
	}
	</script>
</head>

<body class="right_body">
<s:form action="service!list.action" method="post" name="myform" >
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 业务管理</div>
	
	<div class="top_button_div">
	<hgpj:operation resourceKey="HGPJ_SETTING_SERVICE" operKey="ADD" styleCss="common_button2"><input name="" type="button" class="common_button" value="  新增业务" onclick='location="service!toInsert.action"'  /></hgpj:operation>
	</div>
	
	<div class="search">
		<h2>
			<span class="fl">业务管理查询</span>
			<span class="fr">
			<input name="" type="submit" value="" class="search_button"/>
			<input name="" type="button" class="purge_button"  onclick="clearForm();"/></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<ul>
			<li><div class="w_s">业务名：</div>
			<s:textfield id="name" name="service.name" cssClass="input_w"></s:textfield>
			</li>
			<li><div class="w_s">状态：</div>
				<s:select id="status" cssClass="select_s_2" name="service.status" list="#{1:'正常', 0:'禁用'}" listKey="key" listValue="value" headerKey="" headerValue="全部"></s:select>
			</li>
		</ul>
	</div>
	
	<div class="data_list">
		<h2>
			<span class="fl">业务管理列表</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
				<th width="50%">业务名</th>
				<th width="30%">状态</th>
			    <th width="20%">操作</th>
		      </tr>
		      <s:iterator value="services" status="st">
			  <tr ${st.even ? 'class="td_bgcolor"' : 'class="td_bgcolor2"'}>
				<td>${name }</td>
				<td>${status == 1?"正常":"禁用" }</td>
			    <td>
			    <hgpj:operation resourceKey="HGPJ_SETTING_SERVICE" operKey="VIEW" styleCss="button_userlook2"><input name="" type="button" class="button_userlook" title="查看" onclick="javascript: location.href='service!view.action?service.id=${id }';"></hgpj:operation>
				<hgpj:operation resourceKey="HGPJ_SETTING_SERVICE" operKey="MODIFY" styleCss="button_useredit2"><input name="" type="button" class="button_useredit" title="修改" onclick="javascript: location.href='service!toModify.action?service.id=${id }';"></hgpj:operation>
				</td>
		      </tr>
		      </s:iterator>
		  </table>
		  
		   <div class="page"><page:paginator formName="myform" nameInRequest="paginator"/>
		   </div>
		  
		</div>
	</div>
</s:form>
</body>
</html>