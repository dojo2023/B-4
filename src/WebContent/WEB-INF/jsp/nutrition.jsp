 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>栄養管理</title>
 <link rel="stylesheet" href="/komatsukita/css/nutrition.css">
 <link rel="stylesheet" href="/komatsukita/css/hum.css">
 <style>
 	.tree-img {
	background-image: url("img/tile.jpg"); 
	height: 800px;
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

<div style="text-align: left;">

<img src="img/eiyoukannri.png" width="200" height="50"><br>
</div>
<br>

<div class="muri center">
    <label for="sample">目的を選択</label>
    <div class="col-auto my-1">
      <select class="form-control" id="sample" onchange="viewChange();">
        <option value="select1">体を鍛えたい（タンパク質）</option>
        <option value="select2">食生活の改善（ビタミン重視）</option>
        <option value="select3">瘦せたい、ダイエット（脂質抜きダイエット）</option>
        <option value="select4">瘦せたい、ダイエット（糖質抜きダイエット）</option>
        <option value="select5">日々の健康維持（ミネラル）</option>
      </select>
    </div>
  </div>

<br>

<div class="col-auto my-5 center">
<div id="Box1" class="my-5" style="display:none;">
    <p>
        鶏むね肉（皮なし）100g(24.4g)→ガーリック醤油チキン、唐揚げ<br>
        さけ100g(22.3g)→ムニエル、サーモンと新玉ねぎのマリネ<br>
        たまご(12.3g)→玉子焼き、オムレツ<br>
        牛乳<br>
        豆乳<br>
        プロテイン<br>
    </p>
</div>
<div id="Box2" class="my-5" style="display:none;">
    <p>
        赤ピーマン100g(170mg)→ガパオライス<br>
        ブロッコリー100g(120mg)→ブロッコリーのペペロンチーノ<br>
        サツマイモ100g(29mg)→ドンキの焼き芋<br>
        キウイフルーツ（黄）100g(140mg)<br>
        キウイフルーツ（緑）100g(69mg)<br>
        イチゴ100g(62mg)<br>
    </p>
</div>
<div id="Box3" class="my-5" style="display:none;">
    <p>
豆腐ハンバーグ<br>
マグロのステーキ<br>
親子丼<br>
低脂肪牛乳<br>
低脂肪ヨーグルト<br>
鶏ささみ<br>
    </p>
</div>
<div id="Box4" class="my-5" style="display:none;">
    <p>
        玄米<br>
        そば<br>
        納豆<br>
        きのこ<br>
        こんにゃくと大豆の煮物<br>
        ひじきの煮物<br>
    </p>
</div>
<div id="Box5" class="my-5" style="display:none;">
    <p>
        レバニラ<br>
        味噌汁<br>
        きな粉がけヨーグルト<br>
        牡蠣<br>
        たらこ<br>
        アーモンド<br>
        カシューナッツ<br>
        焼き海苔<br>
    </p>
</div>
</div>
<img src="/komatsukita/img/shell.png" width="260" height="250" alt="女の子">
<script>
function viewChange() {
    var id = document.getElementById('sample').value;
    document.getElementById('Box1').style.display = "none";
    document.getElementById('Box2').style.display = "none";
    document.getElementById('Box3').style.display = "none";
    document.getElementById('Box4').style.display = "none";
    document.getElementById('Box5').style.display = "none";

    if (id === 'select1') {
        document.getElementById('Box1').style.display = "block";
    } else if (id === 'select2') {
        document.getElementById('Box2').style.display = "block";
    } else if (id === 'select3') {
        document.getElementById('Box3').style.display = "block";
    } else if (id === 'select4') {
        document.getElementById('Box4').style.display = "block";
    } else if (id === 'select5') {
        document.getElementById('Box5').style.display = "block";
    }
}

window.onload = viewChange;
</script>
</div>
</body>
</html>

<!-- https://bonoponz.hatenablog.com/entry/2020/05/12/%E3%80%90Web%E3%80%91%E3%83%97%E3%83%AB%E3%83%80%E3%82%A6%E3%83%B3%E3%81%A7%E8%A1%A8%E7%A4%BA%E5%86%85%E5%AE%B9%E3%82%92%E5%88%87%E3%82%8A%E6%9B%BF%E3%81%88%E3%82%8B#HTML-1参考 -->
