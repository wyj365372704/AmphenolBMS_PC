<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html >
<style type="text/css">
<!--
body,html{height:100%;}<!--  这是针对整个背景自适应高度的样式，不能删  -->
-->
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<link href="../css/userCenter.css" rel="stylesheet" type="text/css" />
</head>

<body class="center_body" onselectstart="return false">
<table  height="100%" border="0" cellpadding="0" cellspacing="0"   id="main_scroll" style=" cursor:e-resize;">
  <tr>
   <td width="10" id="main_leftScroll_bg" onselectstart="return false" style="text-align:center;"  ><a  href="#" onClick="changeState();" class="scroll_table_opened" id="leftIcon"></a></td>
  </tr>
</table>
</body>
</html>
<script type="text/javascript">
document.onmouseup=function(){
	parent.dragFlag=false;
}

document.onmousedown=function() {
	if(document.getElementById("leftIcon").className == "scroll_table_opened"){
		parent.dragFlag=true;
	}else{
		parent.dragFlag=false;
	}
}

document.onmousemove = function(){
    if ( parent.dragFlag==true){
		//parent.document.getElementById('exFra').cols = event.screenX -5 + ",12,*";
	}
}

function changeState() { 

if(document.getElementById("leftIcon").className == "scroll_table_opened"){
tempNum=parent.document.getElementById('exFra').cols;
//tempNum2=parent.exLeftFrame.document.getElementById("main_leftTab").clientWidth;

parent.document.getElementById('exFra').cols = "0,11,*";

document.getElementById("main_leftScroll_bg").style.borderLeft = "";
document.getElementById("leftIcon").className = "scroll_table_closed";
document.getElementById("main_scroll").style.cursor="default";
}else{
parent.document.getElementById('exFra').cols = tempNum;
//document.getElementById("leftIcon").src = "images/default/scroll_icon_opened.gif";
document.getElementById("leftIcon").className = "scroll_table_opened";
// parent.exLeftFrame.document.getElementById("main_leftTab").style.width=tempNum2;
document.getElementById("main_leftScroll_bg").style.borderLeft = "0";
document.getElementById("main_scroll").style.cursor="e-resize";
}
}

</script>