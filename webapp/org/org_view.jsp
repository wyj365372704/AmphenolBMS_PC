<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function(){
			$(":checkbox").attr("disabled",true);
			$("#selectAll").hide();
			$("#cancelAll").hide();
			$(":input[type='text']").attr("disabled",true);

			//查看页面默认权限展开显示
			var obj = document.getElementsByTagName("div");
			for(var i=0;i<obj.length;i++){
				if (obj[i].style.display=="none") {
					obj[i].style.display="";
				}
			}	
		});

		function newOrg()
		{
			window.location.href="org!toInsert.action?org.orgId=${org.orgId}";
		}

		function deleteOrg()
		{
			if(${org.orgId}==1){
				jAlert('warning', '该组织是系统根组织，不能删除！', '提示');
			}else{
				jConfirm('组织数据删除后不可恢复，您确认吗？', '提示', function(r) {
		           if(r)
		        	   window.parent.location.href="org!delete.action?org.orgId=${org.orgId}";
		          });
			}
		}

		function editOrg()
		{
			window.location.href="org!toModify.action?org.orgId=${org.orgId}";
		}
	</script>
	
</head>

<body>
		
<div class="top_button_div">
	<hgpj:operation resourceKey="ORG_MANAGER" operKey="ADD" styleCss="addorg_button2"><input id="newOrgId" name="newOrg" type="button" class="addorg_button" onclick="newOrg()" /></hgpj:operation>
	<hgpj:operation resourceKey="ORG_MANAGER" operKey="MODIFY" styleCss="editorg_button2"><input id="editOrgId" name="" type="button" class="editorg_button" onclick="editOrg()" /></hgpj:operation>
	<hgpj:operation resourceKey="ORG_MANAGER" operKey="DELETE" styleCss="deleteorg_button2"><input id="deleteOrgId" name="" type="button" class="deleteorg_button" onclick="deleteOrg()"/></hgpj:operation>
</div>

<div class="public_div">
	<h2>
		<span class="fl">机构基本信息</span>
		<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
	</h2>
	
	<div class="public_inner">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
		  <tr>
			<td width="13%" class="text_r"> 机构名称：</td>
			<td width="37%"><input type="text" name="org.orgName" value="${org.orgName}" class="input_s_1" disabled="disabled"/></td>
			<td width="13%" class="text_r">上级机构：</td>
			<td width="37%">
			
			<s:if test="%{org.parentOrg==0 or org.parentOrg==-1}">
				<input type="text" name="org.parentOrgName" value="" class="input_s_1" disabled="disabled"/>
			</s:if>
			<s:else>
				<input type="text" name="org.parentOrgName" value="${org.parentOrgName}" class="input_s_1" disabled="disabled"/>
			</s:else>
		    </td>
		  </tr>
		  <tr>
			<td class="text_r">机构类型：</td>
			<td><s:select name="org.orgType" list="org.orgTypeList" listKey="key" listValue="value" value="%{org.orgType}" cssClass="select_s_1" disabled="true"></s:select></td>
			<td class="text_r">创建用户：</td>
			<td><input type="text" name="org.createUser" value="${org.createUser}" class="input_s_1" disabled="disabled"/></td>
		  </tr>
		  <tr>
			<td class="text_r">创建时间：</td>
			<td><input type="text" name="org.createDate" value='<s:date name="org.createDate" format="yyyy-MM-dd HH:mm:ss"/>' class="input_s_1" disabled="disabled"/></td>
		    <td class="text_r">&nbsp;</td>
		    <td>&nbsp;</td>
		  </tr>
		  <tr>
			<td class="text_r v_t">组织描述：</td>
			<td colspan="3">
				<label>
			  		<textarea name="org.orgDesc" class="textarea_s_1" disabled="disabled">${org.orgDesc}</textarea>
				</label>
			</td>
		  </tr>
	  </table>
  </div>
</div>

<div class="public_div">
     <s:include value="../commons/permission.jsp"></s:include>
</div>

</body>
</html>