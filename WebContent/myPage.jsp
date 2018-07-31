<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>Home</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>マイページ</h1>
		</div>

		<div>
			<s:iterator value="#session.userInfoDTOList">
				<table>
					<tr>
						<th>ログインID：</th>
						<td colspan="2"><s:property value="userId"/></td>
					</tr>
					<tr>
						<th>パスワード：</th>
						<td colspan="2"><s:property value="password"/></td>
					</tr>
					<tr>
						<th>名前：</th>
						<td><s:property value="familyName"/></td>
						<td><s:property value="firstName"/></td>
					</tr>
					<tr>
						<th>名前(かな)：</th>
						<td><s:property value="familyNameKana"/></td>
						<td><s:property value="firstNameKana"/></td>
					</tr>
					<tr>
						<th>性別：</th>
						<td colspan="2">
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
						<td colspan="2"><s:property value="email"/></td>
					</tr>
				</table>
			</s:iterator>
		</div>

		<div>
			<s:form action="BuyProductHistoryAction">
				<s:submit value="購入履歴"/>
			</s:form>
		</div>

		<div>
			<s:form action="UpdateUserAction">
				<s:submit value="登録情報変更"/>
			</s:form>
		</div>

		<div>
			<s:form action="DeleteUserAction">
				<s:submit value="登録情報削除"/>
			</s:form>
		</div>


	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>