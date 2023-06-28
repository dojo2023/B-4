<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ゆるっとへるすけあ</title>
<link rel="stylesheet" href="/komatsukita/css/weight.css">
<link rel="stylesheet" type="text/css" href="/komatsukita/css/hum.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<link rel="stylesheet" href = "/komatsukita/css/style.css">
</head>
<body>
<div class="hamburger-menu">
        <div class="hamburger-menu__icon">
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
    <ul class="accordion-menu">
        <li class="accordion-menu__item">
            <a href="/komatsukita/HomeServlet">ホーム</a>
        </li>
        <li class="accordion-menu__item">
            <a href="/komatsukita/WeightServlet">体重管理</a>
        </li>
        <li class="accordion-menu__item">
            <a href="/komatsukita/NutritionServlet">栄養管理</a>
        </li>
        <li class="accordion-menu__item">
            <a href="/komatsukita/TrainingServlet">トレーニング</a>
        </li>
        <li class="accordion-menu__item">
            <a class="accordion-menu__link" href="#">トレーニング例（家）</a>
            <div class="accordion-menu__content">
                <ul>
                    <li><a href="/komatsukita/HomearmServlet">トレーニング（腕）</a></li>
                    <li><a href="/komatsukita/HomebehindServlet">トレーニング（背中）</a></li>
                    <li><a href="/komatsukita/HomelegServlet">トレーニング（脚）</a></li>
                    <li><a href="/komatsukita/HomesixpackServlet">トレーニング（お腹）</a></li>
                    <li><a href="/komatsukita/HomepowerServlet">トレーニング（体力）</a></li>
                </ul>
            </div>
        </li>
        <li class="accordion-menu__item">
            <a class="accordion-menu__link" href="#">トレーニング例（ジム）</a>
            <div class="accordion-menu__content">
                <ul>
                    <li><a href="/komatsukita/GymarmServlet">トレーニング（腕）</a></li>
                    <li><a href="/komatsukita/GymbehindServlet">トレーニング（背中）</a></li>
                    <li><a href="/komatsukita/GymlegServlet">トレーニング（脚）</a></li>
                    <li><a href="/komatsukita/GymsixpackServlet">トレーニング（お腹）</a></li>
                    <li><a href="/komatsukita/GympowerServlet">トレーニング（体力）</a></li>
                </ul>
            </div>
        </li>
        <li class="accordion-menu__item">
            <a href="/komatsukita/GameServlet">育成ゲーム</a>
        </li>
        <!--  <li class="accordion-menu__item">
            <a href="">ランキング</a>
        </li> -->
        <li class="accordion-menu__item">
            <a href="/komatsukita/FriendServlet">友達追加</a>
        </li>
        <li class="accordion-menu__item">
            <a href="/komatsukita/FriendlistServlet">フレンドリスト</a>
        </li>
        <li class="accordion-menu__item">
            <a href="/komatsukita/LoginServlet">ログアウト</a>
        </li>
    </ul>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.hamburger-menu__icon').click(function () {
                $('.accordion-menu').slideToggle();
                $(this).toggleClass('open');
            });
            $('.accordion-menu__link').click(function (e) {
                e.preventDefault();
                $(this).next('.accordion-menu__content').slideToggle();
            });
        });
    </script>
<h1>たいじゅうかんり</h1>
<hr>

<input type="submit" name="TERM" value="一週間" class="button">
<input type="submit" name="TERM" value="１か月" class="button">
<input type="submit" name="TERM" value="３か月" class="button">
<input type="submit" name="TERM" value="半年" class="button">

<c:if test="${empty weight}">
		<p>一致するデータはありません</p>
	</c:if>

<c:forEach var="e" items="${weight}" varStatus="status">
<form method="POST" action="sampleTest/WeightServlet.java">
data1<input id="${status.index}data1" type="text" name="data1" value="${e.data1}"><br>
data2<input	id="${status.index}data2" type="text" name="data2" value="${e.data2}"><br>
data3<input	id="${status.index}data3" type="text" name="data3" value="${e.data3}">

</form>
<hr>
</c:forEach>
<form>
<input id="target" type="hidden" value="${target}">
</form>

<div class="chart-container" >
<canvas id="Chart" ></canvas>
</div>
<script>
data0=[65, 64, 63];
data1=[60, 60, 60];



</script>
<script src="/komatsukita/js/weightchart.js"></script>
理想体重<input type="text" name="DREAMWEIGHTS"><br>
開始日<input type="text" name="STARTS"><br>
期限日<input type="text" name="DEADLINES"><br>
今日の体重<input type="text" name="REALWEIGHTS"><br>
<input type="submit" name="REGIST" value="登録" class="button"><br>
</body>
</html>