<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3;URL=adminPage.jsp">
		<link rel="stylesheet" href="./css/style.css">
		<title>DeleteProductAllComplete</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div class="top">
			<h1>商品削除完了</h1>
		</div>

		全ての商品の削除が完了しました<br>
		3秒後に管理者ページに戻ります

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>