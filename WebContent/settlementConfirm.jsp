<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<meta  charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>Settlement</title>
	</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div>
			<h1>決済内容確認</h1>
		</div>

		<div>
			<div>
				===== 送付先 =====
				<table>
					<s:iterator value="#session.destinationInfoDTO">
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
							<th>住所：</th>
							<td colspan="2"><s:property value="userAddress"/></td>
						</tr>
						<tr>
							<th>電話番号：</th>
							<td colspan="2"><s:property value="telNumber"/></td>
						</tr>
					</s:iterator>
				</table>
			</div>

			<br>　　　<br>

			<div class="settlement">
				===== 購入内容 =====
				<table>
					<s:iterator value="#session.cartInfoDTOList">
						<tr>
							<td>
								<img src='<s:property value="imageFileName"/>'/>
							</td>
							<td>
								<table>
									<tr>
										<th>商品名：</th>
										<td><s:property value="productName"/></td>
									</tr>
									<tr>
										<th>商品名(かな)：</th>
										<td><s:property value="productNameKana"/></td>
									<tr>
										<th>値段：</th>
										<td><s:property value="productPrice"/>円</td>
									</tr>
									<tr>
										<th>個数：</th>
										<td><s:property value="productCount"/>個</td>
									</tr>
									<tr>
										<th>　</th>
										<td>　</td>
									</tr>
									<tr>
										<th>小計：</th>
										<td><s:property value="subtotal"/>円</td>
									</tr>
								</table>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>

			<s:form action="SettlementCompleteAction">
				<s:submit value="決済"/>
				<s:hidden name="id" value="%{id}"/>
			</s:form>
		</div>

	</div>

	<!-- フッター -->
	<jsp:include page="footer.jsp"/>

</body>
</html>