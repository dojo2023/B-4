<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆったりへるすけあ</title>
</head>
<body>
<div style="text-align: right;">
<a href="/komatsukita/LoginServlet">ログインページに戻る</a>
</div>
<div style="text-align: center;">
    <img src="img/neko.png" width="300" height="200">

<form method="POST" action="/komatsukita/RegistServlet">

<input type="text" name="ID" placeholder="ID"><br>
<input type="password" name="PW" placeholder="パスワード"><br>
<input type="text" name="USER" placeholder="ユーザー名"><br>

<input type="submit" name="REGIST" value="登録"><br>
</form>
</div>
</body>
</html>