<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Design</title>
<link rel="stylesheet" type="text/css" href="css/10.Design.css">
<link rel="stylesheet" type="text/css" href="css/botan.css">
</head>
<body>
<!--ヘッダーを入れる-->

<div class="design-main">

	<div class="main-top"><h1>絵柄一覧</h1>
		<div class="main-top">好きな絵柄をクリックして確定を押してください</div>
	</div>

	<div class="choose">

		<div class="choose-top">
			  <s:form action="ReturnEgaraAction" namespace="/">
					<table>
						<tr>
							<th><img src="img/mackey.jpg"></th>
							<th><img src="img/mannie.jpg"></th>
							<th><img src="img/dolnad.jpg"></th>
							<th><img src="img/doisy.jpg"></th>
							<th><img src="img/gufy.png"></th>
							<th><img src="img/poluto.jpg"></th>
						</tr>
						<tr>
							<td><s:radio list="#{'mackey':'マッキー'}" name="character"/></td>
							<td><s:radio list="#{'mannie':'マニー'}" name="character" /></td>
							<td><s:radio list="#{'dolnad':'ドルナド'}" name="character"/></td>
							<td><s:radio list="#{'doisy':'ドイジー'}" name="character"/></td>
							<td><s:radio list="#{'gufy':'グッフィー'}" name="character"/></td>
							<td><s:radio list="#{'poluto':'ポルート'}" name="character"/></td>
						</tr>
<!--チケット画像６枚以上になる場合
						<tr class="border-img">
							<td><img src="http://cdn.amanaimages.com/preview640/11002025484.jpg"></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><input type="radio" name="q1" value="マッキー"> マッキー</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					-->
						</table>
						<div class="button-box">
						<s:submit cssClass="button9"  value="確定"/>
						</div>
				</s:form>
		</div>

	</div>

				<br>


</div>

<!-- フッターを入れる -->
</body>
</html>
