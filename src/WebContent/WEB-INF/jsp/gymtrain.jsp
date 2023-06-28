<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ジム用トレーニング</title>
<link rel="stylesheet" href="/komatsukita/css/hum.css">
<style>
.tree-img {
	background-image: url("img/tile.jpg"); 
	
}
</style>
</head>
<body>
<div class = "tree-img">
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
            <a href="/komatsukita/HomeServlet">体重管理</a>
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
<h1>ジム用トレーニング</h1>
<h2>トレーニングメニュー</h2>
<form method="POST" action="/komatsukita/HometrainServlet">
    <img src="/komatsukita/img/map2.png" usemap="#ImageMap" alt="" />
    <map name="ImageMap">
      <area shape="rect" coords="143,295,199,326" href="/komatsukita/TraincheckServlet?parts_name=体力" alt="体力" />
      <area shape="rect" coords="291,193,362,225" href="/komatsukita/TraincheckServlet?parts_name=お腹" alt="お腹" />
      <area shape="rect" coords="280,309,333,338" href="/komatsukita/TraincheckServlet?parts_name=脚" alt="脚" />
      <area shape="rect" coords="393,184,454,220" href="/komatsukita/TraincheckServlet?parts_name=背中" alt="背中" />
      <area shape="rect" coords="365,228,412,259" href="/komatsukita/TraincheckServlet?parts_name=腕" alt="腕" />
    </map>
</form>
<br>
 <a href="/komatsukita/TrainingServlet" style="display: inline-block; padding: 5px; background-color: 	#008CAF; color: white; text-decoration: none;">トレーニング選択ページに戻る</a>
 </div>
</body>
</html>