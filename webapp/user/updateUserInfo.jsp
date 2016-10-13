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

<script type="text/javascript">
	var checkResult = true;
	var ErrMsg="";
	function CheckExt(obj){
		var AllowExt=".jpg|.jpeg|.gif|.bmp|.png|"; //允许上传的图片格式类型
	  	var FileObj=obj;
	  	if(obj.value=="")return false;	  
	  	var FileExt=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();
	  	if(AllowExt!=0&&AllowExt.indexOf(FileExt+"|")==-1) //判断文件类型是否允许上传
	  	{
	    	ErrMsg="用户照片文件不合法，只允许上传文件后缀名为jpg、jpeg、gif、bmp、png的图片，请重新上传！";
	    	checkResult=false;
	  	}else{
	  		checkResult=true;
	  	}
	}
	
	var isExtendsValidate = true;
	function extendsValidate(){
		var extendSubmit=true;
		if(!checkResult){
			errorMessge=errorMessge+menu+"."+ErrMsg+""+'\n';
			menu++;
			extendSubmit = false;
		}
		return extendSubmit;
	}	
</script>
</head>

<body class="right_body">

<s:form action="user!modifyUserInfo.action" method="post" name="myform" enctype="multipart/form-data">
	<div class="path">您现在的位置： 首页 &gt; 个人资料</div>
	<div class="public_div">
		<h2>
			<span class="fl">用户基本信息</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="public_table">
			 <tr>
			    <td width="11%" class="td_w_s text_r">用户名：</td> 
			    <td width="39%">
			    	<input type="text" name="user.userName" value="${user.userName }" class="input_s_1" disabled="disabled"/>
			    	<s:hidden name="user.userId"></s:hidden>
			    	<s:hidden name="user.userName"></s:hidden>
                </td>
			    <td width="11%" class="td_w_s text_r"><span class="text_r">真实姓名：</span></td>
			    <td width="39%">
			    	<input type="text" name="user.realName" value="${user.realName }" class="input_s_1" reg="^\S" maxlength="20"  tip="姓名为必填项" />
                    <span class="red">*</span>
                </td>
		  	 </tr>
		  	 <tr>
				<td class="td_w_s text_r">工号：</td>
				<td><input type="text" name="user.employeeNumber" value="${user.employeeNumber }" class="input_s_1" maxlength="10" reg="^\S" tip="工号不能为空"/><span class="red">*</span></td>
				<td class="td_w_s text_r">职务：</td>
				<td><input type="text" name="user.position" value="${user.position }" class="input_s_1" maxlength="30" reg="^\S" tip="职务不能为空"/><span class="red">*</span></td>
			 </tr>
			 <tr>
                <td class="td_w_s text_r">所属机构：</td>
			    <td>
			    	<input type="text" name="userOrgId" value="${user.orgName }" class="input_s_1" disabled="disabled" />
			    	<s:hidden name="user.orgId"></s:hidden>
				</td>
				<td class="td_w_s text_r">用户状态：</td>
			    <td>
                	<s:select name="userStatus" list="user.statusList" listKey="key" listValue="value" value="%{user.status }" cssClass="select_s_1" disabled="true"></s:select>
                	<s:hidden name="user.status"></s:hidden>
				</td>
	      	 </tr>
			 <tr>
	      	 	<td class="td_w_s text_r">报表数据访问权限：</td>
	      	 	<td>
	      	 		<s:select name="dataAccessPerm" list="user.dataAccessPermList" listKey="key" listValue="value" value="%{user.dataAccessPerm }" cssClass="select_s_1" disabled="true"></s:select>
	      	 		<s:hidden name="user.dataAccessPerm"></s:hidden>
	      	 	</td>
	      	 	<td class="td_w_s text_r">触摸屏评价：</td>
	      	 	<td>
	      	 		<s:select name="isEvaluated" list="user.isEvaluatedList" listKey="key" listValue="value" value="%{user.isEvaluated }" cssClass="select_s_1" disabled="true"></s:select>
	      	 		<s:hidden name="user.isEvaluated"></s:hidden>
	      	 	</td>
	      	 </tr>
			 <tr>
			    <td class="td_w_s text_r">性别：</td>
			    <td>
                	<s:radio name="user.sex" list="user.sexList" listKey="key" listValue="value" value="%{user.sex }" label="性别"></s:radio>
				</td>
			    <td class="td_w_s text_r"><span class="text_r">邮箱地址：</span></td>
			    <td><input type="text" name="user.email" value="${user.email }" class="input_s_1" reg="^\s*$|^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" tip="邮箱地址格式不正确" maxlength="50"/></td>
	      	 </tr>
			 <tr>
                <td class="td_w_s text_r">办公电话：</td>
			    <td><input type="text" name="user.telephone" value="${user.telephone }" reg="^((\d+[-])*\d+)*$" maxlength="30" tip="电话号码格式不正确" class="input_s_1" /></td>
			    <td class="td_w_s text_r"><span class="text_r">手机号码：</span></td>
			    <td><input type="text" name="user.mobile" value="${user.mobile }" class="input_s_1" maxlength="30"/></td>
	      	 </tr>
	       	 <tr>
			    <td class="td_w_s text_r"><span class="text_r">照片预览：</span></td>
			    <td colspan="3">
			    	<s:if test="user.photo==null">
		      			&nbsp;<img src="images/user_picture.jpg" width="90" height="120" border="0"/>
		      		</s:if>
		      		<s:else>
			    		&nbsp;<img src="<%=request.getContextPath()%>/user!viewPhoto.action?user.userId=<s:property value='user.userId' />" width="90" height="120" border="0"/>
		      		</s:else>
		      		<s:hidden name="user.photo"></s:hidden>
			    </td>
	      	 </tr>
	      	 <tr>
			    <td class="td_w_s text_r"><span class="text_r">重新上传照片：</span></td>
			    <td colspan="3">&nbsp;<input type="file" name="photo" id="photo" onchange="CheckExt(this)"/></td>
	      	 </tr>
		  </table>
	  </div>
	</div>
</div>
	
<div class="button_div">
	<s:submit value="" cssClass="save_button"></s:submit><s:reset value="" cssClass="purge_button2"></s:reset><input name="back" type="button" class="return_button" onclick="history.go(-1)" />
</div>

</s:form>
</body>
</html>
