<!-- ログイン成功時の画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- タグライブラリの使用を宣言する -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userBean" class="jp.co.aforce.beans.UserBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/success.css" />">
<title>成功画面</title>
</head>
<body>
	<div>ログイン成功</div>
	<br>
	<p>
		ようこそ
		<c:out value="${param.username}" />
		さん
	</p>
	<p>＜ ログインユーザ情報 ＞</p>
	<p>
		名前：
		<c:out value="${loginUser.username}" />
	</p>
		<p>
			性別：
			<c:out value="${loginUser.gender}" />
		</p>
		<p>
			住所：
			<c:out value="${loginUser.address}" />
		</p>
	<br>
	<p>＜ 登録済ユーザ情報 ＞</p>
	<c:forEach var="data" items="${users}">
	<p>
		名前：
		<c:out value="${data.username}" />
	</p>
		<p>
			性別：
			<c:out value="${data.gender}" />
		</p>
		<p>
			住所：
			<c:out value="${data.address}" />
		</p>
		<hr>
	</c:forEach>

</body>
</html>