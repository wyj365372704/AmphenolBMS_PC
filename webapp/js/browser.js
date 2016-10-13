 var Sys = {};
	    var ua = navigator.userAgent.toLowerCase();
	    var s;
	    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
	    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
	    (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
	    (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
	    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
	
	    //判断浏览器类型：测试
	    //if (Sys.ie) document.write('IE: ' + Sys.ie);
	    //if (Sys.firefox) document.write('Firefox: ' + Sys.firefox);
	    //if (Sys.chrome) document.write('Chrome: ' + Sys.chrome);
	    //if (Sys.opera) document.write('Opera: ' + Sys.opera);
	    //if (Sys.safari) document.write('Safari: ' + Sys.safari);
	   
function ismaxlength(obj)
{
	//针对IE浏览器不支持MAXLENGTH时使用
	if(Sys.ie){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
			alert('该文本框允许输入最大长度为'+mlength+"个字符,超出内容将会被截断")
			obj.value=obj.value.substring(0,mlength)
	}
}

function imposeMaxLength(obj)
{
	//针对IE浏览器不支持MAXLENGTH时使用
	if(Sys.ie){
	  var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	  return (obj.value.length <mlength);
	}
}