<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆるっとへるすけあ</title>
<link rel="stylesheet" href="/komatsukita/css/style.css">
</head>
<body>
<h1><c:out value="${result.title}" /></h1>
<hr>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">戻る</a>
</body>
</html>
