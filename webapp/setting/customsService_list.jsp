<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>业务设置</title>
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
		$('#orgId:enabled').val('');
	}
	</script>
</head>

<body class="right_body">
<s:form action="customsService!list.action" method="post" name="myform" >
	<div class="path">您现在的位置： 首页 &gt; 系统设置 &gt; 业务设置</div>
	
	<div class="top_button_div">
	<hgpj:operation resourceKey="HGPJ_SETTING_CSERVICE" operKey="ADD" styleCss="common_button2"><input name="" type="button" class="common_button" value="  新增设置" onclick='location="customsService!toInsert.action"' /></hgpj:operation>
	</div>
	
	<div class="search">
		<h2>
			<span class="fl">业务设置查询</span>
			<span class="fr">
			<input name="" type="submit" value="" class="search_button"/>
			<input name="" type="button" class="purge_button"  onclick="clearForm();"/></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<ul>
			<li><div class="w_s">所属关区：</div>
				<s:if test="#session.loginInfo.user.customsId==1">
					<s:select id="orgId" name="customsService.orgId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="全部" cssClass="select_s_2"></s:select>
				</s:if>
				<s:else>
					<s:select id="orgId" name="customsService.orgId" list="#request.orgs" listKey="orgId" listValue="orgName" headerKey="" headerValue="全部" cssClass="select_s_2" disabled="true"></s:select>
				</s:else>
			</li>
		</ul>
	</div>
	
	<div class="data_list">
		<h2>
			<span class="fl">业务设置列表</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
				<th width="20%">所属关区</th>
				<th>已设置业务</th>
			    <th width="30%">操作</th>
		      </tr>
		      <s:iterator value="customsServices" status="st">
			  <tr ${st.even ? 'class="td_bgcolor"' : 'class="td_bgcolor2"'}>
				<td>${orgName }</td>
				<td style="width:300px;word-break: break-all; work-wrap: break-word;overflow：hidden">${serviceName }</td>
			    <td>
			    <hgpj:operation resourceKey="HGPJ_SETTING_CSERVICE" operKey="VIEW" styleCss="button_userlook2"><input name="" type="button" class="button_userlook" title="查看" onclick="javascript: location.href='customsService!view.action?customsService.orgId=${orgId }';"></hgpj:operation>
				<hgpj:operation resourceKey="HGPJ_SETTING_CSERVICE" operKey="MODIFY" styleCss="button_useredit2"><input name="" type="button" class="button_useredit" title="修改" onclick="javascript: location.href='customsService!toModify.action?customsService.orgId=${orgId }';"></hgpj:operation>
				<hgpj:operation resourceKey="HGPJ_SETTING_CSERVICE" operKey="DELETE" styleCss="button_userdelete2"><input name="" type="button" class="button_userdelete" title="删除" onclick="javascript: jConfirm('确定要删除该设置？','提示', function(result){if(result){ location.href='customsService!delete.action?customsService.orgId=${orgId }';}})"></hgpj:operation>
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