<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>深圳海关服务评价系统</title>
		<link href="<s:url value="/css/evaluation.css"/>" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<div id="header">
			<div class="con02">
				<div class="logo"><img src="<s:url value="/images/logozi.png"/>" /></div>
				<div class="exit"><p>欢迎您，${userMap.name }（${userMap.idCardNo }）</p> <span><a href="evaluation!logout.action">退出</a></span></div>
			</div>
		</div>
		<div class="warp">
			<div class="list01">
				<ul class="menubox">
					<li>
						<a href="evaluation!listWindow.action"><img src="<s:url value="/images/list01_03.png"/>" alt="窗口评价"
								border="0" />
						</a>
						<s:if test="#request.windows != null">
						<span></span>
						</s:if>
					</li>
					<li>
						<a href="evaluation!listUser.action"><img src="<s:url value="/images/list01_05.png"/>" alt="关员评价"
								border="0" />
						</a>
						<s:if test="#request.users != null">
						<span></span>
						</s:if>
					</li>
					<li>
						<a href="evaluation!listService.action"><img src="<s:url value="/images/list01_07.png"/>" alt="业务评价"
								border="0" />
						</a>
						<s:if test="#request.services != null">
						<span></span>
						</s:if>
					</li>
				</ul>
				<s:if test="#request.windows != null">
					<div class="listbox">
						<div class="title">
							<h1>
								窗口评价列表
							</h1>
						</div>
						<div class="conbox">
							<ul class="listul01">
								<s:iterator value="#request.windows">
								<li>
									<a href="evaluation!toInsert.action?windowId=${id }">
									<table border="0" width="100%">
										<tr>
											<td width="50%"><span><strong>窗　　口：</strong> ${name }</span></td>
											<td width="50%"><span><strong>所属科室：</strong> ${orgName }</span></td>
										</tr>
									</table>
									</a>
								</li>
								</s:iterator>
							</ul>
						</div>
						<div class="bottom"></div>
					</div>
				</s:if>
				<s:if test="#request.users != null">
					<div class="listbox">
						<div class="title">
							<h1>
								关员评价列表
							</h1>
						</div>
						<div class="conbox">
							<ul class="listul02">
								<s:iterator value="#request.users">
								<li>
									<a href="evaluation!toInsert.action?userId=${userId }">
											<img width="60" height="80" src="<%=request.getContextPath()%>/user!viewPhoto.action?user.userId=<s:property value='userId' />" border="0"/>
											<span><strong>姓　　名：</strong> ${realName } </span> 
											<span><strong>性　　别：</strong> ${sex=='M'?'男':sex=='F'?'女':'未知'}</span>
											<span><strong>关员工号：</strong> ${employeeNumber}</span> 
											<span><strong>所在部门：</strong> ${orgName } </span> 
											<span><strong>职　　务：</strong> ${position } </span> 
											<span><strong>办公电话：</strong> ${telephone}</span> 
									</a>
								</li>
								</s:iterator>
							</ul>
						</div>
						<div class="bottom"></div>
					</div>
				</s:if>
				<s:if test="#request.services != null">
					<div class="listbox">
						<div class="title">
							<h1>
								业务评价列表
							</h1>
						</div>
						<div class="conbox">
							<ul class="listul01">
								<s:iterator value="#request.services">
								<li>
									<a href="evaluation!toInsert.action?serviceId=${serviceId }&orgId=${orgId }">
											<span><strong>业务名称：</strong> ${serviceName } </span> 
									</a>
								</li>
								</s:iterator>
							</ul>
						</div>
						<div class="bottom"></div>
					</div>
				</s:if>
			</div>
		</div>
	</body>
</html>