<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<link href="../css/global.css" rel="stylesheet" type="text/css" />
<link href="../css/dtree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/dtree.js"></script>
</head>

<body class="org_body">
<div class="role_tree">


<div class="dtree" id="resTree">
	
	<script type="text/javascript">
		tree = new dTree('tree',-1);
		tree.add(0,-1,'  系统菜单资源','<%=request.getContextPath() %>/resource/resource!viewMenu.action','','exMainTFrame2');
		<s:iterator value="resources" id="res1">
			tree.add(${res1.menuId},0,'${res1.menuName}','<%=request.getContextPath() %>/resource/resource!viewMenu.action?menu.menuId=${res1.menuId}','','exMainTFrame2');
			<s:iterator value="#res1.subMenuList" id="res2">
				tree.add(${res2.menuId},${res1.menuId},'${res2.menuName}','<%=request.getContextPath() %>/resource/resource!viewMenu.action?menu.menuId=${res2.menuId}','','exMainTFrame2');
				<s:iterator value="#res2.operList" id="oper" status="cur">
					tree.add(${cur.index+99999},${res2.menuId},'${oper.operName}','<%=request.getContextPath() %>/operation/operation!view.action?oper.operKey=${oper.operKey}&oper.menuId=${oper.menuId}','','exMainTFrame2');
				</s:iterator>	
			</s:iterator>
		</s:iterator>	
	document.write(tree);
	</script>
</div>
</div>
</body>
</html>
