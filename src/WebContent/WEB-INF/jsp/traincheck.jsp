<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>traincheck</title>
<style>
	.tree-img {
	background-image: url("img/tile.jpg"); 
	height: 550px;
}
</style>
</head>
<body>
<div class = "tree-img">
<h1>かくにん</h1>
<img src="/komatsukita/img/nekotatsu.png" width=200;>
<p>カレンダーに登録しますか？</p>

<form method="POST" action="/komatsukita/TraincheckServlet">
	<input type="text" name="kakunin" value="${parts_name}">

	<input type="submit" name="sub" value="登録"><br>

</form>
<a href="/komatsukita/HomeServlet">ホームに戻る</a>
</div>
</body>
</html>