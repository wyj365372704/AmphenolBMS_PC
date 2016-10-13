<!-- 授权页面：显示所有权限信息：特殊功能禁止勾选 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 	  <h2> <span class="fl">授权信息</span> 
 	  <span class="fr">
 	  	<input type="button" id="selectAll" value="" onclick="fCheckAll()" class="checkall_button"/>
 	  	<input type="button" id="cancelAll" value="" onclick="fUnCheckAll()" class="cancelselect_button"/>
 	  	<input type="button" id="selectAll" value="全部展开" class="gray_button" onclick="displayAll()" />
 	  	<input type="button" id="cancelAll" value="全部收缩" class="gray_button" onclick="hiddenAll()" />
 	  </span>
          <!--  span里无内容时，此span不能删除  -->
      </h2>
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
	if(type==2){
		//批量添加权限的操作与企业开户的JS一样：1、勾选操作时如果操作有依赖项则把依赖项也勾选；2、取消勾选依赖项自身时,如果仍有其它项依赖它，则提示不能取消。
		//批量删除权限的操作：1、勾选依赖项则将被依赖项全勾选；2、第1步操作后如果去除被依赖项则提示依赖项已去除，留着没意义，继续勾选
		var resId = myself.id;
		//勾选依赖项则将被依赖项全勾选
	    if(myself.checked==true){
	      var obj = document.getElementsByTagName("input");
	      for(var i=0;i<obj.length;i++){
	        if(obj[i].type=="checkbox"){
	            if(obj[i].id==resId){
	              var operValue=obj[i].value;
	              var operValArray = operValue.split("~");
	              var operValArrayMy = myself.value.split("~");
	              if(operValArray!=null && operValArrayMy!=null && operValArrayMy[1]==operValArray[2]){
	               	 obj[i].checked = true;
	              }
	            }
	        }
	      }
	    }	   
	
		//依赖与被依赖全勾选时，此时不勾选被依赖项提示依赖项已勾选，自己也得必须勾选
	    if(myself.checked==false){
	        if(operKey!='')
	        {
	        	 var obj = document.getElementsByTagName("input");
	             for(var i=0;i<obj.length;i++){
	               if(obj[i].type=="checkbox"){
	                   if(obj[i].id==resId){
	                	   var operValue=obj[i].value;
	                	   var operValArray = operValue.split("~");
	                	   if(operValArray!=null && operKey==operValArray[1]){
	                    	   if(obj[i].checked == true)
	                    	   {
	                    		  jAlert('warning', '当前操作所依赖的操作已勾选，不能取消！', '提示');
	                    		  myself.checked = true;
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
    else
    {
        pCheck(operKey,myself);
        
        //单行全选与后面操作的关系
    	menuCheck(myself,menuName);
    }

	

    
	
}

function pCheck(operKey,myself){
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

</script> 
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
