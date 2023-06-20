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
</head>

<body>
<h1>ゆるすけあ</h1>
<div class = "komatsu4">
	<img src="/komatsukita/img/homewoman.png" width="260" height="130"><br>
</div>
	<input type ="text" name = "dreamweight" placeholder = "もくひょうたいじゅう">
	<input type = "text" name = "mokuteki" placeholder="もくてき"><br>
	<input type="date" name="calendar1" value = "開始日">
	<input type="date" name="calendar1" value = "開始日">
	<!-- カレンダーを作る -->
	<button id="prev" type="button">前の月</button>
	<button id="next" type="button">次の月</button>
	<div id="calendar"></div>
<div class="calendar">
    <h2>カレンダー</h2>
    <div class="month">
      <select id="month">
        <option value="0">1月</option>
        <option value="1">2月</option>
        <option value="2">3月</option>
        <option value="3">4月</option>
        <option value="4">5月</option>
        <option value="5">6月</option>
        <option value="6">7月</option>
        <option value="7">8月</option>
        <option value="8">9月</option>
        <option value="9">10月</option>
        <option value="10">11月</option>
        <option value="11">12月</option>
      </select>
      <select id="year">
        <option value="2021">2021年</option>
        <option value="2022">2022年</option>
        <option value="2023">2023年</option>
      </select>
    </div>
    <div class="weekdays">
      <div>日</div>
      <div>月</div>
      <div>火</div>
      <div>水</div>
      <div>木</div>
      <div>金</div>
      <div>土</div>
    </div>
    <div class="days" id="days"></div>
  </div>

  <script>
    function createCalendar(month, year) {
      var daysElement = document.getElementById("days");
      daysElement.innerHTML = "";

      var date = new Date(year, month, 1);
      var currentMonth = date.getMonth();
      while (date.getMonth() === currentMonth) {
        var day = document.createElement("div");
        day.classList.add("day");
        day.textContent = date.getDate();
        day.addEventListener("click", function() {
          var selectedDay = document.querySelector(".day.selected");
          if (selectedDay) {
            selectedDay.classList.remove("selected");
          }
          this.classList.add("selected");
          console.log(year + "-" + (month + 1) + "-" + this.textContent);
        });
        daysElement.appendChild(day);
        date.setDate(date.getDate() + 1);
      }
    }

    var monthSelect = document.getElementById("month");
    var yearSelect = document.getElementById("year");

    monthSelect.addEventListener("change", function() {
      var month = parseInt(this.value);
      var year = parseInt(yearSelect.value);
      createCalendar(month, year);
    });

    yearSelect.addEventListener("change", function() {
      var month = parseInt(monthSelect.value);
      var year = parseInt(this.value);
      createCalendar(month, year);
    });

    // ページ読み込み時にカレンダーを表示
    var initialMonth = new Date().getMonth();
    var initialYear = new Date().getFullYear();
    createCalendar(initialMonth, initialYear);
  </script>
</body>
</html>