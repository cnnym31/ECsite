<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>UpdateProduct</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>商品情報更新</h1>
		</div>

		<div>
			<s:form action="UpdateProductConfirmAction">
				<table>
					<tr>
						<th>商品名：</th>
						<td><input type="text" name="productName" value='<s:property value="#session.productName"/>'/></td>
					</tr>
					<tr>
						<th>商品名(かな)：</th>
						<td><input type="text" name="productNameKana" value='<s:property value="#session.productNameKana"/>'/></td>
					</tr>
					<tr>
						<th>商品詳細：</th>
						<td><input type="text" name="productDescription" value='<s:property value="#session.productDescription"/>'/></td>
					</tr>
					<tr>
						<th>カテゴリ：</th>
						<td>
							<s:if test="#session.categoryId == 2">
								<select name="categoryId">
									<option value="2" selected="selected">カテゴリ１</option>
									<option value="3">カテゴリ２</option>
									<option value="4">カテゴリ３</option>
								</select>
							</s:if>
							<s:if test="#session.categoryId == 3">
								<select name="categoryId">
									<option value="2">カテゴリ１</option>
									<option value="3" selected="selected">カテゴリ２</option>
									<option value="4">カテゴリ３</option>
								</select>
							</s:if>
							<s:if test="#session.categoryId == 4">
								<select name="categoryId">
									<option value="2">カテゴリ１</option>
									<option value="3">カテゴリ２</option>
									<option value="4" selected="selected">カテゴリ３</option>
								</select>
							</s:if>
						</td>
					</tr>
					<tr>
						<th>価格：</th>
						<td><input type="text" name="productPrice" value='<s:property value="#session.productPrice"/>'/>円</td>
					</tr>
				</table>

				<input type="submit" value="確認画面へ"/>
				<s:hidden name="id" value="%{#session.id}"/>
			</s:form>
		</div>
	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>