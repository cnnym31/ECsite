<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>DeleteProductAll</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div class="top">
			<h1>全商品削除</h1>
		</div>

		全ての商品を削除してよろしいですか？

		<s:form action="DeleteProductAllCompleteAction">
			<s:submit value="全て削除する"/>
		</s:form>
	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>