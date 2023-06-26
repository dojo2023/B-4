<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
    .calendar {
      font-family: Arial, sans-serif;
      width: 300px;
      padding: 10px;
      border: 1px solid #ccc;
      background-color: #f9f9f9;
    }

    .calendar h2 {
      text-align: center;
    }

    .calendar .month {
      margin-bottom: 10px;
    }

    .calendar .weekdays {
      display: flex;
      justify-content: space-between;
      margin-bottom: 5px;
      font-weight: bold;
    }

    .calendar .days {
      display: flex;
      flex-wrap: wrap;
    }

    .calendar .day {
      width: 40px;
      height: 40px;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
    }

    .calendar .day:hover {
      background-color: #eee;
    }

    .calendar .selected {
      background-color: #428bca;
      color: #fff;
    }

  </style>
  <link rel="stylesheet" href="/komatsukita/css/home.css">
  <link rel="stylesheet" href="/komatsukita/css/hum.css">
  <link rel="stylesheet" href="css/calender_sample.css">
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
<h1>
	<span class = "hm">
    	ゆるっとほーむ
	</span>
</h1>
<div class = "komatsu4">
	<img src="/komatsukita/img/homewoman.png" width="260" height="130"><br>
</div>
<div class = "moku">
	<div class="group">
	   <label for="text3" id="l_text3">理想体重</label><br>
	   <input id="text3" type="text" placeholder="体重を入力する(数字のみ)">
	   <div class="text_underline"></div><br>
	   <label for="text4" id="l_text4">目的</label>
	   <input id="text4" type="text" placeholder="目的を入力する">
	   <div class="text_underline"></div><br>
	</div>

</div>
<div class = "ma">
	<div class = "start">
		<p>開始日</p><br>
		<input type="date" name="calendar1" >
	</div>
	<div class = "last">
		<p>期限日</p><br>
		<input type="date" name="calendar2" value = "開始日"><br>
	</div>
</div>
<div class="body">
<button id="prev" type="button">前の月</button>
            <button id="next" type="button">次の月</button>
            <div id="calendar"></div>
           <script src="js/calender_sample.js"></script>
</div>
			<div id="weight_list">
				<c:forEach var="e" items="${weightList}" varStatus="status">
					<form>
						<input type="hidden" name="weight" value="${e.weight}" id="weight${status.index}"> <br>
						<input type="hidden" name="date" value="${e.created_date}" id="date${status.index}"> <br>
						<input type="hidden" name="time" value="${e.created_time}" id="time${status.index}"> <br>
						<input type="hidden" name="count" class="${status.last}" id="${status.index}"> <br>




					</form>

				</c:forEach>
			</div>
	<!-- カレンダーを作る -->

<!--  	 <div class="container-calendar">
          <h4 id="monthAndYear"></h4>
          <div class="button-container-calendar">
              <button id="previous" onclick="previous()">‹</button>
              <button id="next" onclick="next()">›</button>
          </div>

          <table class="table-calendar" id="calendar" data-lang="ja">
              <thead id="thead-month"></thead>
              <tbody id="calendar-body"></tbody>
          </table>

          <div class="footer-container-calendar">
              <label for="month">日付指定：</label>
              <select id="month" onchange="jump()">
                  <option value=0>1月</option>
                  <option value=1>2月</option>
                  <option value=2>3月</option>
                  <option value=3>4月</option>
                  <option value=4>5月</option>
                  <option value=5>6月</option>
                  <option value=6>7月</option>
                  <option value=7>8月</option>
                  <option value=8>9月</option>
                  <option value=9>10月</option>
                  <option value=10>11月</option>
                  <option value=11>12月</option>
              </select>
              <select id="year" onchange="jump()"></select>
          </div>
    </div>

    <script src="js/calendar.js" type="text/javascript"></script>-->


</body>
</html>