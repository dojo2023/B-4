<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フレンド登録</title>
</head>
<link rel="stylesheet" type="text/css" href="friend.css">

<body>

    <img src="/komatsukita/img/komatsu12.png" width="260" height="100" alt="女の子">
    <h1>ともだち</h1>
    <form action="friendRegistration.jsp" method="get" id="searchForm">
        <input type="search" name="search" placeholder="IDをにゅうりょくする" id="searchInput">
        <input type="image" src="/komatsukita/img/search.png" width="30" height="30" alt="検索" value="検索する">
    </form>

    <script>
        'use strict';
        document.getElementById('searchForm').addEventListener('submit', function(event) {
            event.preventDefault(); // フォームのデフォルトの送信動作をキャンセルする

            var searchInput = document.getElementById('searchInput').value;
            // ここでデータベースに対して検索を行う処理を実装する
            // 仮にsearchInputがフレンドのIDと一致するかどうかを判定する

            // 仮に一致するIDがあるとする
            var foundFriend = true;

            if (foundFriend) {
                // サブウィンドウを開く
                var confirmWindow = window.open("", "confirmWindow", "width=400,height=200");
                confirmWindow.document.write("<p>登録する？</p>");
                confirmWindow.document.write("<button onclick=\"registerFriend()\">はい</button>");
                confirmWindow.document.write("<button onclick=\"closeWindow()\">いいえ</button>");
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
</body>
</html>
