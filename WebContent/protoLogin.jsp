<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<!-- CSS body中央 -->
<style type="text/css">body {text-align: center;}</style>
</head>
<body>
    <h1><s:text name = "%{getText('login.ninn')}"/></h1>

 		<!-- ログイン -->
        <s:form action="LoginAction">
            <s:text name = "%{getText('login.user')}"/>
            <s:textfield name="id"/><br>
            <br>
            <s:property value="errorid" /><br>

            <s:text name = "%{getText('login.pass')}"/>
            <s:password name="password"/><br>
            <s:property value="errorPassword" /><br>

            <s:submit value="%{getText('login.sign')}"/>
            <s:property value="errorLogin" /><br>
        </s:form>
        <br>

        <!-- 新規登録 -->
        <s:url var="new" action="newuser" />
        <s:a href="%{new}" ><button><s:text name = "%{getText('login.sinki')}"/></button></s:a>
        <br>
        <br>

		<!-- フェイスブック -->
        <s:url var="facebook" action="login-facebook" />
        <s:a href="%{facebook}" >
        <img src="img/facebook-j.png">
        </s:a>

		<!-- グーグル -->
        <s:url var="google" action="login-google" />
        <s:a href="%{google}">
        <img src="img/google-j.png">
        </s:a>

		<!-- ツイッター  -->
        <s:url var="twitter" action="login-twitter" />
        <s:a href="%{twitter}">
        <img src="img/twitter-j.png">
        </s:a>
    </body>
</html>