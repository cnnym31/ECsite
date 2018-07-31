<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>ProductDetails</title>
	</head>
<body>

	<s:include value="header.jsp" />

	<div class="main">
		<div>
			<h1>商品詳細</h1>
		</div>

		<div class="productDetails">
			<s:form action="AddCartAction">
				<div class="productDetails-left">
					<img src='<s:property value="#session.imageFileName"/>' >
				</div>

				<div class="productDetails-right">
						<table>
						<tr>
							<th>商品名：</th>
							<td><s:property value="#session.productName"/></td>
						</tr>
						<tr>
							<th>商品名(かな)：</th>
							<td><s:property value="#session.productNameKana"/></td>
						</tr>
						<tr>
							<th>商品詳細：</th>
							<td><s:property value="#session.productDescription"/></td>
						</tr>
						<tr>
							<th>値段：</th>
							<td><s:property value="#session.productPrice"/>円</td>
						</tr>
						<tr>
							<th>購入個数：</th>
							<td>
								<select name="productCount">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>個
							</td>
						</tr>
					</table>

					<input type="submit" value="カートに追加"/>
				</div>

				<s:hidden name="productId" value="%{#session.productId}"/>
				<s:hidden name="productName" value="%{#session.productName}"/>
				<s:hidden name="productNameKana" value="%{#session.productNameKana}"/>
				<s:hidden name="productDescription" value="%{#session.productDescription}"/>
				<s:hidden name="productPrice" value="%{#session.productPrice}"/>
				<s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
			</s:form>
		</div>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>