<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>CreateUserConfirm</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>登録内容確認</h1>
		</div>

		<div>
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
					<td>
						<s:if test="sex == 0">
							男性
						</s:if>
						<s:if test="sex ==1">
							女性
						</s:if>
					</td>
				</tr>
				<tr>
					<th>メールアドレス：</th>
					<td><s:property value="email"/></td>
				</tr>
			</table>
		</div>

		<div>
			<s:form action="CreateUserCompleteAction">
				<s:submit value="完了"/>

				<s:hidden name="userId" value="%{userId}"/>
				<s:hidden name="password" value="%{password}"/>
				<s:hidden name="familyName" value="%{familyName}"/>
				<s:hidden name="firstName" value="%{firstName}"/>
				<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
				<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
				<s:hidden name="sex" value="%{sex}"/>
				<s:hidden name="email" value="%{email}"/>
			</s:form>
		</div>
	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>