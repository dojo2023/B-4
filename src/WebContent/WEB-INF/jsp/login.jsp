<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプル名刺管理</title>
<link rel="stylesheet" href="/simpleBC/css/login.css">
</head>
<body>
<hr>
<form  class="box" method="POST" action="/simpleBC/LoginServlet">
<h1>LOGIN</h1>
<input type="text" name="ID" placeholder="ID">
<input type="password" name="PW" placeholder="Password">
<input type="submit" name="LOGIN" value="Login">
</form>
<a href="/simpleBC/RegistIdpwServlet" class="new-regist">新規登録</a>
</body>
</html>
