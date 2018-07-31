<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3;URL=home.jsp">
		<link rel="stylesheet" href="./css/style.css">
		<title>SettlementComplete</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div class="top">
			<h1>決済完了</h1>
		</div>

		決済が完了しました<br>
		3秒後にホームに戻ります

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>