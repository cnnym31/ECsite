<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>CreateDestinationConfirm</title>
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
					<th>住所：</th>
					<td><s:property value="userAddress"/></td>
				</tr>
				<tr>
					<th>電話番号：</th>
					<td><s:property value="telNumber"/></td>
				</tr>
			</table>
		</div>

		<div>
			<s:form action="CreateDestinationCompleteAction">
				<s:submit value="完了"/>

				<s:hidden name="familyName" value="%{familyName}"/>
				<s:hidden name="firstName" value="%{firstName}"/>
				<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
				<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
				<s:hidden name="userAddress" value="%{userAddress}"/>
				<s:hidden name="telNumber" value="%{telNumber}"/>
			</s:form>
		</div>
	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>