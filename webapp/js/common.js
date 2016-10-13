function dosubmit(){
	var goPagePattern=/^([1-9]|([1-9]\d+))$/;
	var pageSizePattern=/^[1-9]$|(^[1-9]\d$)/;
	if(!pageSizePattern.test($("[name=pageSize]").val())) {
		 alert('每页条数只能为1~99范围内的整数，请重新输入！');
		 return false;
	 }
	 if(!goPagePattern.test($("[name=goPage]").val())) {
		 alert('到指定页只能为大于0的整数，请重新输入！');
		 return false;
	 }
	 if(parseInt($("[name=goPage]").val())>2147483647){
	 	$("[name=goPage]").val(2147483647);
	 }
	return true;
}

//获取客户端登录域名
function getDomainName(){
	var domainName;
	try{
		var obj = new ActiveXObject("WScript.Shell");
		var str = "HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\DefaultDomainName";
		domainName = obj.RegRead(str);
	}catch(e){
		domainName = "";
	} 
	return domainName;
}

//获取客户端登录帐号
function getDomainUser(){
	var userName;
	try{
		var obj = new ActiveXObject("WScript.Shell");
		var str = "HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Winlogon\\DefaultUserName";
		userName = obj.RegRead(str);
	}catch(e){
		userName = "";
	} 
	return userName;
}