<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function del(id,name){
          jConfirm("即将删除角色‘"+name+"’，数据删除后不可恢复，您确认吗？", '提示框', function(r) {
          		if(r)
                 window.location.href="role!delete.action?role.roleId="+id;
          });
	}
	
	function openSelectOrg(){
		var iWidth = 600;
        var iHeight = 400;
        var iTop = (window.screen.availHeight - 20 - iHeight) / 2;
        var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;
        var orgId = window.showModalDialog("<%=request.getContextPath() %>/role/role!roleSelectOrg.action", window, 'dialogWidth:' + iWidth + 'px;dialogHeight:' + iHeight + 'px;dialogTop: ' + iTop + 'px; dialogLeft: ' + iLeft + 'px;center:yes;scroll:no;status:no;resizable:0;location:no');
        if(orgId){
        	location.href="<%=request.getContextPath() %>/role/role!toInsert.action?role.orgId="+orgId;
        }
	}
	
	function getChildOrg(){
		var seleVal = "${role.orgId}";
		$("[name='role.orgId']").empty();
		$("[name='role.orgId']").append("<option value=''>全部</option>");  
		$.ajax({
        	type: "POST",
        	url: "../org/org!getChildOrg.action",
        	data: {"org.orgId":$("[name='role.customsId']").val()},
        	success:function(data){
        		if(data!=""&&data!=null){
		        	var dataObj = eval("("+data+")");
	        		$.each(dataObj.data,function(idx,item){
	        			var value = item.value;
	                    var label = item.label;
	                    if(seleVal==value){
	    					$("[name='role.orgId']").append("<option value='"+value+"' selected>"+label+"</option>");
	    				}else{
	    					$("[name='role.orgId']").append("<option value='"+value+"'>"+label+"</option>");
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

<s:form action="role!list.action" method="post" name="queryform">

	<div class="path">您现在的位置： 首页 &gt; 权限管理 &gt; 角色管理</div>
	
	<div class="top_button_div"><hgpj:operation resourceKey="ROLE_MANAGER" operKey="ADD" styleCss="addrole_button2"><input name="" type="button" class="addrole_button" onclick='location="role!toInsert.action"' /></hgpj:operation></div>
	
	<div class="search">
		<h2>
			<span class="fl">角色查询</span>
			<span class="fr"><s:submit id="queryId" value="" cssClass="search_button" onclick="return dosubmit()"></s:submit>
				<s:reset value="" cssClass="purge_button"></s:reset></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<ul>
			<li><div class="w_s">关区：</div>
				<s:if test="#session.loginInfo.user.customsId==1">
					<s:select name="role.customsId" list="customsOrg" listKey="orgId" listValue="orgName" headerKey="" headerValue="全部" cssClass="select_s_2" onchange="getChildOrg();"></s:select>
				</s:if>
				<s:else>
					<s:select name="role.customsId" list="customsOrg" listKey="orgId" listValue="orgName" headerKey="" headerValue="全部" cssClass="select_s_2" disabled="true"></s:select>
				</s:else>
			</li>
			<li><div class="w_s">科室：</div>
				<s:if test="#session.loginInfo.user.customsId==1||#session.loginInfo.user.customsId==#session.loginInfo.user.orgId">
					<s:select name="role.orgId" list="departmentOrg" listKey="orgId" listValue="orgName"  headerKey="" headerValue="全部" cssClass="select_s_2"></s:select>
				</s:if>
				<s:else>
					<s:select name="role.orgId" list="departmentOrg" listKey="orgId" listValue="orgName"  headerKey="" headerValue="全部" cssClass="select_s_2" disabled="true"></s:select>				
				</s:else>
			</li>
			<li><div class="w_s">角色名称：</div><s:textfield name="role.roleName" cssClass="input_w"/></li>
		</ul>
	</div>
	
	<div class="data_list">
		<h2>
			<span class="fl">角色列表</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="list_inner">
			<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
			  <tr>
				<th>关区</th>
				<th>科室</th>
				<th>角色名称</th>
				<th>创建时间</th>
				<th>操作</th>
			  </tr>
			<s:iterator value="roleList" id="role" status="st">
  				 <s:if test="#st.Even">
		      		<tr class="td_bgcolor">
		      	</s:if>
		      	<s:else>
		      		<tr class="td_bgcolor2">
		      	</s:else>
	  				<td><s:property value="customsName"/></td>
	  				<td>
	  					<s:if test="customsName==orgName">-</s:if>
						<s:else>
							<s:property value="orgName"/>
						</s:else>
	  				</td>
  					<td><s:property value="roleName"/></td>
	  				<td><s:date name="createDate" format="yyyy-MM-dd HH:mm:ss" /></td>
	  			<td>
	  				<hgpj:operation resourceKey="ROLE_MANAGER" operKey="VIEW" styleCss="button_userlook2"><input name="" type="button" class="button_userlook" title="查看" onclick=javascript:location.href="role!view.action?role.roleId=<s:property value='roleId'/>" /></hgpj:operation>
				    <hgpj:operation resourceKey="ROLE_MANAGER" operKey="MODIFY" styleCss="button_useredit2"><input name="" type="button" class="button_useredit" title="修改"  onclick=javascript:location.href="role!toModify.action?role.roleId=<s:property value='roleId'/>" /></hgpj:operation>
	  				<s:if test='#role.roleId==1||#role.roleName=="分关管理员"'>
	  					<input name="" type="button" class="button_userdelete2" title="删除" />
	  				</s:if>
	  				<s:else>
					    <hgpj:operation resourceKey="ROLE_MANAGER" operKey="DELETE" styleCss="button_userdelete2"><input name="" type="button" class="button_userdelete" title="删除" onclick="del(<s:property value='roleId'/>,'<s:property value='roleName'/>')" /></hgpj:operation>
	  				</s:else>
				</td>
  			   </tr>
  			</s:iterator>
		  </table>
		  <div class="page"><page:paginator formName="queryform" nameInRequest="paginator"/>
		  </div>
		</div>
	</div>
	
</s:form>

</body>
</html>