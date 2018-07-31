
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>UpdateUser</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>登録情報変更</h1>
		</div>

		<div>
			<s:form action="UpdateUserConfirmAction">
				<s:iterator value="#session.userInfoDTOList">
					<table>
						<tr>
							<th>ログインID：</th>
							<td colspan="3"><input type="text" name="userId" value='<s:property value="userId"/>'/></td>
						</tr>
						<tr>
							<th>パスワード：</th>
							<td colspan="3"><input type="text" name="password" value='<s:property value="password"/>'/></td>
						</tr>
						<tr>
							<th>姓：</th>
							<td><input type="text" name="familyName" value='<s:property value="familyName"/>'/></td>
							<th>名：</th>
							<td><input type="text" name="firstName" value='<s:property value="firstName"/>'/></td>
						</tr>
						<tr>
							<th>姓(かな)：</th>
							<td><input type="text" name="familyNameKana" value='<s:property value="familyNameKana"/>'/></td>
							<th>名(かな)：</th>
							<td><input type="text" name="firstNameKana" value='<s:property value="firstNameKana"/>'/></td>
						</tr>
						<tr>
							<th>性別：</th>
							<td colspan="3">
								<s:if test="sex == 0">
									<input type="radio" name="sex" value="0" checked="checked"/>男性
									<input type="radio" name="sex" value="1"/>女性
								</s:if>
								<s:if test="sex == 1">
									<input type="radio" name="sex" value="0"/>男性
									<input type="radio" name="sex" value="1" checked="checked"/>女性
								</s:if>
							</td>
						</tr>
						<tr>
							<th>メールアドレス：</th>
							<td colspan="3"><input type="text" name="email" value='<s:property value="email"/>'/></td>
						</tr>
					</table>
				</s:iterator>

				<input type="submit" value="確認画面へ"/>
			</s:form>
		</div>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>