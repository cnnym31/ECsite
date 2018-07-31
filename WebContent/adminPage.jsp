<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>AdminPage</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">

		<div>
			<h1>管理者ページ</h1>
		</div>

		<div>

			<s:form action="AdminProductListAction">
				<s:submit value="商品一覧"/>
			</s:form>

		</div>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>