<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>深圳海关服务评价系统</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.livequery.js"></script>
		<link href="../css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/validator/easy_validator.pack.js"></script>
		<script type="text/javascript" src="../js/validator/jquery.bgiframe.min.js"></script>
		<link  href="../css/validate.css" rel="stylesheet" type="text/css" />
		<script src="../js/alert/jquery.ui.draggable.js" type="text/javascript"></script>    
		<script src="../js/alert/jquery.alerts.js" type="text/javascript"></script>
		<link href="../js/alert/alerts.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			$(document).ready(function(){
			    // 添加单元表格行信息
			    $("#addOper").bind("click",function(){
			      var template = $("<tr></tr>").append($("#operList tr:last").html());
			      $("#operList").append(template);
			      template.find("input[name='addresses.addressName']").val('');
			      template.find("input[name='addresses.addressUrl']").val('');
			    });
				
			    // 删除单元格行信息
				$(".button_userdelete").livequery(function(){
					 $(this).bind("click",function(){
					 	var t = $(this);
					 	var count = $("#operList>tbody>tr:not(:first)").length;
					 	if (count < 2) {
					 		jConfirm("资源操作必须包含一个以上操作地址！", "提示框",function(){});		
					 		return;
					 	}
					 	jConfirm("删除操作地址，您确认吗？", "提示框", function(r) {
				          	if(r){
				          		t.parent().parent().remove();
				          	}
				        });
				    });
				});
			});
			
			function doSubmit(){
				var i = 0;
				$("#operList>tbody>tr:not(:first)").each(function(){
					$(this).find("input[name^='addresses']").each(function(){
						var $name=$(this).attr("name");
						var prefix = $name.substr(0,"addresses".length);
						var suffix = $name.substr($name.indexOf("."));
						$(this).attr("name",prefix+"["+i+"]"+suffix);
					});
					i++;
				})
			}
		</script>
	</head>

	<body>
	<s:form action="/operation/operation!modify.action" method="post" onsubmit="return doSubmit()">
		<div class="top_button_div"></div>
		<div class="public_div">
			<h2>
				<span class="fl">操作信息</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>

			<div class="public_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="public_table">
					<tr>
						<td class="td_w_s text_r">所属菜单：</td>
						<td>
							<input type="text" name="oper.menuName" class="input_s_1"
								value="<s:property value='oper.menuName'/>" disabled="true" />
							<input type="hidden" name="oper.menuId" value="<s:property value='oper.menuId'/>" />
							<input type="hidden" name="oper.orderKey" value="<s:property value='oper.orderKey'/>" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">操作名称：</td>
						<td>
							<input type="text" name="oper.operName" class="input_s_1"
								value="<s:property value='oper.operName'/>" maxlength="10" reg="^\S+$" tip="操作名称为必填项" />
							<span class="red">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">操作KEY：</td>
						<td>
							<input type="text" name="oper.operKey" class="input_s_1"
								value="<s:property value='oper.operKey'/>" disabled="true" />
							<input type="hidden" name="oper.operKey" value="<s:property value='oper.operKey'/>" />
						</td>
					</tr>
					<tr>
						<td class="td_w_s text_r">依赖操作KEY：</td>
						<td>
							<input type="text" name="oper.preKey" class="input_s_1"
								value="<s:property value='oper.preKey'/>" />
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="data_list">
			<h2>
				<span class="fl">操作地址列表</span>
				<span class="fr">
					<input type="button" id="addOper" value="添加" class="gray_button"/>
				</span><!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="list_inner">
				<table id="operList" width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
				  <tr>
					<th>地址名称</th>
					<th>地址URL</th>
					<th>操作</th>
			      </tr>
			      <s:iterator value="oper.addressList" status="st">
			       <s:if test="#st.Even">
			      		<tr class="td_bgcolor">
			      	</s:if>
			      	<s:else>
			      		<tr>
			      	</s:else>
						<td>
							<input type="text" name="addresses.addressName" class="input_s_1"
								value="<s:property value='addressName'/>" maxlength="15" reg="^\S+$" tip="地址名称为必填项" />
							<input type="hidden" name="addresses.addressId" value="<s:property value='addressId'/>" />
							<input type="hidden" name="addresses.menuId" value="<s:property value='menuId'/>" />
							<input type="hidden" name="addresses.operKey" value="<s:property value='operKey'/>" />
						</td>
					    <td>
					    	<input type="text" name="addresses.addressUrl" class="input_s_1"
								value="<s:property value='addressUrl'/>" maxlength="128" reg="^\S+$" tip="地址URL为必填项" />
					    </td>
					    <td>
					    	<input name="" type="button" class="button_userdelete" title="删除" />
					    </td>
				      </tr>
			      </s:iterator>
			  </table>	
			</div>
		</div>
		
		<div class="button_div">
		  <s:submit value="" cssClass="save_button"></s:submit><s:reset value="" cssClass="purge_button2"></s:reset><input name="back" type="button" class="return_button" onclick="history.go(-1)" />
		</div>
	</s:form>
	</body>
</html>
