<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<!-- アクション名いれてください -->
		<s:form action="LoginAction">
			ユーザー：<s:textfield name="user"/><br>
				<s:property value="errorUser" /><br>
			パスワード：<s:password name="password"/><br>
				<s:property value="errorPassword" /><br>
			<s:submit value="ログイン"/><s:property value="errorLogin" /><br>
		</s:form>
		<!-- アクション名いれてください -->
		<s:url var="new" action="newuser" />
		<s:a href="%{new}" ><button>新規</button></s:a>
		<s:url var="facebook" action="login-facebook" />
		<br>
		<s:a href="%{facebook}" >
			<img src="img/facebook-j.png">
		</s:a>
		<s:url var="google" action="login-google" />
		<s:a href="%{google}">
			<img src="img/google-j.png">
		</s:a>
		<s:url var="twitter" action="login-twitter" />
		<s:a href="%{twitter}">
			<img src="img/twitter-j.png">
		</s:a>
	</body>
</html>