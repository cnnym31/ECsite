<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="3;URL=myPage.jsp">
		<link rel="stylesheet" href="./css/style.css">
		<title>UpdateUserComplete</title>
	</head>
<body>

	<s:include value="header.jsp" />

	<div class="main">
		<h1>登録完了画面</h1>

		登録情報の変更が完了しました<br>
		3秒後にマイページに戻ります

	</div>

	<s:include value="footer.jsp" />

</body>
</html>