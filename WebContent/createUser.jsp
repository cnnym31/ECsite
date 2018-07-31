<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>CreateUser</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>新規ユーザー登録</h1>
		</div>

		<div>
			<s:form action="CreateUserConfirmAction">
				<table>
					<tr>
						<th>ログインID：</th>
						<td colspan="3"><input type="text" name="userId" placeholder="ログインID"/></td>
					</tr>
					<tr>
						<th>パスワード：</th>
						<td colspan="3"><input type="password" name="password" placeholder="パスワード"/></td>
					</tr>
					<tr>
						<th>姓：</th>
						<td><input type="text" name="familyName" placeholder="姓"/></td>
						<th>名：</th>
						<td><input type="text" name="firstName" placeholder="名"/></td>
					</tr>
					<tr>
						<th>姓(かな)：</th>
						<td><input type="text" name="familyNameKana" placeholder="姓(かな)"/></td>
						<th>名(かな)：</th>
						<td><input type="text" name="firstNameKana" placeholder="名(かな)"/></td>
					</tr>
					<tr>
						<th>性別：</th>
						<td colspan="3">
							<input type="radio" name="sex" value="0"/>男性
							<input type="radio" name="sex" value="1"/>女性
						</td>
					</tr>
					<tr>
						<th>メールアドレス：</th>
						<td colspan="3"><input type="text" name="email" placeholder="メールアドレス"/></td>
					</tr>
				</table>

				<input type="submit" value="新規登録"/>
			</s:form>
		</div>
	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>