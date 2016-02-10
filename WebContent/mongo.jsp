<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mongoでイベント編集</title>
</head>
<body>
	<s:form action="EventDisplayAction">
		<s:submit>イベントの表示</s:submit>
	</s:form>
	<table>
		<tr>
			<th>イベントID</th>
			<th>イベント名</th>
			<th>イベントの値段</th>
			<th>チケットの枚数</th>
		</tr>
		<s:iterator value="eventList">
			<tr>
				<td><s:property value="id"></s:property></td>
				<td><s:property value="name"></s:property></td>
				<td><s:property value="price"></s:property></td>
				<td><s:property value="ticket"></s:property></td>
			</tr>
		</s:iterator>
	</table>
	<br>
	<br>


	<label>イベントの追加</label>
	<s:form action="EventInsertAction">
		<label for="id">イベントID</label>
		<s:textfield name="id" placeholder="イベントID"></s:textfield>
		<br>
		<label for="name">イベント名</label>
		<s:textfield name="name" placeholder="イベント名"></s:textfield>
		<br>
		<label for="price">イベントの値段</label>
		<s:textfield name="price" placeholder="イベントの値段"></s:textfield>
		<br>
		<label for="ticket">チケットの枚数</label>
		<s:textfield name="ticket" placeholder="チケットの枚数"></s:textfield>
		<s:submit laber="商品の追加！" type="button" />
	</s:form>
	<br>
	<br>


	<label>イベントの削除</label>
	<s:form action="EventDeleteAction">
		<label for="id">イベントID</label>
		<s:textfield name="id" placeholder="イベントID"></s:textfield>
		<s:submit laber="商品の削除！" type="button" />
	</s:form>


	<label>イベントの更新</label>
	<s:form action="EventUpdateAction">
		<label for="id">イベントID</label>
		<s:textfield name="id" placeholder="イベントID"></s:textfield>
		<br>
		<label for="name">イベント名</label>
		<s:textfield name="name" placeholder="イベント名"></s:textfield>
		<br>
		<label for="price">イベントの値段</label>
		<s:textfield name="price" placeholder="イベントの値段"></s:textfield>
		<br>
		<label for="ticket">チケットの枚数</label>
		<s:textfield name="ticket" placeholder="チケットの枚数"></s:textfield>
		<s:submit laber="商品の追加！" type="button" />
	</s:form>

</body>
</html>