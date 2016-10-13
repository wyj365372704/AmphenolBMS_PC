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
	<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
	<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
	<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
	<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
	<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
	<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
		function displayAll()
		{
			jQuery('.div_bgcolor2').find('div[id]').each(function(n){
				var cru = jQuery(this);
				cru.show();
			});	
		}
		
		function hiddenAll()
		{
			jQuery('.div_bgcolor2').find('div[id]').each(function(n){
				var cru = jQuery(this);
				cru.hide();
			});	
		}
		
		function hit(name)
		{
			var obj = document.getElementById(name);
			if (obj.style.display=="none") {
				obj.style.display="";
			}
			else {
				obj.style.display="none";
			}
		}
		
		function fCheckAll()
		{
			displayAll();
			jQuery('.div_bgcolor2').find("input").each(function(n){
				var cru = jQuery(this);
				cru.attr("checked",'true');
			});	
		}
		
		function fUnCheckAll()
		{
			jQuery('.div_bgcolor2').find("input").each(function(n){
				var cru = jQuery(this);
				cru.removeAttr("checked");
			});	
		}
		
		function fCheck(resId,myself)
		{
			var obj = document.getElementsByTagName("input");
			for(var i=0;i<obj.length;i++){
				if(obj[i].type=="checkbox"){
					if(obj[i].id==resId){
						if(myself.checked==true){
							obj[i].checked=true;
						}else{
							obj[i].checked=false;
						}
					}
				}
			}
		}
		
		function menuCheck(myself,menuName)
		{
			var resId = myself.id;
			//全选项后面的所有操作勾选了，则自动勾选全选项
			var menuObj = document.getElementById(menuName);
			var obj = document.getElementsByTagName("input");
			var resAllCheck = true;
			for(var i=0;i<obj.length;i++){
				if(obj[i].type=="checkbox"){
					if(obj[i].id==resId){
						resAllCheck = resAllCheck && obj[i].checked
					}
				}
			}
			if(resAllCheck)
			{
				menuObj.checked = true;
			}
		
			//全选项已勾选，后面的操作取消一个则全选不勾选
			if(menuObj.checked==true && myself.checked==false)
			{
				menuObj.checked = false;
			}
		}
		
		function preCheck(operKey,myself,menuName)
		{
			var resId = myself.id;
			if(operKey!=''){
				//勾选操作时如果操作有依赖项则把依赖项也勾选
				var obj = document.getElementsByTagName("input");
				for(var i=0;i<obj.length;i++){
					if(obj[i].type=="checkbox"){
						if(obj[i].id==resId){
							var operValue=obj[i].value;
							var operValArray = operValue.split("~");
							if(operValArray!=null && operKey==operValArray[1]){
								if(myself.checked==true){
									obj[i].checked=true;
								}
							}
						}
					}
				}
			}else{
				//取消勾选依赖项自身时,如果仍有其它项依赖它，则提示不能取消。
				if(myself.checked==false){
					var obj = document.getElementsByTagName("input");
					for(var i=0;i<obj.length;i++){
						if(obj[i].type=="checkbox"){
							if(obj[i].checked==true){
								if(obj[i].id==resId){
									var operValue=obj[i].value;
									var operValArray = operValue.split("~");
									var operValArrayMy = myself.value.split("~");
									if(operValArray!=null && operValArrayMy!=null && operValArrayMy[1]==operValArray[2]){
										jAlert('warning', '其它操作依赖该操作，不能取消！', '提示');
										myself.checked = true;
										return;
									}
								}
							}
						}
					}
				}
			}
		
			//单行全选与后面操作的关系
			menuCheck(myself,menuName);
		}
	</script>
</head>

