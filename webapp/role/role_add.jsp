<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<link rel="stylesheet" href="../css/demo.css" type="text/css">
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="../js/browser.js"></script>
<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.excheck-3.5.js"></script>  
<script type="text/javascript">
	var isExtendsValidate = true;	
	function extendsValidate(){	
	   var extendSubmit=true;
		if($("[name='role.roleDesc']").val().length > 100) {
			errorMessge=errorMessge+menu+".角色描述不能超过100个字符"+'\n';
			menu++;
			extendSubmit = false;
		}	
		if($("[name='orgRes']:checked").length < 1){
			errorMessge=errorMessge+menu+".请选择资源权限"+'\n';
			menu++;
			extendSubmit = false;
		}
		return extendSubmit;
		
	}
	
	function changeOrg(value){ 
	  	$.ajax({
	  		url:"../role/role!menuTree.action" , 
	  		type:"GET" ,
	  		data:{'role.orgId':value} ,
	  		cache:false,
	  		success:function(msg){
	      		  $('#permission').html(msg);
	  		}
		}); 	 
	}

	var setting = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "all"
		},
		view: {
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: onClick,
			onCheck: onCheck
		}
	};

	var zNodes =[${orgTreeData}];

	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("orgTree");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}

	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("orgTree");
		nodes = zTree.getCheckedNodes(true);
		$("#orgSel").attr("value", nodes[0].name);
		$("#orgId").attr("value", nodes[0].id);
		hideOrgTree();
		changeOrg(nodes[0].id);
	}

	function showOrgTree() {
		var orgObj = $("#orgSel");
		var orgOffset = $("#orgSel").offset();
		$("#orgContent").css({left:orgOffset.left + "px", top:orgOffset.top + orgObj.outerHeight() + "px"}).slideDown("fast");

		$("html").bind("mousedown", onBodyDown);
	}
	function hideOrgTree() {
		$("#orgContent").fadeOut("fast");
		$("html").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "orgSelBtn" || event.target.id == "orgSel" || event.target.id == "orgContent" || $(event.target).parents("#orgContent").length>0)) {
			hideOrgTree();
		}
	}

	$(document).ready(function(){
		$.fn.zTree.init($("#orgTree"), setting, zNodes);
	}); 
</script>
</head>

<body class="right_body">

<s:form action="role!insert.action" method="post" name="myform">

	<div class="path">您现在的位置： 首页 &gt; 权限管理 &gt; 角色管理 &gt; 新增角色</div>
		
	<div class="public_div">
		<h2>
			<span class="fl">角色基本信息</span>
			<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
		</h2>
		
		<div class="public_inner">
			<table border="0" cellpadding="0" cellspacing="1" class="public_table">
			  <tr>
				<td class="td_w_s text_r">角色名称：</td>
				<td>
					<input type="text" name="role.roleName" class="input_s_2" reg="^[a-zA-Z0-9\u4e00-\u9fa5]{1,25}$" maxlength="25" tip="角色名称为必填项且不能包含特殊字符"/>
					<input type="hidden" name="role.oldRoleName" value="" />
			    	<span class="red">*</span>
			    </td>
			  </tr>
			  <tr>
				<td class="td_w_s text_r">所属机构：</td>
				<td>
					<input type="text" id="orgSel" value="" class="input_s_2" readonly="readonly" onclick="showOrgTree();"/>
					<input type="hidden" id="orgId" name="role.orgId" value="" />
					<input type="button" id="orgSelBtn" class="picking_button v_m" onclick="showOrgTree();"/><span class="red">*</span>
				    <div id="orgContent" class="menuContent" style="display:none; position: absolute;">
						<ul id="orgTree" class="ztree" style="margin-top:0; width:270px; height: 300px;"></ul>
					</div>
			    </td>
			  </tr>
			  <tr>
				<td class="text_r v_t">角色描述：</td>
				<td colspan="3"><label>
				  <textarea name="role.roleDesc" class="textarea_s_1"></textarea>
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
	<s:submit value="" cssClass="save_button"></s:submit><s:reset value="" cssClass="purge_button2"></s:reset><input name="back" type="button" class="return_button" onclick="history.go(-1)" />
</div>

</s:form>
</body>
</html>

