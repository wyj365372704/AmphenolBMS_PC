<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://www.eclink.com.cn/dfcm/paginator" prefix="page"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://www.eclink.com.cn/hgpj/permission" prefix="hgpj"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'printPage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table width="100%" cellpadding="5px" border="1"
		style="border-collapse: collapse;">
		<tr>
			<td>
				<table width="100%" border="0">
					<tr>
						<td align="center" colspan="4"><span
							style="font-weight: bold;font-size:18px;"> <s:if
									test="language == 0">
									<s:property value="zbmsctl.nmchs" />
								</s:if> <s:else>
									<s:property value="zbmsctl.nmeng" />
								</s:else> </span>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<table width="100%">
								<tr>
									<td nowrap="nowrap"><s:if test="language == 0">
											仓库:
										</s:if> <s:else>
											Warehouse:
										</s:else></td>
									<td width="50%" align="left"><s:property
											value="pomast.house" />
									</td>
									<td nowrap="nowrap"><s:if test="language == 0">
											订单日期:
										</s:if> <s:else>
											Order date:
										</s:else></td>
									<td width="50%" align="left"><s:property
											value="pomast.actdts" />
									</td>
								</tr>
							</table>
						</td>

						<td colspan="2"><s:property value="pomast.ordno" />-<s:property
								value="pomast.revnb" />
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap"><s:if test="language == 0">
											送货地:
										</s:if> <s:else>
											Ship To:
										</s:else></td>
						<td width="50%"><table>
								<tr align="left">
									<td><s:property value="pomast.sn35" />
									</td>
								</tr>
								<tr align="left">
									<td><s:property value="pomast.s135" /> <s:property
											value="pomast.s235" />
									</td>
								</tr>
							</table>
						</td>
						<td nowrap="nowrap"><s:if test="language == 0">
											供货方:
										</s:if> <s:else>
											Supplier:
										</s:else></td>
						<td width="50%" align="left"><s:property value="pomast.vndnr" />
							<s:property value="vennam.vn35" />
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap"><s:if test="language == 0">
											采购员:
										</s:if> <s:else>
											Buyer:
										</s:else></td>
						<td align="left"><s:property value="pomast.buyno" /> <s:property
								value="buynm" />
						</td>
						<td nowrap="nowrap"><s:if test="language == 0">
											联系人:
										</s:if> <s:else>
											Contact:
										</s:else>
						</td>
						<td align="left"><s:property value="vennam.vcont" />
						</td>
					</tr>
					<tr>
						<td rowspan="2" nowrap="nowrap"><s:if test="language == 0">
											开票抬头:
										</s:if> <s:else>
											Bill To:
										</s:else>
						</td>
						<td rowspan="2"><table width="100%">
								<tr>
									<td align="left"><s:property value="shpmst.shpnm" />
									</td>
								</tr>
								<tr>
									<td align="left"><s:property value="shpmst.s135" /> <s:property
											value="shpmst.s235" />
									</td>
								</tr>
							</table>
						</td>
						<td><s:if test="language == 0">
											币种:
										</s:if> <s:else>
											Currency:
										</s:else>
						</td>
						<td><table border="0" width="100%" cellpadding="0"
								cellspacing="0">
								<tr>

									<td align="left" width="50%"><s:if
											test="pomast.curid!='   '">
											<s:property value="pomast.curid" />
										</s:if> <s:elseif test="zbmsctl.curid!='   '">
											<s:property value="zbmsctl.curid" />
										</s:elseif> <s:else>CNY</s:else></td>
									<td nowrap="nowrap"><s:if test="language == 0">
											税率:
										</s:if> <s:else>
											Tax Rate:
										</s:else>
									</td>
									<td align="left" width="50%"><s:property value="txsuf" />
									</td>
								</tr>

							</table>
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap"><s:if test="language == 0">
											付款条款:
										</s:if> <s:else>
											Terms:
										</s:else>
						</td>
						<td align="left" colspan="3"><s:property value="pomast.trmds" />
						</td>
					</tr>
					<tr>
						<td nowrap="nowrap"><s:if test="language == 0">
											联系人:
										</s:if> <s:else>
											Contact:
										</s:else>
						</td>
						<td align="left"><s:property value="shpmst.scont" />
						</td>
						<td nowrap="nowrap"><s:if test="language == 0">
											运输方式:
										</s:if> <s:else>
											Ship Via:
										</s:else>
						</td>
						<td align="left"><s:property value="pomast.viads" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%">
					<tr>
						<td>
							<table border="1" width="100%" cellpadding="5px"
								style="border-collapse: collapse;">
								<s:set var="count" value="0"></s:set>
								<s:set var="total" value="0"></s:set>
								<tr align="center">
									<td><s:if test="language == 0">
											序号
										</s:if> <s:else>
											No.
										</s:else>
									</td>
									<td><s:if test="language == 0">
											料号 / 描述 / 交货日期 / 备注
										</s:if> <s:else>
											Item / Description / Delivery date / Comments
										</s:else>
									</td>
									<td><s:if test="language == 0">
											数量
										</s:if> <s:else>
											Quantity
										</s:else>
									</td>
									<td><s:if test="language == 0">
											单价
										</s:if> <s:else>
											Price
										</s:else>
									</td>
									<td><s:if test="language == 0">
											金额
										</s:if> <s:else>
											Amount
										</s:else>
									</td>
								</tr>
								<s:iterator value="pomast.poitemList" var="poitem" status="st">
									<s:if test="#poitem.staic == \"50\" && chk01 == \"false\""></s:if>
									<s:else>
										<s:if test="#poitem.staic == \"99\" && chk03 == \"false\""></s:if>
										<s:else>
											<tr align="center">
												<td><s:property value="#st.count" /></td>
												<td>
													<table border="0" width="100%">
														<tr align="center">
															<td colspan="2"><s:property value="#poitem.itnbr" />{<s:property
																	value="#poitem.itdsc" />}</td>

														</tr>

														<s:if test="#poitem.blcod==\"1\"">
															<s:if
																test="#poitem.poblktList.size == 0 && && chk02 == \"false\""></s:if>
															<s:else>
																<tr align="center">
																	<td><s:if test="language == 0">
											交货日期
										</s:if> <s:else>
											Delivery date
										</s:else></td>
																	<td><s:if test="language == 0">
											交货数量
										</s:if> <s:else>
											Release Quantity
										</s:else></td>
																</tr>
																<s:iterator value="#poitem.poblktList" var="poblkt">
																	<s:if
																		test="#poblkt.staic == \"50\" && chk01 == \"false\""></s:if>
																	<s:else>
																		<s:if
																			test="#poblkt.staic == \"99\" && chk01 == \"false\""></s:if>
																		<s:else>
																			<tr align="center">
																				<td><s:property value="#poblkt.dokdts" />
																				</td>
																				<td><s:property value="#poblkt.relqt" />
																				</td>
																			</tr>
																		</s:else>
																	</s:else>
																</s:iterator>
															</s:else>

														</s:if>
														<s:else>
															<tr>
																<td colspan="2" align="center"><s:if
																		test="language == 0">
											交货日期:
										</s:if> <s:else>
											Delivery date:
										</s:else> <s:property value="#poitem.dokdts" />
																</td>
															</tr>
														</s:else>

													</table>
												</td>
												<td><s:property value="#poitem.ucorq" /></td>
												<td><s:property value="#poitem.curpr" /></td>
												<s:set var="total" value="#total+#poitem.ucorq"></s:set>
												<s:set var="count"
													value="#count+#poitem.ucorq*#poitem.curpr"></s:set>
												<td><fmt:formatNumber
														value="${poitem.ucorq*poitem.curpr}" pattern="#0.0000" />
												</td>
											</tr>
										</s:else>
									</s:else>

								</s:iterator>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<table width="100%">
								<tr align="center">
									<td><s:if test="language == 0">
											数量合计:
										</s:if> <s:else>
											Quantity:
										</s:else> <fmt:formatNumber value="${total }" pattern="#0.0000" />
									</td>
									<td><s:if test="language == 0">
											采购金额:
										</s:if> <s:else>
											Purchase amount:
										</s:else> <fmt:formatNumber value="${count }" pattern="#0.0000" />
									</td>
									<td><s:if test="language == 0">
											税额:
										</s:if> <s:else>
											Tax amount:
										</s:else> <fmt:formatNumber value="${count }" pattern="#0.0000" /></td>
									<td><s:if test="language == 0">
											税价合计:
										</s:if> <s:else>
											Amount total:
										</s:else> <fmt:formatNumber value="${count }" pattern="#0.0000" />
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</td>

		</tr>
		<tr>
			<td>
				<p>
					<s:if test="language == 0">
											条款说明:
										</s:if>
					<s:else>
											Remark.
										</s:else>
				</p>
				<p>
					<s:if test="language == 0">
											1.本合约书系立约双方(本公司、供应商)同意订立。
										</s:if>
					<s:else>
											Please be note that your parts should be ROHS comliant.
										</s:else>
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%">
					<tr align="center">
						<s:if test="language == 0">
							<td  width="33%">核准:</td>
							<td width="33%">审核:</td>
							<td width="33%">采购员:</td>
						</s:if>
						<s:else>
							<td width="50%">Authorized By</td>
							<td width="50%">Supplier Acceptance</td>
						</s:else>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>