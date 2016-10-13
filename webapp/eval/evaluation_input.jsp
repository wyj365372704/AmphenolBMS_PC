<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>窗口评分建议</title>
		<link href="<s:url value="/css/evaluation.css"/>" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<s:url value="/js/jquery-1.4.2.min.js"/>"></script>
		<script type="text/javascript">
		function check(){
			var $res = $(":radio[name='evaluation.evalResult']:checked");
			if($res.length == 0){
				alert('请选择评分选项！');
				return;
			}
			if ($("[name='evaluation.evalSuggest']").val().length > 1000){
				alert("建议不允许超过1000个字符！");
				return;
			}
			$('form').submit();
		}
		</script>
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
						<a href="evaluation!listWindow.action"><img
								src="<s:url value="/images/list01_03.png"/>" alt="窗口评价"
								border="0" /> </a>
						<s:if test="#request.window != null">
							<span></span>
						</s:if>
					</li>
					<li>
						<a href="evaluation!listUser.action"><img
								src="<s:url value="/images/list01_05.png"/>" alt="关员评价"
								border="0" /> </a>
						<s:if test="#request.user != null">
							<span></span>
						</s:if>
					</li>
					<li>
						<a href="evaluation!listService.action"><img
								src="<s:url value="/images/list01_07.png"/>" alt="业务评价"
								border="0" /> </a>
						<s:if test="#request.service != null">
							<span></span>
						</s:if>
					</li>
				</ul>
				<s:form action="evaluation!insert.action" method="POST">
				<s:if test="#request.window != null">
					<div class="listbox">
						<div class="title">
							<h1>
								评分建议
							</h1>
						</div>
						<div class="conbox">
							<div class="detabox">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="detatab">
									<tr>
										<td colspan="2">
											<ul class="deta01">
												<li>
													<input type="hidden" name="evaluation.windowId" value="${window.id }">
													<input type="hidden" name="evaluation.orgId" value="${window.orgId }">
													<input type="hidden" name="evaluation.customsId" value="${window.parentOrg }">
													<input type="hidden" name="evaluation.evalType" value="1">
													<input type="hidden" name="evaluation.touchEvalType" value="W">
													<span><strong>窗　　口：</strong> ${window.name }</span>
													<span><strong>所属科室：</strong> ${window.orgName }</span>
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<td width="19%" align="right">
											评分选项：
										</td>
										<td width="81%">
											<s:radio name="evaluation.evalResult" list="#{4: '非常满意', 3: '满意', 2: '基本满意', 1: '不满意'}" listKey="key" listValue="value"></s:radio>
										</td>
									</tr>
									<tr>
										<td align="right" valign="top">
											您的建议：
										</td>
										<td>
											<label>
												<textarea name="evaluation.evalSuggest" cols="40" rows="7"></textarea>
											</label>
										</td>
									</tr>
									<tr>
										<td align="right">
											联系方式：
										</td>
										<td>
											<input name="evaluation.telephone" maxlength="20" type="text" value="" />
										</td>
									</tr>

								</table>
								<div class="buttonbox">
									<input type="button" value="提 交" onclick="check()" />

									<input name="button" type="button"
										onclick="location.href='javascript:history.go(-1);'"
										value="返 回" />
								</div>
							</div>
						</div>
						<div class="bottom"></div>
					</div>
				</s:if>
				<s:if test="#request.user != null">
					<div class="listbox">
						<div class="title">
							<h1>
								评分建议
							</h1>
						</div>
						<div class="conbox">
							<div class="detabox">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="detatab">
									<tr>
										<td colspan="2">
											<ul class="deta02">
												<li>
													<img width="60" height="80" src="<%=request.getContextPath()%>/user!viewPhoto.action?user.userId=${user.userId }" border="0"/>
													<span><strong>姓　　名：</strong> ${user.realName} </span>
													<span><strong>关员工号：</strong> ${user.employeeNumber}</span>
													<span><strong>所在部门：</strong> ${user.orgName } </span>
													<span><strong>办公电话：</strong> ${user.telephone}</span>
													<span><strong>职　　务：</strong> ${user.position } </span>
													<span><strong>性　　别：</strong> ${user.sex=='M'?'男':user.sex=='F'?'女':'未知'}</span>
												</li>
											</ul>
											<input type="hidden" name="evaluation.userName" value="${user.userName }">
											<input type="hidden" name="evaluation.orgId" value="${user.orgId }">
											<input type="hidden" name="evaluation.customsId" value="${user.customsId }">
											<input type="hidden" name="evaluation.evalType" value="1">
											<input type="hidden" name="evaluation.touchEvalType" value="P">
										</td>
									</tr>
									<tr>
										<td width="19%" align="right">
											评分选项：
										</td>
										<td width="81%">
											<s:radio name="evaluation.evalResult" list="#{4: '非常满意', 3: '满意', 2: '基本满意', 1: '不满意'}" listKey="key" listValue="value"></s:radio>
										</td>
									</tr>
									<tr>
										<td align="right" valign="top">
											您的建议：
										</td>
										<td>
											<label>
												<textarea name="evaluation.evalSuggest" cols="40" rows="7"></textarea>
											</label>
										</td>
									</tr>
									<tr>
										<td align="right">
											联系方式：
										</td>
										<td>
											<input name="evaluation.telephone" maxlength="20" type="text" value="" />
										</td>
									</tr>

								</table>
								<div class="buttonbox">
									<input type="button" value="提 交" onclick="check()" />

									<input name="button" type="button"
										onclick="location.href='javascript:history.go(-1);'"
										value="返 回" />
								</div>
							</div>
						</div>
						<div class="bottom"></div>
					</div>
				</s:if>
				<s:if test="#request.service != null">
					<div class="listbox">
						<div class="title">
							<h1>
								评分建议
							</h1>
						</div>
						<div class="conbox">
							<div class="detabox">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="detatab">
									<tr>
										<td colspan="2">
											<ul class="deta01">
												<li>
													<input type="hidden" name="evaluation.customsId" value="${service.orgId }">
													<input type="hidden" name="evaluation.serviceId" value="${service.serviceId }">
													<input type="hidden" name="evaluation.evalType" value="1">
													<input type="hidden" name="evaluation.touchEvalType" value="S">
													<span><strong>业务名称：</strong> ${service.serviceName} </span>
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<td width="19%" align="right">
											评分选项：
										</td>
										<td width="81%">
											<s:radio name="evaluation.evalResult" list="#{4: '非常满意', 3: '满意', 2: '基本满意', 1: '不满意'}" listKey="key" listValue="value"></s:radio>
										</td>
									</tr>
									<tr>
										<td align="right" valign="top">
											您的建议：
										</td>
										<td>
											<label>
												<textarea name="evaluation.evalSuggest" cols="40" rows="7"></textarea>
											</label>
										</td>
									</tr>
									<tr>
										<td align="right">
											联系方式：
										</td>
										<td>
											<input name="evaluation.telephone" maxlength="20" type="text" value="" />
										</td>
									</tr>

								</table>
								<div class="buttonbox">
									<input type="button" value="提 交" onclick="check()" />

									<input name="button" type="button"
										onclick="location.href='javascript:history.go(-1);'"
										value="返 回" />
								</div>
							</div>
						</div>
						<div class="bottom"></div>
					</div>
				</s:if>
				</s:form>
			</div>
		</div>
	</body>
</html>