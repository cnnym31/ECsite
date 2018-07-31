<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Header</title>
	</head>
<body>
	<header>
		<div class="header-title">
			with M
		</div>

		<div class="header-menu">
			<ul>
				<li>
					<s:if test="#session.logined == 1 || #session.admin == 1">
						<s:form action="LogoutAction">
							<s:submit value="ログアウト"/>
						</s:form>
					</s:if>
					<s:else>
						<s:form action="GoLoginAction">
							<s:submit value="ログイン"/>
						</s:form>
					</s:else>
				</li>
				<s:if test="#session.admin != 1">
					<li>
						<s:form action="ProductListAction">
							<s:submit value="商品一覧"/>
						</s:form>
					</li>
					<li>
						<s:form action="GoCartAction">
							<s:submit value="カート"/>
						</s:form>
					</li>
				</s:if>
				<s:if test="#session.logined == 1">
					<li>
						<s:form action="GoMyPageAction">
							<s:submit value="マイページ"/>
						</s:form>
					</li>
				</s:if>
				<s:if test="#session.admin ==1">
					<li>
						<s:form action="GoAdminPageAction">
							<s:submit value="管理者ページ"/>
						</s:form>
					</li>
				</s:if>
			</ul>
		</div>
	</header>
</body>
</html>