<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>CreateDestination</title>
	</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>送付先新規登録</h1>
		</div>

		<div>
			<s:form action="CreateDestinationConfirmAction">
				<table>
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
						<th>住所：</th>
						<td colspan="3"><input type="text" name="userAddress" placeholder="住所"/></td>
					</tr>
					<tr>
						<th>電話番号：</th>
						<td colspan="3"><input type="text" name="telNumber" placeholder="電話番号"/></td>
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