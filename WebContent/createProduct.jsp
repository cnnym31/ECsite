<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>CreateProduct</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">

		<div>
			<h1>商品追加</h1>
		</div>

		<div>
			<s:form action="CreateProductConfirmAction">
				<table>
					<tr>
						<th>商品名：</th>
						<td><input type="text" name="productName" placeholder="商品名"/></td>
					</tr>
					<tr>
						<th>商品名(かな)：</th>
						<td><input type="text" name="productNameKana" placeholder="商品名(かな)"/></td>
					</tr>
					<tr>
						<th>商品詳細：</th>
						<td><input type="text" name="productDescription" placeholder="商品詳細"/></td>
					</tr>
					<tr>
						<th>カテゴリ：</th>
						<td>
							<select name="categoryId">
								<option value="2" selected="selected">カテゴリ１</option>
								<option value="3">カテゴリ２</option>
								<option value="4">カテゴリ３</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>価格：</th>
						<td><input type="text" name="productPrice" placeholder="価格"/>円</td>
					</tr>
				</table>

				<input type="submit" value="確認画面へ"/>
			</s:form>
		</div>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>