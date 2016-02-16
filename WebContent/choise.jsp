<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>選択一覧</title>
<link rel="stylesheet" type="text/css" href="css/botan2.css">
<link rel="stylesheet" type="text/css" href="css/07.erabu.css">
<link rel="stylesheet" type="text/css" href="css/botan.css">

</head>
<body>
		<div class="kan"align="center">
			<a>選択一覧</a>
		</div>

		<c:forEach var="i" begin="1" end="3" step="1" >
		<div class="itirann"align="center">
			<table border="1">
				<tr>
					<th rowspan="5"class="1">
						1
					</th>
					<td class="no">
						チケット種別
					</td>
					<td class="no">
						入園日&nbsp;・&nbsp;有効期限
					</td>
				</tr>
				<tr>
					<td class="tiketto">
						一般チケット
					</td>
					<td class="hizuke">
						２０１６年０２月０９日～
						<br>
						２０１６年０２月０９日
						&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2"class="no">
						絵柄
					</td>
				</tr>
				<tr>
					<td rowspan="2">
				<c:choose>
				<c:when test="${list.get(i)}"><img src="img/mackey.jpg"><td class="egara">絵柄名&nbsp;:&nbsp;マッキー</c:when>
				<c:when test="${list.get(i)}"><img src="img/mannie.jpg"><td class="egara">絵柄名&nbsp;:&nbsp;マニー</c:when>
				<c:when test="${list.get(i)}"><img src="img/dolnad.jpg"><td class="egara">絵柄名&nbsp;:&nbsp;ドルナド</c:when>
				<c:when test="${list.get(i)}"><img src="img/doisy.jpg"><td class="egara">絵柄名&nbsp;:&nbsp;ドイジー</c:when>
				<c:when test="${list.get(i)}"><img src="img/gufy.png"><td class="egara">絵柄名&nbsp;:&nbsp;グッフィ</c:when>
				<c:when test="${list.get(i)}"><img src="img/poluto.jpg"><td class="egara">絵柄名&nbsp;:&nbsp;ポルート</c:when>
				<c:when test="${list.isEmpty()}"><img src="img/mackey.jpg"><td class="egara">絵柄名&nbsp;:&nbsp;マッキー</c:when>
				</c:choose>
					</td>
				</tr>
				<tr>
					<td><s:form action="GoEgaraAction" namespace="/">
						<s:submit cssClass="button9"  value="絵柄変更"/>
						</s:form>
					</td>
				</tr>
			</table>
		</div>
		</c:forEach>

		<div align="center">
		<s:form action="ReturnSelectAction" namespace="/">
			<s:submit cssClass="button9"  value="確認画面へ"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			</s:form>

			<s:form action="GoPurchaseAction" namespace="/">
			<s:submit cssClass="button9"  value="戻る"/>
			</s:form>
		</div>
</body>
</html>