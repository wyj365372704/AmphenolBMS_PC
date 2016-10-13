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


<div class="dtree" id="asgardCard">
 	<script type="text/javascript">
	 	<s:iterator value="listTree" id="orgVO" status="st">
	 		<s:if test="%{#st.index==0}">
	 			tree = new dTree('tree',${orgVO.parentOrg-1});
				tree.add(${orgVO.parentOrg},${orgVO.parentOrg-1},'  机构树','','','exMainTFrame2');
	 		</s:if>
			tree.add(${orgVO.orgId},${orgVO.parentOrg},"${orgVO.orgName}",'org!view.action?org.orgId=${orgVO.orgId}','','exMainTFrame2');	
	 	</s:iterator>
		document.write(tree);
	</script>
</div>
</div>
</body>
</html>
