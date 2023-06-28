<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゆるっとへるすけあ</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/komatsukita/css/hum.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
<link rel="stylesheet" href="/komatsukita/css/stylechart.css">
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


	<c:if test="${empty weights}">
		<p>一致するデータはありません</p>
	</c:if>

	<!--  今回はvarStatusを用いてループの回数を先頭に付けたindexを設定している-->


	//グラフの描画領域
	<div class="chart-container">
		<canvas id="Chart"></canvas>
	</div>
	<!--目標体重  -->
<p id="target" style="visibility: hidden">${target[0].target}</p>
<!--  体重データ読み込み、表示部分 -->
	<c:forEach var="e" items="${weights}" varStatus="status">
		<form method="POST" action="sampleTest/WeightServlet.java">
			<input type="hidden" id="user_id${status.index}"
				value="${e.user_id}"><br>
			<input  type="hidden" id="weight${status.index}"
				value="${e.weight}"><br>
			<input	 type="hidden" id="date${status.index}"
				value="${e.date}">
				<input  type="hidden" class="weight_${status.last}" id = "${status.index}" value = "${status.index}"><br>
		</form>

	</c:forEach>
	<script src="/komatsukita/js/script.js"></script>
	理想体重<input type="text" name="DREAMWEIGHTS"><br>
	開始日<input type="text" name="STARTS"><br>
	期限日<input type="text" name="DEADLINES"><br>
	今日の体重<input type="text" name="REALWEIGHTS"><br>
	<input type="submit" name="REGIST" value="登録" class="button"><br>
</body>
</html>