<body class="right_body">
<div class="path">您现在的位置： 首页 &gt; 模块管理 &gt; 系统管理员授权</div>
<s:form action="grant!adminGrant.action" method="post">
<div class="public_div">
	<h2>
		<span class="fl">授权信息</span> 
	  		<span class="fr">
	  			<input type="button" id="selectAll" value="全部展开" class="gray_button" onclick="displayAll()" />
	  			<input type="button" id="cancelAll" value="全部收缩" class="gray_button" onclick="hiddenAll()" />
	  		</span><!--  span里无内容时，此span不能删除  -->
     	</h2>
	<div class="public_inner div_bgcolor" id="divSys"> 
	<div class="inner_data div_bgcolor2"> 
	
 	<s:iterator value="menus" id="menu1">
 		<%-- 一级菜单开始 --%>
 		<div><h5><a href="javascript:;" onClick="javascript:hit('${menu1.menuId}')"><img src="../images/oneLevel.png"/><s:property value="menuName"/></a></h5></div>
		<div id="${menu1.menuId}">
			<s:iterator value="#menu1.subMenuList" id="menu2">
		 		<%-- 二级菜单 --%>
				<div><h6><a href="javascript:;" onClick="javascript:hit('${menu2.menuId}')"><img src="../images/twoLevel.png"/><s:property value="menuName"/></a></h6></div>
				<div id="${menu2.menuId}" style="margin:0px; padding:0px; height:100%; overflow:hidden;">
				<s:if test="%{#menu2.operList.size>0}">
					<table width="80%" border="0" cellspacing="0" cellpadding="0" class="table_l_m table_border">
						<!-- 设定每行显示的列数 -->
						<s:set var="colcount" value="4"/>
						<!-- 计算总行数开始 -->
						<s:if test="%{#menu2.operList.size%#colcount==0}">
							<s:set var="rowcount" value="%{#menu2.operList.size/#colcount}"/>
						</s:if> 		
						<s:else>
							<s:set var="rowcount" value="%{#menu2.operList.size/#colcount+1}"/>
						</s:else>
						<!-- 计算总行数开始 -->
						<s:if test="%{#rowcount>0}">
							<s:bean name="org.apache.struts2.util.Counter" id="counter">     
						    	<s:param name="first" value="1" />     
						    	<s:param name="last" value="#rowcount" />     
						    	<s:iterator>     
						    		<!-- 设定当前迭代的行数 -->
						    		<s:set var="curr" value="current-1"></s:set>
									<s:if test="%{#curr==1}">
								    <!-- 当前行为第一行时 -->
									<tr>
									<!-- 当前行为第一行时设定rowspan 开始 -->
										<s:if test="%{#rowcount>1}">
											<td width="20%" rowspan="${rowcount}">
										</s:if>
										<s:else>
											<td width="20%">
										</s:else>
										<!-- 当前行为第一行时设定rowspan 结束 -->
										<!-- 第一行增加全选 开始  -->
									    <table border="0" cellspacing="0" cellpadding="0">
											<tr>
						                    	<td>&nbsp;<img src="../images/icon_3.png" width="16" height="16" /> </td>
						                    	<td>&nbsp;全选 </td>
						                    	<td>&nbsp;<input id="${menu2.menuName}" name="operSelect" type="checkbox" value="${menu2.menuId}" onclick="fCheck('${menu2.menuId}',this)"/></td>
						                	</tr>
						              	</table>
										<!-- 第一行增加全选 结束 -->
									    </td>
										  <!-- 二级菜单的操作 -->
										  <s:subset source="#menu2.operList" start="0" count="%{#colcount}">
											  <s:iterator id="oper2" status="st">
										       	 <td width="20%" ><input name="orgRes" type="checkbox" id="${oper2.menuId}" value="${oper2.menuId}~${oper2.operKey}~${oper2.preKey}~${menu2.menuKey}" onclick="preCheck('${oper2.preKey}',this,'${menu2.menuName}')" class="v_m" <s:if test='selected=="Y"'>checked</s:if>  />${oper2.operName}</td>
											  </s:iterator>
										　</s:subset>
												 <!-- 补完最后一行的数据列不够时的TD 开始 (行一)-->
												 <s:if test="%{#curr==#rowcount}">
													 <s:if test="%{#menu2.operList.size%#colcount!=0}">
													 	<!-- 计算最后一行需要补充的TD数 -->
													 	<s:set var="blankCount" value="%{#colcount-(#menu2.operList.size-(#rowcount-1)*#colcount)}"></s:set>
													 	<s:bean name="org.apache.struts2.util.Counter" id="counter1">     
														    <s:param name="first" value="1" />     
														    <s:param name="last" value="#blankCount" />
														    <s:iterator>
														    	<td>&nbsp;</td>
														    </s:iterator>
														 </s:bean>    
													 </s:if>
												 </s:if>
												 <!-- 补完最后一行的数据列不够时的TD 结束  (行一)-->
											 </tr>
										</s:if>	 
										<s:else> 
											<tr>
												  <!-- 二级菜单的操作 -->
												 <s:subset source="#menu2.operList" start="%{#colcount*(#curr-1)}" count="%{#colcount}">
													 <s:iterator id="oper2" status="st">
												        <td width="20%" ><input name="orgRes" type="checkbox" id="${oper2.menuId}" value="${oper2.menuId}~${oper2.operKey}~${oper2.preKey}~${menu2.menuKey}" onclick="preCheck('${oper2.preKey}',this,'${menu2.menuName}')" class="v_m" <s:if test='selected=="Y"'>checked</s:if>  />${oper2.operName}</td>
													 </s:iterator>
												 </s:subset>
												 <!-- 补完最后一行的数据列不够时的TD 开始-->
												 <s:if test="%{#curr==#rowcount}">
													 <s:if test="%{#menu2.operList.size%#colcount!=0}">
													 	<!-- 计算最后一行需要补充的TD数 -->
													 	<s:set var="blankCount" value="%{#colcount-(#menu2.operList.size-(#rowcount-1)*#colcount)}"></s:set>
													 	<s:bean name="org.apache.struts2.util.Counter" id="counter1">     
														    <s:param name="first" value="1" />     
														    <s:param name="last" value="#blankCount" />
														    <s:iterator>
														    	<td>&nbsp;</td>
														    </s:iterator>
														 </s:bean>    
													 </s:if>
												 </s:if>
												 <!-- 补完最后一行的数据列不够时的TD 结束-->
											</tr>
										</s:else>
						    		</s:iterator>     
								 </s:bean>  
							</s:if>
				 		</table>
					</s:if>
				</div>
			</s:iterator>
			<%-- 二级菜单结束 --%>
		</div>
		<%-- 一级菜单结束 --%>
 	</s:iterator>
 	</div>	      	
</div>
<div class="button_div">
	<s:submit value="" cssClass="save_button"></s:submit>
</div>
</s:form>
<script language="javascript">
//处理页面加载完成后每一行的全选是否勾选
function handleSelect()
{
	var obj = document.getElementsByName("operSelect");
	var len = obj.length;
	for(var i=0;i<len;i++){
		var objS = obj[i];
		selAll(objS);
	}
}

function selAll(objS)
{	
	if(objS.type=="checkbox")
	{
		var objValResId = objS.value;
		var operSelectAll = true;
		var objOper = document.getElementsByName("orgRes");
		for(var i=0;i<objOper.length;i++){
			if(objOper[i].type=="checkbox"){
				var objOperIdVal = objOper[i].id;
				if(objValResId==objOperIdVal)
				{
					operSelectAll = operSelectAll && objOper[i].checked;
				}
			}
		}
		if(operSelectAll)
		{
			objS.checked=true;
		}
		
	}
}
handleSelect();
jQuery(function(){
	jQuery('.div_bgcolor2').find('div[id]').each(function(n){
		var cru = jQuery(this);
		hit(cru.attr('id'));
	});
})
</script> 
</body>
</html>