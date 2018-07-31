<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>ProductList</title>
	</head>
<body>

	<s:include value="header.jsp" />

	<div class="main">
		<s:if test="productInfoDTOList == null">
			検索結果がありません。
		</s:if>

		<s:else>
			<h1>商品一覧</h1>

			<div class="product-list">
				<s:iterator value="#session.productInfoDTOList">
					<ul>
						<li>
							<a href='<s:url action="ProductDetailsAction"><s:param name="id" value="%{id}"/></s:url>'>
										<img src='<s:property value="imageFileName"/>'/>
							</a><br><br>
							<s:property value="productName"/><br>
							<s:property value="productNameKana"/><br>
							<s:property value="productPrice"/>円<br>
						</li>
					</ul>
				</s:iterator>
			</div>
		</s:else>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>