<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>深圳海关服务评价系统</title>
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<link href="../css/global.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function moveUp(obj)
			{
			    var current=$(obj).parent().parent();
			    var prev=current.prev();
			    if(current.index()>1)
			    {
			        current.insertBefore(prev);
			    }
			}
			function moveDown(obj)
			{
			    var current=$(obj).parent().parent();
			    var next=current.next();
			    if(next)
			    {
			        current.insertAfter(next);
			    }
			}
			function doSubmit()
			{
				var i = 0;
				$(".operationOrder").each(function(){
					i=i+1;
					$(this).val(i);
				})
			}
		</script>
	</head>

	<body>
	<div class="search"></div>
	<s:form action="/operation/operation!sort.action" method="post" onsubmit="return doSubmit()">
		<div class="data_list">
			<h2>
				<span class="fl">资源操作顺序</span>
				<span class="fr"></span><!--  span里无内容时，此span不能删除  -->
			</h2>
			<div class="list_inner">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" class="list_table_s">
				  <tr>
					<th>操作名称</th>
					<th>操作KEY</th>
					<th>调整顺序</th>
			      </tr>
			      <s:iterator value="operations" status="st">
			      	<tr>
						<td>
							<s:property value="operName"/>
							<input type="hidden" name="operations[${st.index }].menuId" value="<s:property value='menuId'/>" />
							<input type="hidden" name="operations[${st.index }].operName" value="<s:property value='operName'/>" />
							<input type="hidden" name="operations[${st.index }].operKey" value="<s:property value='operKey'/>" />
							<input type="hidden" name="operations[${st.index }].preKey" value="<s:property value='preKey'/>" />
							<input type="hidden" class="operationOrder" name="operations[${st.index }].orderKey" value="<s:property value='orderKey'/>" />
						</td>
						<td><s:property value="operKey"/></td>
					    <td>
					    	<img src="../images/arrow_up.gif" alt="上移" onclick="moveUp(this)" />&nbsp;&nbsp;
					    	<img src="../images/arrow_down.gif" alt="下移" onclick="moveDown(this)" />
					    </td>
				    </tr>
			      </s:iterator>
			  </table>	
			</div>
		</div>
		
		<div class="button_div">
		  <s:submit value="" cssClass="save_button"></s:submit><input name="back" type="button" class="return_button" onclick="history.go(-1)" />
		</div>
	</s:form>
	</body>
</html>
