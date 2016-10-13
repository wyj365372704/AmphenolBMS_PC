<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<script type="text/javascript" src="./js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="./js/randomNumber.js"></script>
<script type="text/javascript" src="./js/validator/easy_validator.pack.js"></script>
<script type="text/javascript" src="./js/validator/jquery.bgiframe.min.js"></script>
<link rel="stylesheet" href="./css/demo.css" type="text/css">
<link href="./css/global.css" rel="stylesheet" type="text/css" />
<link  href="./css/validate.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="./js/alert/jquery.ui.draggable.js" type="text/javascript"></script>
<script type="text/javascript" src="./js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="./js/jquery.ztree.excheck-3.5.js"></script>    
<script src="./js/alert/jquery.alerts.js" type="text/javascript"></script>
<link href="./js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>

<body class="right_body">
	<div class="path">您现在的位置： 首页 &gt; 权限管理 &gt; 用户管理 &gt; 查看用户</div>
	<div class="public_div">
		<h2>
			<span class="fl">用户基本信息</span>
			<span class="fr"></span>
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
			 <tr>
			    <td width="11%" class="td_w_s text_r">用户名：</td> 
			    <td width="39%"><s:textfield name="user.userName" cssClass="input_s_1" disabled="true"/></td>
			    <td width="11%" class="td_w_s text_r"><span class="text_r">真实姓名：</span></td>
			    <td width="39%"><s:textfield name="user.realName" cssClass="input_s_1" disabled="true"/></td>
		  	 </tr>
		  	 <tr>
				<td class="td_w_s text_r">工号：</td>
				<td><s:textfield name="user.employeeNumber" cssClass="input_s_1" disabled="true"/></td>
				<td class="td_w_s text_r">职务：</td>
				<td><s:textfield name="user.position" cssClass="input_s_1" disabled="true"/></td>
			 </tr>
			 <tr>
                <td class="td_w_s text_r">所属机构：</td>
			    <td><s:textfield name="user.orgName" cssClass="input_s_1" disabled="true"/></td>
			    <td class="td_w_s text_r">用户状态：</td>
			    <td>
                	<s:select name="user.status" list="user.statusList" listKey="key" listValue="value" value="%{user.status }" cssClass="select_s_1" disabled="true"></s:select>
				</td>
	      	 </tr>
			 <tr>
	      	 	<td class="td_w_s text_r">报表数据访问权限：</td>
	      	 	<td><s:select name="user.dataAccessPerm" list="user.dataAccessPermList" listKey="key" listValue="value" value="%{user.dataAccessPerm }" cssClass="select_s_1" disabled="true"></s:select></td>
	      	 	<td class="td_w_s text_r">触摸屏评价：</td>
	      	 	<td><s:select name="user.isEvaluated" list="user.isEvaluatedList" listKey="key" listValue="value" value="%{user.isEvaluated }" cssClass="select_s_1" disabled="true"></s:select></td>
	      	 </tr>
			 <tr>
			 	<td class="td_w_s text_r">性别：</td>
			    <td>
                	<s:radio name="user.sex" list="user.sexList" listKey="key" listValue="value" value="%{user.sex }" label="性别" disabled="true"></s:radio>
				</td>
			    <td class="td_w_s text_r"><span class="text_r">邮箱地址：</span></td>
			    <td><s:textfield name="user.email" cssClass="input_s_1" disabled="true"/></td>
	      	 </tr>
			 <tr>
                <td class="td_w_s text_r">办公电话：</td>
			    <td><s:textfield name="user.telephone" cssClass="input_s_1" disabled="true"/></td>
			    <td class="td_w_s text_r"><span class="text_r">手机号码：</span></td>
			    <td><s:textfield name="user.mobile" cssClass="input_s_1" disabled="true"/></td>
	      	 </tr>
	       	 <tr>
			    <td class="td_w_s text_r"><span class="text_r">照片预览：</span></td>
			    <td colspan="3">
			    	&nbsp;<img src="<%=request.getContextPath()%>/user!viewPhoto.action?user.userId=<s:property value='user.userId' />" width="90" height="120" border="0"/>
		      		<s:hidden name="user.photo"></s:hidden>
			    </td>
	      	 </tr>
		  </table>
	  </div>
	</div>
	
	<div class="data_list">
		<h2>
			<span class="fl">用户角色</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner" id="roleInner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
			    <th><input name="Input2" type="checkbox" value="" checked disabled="disabled"/></th>
				<th>角色名称</th>
			  </tr>
			  <s:iterator value="roleList">
				<tr>
					<td><input name="roleIds" type="checkbox" value="<s:property value='roleId'/>" checked disabled="disabled"/></td>
					<td><s:property value="roleName"/></td>
				</tr>
			 </s:iterator>
			 </table>
		</div>
	</div>
</div>
	
<div class="button_div">
	<input name="back" type="button" class="return_button" onclick="history.go(-1)" />
</div>
</body>
</html>
