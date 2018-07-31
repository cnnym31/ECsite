<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>Cart</title>
	</head>
<body>

	<s:include value="header.jsp" />

	<div class="main">
		<div>
			<h1>カート</h1>
		</div>

		<div class="cart">
			<s:if test="#session.cartInfoDTOList.size() > 0">
				<div>
					<s:iterator value="#session.cartInfoDTOList">
						<table>
							<tr>
								<td>
									<img src='<s:property value="imageFileName"/>'/>
								</td>
								<td>
									<table>
										<tr>
											<th>商品名：</th>
											<td><s:property value="productName"/></td>
										</tr>
										<tr>
											<th>商品名(かな)：</th>
											<td><s:property value="productNameKana"/></td>
										</tr>
										<tr>
											<th>値段：</th>
											<td><s:property value="productPrice"/>円</td>
										</tr>
										<tr>
											<th>個数：</th>
											<td><s:property value="productCount"/></td>
										</tr>
										<tr>
											<th>　</th>
											<td>　</td>
										</tr>
										<tr>
											<th>小計:</th>
											<td><s:property value="subtotal"/>円</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</s:iterator>
				</div>

				<div>
					<table>
						<tr>
							<th>カート合計</th>
							<td><s:property value="#session.totalPrice"/>円</td>
						</tr>
					</table>

					<s:form action="SettlementAction">
						<s:submit value="レジへ進む"/>
					</s:form>
				</div>
			</s:if>

			<s:else>
				カートに何も入っていません
			</s:else>
		</div>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>