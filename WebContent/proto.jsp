<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mysql</title>
</head>
<body>
	<s:form action="UserSelectAction">
		<s:submit label="データの表示" type="button" />
	</s:form>
	<table>
		<tr>
			<th>ID</th>
			<th>ユーザー名</th>
			<th>パスワード</th>

		</tr>
		<s:iterator value="list">
			<tr>
				<td><s:property value="id"></s:property></td>
				<td><s:property value="user"></s:property></td>
				<td><s:property value="password"></s:property></td>

			</tr>
		</s:iterator>
	</table>
	<br>
	<br>


	<label>追加</label>
	<s:form action="UserInsertAction">
		<label for="user">ユーザー名</label>
		<s:textfield name="user" placeholder="ユーザー名" maxlength="255"></s:textfield><br>
		<s:property value="errorUser" />
		<br>
		<label for="password">パスワード</label>
		<s:textfield name="password" placeholder="パスワード" mazlength="255"></s:textfield><br>
		<s:property value="errorPassword" />
		<br>
		<s:submit label="追加" type="button" />
	</s:form>
	<br>
	<br>


	<label>削除</label>
	<s:form action="UserDeleteAction">
		<label for="user">ユーザー名</label>
		<s:textfield name="user" placeholder="ユーザー名" maxlength="255"></s:textfield><br>
		<s:property value="errorUser" />

		<s:submit label="削除" type="button" />
	</s:form>
	<br>
	<br>


	<label>更新</label>
	<s:form action="UserUpdateAction">
		<label for="id">ID</label>
		<s:textfield name="id" placeholder="id" maxlength="11"></s:textfield><br>
		<s:property value="errorCheckId" />
		<br>
		<label for="user">ユーザー名</label>
		<s:textfield name="user" placeholder="ユーザー名" maxlength="255"></s:textfield><br>
		<s:property value="errorUser" />
		<br>
		<label for="password">パスワード</label>
		<s:textfield name="password" placeholder="パスワード" maxlength="255"></s:textfield><br>
		<s:property value="errorPassword" />
		<br>
		<s:submit label="更新" type="button" />
	</s:form>

</body>
</html>