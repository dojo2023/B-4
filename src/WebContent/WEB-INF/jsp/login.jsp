<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆったりへるすけあ</title>
</head>
<body>
<div style="text-align: center;">

<img src="img/hukkin.png" width="300" height="200"><br>
<img src="img/logo.png" width="400" height="100">

<form method="POST" action="/komatsukita/LoginServlet">
<input type="text" name="ID" placeholder="ID"><br>
<input type="password" name="PW" placeholder="パスワード"><br>

<input type="submit" name="LOGIN" value="ログイン"><br>
</form>

<a href="/komatsukita/RegistServlet">新規登録はこちらから</a>
</div>

</body>
</html>