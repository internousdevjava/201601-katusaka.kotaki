<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/20.Login.css" media="all" />
<title>管理者ログイン</title>
</head>
<body>


<center>

    <p class="form-title">管理者ログイン</p>

    <div id="form">
        <s:form action="AdminLoginAction">
            <h2>下記に情報を入力してください。</h2>
            <br>

            <table>
                <tr>
                    <td><h4>ID　 　　　　    : 　　 　 　 <s:textfield name="id" /></h4></td>
                </tr>

                <tr>
                    <td><h4>パスワード :　　　　  　 <s:password name="password" /></h4></td>
                </tr>
            </table>
            <s:submit class="button9" type="button" value="ログイン"></s:submit>


            <br>
            <br>
        </s:form>
    </div>

<br>
</center>

</body>
</html>