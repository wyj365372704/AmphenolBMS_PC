<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="hgpj" uri="http://www.eclink.com.cn/hgpj/permission" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深圳海关服务评价系统</title>
<link href="./css/userCenter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="./js/TabPanel.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("div h2").bind("click",function(){
			if ($(this).attr("class")=='out') {
				$(this).removeClass("out").addClass("on");
			} else {
				$("div h2.out").removeClass("out").addClass("on");
				$(this).removeClass("on").addClass("out");
			}
		});
		
		$("li").bind("click",function(){
			if ($(this).attr("class")=="li_opt") {
				$(this).removeClass("li_opt");
			} else {
				$("li").removeClass("li_opt");
				$(this).addClass("li_opt");
			}
		});
		
		jQuery('.menu').find('li').find('a').bind("click",function(){
			var a = $(this), url = a.data('url');
			if(url == null){
				url = a.attr('href');
				a.data('url', url);
			}
			setTimeout(function(){
				a.attr("href","javascript:void(0);");
				setTimeout(function(){
					a.attr('href',url);
				},2000);
			},100);			
		});
	});
	
   function showHide(obj){
      var oStyle = document.getElementById(obj).style;
      oStyle.display == "none" ? oStyle.display = "block" : oStyle.display = "none";
     
      if(oStyle.display == "block")
      {
          var elseTableElement = document.getElementsByTagName("ul");
          if(elseTableElement)
          {
              for(var i=0;i<elseTableElement.length;i++)
              {
                if(elseTableElement.item(i).id != obj)
                {
                    if( elseTableElement.item(i).style.display=="block")
                    {
                        elseTableElement.item(i).style.display = "none";
                        break;
                    }
                }
              }
          }
      }
    }
</script>


</head>

<body class="left_body">

	<div class="left_title"></div>
	
	<div class="menu">
		<s:iterator value="menus" id="res1">
			<h2 class="on" onClick="JavaScript:showHide('<s:property value="menuKey"/>');"><span><s:property value="menuName"/></span></h2>
			<s:if test="%{#res1.subMenuList.size>0}">
				<ul id='<s:property value="menuKey"/>' style="DISPLAY: none">
				<s:iterator value="#res1.subMenuList">
					<li><a href="<%=request.getContextPath() %><s:property value='menuUrl'/>" target="exMainTFrame"><span><s:property value="menuName"/></span></a></li>
				</s:iterator>
				</ul>
			</s:if>
		</s:iterator>
	</div>


</body>
</html>
