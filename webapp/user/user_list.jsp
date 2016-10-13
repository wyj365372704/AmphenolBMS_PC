<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
    <script src="./js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="./js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
    <script src="./js/alert/jquery.alerts.js" type="text/javascript"></script>
    <script src="./js/common.js" type="text/javascript"></script>
    <link href="./js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<link href="./css/global.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function del(id,name){
          jConfirm("即将删除用户‘"+name+"’，数据删除后不可恢复，您确认吗？", "提示", function(r) {
          		if(r)
                 window.location.href="user!delete.action?user.userId="+id;
          });
	}
	
	function getChildOrg(){
		var seleVal = "${user.orgId}";
		$("[name='user.orgId']").empty();
		$("[name='user.orgId']").append("<option value=''>全部</option>");  
		$.ajax({
        	type: "POST",
        	url: "./org/org!getChildOrg.action",
        	data: {"org.orgId":$("[name='user.customsId']").val()},
        	success:function(data){
        		if(data!=""&&data!=null){
	        		var dataObj = eval("("+data+")");
	        		$.each(dataObj.data,function(idx,item){
	        			var value = item.value;
	                    var label = item.label;
	                    if(seleVal==value){
	    					$("[name='user.orgId']").append("<option value='"+value+"' selected>"+label+"</option>");
	    				}else{
	    					$("[name='user.orgId']").append("<option value='"+value+"'>"+label+"</option>");
	    				}
	        		});
        		}
        	},
        	cache: false
        });
	}
	
	$(document).ready(function(){
		getChildOrg();
	});
</script>
<body class="right_body">
 <s:form action="user!list.action" method="post" name="queryform">
	<div class="path">您现在的位置： 首页 &gt; 权限管理 &gt; 用户管理</div>
	
	<div class="top_button_div"><hgpj:operation resourceKey="USER_MANAGER" operKey="ADD" styleCss="adduser_button2"><input name="" type="button" class="adduser_button" onclick='location="user!toInsert.action"' /></hgpj:operation></div>
	
	<div class="search">
		<h2>
			<span class="fl">用户查询</span>
			<span class="fr"><s:submit id="queryId" value="" cssClass="search_button" onclick="return dosubmit()"></s:submit>
				<s:reset value="" cssClass="purge_button"></s:reset></span>
		</h2>
		
		<ul>
			<li><div class="w_s">关区：</div>
				<s:if test="#session.loginInfo.user.customsId==1">
					<s:select name="user.customsId" list="customsOrg" listKey="orgId" listValue="orgName" headerKey="" headerValue="全部" cssClass="select_s_2" onchange="getChildOrg();"></s:select>
				</s:if>
				<s:else>
					<s:select name="user.customsId" list="customsOrg" listKey="orgId" listValue="orgName" headerKey="" headerValue="全部" cssClass="select_s_2" disabled="true"></s:select>
				</s:else>
			</li>
			<li><div class="w_s">科室：</div>
				<s:if test="#session.loginInfo.user.customsId==1||#session.loginInfo.user.customsId==#session.loginInfo.user.orgId">
					<s:select name="user.orgId" list="departmentOrg" listKey="orgId" listValue="orgName"  headerKey="" headerValue="全部" cssClass="select_s_2"></s:select>
				</s:if>
				<s:else>
					<s:select name="user.orgId" list="departmentOrg" listKey="orgId" listValue="orgName"  headerKey="" headerValue="全部" cssClass="select_s_2" disabled="true"></s:select>
				</s:else>
			</li>
			<li><div class="w_s">用户名：</div><s:textfield name="user.userName" cssClass="input_w" /></li>
			<li><div class="w_s">姓名：</div><s:textfield name="user.realName" cssClass="input_w" /></li>
			<li><div class="w_s">工号：</div><s:textfield name="user.employeeNumber" cssClass="input_w" /></li>
			<li><div class="w_s">触摸屏评价：</div><s:select name="user.isEvaluated" list="user.isEvaluatedList" listKey="key" listValue="value"  headerKey="" headerValue="全部" cssClass="select_s_2"></s:select></li>
		</ul>
	</div>
	
	<div class="data_list">
		<h2>
			<span class="fl">用户列表</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
			  	<th>照片</th>
			  	<th>关区</th>
			  	<th>科室</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>工号</th>
				<th>职务</th>
				<th>状态</th>
				<th>触摸屏评价</th>
			    <th>操作</th>
			  </tr>
			  <s:iterator value="userList" status="st">
			    <s:if test="#st.Even">
		      		<tr class="td_bgcolor">
		      	</s:if>
		      	<s:else>
		      		<tr class="td_bgcolor2">
		      	</s:else>
		      	<td>
		      		<img src="<%=request.getContextPath()%>/user!viewPhoto.action?user.userId=<s:property value='userId' />" width="60" height="90" border="0"/>
		      	</td>
				<td><s:property value="customsName"/></td>
				<td>
					<s:if test="customsName==orgName">-</s:if>
					<s:else>
						<s:property value="orgName"/>
					</s:else>
				</td>
				<td><s:property value="userName"/></td>
				<td><s:property value="realName"/></td>
				<td><s:property value="employeeNumber"/></td>
				<td><s:property value="position"/></td>
				<td><s:property value="statusAlias"/></td>
				<td><s:property value="isEvaluatedAlias"/></td>
			    <td>
			    	<hgpj:operation resourceKey="USER_MANAGER" operKey="VIEW" styleCss="button_userlook2"><input name="" type="button" class="button_userlook" title="查看" onclick=javascript:location.href="user!view.action?user.userId=<s:property value='userId'/>" /></hgpj:operation>
		    		<hgpj:operation resourceKey="USER_MANAGER" operKey="MODIFY" styleCss="button_useredit2"><input name="" type="button" class="button_useredit" title="修改" onclick=javascript:location.href="user!toModify.action?user.userId=<s:property value='userId'/>" /></hgpj:operation>
		    		<hgpj:operation resourceKey="USER_MANAGER" operKey="DELETE" styleCss="button_userdelete2"><input name="" type="button" class="button_userdelete" title="删除" onclick="del(<s:property value='userId'/>,'<s:property value='userName'/>')" /></hgpj:operation>
				</td>
			</tr>
		</s:iterator>
	</table>
		  
	<div class="page">
		<div class="page"><page:paginator formName="queryform" nameInRequest="paginator"/>
	</div>
		  
</div>
</div>
</div>

</s:form>

</body>
</html>