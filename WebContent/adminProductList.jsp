<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>ProductList</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">

		<div>
			<h1>商品一覧(管理者)</h1>
		</div>

		<div class="adminProductList">
			<s:form action="CreateProductAction">
					<s:submit value="商品追加"/>
			</s:form>


			<s:if test="productInfoDTOList ==null">
				登録商品はありません
			</s:if>

			<s:else>
				<s:form action="DeleteProductAllAction">
					<s:submit value="全削除"/>
				</s:form>

				<s:iterator value="productInfoDTOList">
				<table>
					<tr>
						<td><img src='<s:property value="imageFileName"/>'/></td>
						<td>
							<table>
								<tr>
									<th>商品ID：</th>
									<td><s:property value="id"/></td>
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
									<th>商品詳細：</th>
									<td><s:property value="productDescription"/></td>
								<tr>
									<th>カテゴリ：</th>
									<td>
										<s:if test="categoryId == 2">
											カテゴリ１
										</s:if>
										<s:if test="categoryId == 3">
											カテゴリ２
										</s:if>
										<s:if test="categoryId == 4">
											カテゴリ３
										</s:if>
									</td>
								</tr>
								<tr>
									<th>値段：</th>
									<td><s:property value="productPrice"/>円</td>
								</tr>
							</table>
						</td>
						<td>
							<s:form action="UpdateProductAction">
								<s:submit value="更新"/>
								<s:hidden name="id" value="%{id}"/>
							</s:form>
							<s:form action="DeleteProductAction">
								<s:submit value="削除"/>
								<s:hidden name="id" value="%{id}"/>
							</s:form>
						</td>
					</tr>
				</table>
				</s:iterator>
			</s:else>
		</div>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>