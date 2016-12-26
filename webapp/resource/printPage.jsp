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

<title>采购订单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	window.resizeTo(1000, 800);
</script>
<body>
	<s:if test="resultMap.outSource == true">
		<!-- 为外协订单 -->
		<s:iterator value="resultMap.item" var="son1" status="st">
			<table width="100%" cellpadding="5px" border="1"
				style="border-collapse: collapse;">
				<tr>
					<td>
						<table width="100%" border="0">
							<tr>
								<td align="center" colspan="4"><span
									style="font-weight: bold;font-size:18px;"> <s:if
											test="language == 0">
											<s:property value="resultMap.nmchs" />
										</s:if> <s:else>
											<s:property value="resultMap.nmeng" />
										</s:else> </span>
								</td>
							</tr>
							<tr>
								<td align="center" colspan="4"><span
									style="font-weight: bold;font-size:18px;"><s:if
											test="language == 0">外协采购订单</s:if><s:else>Subcontract Purchase Order</s:else></span>
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
													value="resultMap.house" />
											</td>
											<td nowrap="nowrap"><s:if test="language == 0">
											订单日期:
										</s:if> <s:else>
											Order date:
										</s:else></td>
											<td width="50%" align="left"><s:property
													value="resultMap.actdts" />
											</td>
										</tr>
									</table>
								</td>

								<td colspan="2"><s:property value="resultMap.ordno" />-<s:property
										value="resultMap.revnb" />
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
											<td><s:property value="resultMap.sn35" />
											</td>
										</tr>
										<tr align="left">
											<td><s:property value="resultMap.s135" /> <s:property
													value="resultMap.s235" />
											</td>
										</tr>
									</table>
								</td>
								<td nowrap="nowrap"><s:if test="language == 0">
											供货方:
										</s:if> <s:else>
											Supplier:
										</s:else></td>
								<td width="50%" align="left"><s:property
										value="resultMap.vndnr" /> <s:property value="resultMap.vn35" />
								</td>
							</tr>
							<tr>
								<td nowrap="nowrap"><s:if test="language == 0">
											采购员:
										</s:if> <s:else>
											Buyer:
										</s:else></td>
								<td align="left"><s:property value="resultMap.buyno" /> <s:property
										value="resultMap.buynm" />
								</td>
								<td nowrap="nowrap"><s:if test="language == 0">
											联系人:
										</s:if> <s:else>
											Contact:
										</s:else>
								</td>
								<td align="left"><s:property value="resultMap.vcont" />
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
											<td align="left"><s:property value="resultMap.shpnm" />
											</td>
										</tr>
										<tr>
											<td align="left"><s:property
													value="resultMap.shpmst_s135" /> <s:property
													value="resultMap.shpmst_s235" />
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
											<td align="left" width="50%"><s:property
													value="resultMap.curid" /></td>
											<td nowrap="nowrap"><s:if test="language == 0">
											税率:
										</s:if> <s:else>
											Tax Rate:
										</s:else>
											</td>
											<td align="left" width="50%"><s:property
													value="resultMap.txsuf" />
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
								<td align="left" colspan="3"><s:property
										value="resultMap.trmds" />
								</td>
							</tr>
							<tr>
								<td nowrap="nowrap"><s:if test="language == 0">
											联系人:
										</s:if> <s:else>
											Contact:
										</s:else>
								</td>
								<td align="left"><s:property value="resultMap.scont" />
								</td>
								<td nowrap="nowrap"><s:if test="language == 0">
											运输方式:
										</s:if> <s:else>
											Ship Via:
										</s:else>
								</td>
								<td align="left"><s:property value="resultMap.viads" />
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
										<s:if test="#son1.staic == \"50\" && chk01 == \"false\""></s:if>
										<s:else>
											<s:if test="#son1.staic == \"99\" && chk03 == \"false\""></s:if>
											<s:else>
												<tr align="center">
													<td><s:property value="#st.count" /></td>

													<td>
														<table border="0" width="100%">
															<tr align="center">
																<td colspan="2"><s:property value="#son1.itnbr" />{<s:property
																		value="#son1.itdsc" />}</td>

															</tr>

															<s:if test="#son1.blcod==\"1\"">
																<!-- 外协且总括,实际情况下不存在 -->
																<s:if
																	test="#son1.son1_.size == 0 && && chk02 == \"false\""></s:if>
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
																	<s:iterator value="#son1.son1_" var="son11">
																		<s:if
																			test="#son11.staic == \"50\" && chk01 == \"false\""></s:if>
																		<s:else>
																			<s:if
																				test="#son11.staic == \"99\" && chk01 == \"false\""></s:if>
																			<s:else>
																				<tr align="center">
																					<td><s:property value="#son11.dokdts" />
																					</td>
																					<td><s:property value="#son11.relqt" />
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
										</s:else> <s:property value="#son1.dokdts" />
																	</td>
																</tr>
															</s:else>

														</table>
													</td>
													<td><s:property value="#son1.ucorq" /></td>
													<td><s:property value="#son1.curpr" /></td>
													<s:set var="total" value="#total+#son1.ucorq"></s:set>
													<s:set var="count" value="#count+#son1.ucorq*#son1.curpr"></s:set>
													<td><fmt:formatNumber value="${son1.ucorq*son1.curpr}"
															pattern="#0.0000" />
													</td>

												</tr>
											</s:else>
										</s:else>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table width="100%">
										<tr>
											<td>
											<s:if test="language == 0">
											生产信息
										</s:if> <s:else>
											Manufacturing Info.
										</s:else></td>
										<tr>
											<td>&nbsp;&nbsp;<s:if test="language == 0">
											生产订单号:
										</s:if> <s:else>
											MO#:
										</s:else><s:property
													value="#son1.son2.monr" />,&nbsp;<s:if test="language == 0">
											产品:
										</s:if> <s:else>
											Finished Item:
										</s:else><s:property
													value="#son1.son2.fitem" />,&nbsp;<s:if test="language == 0">
											产品描述:
										</s:if> <s:else>
											Description:
										</s:else><s:property
													value="#son1.son2.fdesc" /></td>
										</tr>
										<tr>
											<td>&nbsp;&nbsp;<s:if test="language == 0">
											工序:
										</s:if> <s:else>
											Operation:
										</s:else><s:property value="#son1.son2.opsq" />(<s:property
													value="#son1.son2.opdsc"/>),&nbsp;<s:if test="language == 0">
											生产数量:
										</s:if> <s:else>
											Quantity:
										</s:else><fmt:formatNumber
													value="${son1.son2.orqty+son1.son2.qtdev}"
													pattern="#0.0000" />,&nbsp;<s:if test="language == 0">
											单位:
										</s:if> <s:else>
											UOM:
										</s:else><s:property
													value="#son1.son2.umstt9" /></td>
										</tr>

									</table></td>
							</tr>
							<tr>
								<td>
									<table border="1" width="100%" cellpadding="5px"
										style="border-collapse: collapse;">
										<tr align="center">
											<td><s:if test="language == 0">
											序号
										</s:if> <s:else>
											No.
										</s:else>
											</td>
											<td><s:if test="language == 0">
											材料品号
										</s:if> <s:else>
											Component Item
										</s:else>
											</td>
											<td><s:if test="language == 0">
											材料名称
										</s:if> <s:else>
											Component Item Description
										</s:else>
											</td>
											<td><s:if test="language == 0">
											需领数量
										</s:if> <s:else>
											Required Qty
										</s:else>
											</td>
											<td><s:if test="language == 0">
											单位
										</s:if> <s:else>
											UOM
										</s:else>
											</td>
											<td><s:if test="language == 0">
											子库
										</s:if> <s:else>
											Sub-WHS
										</s:else>
											</td>
										</tr>
										<s:iterator value="#son1.son2.son2_" var="son22" status="st">
											<tr align="center">
												<td><s:property value="#st.count" /></td>
												<td><s:property value="#son22.citem" /></td>
												<td><s:property value="#son22.cdesc" /></td>
												<td><fmt:formatNumber value="${son22.qtreq}"
														pattern="#0.0000" /></td>
												<td><s:property value="#son22.unmsr" /></td>
												<td><s:property value="#son22.whsub2" /></td>
											</tr>
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
									<td width="33%">核准:</td>
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

		</s:iterator>
	</s:if>
	<s:else>
		<table width="100%" cellpadding="5px" border="1"
			style="border-collapse: collapse;">
			<tr>
				<td>
					<table width="100%" border="0">
						<tr>
							<td align="center" colspan="4"><span
								style="font-weight: bold;font-size:18px;"> <s:if
										test="language == 0">
										<s:property value="resultMap.nmchs" />
									</s:if> <s:else>
										<s:property value="resultMap.nmeng" />
									</s:else> </span>
							</td>
						</tr>
						<tr>
							<td align="center" colspan="4"><span
								style="font-weight: bold;font-size:18px;"><s:if
											test="language == 0">采购订单</s:if><s:else>Purchase Order</s:else></span>
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
												value="resultMap.house" />
										</td>
										<td nowrap="nowrap"><s:if test="language == 0">
											订单日期:
										</s:if> <s:else>
											Order date:
										</s:else></td>
										<td width="50%" align="left"><s:property
												value="resultMap.actdts" />
										</td>
									</tr>
								</table>
							</td>

							<td colspan="2"><s:property value="resultMap.ordno" />-<s:property
									value="resultMap.revnb" />
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
										<td><s:property value="resultMap.sn35" />
										</td>
									</tr>
									<tr align="left">
										<td><s:property value="resultMap.s135" /> <s:property
												value="resultMap.s235" />
										</td>
									</tr>
								</table>
							</td>
							<td nowrap="nowrap"><s:if test="language == 0">
											供货方:
										</s:if> <s:else>
											Supplier:
										</s:else></td>
							<td width="50%" align="left"><s:property
									value="resultMap.vndnr" /> <s:property value="resultMap.vn35" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap"><s:if test="language == 0">
											采购员:
										</s:if> <s:else>
											Buyer:
										</s:else></td>
							<td align="left"><s:property value="resultMap.buyno" /> <s:property
									value="resultMap.buynm" />
							</td>
							<td nowrap="nowrap"><s:if test="language == 0">
											联系人:
										</s:if> <s:else>
											Contact:
										</s:else>
							</td>
							<td align="left"><s:property value="resultMap.vcont" />
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
										<td align="left"><s:property value="resultMap.shpnm" />
										</td>
									</tr>
									<tr>
										<td align="left"><s:property
												value="resultMap.shpmst_s135" /> <s:property
												value="resultMap.shpmst_s235" />
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
										<td align="left" width="50%"><s:property
												value="resultMap.curid" /></td>
										<td nowrap="nowrap"><s:if test="language == 0">
											税率:
										</s:if> <s:else>
											Tax Rate:
										</s:else>
										</td>
										<td align="left" width="50%"><s:property
												value="resultMap.txsuf" />
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
							<td align="left" colspan="3"><s:property
									value="resultMap.trmds" />
							</td>
						</tr>
						<tr>
							<td nowrap="nowrap"><s:if test="language == 0">
											联系人:
										</s:if> <s:else>
											Contact:
										</s:else>
							</td>
							<td align="left"><s:property value="resultMap.scont" />
							</td>
							<td nowrap="nowrap"><s:if test="language == 0">
											运输方式:
										</s:if> <s:else>
											Ship Via:
										</s:else>
							</td>
							<td align="left"><s:property value="resultMap.viads" />
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
									<s:iterator value="resultMap.item" var="son1" status="st">
										<s:if test="#son1.staic == \"50\" && chk01 == \"false\""></s:if>
										<s:else>
											<s:if test="#son1.staic == \"99\" && chk03 == \"false\""></s:if>
											<s:else>
												<tr align="center">
													<td><s:property value="#st.count" /></td>

													<td>
														<table border="0" width="100%">
															<tr align="center">
																<td colspan="2"><s:property value="#son1.itnbr" />{<s:property
																		value="#son1.itdsc" />}</td>

															</tr>

															<s:if test="#son1.blcod==\"1\"">
																<s:if
																	test="#son1.son1_.size == 0 && && chk02 == \"false\""></s:if>
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
																	<s:iterator value="#son1.son1_" var="son11">
																		<s:if
																			test="#son11.staic == \"50\" && chk01 == \"false\""></s:if>
																		<s:else>
																			<s:if
																				test="#son11.staic == \"99\" && chk01 == \"false\""></s:if>
																			<s:else>
																				<tr align="center">
																					<td><s:property value="#son11.dokdts" />
																					</td>
																					<td><s:property value="#son11.relqt" />
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
										</s:else> <s:property value="#son1.dokdts" />
																	</td>
																</tr>
															</s:else>

														</table>
													</td>
													<td><s:property value="#son1.ucorq" /></td>
													<td><s:property value="#son1.curpr" /></td>
													<s:set var="total" value="#total+#son1.ucorq"></s:set>
													<s:set var="count" value="#count+#son1.ucorq*#son1.curpr"></s:set>
													<td><fmt:formatNumber value="${son1.ucorq*son1.curpr}"
															pattern="#0.0000" />
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
								<td width="33%">核准:</td>
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
	</s:else>
</body>
</html>