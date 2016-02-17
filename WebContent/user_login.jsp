<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/01.Login.css" />
<title>ログイン</title>
</head>
<body>

<h1>ログイン</h1>

<div class="skin">

	<h3>下記に情報を入力してください。</h3><br>

<!-- ログインエラーメッセージ -->
<div class="errorMsg"><s:property value="ErrorMsg"/></div>

<!-- ログイン -->
	<s:form action="LoginAction" namespace="/">
		<table>
		<tr>
		<td><h4>ID(メールアドレス):<s:textfield name="mail_adress" /></h4></td>
		</tr>
		<tr>
		<td><h4>パスワード :　　　　　<s:password name="password"  /><br></h4></td>
		</tr>
		</table>
	<s:submit cssClass="loginBtn"  value="ログイン"/>
</s:form>

<br>
<br>
		<ul>
		<li>SNS認証はこちら</li>
		<!-- フェイスブック  -->
		<li><s:url var="facebook" action="login-facebook"/>
       	<s:a href="%{facebook}" ><img src="img/Facebook.jpg" style="zoom: 40%;"></s:a></li>

        <!-- ツイッター -->
        <li><s:url var="twitter" action="login-twitter" />
        <s:a href="%{twitter}"><img src="img/twitter.jpg" style="zoom: 20%;"></s:a></li>

		<!-- グーグル  -->
		<li><s:url var="google" action="login-google" />
        <s:a href="%{google}"><img src="img/GooglePlusIcon.jpg" style="zoom: 32%;"></s:a></li>
        </ul>
</div>

	<p>登録していない方はこちらから新規登録してください</p>

 <!-- 新規登録 -->
<s:form action="GoCreateUserAction" namespace="/">
<s:submit cssClass="registBtn" value="新規登録"/>
</s:form>

</body>
</html>