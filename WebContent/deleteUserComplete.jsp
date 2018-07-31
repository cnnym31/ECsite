<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3;URL=home.jsp">
		<link rel="stylesheet" href="./css/style.css">
		<title>DeleteUserComplete</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>削除完了</h1>
		</div>

		ユーザー情報を削除しました<br>
		3秒後にホームに戻ります

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>