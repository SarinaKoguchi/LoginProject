<!-- ログイン画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリの使用を宣言する -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="loginBean" class="jp.co.aforce.beans.LoginBean" scope="request" />
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/css/login.css" />" rel="stylesheet">
<title>ログイン画面</title>
</head>
<body>
<div class="form">
	<h1>LOGIN　FORM</h1>

	<!-- エラーメッセージ -->
	<div class="emsg">
	<c:out value="${loginBean.emsg}" />
	</div>

	<!-- 入力フォーム -->
	<form method="POST" action="/LoginProject/login">
	<p>Username : <input type="text" name="username"></p>
	<p>Password : <input type="password" name="password"></p>
	<input type="submit" value="ログイン">
	</form>
</div>

</body>
</html>