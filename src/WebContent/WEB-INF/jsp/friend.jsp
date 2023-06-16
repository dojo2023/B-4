<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フレンド登録</title>
</head>

<body>
    <img src="/komatsukita/img/komatsu12.png" width="260" height="100" alt="女の子">
    <h1>ともだち</h1>

    <form action="friendRegistration.jsp" method="get">
        <input type="search" name="search" placeholder="IDをにゅうりょくする">
        <input type="image" src="/komatsukita/img/kuri.png" width="30" height="30"alt="検索" value="検索する">
    </form>



<form method="POST" action="/simpleBC/RegistServlet">
<table class="wakusen">
<tr>
<th>番号</th>    <td><input type="text" name="NUMBER"></td>
</tr>

<tr>
<th>会社名</th><td><input type="text" name="COMPANY"></td>
</tr>
<tr><th>部署名</th><td><input type="text" name="DEPARTMENT"></td></tr>
<tr><th>役職名</th><td><input type="text" name="POSITION"></td></tr>
<tr><th>氏名</th><td><input type="text" name="NAME"></td></tr>
<tr><th>郵便番号</th><td><input type="text" name="ZIPCODE"></td></tr>
<tr><th>住所</th><td><input type="text" name="ADDRESS"></td></tr>
<tr><th>電話番号</th><td><input type="text" name="PHONE"></td></tr>
<tr><th>FAX番号</th><td><input type="text" name="FAX"></td></tr>
<tr><th>メールアドレス</th><td><input type="text" name="EMAIL"></td></tr>
<tr><th>備考</th><td><input type="text" name="REMARKS"></td></tr>
</table>
<!--<input type="submit" name="REGIST" value="登録">  -->
<input type="submit" name="REGIST" value="登録" onClick="confirmRegistration(event)">

</form>

<br>
<br>
<a href="/simpleBC/MenuServlet">ホーム画面に戻る</a>


 <div id="footer">
<p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>



</div>

<!-- ジャバスクリプト -->
<script>
  'use strict';




	function confirmRegistration(event) {
	  // ユーザーに確認メッセージを表示
	  var result = confirm("登録しますか？");

	  // はい ボタンがクリックされた場合はフォームの処理を続行
	  if (!result) {
	    event.preventDefault(); // フォームの送信をキャンセル
	  }
	}

</script>
</body>
</html>
<!-- https://webukatu.com/wordpress/blog/25972/ これが検索の奴の参考したやつ.下のやつはGPTに聞いたやつ、たぶんDBなきゃわからん
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フレンド登録</title>
</head>

<body>
    <img src="/komatsukita/img/komatsu12.png" width="260" height="100" alt="女の子">
    <h1>ともだち</h1>

    <form id="friendSearchForm" action="friendRegistration.jsp" method="get">
        <input type="search" id="searchInput" name="search" placeholder="IDをにゅうりょくする">
        <input type="image" src="/komatsukita/img/kuri.png" width="30" height="30" alt="検索" value="検索する">
    </form>

    <div id="friendProfile" style="display: none;">
        <!-- プロフィール情報を表示する領域 -->
        <!--  <h2>プロフィール</h2>
        <p id="profileId"></p>
        <p id="profileName"></p>
        <p id="profileEmail"></p>
        <button id="registerButton" onclick="registerFriend()">登録する</button>
    </div>

    <script>
        function registerFriend() {
            // 友達をフレンドリストに登録する処理を記述する

            // 例: Ajaxリクエストを使用してサーバーに登録を送信するなど
        }

        document.getElementById('friendSearchForm').addEventListener('submit', function(event) {
            event.preventDefault(); // フォームのデフォルトの送信動作をキャンセルする

            var searchInput = document.getElementById('searchInput');
            var profileId = document.getElementById('profileId');
            var profileName = document.getElementById('profileName');
            var profileEmail = document.getElementById('profileEmail');
            var friendProfile = document.getElementById('friendProfile');

            // 検索処理を実行し、プロフィール情報を取得する（仮のデータを使用）
            var searchId = searchInput.value;
            var profileData = getProfileData(searchId); // プロフィール情報を取得する関数（仮の実装）

            if (profileData) {
                // プロフィール情報を表示してフレンド登録を確認する領域を表示する
                profileId.textContent = "ID: " + profileData.id;
                profileName.textContent = "名前: " + profileData.name;
                profileEmail.textContent = "メールアドレス: " + profileData.email;
                friendProfile.style.display = "block";
            } else {
                // プロフィールが見つからなかった場合はエラーメッセージを表示するなどの処理を追加できます
                console.log("プロフィールが見つかりませんでした");
            }
        });

        //

-->