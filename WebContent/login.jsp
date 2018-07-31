<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>Login</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">

		<div>
			<h1>ログイン</h1>
		</div>

		<div class="login">
			<s:form action="LoginAction">
				<table>
					<tr>
						<th>ログインID：</th>
						<td><input type="text" name="userId" placeholder="ログインID"/></td>
					</tr>
					<tr>
						<th>パスワード：</th>
						<td><input type="password" name="password" placeholder="パスワード"/></td>
					</tr>
				</table>

				<input type="submit" value="ログイン"/>
			</s:form>
		</div>

			<s:form action="CreateUserAction">
				<s:submit value="新規ユーザー登録"/>
			</s:form>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>