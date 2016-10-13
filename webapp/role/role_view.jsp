<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>

<link href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(":input").attr("disabled",true);
			$(".input_s_1").attr("class","inputForbidden");
			$("#selectAll").hide();
			$("#cancelAll").hide();
			$(":button").attr("disabled",false);


			//查看页面默认权限展开显示
			var obj = document.getElementsByTagName("div");
			for(var i=0;i<obj.length;i++){
				if (obj[i].style.display=="none") {
					obj[i].style.display="";
				}
			}	
		});

		
	</script>
</head>

<body class="right_body">
<div class="path">您现在的位置： 首页 &gt; 权限管理 &gt; 角色管理 &gt; 查看角色</div>
	<div class="public_div">
		<h2>
			<span class="fl">角色基本信息</span>
			<span class="fr"></span>
		</h2>
		<div class="public_inner">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="public_table">
			  <tr>
				<td class="td_w_s text_r"> 角色名称：</td>
				<td><input type="text" name="role.roleName" class="input_s_1" value="<s:property value="role.roleName" />"/></td>
				<td class="td_w_s text_r"><span class="text_r">所属关区：</span></td>
				<td><input type="text" name="role.customsName" class="input_s_1" value="<s:property value="role.customsName" />"/></td>
			  </tr>
			  <tr>
                <td class="td_w_s text_r">所属科室：</td>
			    <td><input type="text" name="role.orgName" class="input_s_1" value="<s:property value="role.orgName" />"/></td>
			    <td class="td_w_s text_r">创建用户：</td>
			    <td><input type="text" name="role.createUser" class="input_s_1" value="<s:property value="role.createUser" />"/></td>					 
	      	  </tr>
	      	  <tr>
			    <td class="td_w_s text_r"><span class="text_r">创建时间：</span></td>
			    <td><input type="text" name="role.createUser" class="input_s_1" value='<s:date name="role.createDate" format="yyyy-MM-dd HH:mm:ss"/>' /></td>
			    <td class="td_w_s text_r"><span class="text_r">&nbsp;</span></td>
				<td>&nbsp;</td>
	      	  </tr>
			  <tr>
				<td class="text_r v_t">角色描述：</td>
				<td colspan="3"><label><textarea name="role.roleDesc" class="textarea_s_1" ><s:property value="role.roleDesc" /></textarea>
				</label></td>
			  </tr>
		  </table>
	  </div>
</div>

	
<div class="public_div">
	<div id="permission"> 
		<s:include value="../commons/permission.jsp"></s:include>
	</div>
</div>
	
<div class="button_div">
	<input name="" type="button" onclick="history.go(-1)" class="return_button" />
</div>
</body>
</html>

