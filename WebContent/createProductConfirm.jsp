<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>CreateProductConfirm</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">

		<div>
			<h1>追加商品確認</h1>
		</div>

		<div>
			<table>
				<tr>
					<th>商品名：</th>
					<td><s:property value="#session.productName"/></td>
				</tr>
				<tr>
					<th>商品名(かな)：</th>
					<td><s:property value="#session.productNameKana"/></td>
				<tr>
				<tr>
					<th>商品詳細：</th>
					<td><s:property value="#session.productDescription"/></td>
				</tr>
				<tr>
					<th>カテゴリ：</th>
					<td>
						<s:if test="#session.categoryId == 2">
							カテゴリ１
						</s:if>
						<s:if test="#session.categoryId == 3">
							カテゴリ２
						</s:if>
						<s:if test="#session.categoryId == 4">
							カテゴリ３
						</s:if>
					</td>
				</tr>
				<tr>
					<th>価格：</th>
					<td><s:property value="#session.productPrice"/>円</td>
				</tr>
			</table>
		</div>

		<div>
			<s:form action="CreateProductCompleteAction">
				<s:submit value="追加する"/>
			</s:form>
		</div>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>