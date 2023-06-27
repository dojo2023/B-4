<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>育成ゲームページ</title>
<link rel="stylesheet" href="css/stylehealth.css">
<link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet">
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
<div class = main>
<h1><img src="img/yanderelogo.png" alt=""></h1>

<!-- リクエストスコープに入っているファイル名をここに貼り付ける -->
<img id="serifu" src="img/${serif_chara.serif}" alt ="" width="180" height="300">
<!-- リクエストスコープに入っているファイル名をここに貼り付ける -->
<img id="mypic" src="img/${serif_chara.chara_file}" alt ="" width="300" height="350">
<br>
<br>
<br>
<button onclick="slideshow()">パワー！！！</button>
<p>1日1回のログインで<br>
1ポイントもらえるぞ
</p>
<br>
<p>女の子の成長は<br>
1週間でリセットされるぞ
</p>
<br>
<p>1ポイント消費で<br>
ボタンを一回押して女の子に元気を送ろう
</p>
<br>

<p>残りポイントは<br>7pt</p>
Copyright © 2023 komatsukita All Right Reserved.
</div>
<script src="game"></script>
<script>
var images_src = new Array("img/yandere1.png", "img/yandere2.png", "img/yandere2.png", "img/yandere3.png", "img/yandere3.png", "img/yandere4.png", "img/yandere5.png");
var serifus = new Array("img/serifu1.png", "img/serifu2.png", "img/serifu3.png", "img/serifu4.png", "img/serifu5.png", "img/serifu6.png"
, "img/serifu7.png");
var currentIndex = 0;


function slideshow() {
    document.getElementById("mypic").src = images_src[currentIndex];
    document.getElementById("serifu").src = serifus[currentIndex];

    currentIndex++;
    if (currentIndex >= images_src.length) {
        currentIndex = 0;
    }
}

</script>
</body>
</html>