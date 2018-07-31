<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<meta  charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>Settlement</title>
	</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>決済</h1>
		</div>

		<div class="settlement">
			<table>
				<s:iterator value="#session.cartInfoDTOList">
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
								<tr>
									<th>値段：</th>
									<td><s:property value="productPrice"/>円</td>
								</tr>
								<tr>
									<th>個数：</th>
									<td><s:property value="productCount"/>個</td>
								</tr>
								<tr>
									<th>　</th>
									<td>　</td>
								</tr>
								<tr>
									<th>小計：</th>
									<td><s:property value="subtotal"/>円</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>

		<div>
			<table>
				<tr>
					<th>合計金額</th>
					<td><s:property value="#session.totalPrice"/>円</td>
				</tr>
			</table>

			<s:form action="SettlementCompleteAction">
				<s:submit value="次へ"/>
			</s:form>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>