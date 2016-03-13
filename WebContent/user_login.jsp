<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/01.Login.css" />
<link rel="stylesheet" type="text/css" href="css/23.24.header_footer.css" />
<title>ログイン</title>
</head>
<body>

<!--ログイン非ログインの判別-->
<%
	String id = (String)session.getAttribute("mail_adress");
	boolean LoginState;
	if(id==null){
		LoginState=false;
	}else{
		LoginState=true;
	}
	%>
<!--ヘッダー全部ここから-->
	<!--ログアウト時ヘッダー-->
<%if(LoginState==false){ %>
	<div id="header">

		<a href="#" class="header-left"><img
			src="http://free-illustrations-ls01.gatag.net/images/lgi01a201409170000.jpg"
			class="sample"></a>

		<div class="ribbon">
				<s:a href="GoMainAction"><span>トップ</span></s:a>
			 	<s:a href="GoCreateUserAction"><span>新規登録</span></s:a>
			 <s:a href="GoUserLoginAction"><span>ログイン</span></s:a>
		</div>
	</div>
<%} %>

	<!--ログイン時ヘッダー-->
<% if(LoginState==true){%>
	<div id="header">

		<a href="#" class="header-left"><img
			src="http://free-illustrations-ls01.gatag.net/images/lgi01a201409170000.jpg"
			class="sample"></a>

		<div class="ribbon">
				<s:a href="GoMainAction"><span>トップ</span></s:a>
				<s:a href="GoMyPageAction"><span>マイページ</span></s:a>
				<s:a href="GoUserLogoutAction"><span>ログアウト</span></s:a>
		</div>
	</div>
<%} %>

<h1>ログイン</h1>

<div class="skin">

	<h3>下記に情報を入力してください。</h3><br>

<%-- ログインエラー時に表示されるメッセージ --%>
<div class="errorMsg"><s:property value="errorMsg"/></div>

<%--  ログイン --%>
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
		<%-- フェイスブック  --%>
		<li><s:url var="facebook" action="login-facebook"/>
       	<s:a href="%{facebook}" ><img src="img/Facebook.jpg" style="zoom: 40%;"></s:a></li>

        <%-- ツイッター --%>
        <li><s:url var="twitter" action="login-twitter" />
        <s:a href="%{twitter}"><img src="img/twitter.jpg" style="zoom: 20%;"></s:a></li>

		 <%--  グーグル --%>
		<li><s:url var="google" action="login-google" />
        <s:a href="%{google}"><img src="img/GooglePlusIcon.jpg" style="zoom: 32%;"></s:a></li>
        </ul>
</div>

	<p>登録していない方はこちらから新規登録してください</p>

 <%-- 新規登録 --%>
<s:form action="GoCreateUserAction" namespace="/">
<s:submit cssClass="registBtn" value="新規登録"/>
</s:form>

<div id="footer">
			<div class="footer-right">
				<ul>
					<li><a href="#">退会画面</a></li>
					<li><a href="#">会社概要</a></li>
					<li><a href="#">利用規約</a></li>
					<li><a href="#">Q&amp;A</a></li>
				</ul>
			</div>
	</div>
<!--フッター全部ここから-->
	<!--ログアウト時フッター-->
<%if(LoginState==false){ %>
	<div id="footer">
		<div class="footer-right">
			<ul>
					<li><s:a href="GoCompanyAction">会社概要</s:a></li>
					<li><s:a href="GoTeamsOfServiceAction">利用規約</s:a></li>
					<li><s:a href="GoHelpAction">Q&amp;A</s:a></li>
			</ul>
		</div>
	</div>
<%} %>
	<!--ログイン時フッター-->
<%if(LoginState==true){ %>
	<div id="footer">
		<div class="footer-right">
			<ul>
					<li><s:a href="GoWithdrawalConfirmAction">退会画面</s:a></li>
					<li><s:a href="GoCompanyAction">会社概要</s:a></li>
					<li><s:a href="GoTeamsOfServiceAction">利用規約</s:a></li>
					<li><s:a href="GoHelpAction">Q&amp;A</s:a></li>
			</ul>
		</div>
	</div>
<%} %>
<!--フッター全部ここまで-->
</body>
</html>