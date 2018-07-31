<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>BuyProductHistory</title>
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<h1>商品購入履歴</h1>

		<div class="buyProductHistory">
			<s:if test="session.buyProductHistoryDTOList.size()>0">
				<table>
				<s:iterator value="#session.buyProductHistoryDTOList">
					<tr>
						<td>
							<img src='<s:property value="imageFileName"/>'/>
						</td>
						<td>
							<table>
								<tr>
									<th>購入日：</th>
									<td><s:property value="insertDate"/></td>
								</tr>
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

			<s:form action="DeleteBuyProductHistoryAction">
				<s:submit value="履歴削除"/>
			</s:form>
			</s:if>

			<s:else>
				商品購入履歴はありません。
			</s:else>
		</div>
	</div>

	<!--  フッター -->
	<jsp:include page="footer.jsp"/>
</body>
</html>