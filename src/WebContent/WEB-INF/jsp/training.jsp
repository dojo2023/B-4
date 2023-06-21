<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/komatsukita/css/hum.css">
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

<h1>トレーニングをえらんでね</h1>
    <a href="/komatsukita/HometrainServlet">家庭用トレーニング</a>

    <img src="/komatsukita/img/senpuki.png" width="300" height="200" alt="女の子">

<br>
    <a href="/komatsukita/GymtrainServlet">ジム用トレーニング</a>
    <img src="/komatsukita/img/inusan.png" width="300" height="200" alt="女の子">
</body>
</html>