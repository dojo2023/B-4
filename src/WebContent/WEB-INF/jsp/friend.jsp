<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>フレンド登録</title>
</head>
<link rel="stylesheet" href="/komatsukita/css/friend.css">
<link rel="stylesheet" href="/komatsukita/css/hum.css">

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
	<span class = "frmain">
    <img src="/komatsukita/img/komatsu12.png" width="250" height="180" alt="女の子">
    <h1>ともだち</h1>
    <form action="friendRegistration.jsp" method="get" id="searchForm">
        <input type="search" name="search" placeholder="IDをにゅうりょくする" id="searchInput">
       <input type="image" src="/komatsukita/img/search.png" width="30" height="30" alt="検索" value="検索する">
   <input type="submit value="検索する"">
    </form>


    <script>
        'use strict';
        document.getElementById('searchForm').addEventListener('submit', function(event) {
            event.preventDefault(); // フォームのデフォルトの送信動作をキャンセルする

            var searchInput = document.getElementById('searchInput').value;
            // ここでデータベースに対して検索を行う処理を実装する
            // 仮にsearchInputがフレンドのIDと一致するかどうかを判定する
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/komatsukita/FriendCheckServlet',false);
			xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');
			xhr.send( 'search='+ searchInput );
		    if(xhr.readyState === 4 && xhr.status === 200) {
		        //window.alert( xhr.responseText );
		    }
            // 仮に一致するIDがあるとする
          <!--  var foundFriend = true; -->

            if (xhr.responseText == "true") {
                // サブウィンドウを開く
                var confirmWindow = window.open("", "confirmWindow", "width=400,height=200");
                confirmWindow.document.clear();

                confirmWindow.document.write("<form action=\"/komatsukita/FriendServlet\" method=\"POST\" >");
                confirmWindow.document.write("<p>とうろくする？</p>");
                //confirmWindow.document.write("<button onclick=\"registerFriend()\">はい</button>");
                confirmWindow.document.write("<input type=\"hidden\" name=\"user_id\" value=\""+searchInput+"\">");

                confirmWindow.document.write("${user_name}");
                confirmWindow.document.write("<input type=\"submit\" value=\"はい\">");
                confirmWindow.document.write("<button onclick=\"closeWindow()\">いいえ</button>");
                confirmWindow.document.write("</form>");
            } else {
                // 一致するIDがない場合の処理
                alert("一致するIDがありません");
            }
        });

        function registerFriend() {
            // 友達をフレンドリストに登録する処理を記述する
            alert("登録しました");
            closeWindow();
        }

        function closeWindow() {
            window.close(); // サブウィンドウを閉じる
        }
    </script>
    </span>
</body>
</html>
