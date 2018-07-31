<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>DeleteUser</title>
	</head>
<body>

	<s:include value="header.jsp" />

	<div class="main">
		<div>
			<h1>削除確認画面</h1>
		</div>

		以下のユーザー情報を削除してよろしいですか？

		<div>
			<s:iterator value="#session.userInfoDTOList">
				<table>
					<tr>
						<th>ログインID：</th>
						<td colspan="3"><s:property value="userId"/></td>
					</tr>
					<tr>
						<th>パスワード：</th>
						<td colspan="3"><s:property value="password"/></td>
					</tr>
					<tr>
						<th>姓：</th>
						<td><s:property value="familyName"/></td>
						<th>名：</th>
						<td><s:property value="firstName"/></td>
					</tr>
					<tr>
						<th>姓(かな)：</th>
						<td><s:property value="familyNameKana"/></td>
						<th>名(かな)：</th>
						<td><s:property value="firstNameKana"/></td>
					</tr>
					<tr>
						<th>性別：</th>
						<td colspan="3">
							<s:if test="sex == 0">
								男性
							</s:if>
							<s:if test="sex == 1">
								女性
							</s:if>
						</td>
					</tr>
					<tr>
						<th>メールアドレス：</th>
						<td colspan="3"><s:property value="email"/></td>
					</tr>
				</table>
			</s:iterator>

			<s:form action="DeleteUserCompleteAction">
				<s:submit value="削除する"/>
			</s:form>
		</div>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>