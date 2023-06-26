/**
 *
 */
'use strict';

const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1
const config = {
	show: 1,
}

function showCalendar(year, month) {
	for (let i = 0; i < config.show; i++) {
		const calendarHtml = createCalendar(year, month)
		const sec = document.createElement('section')
		sec.innerHTML = calendarHtml
		document.querySelector('#calendar').appendChild(sec)

		month++
		if (month > 12) {
			year++
			month = 1
		}
	}
}

function createCalendar(year, month) {
	const startDate = new Date(year, month - 1, 1) // 月の最初の日を取得
	const endDate = new Date(year, month, 0) // 月の最後の日を取得
	const endDayCount = endDate.getDate() // 月の末日
	const lastMonthEndDate = new Date(year, month - 2, 0) // 前月の最後の日の情報
	const lastMonthendDayCount = lastMonthEndDate.getDate() // 前月の末日
	const startDay = startDate.getDay() // 月の最初の日の曜日を取得
	let dayCount = 1 // 日にちのカウント
	let calendarHtml = '' // HTMLを組み立てる変数

	calendarHtml += '<h1>' + year + '/' + month + '</h1>'
	calendarHtml += '<table>'

	// 曜日の行を作成
	for (let i = 0; i < weeks.length; i++) {
		calendarHtml += '<td>' + weeks[i] + '</td>'
	}

	for (let w = 0; w < 6; w++) {
		calendarHtml += '<tr>'

		for (let d = 0; d < 7; d++) {
			if (w == 0 && d < startDay) {
				// 1行目で1日の曜日の前
				let num = lastMonthendDayCount - startDay + d + 1
				calendarHtml += '<td class="is-disabled">' + num + '</td>'
			} else if (dayCount > endDayCount) {
				// 末尾の日数を超えた
				let num = dayCount - endDayCount
				calendarHtml += '<td class="is-disabled">' + num + '</td>'
				dayCount++
			} else {
				calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}">${dayCount}</td>`
				dayCount++
			}
		}
		calendarHtml += '</tr>'
	}
	calendarHtml += '</table>'

	return calendarHtml
}

//以下追加
//表示されているカレンダーの年月を取得
let year_month;
let display_year_month;
let display_year = year;
//月は1桁の時は前に0をつける
let display_month_pre;
let display_month = month;




//ここまで追加


function moveCalendar(e) {
	document.querySelector('#calendar').innerHTML = ''

	if (e.target.id === 'prev') {
		month--

		if (month < 1) {
			year--
			month = 12
		}
	}

	if (e.target.id === 'next') {
		month++

		if (month > 12) {
			year++
			month = 1
		}
	}

	showCalendar(year, month)

	//以下追加
	year_month = document.getElementById("calendar");

	display_year_month = year_month.querySelector("h1").textContent;
	//console.log("year_day:" + display_year_month);
	display_year = display_year_month.substring(0, 4);
	//console.log("year:" + display_year);
	//月は1桁の時は前に0をつける
	display_month_pre = display_year_month.substring(5, 8);
	display_month = display_month_pre.padStart(2, '0');


	//console.log("month:" + display_month);


	parts_name_insert();

	//ここまで追加

}

document.querySelector('#prev').addEventListener('click', moveCalendar)
document.querySelector('#next').addEventListener('click', moveCalendar)

document.addEventListener("click", function(e) {
	if (e.target.classList.contains("calendar_td")) {
		// dataを日付型に型変換し年、月、日で分解し格納
		var OnclickDate = new Date(e.target.dataset.date);
		var selected_year = OnclickDate.getFullYear();
		var selected_month = OnclickDate.getMonth() + 1;
		var selected_day = OnclickDate.getDate();
		// 過去か未来かで分岐処理
		if (OnclickDate > date) {
			alert("未来" + selected_year + "年" + selected_month + "月" + selected_day + "日");
		} else {
			alert("過去" + selected_year + "年" + selected_month + "月" + selected_day + "日");
		}
	}
})

showCalendar(year, month);


//ここから追加文

const start = document.addEventListener("load", parts_name_insert());

function parts_name_insert() {

	//セッションスコープの内容を取得
	//const list = document.getElementById("parts_list");
	//console.log(list);
	//データの個数を取得
	const end_num = document.querySelector(".true").id;

	//console.log(end_num);
	
	//htmlのclass名が「calender_td」のものを取得
	const calender_td = document.querySelectorAll(".calendar_td");




	//セッションスコープの内容がある限り続ける
	for (let i = 0; i < end_num; i++) {
		const parts_name = document.getElementById("parts" + i).value;
		const date = document.getElementById("date" + i).value;
		//const time = document.getElementById("time" + i).value;
		const date_year = date.substring(0, 4)
		const date_month = date.substring(5, 7)
		const date_day = date.substring(8)
		//console.log("weihgt:"+weight);
		//console.log("date:"+date);
		//console.log("date_year:"+date_year);
		//console.log("date_month:"+date_month);
		//console.log("date_day:"+date_day);

		//カレンダーにセッションスコープの日時のデータが有ればその日のtdに追加
		for (let i = 1; i < calender_td.length; i++) {
			//年月日で一緒かどうかを判別
			if (display_year == date_year && display_month == date_month && i == date_day) {
				calender_td[i].innerText = date_day + "\n" + parts_name;
				//console.log(calender_td[i].textContent);
			}
		}
	}

}


/*

function generate_year_range(start, end) {
    var years = "";
    for (var year = start; year <= end; year++) {
        years += "<option value='" + year + "'>" + year + "</option>";
    }
    return years;
  }
  
  var today = new Date();
  var currentMonth = today.getMonth();
  var currentYear = today.getFullYear();
  var selectYear = document.getElementById("year");
  var selectMonth = document.getElementById("month");
  
  var createYear = generate_year_range(1970, 2200);
  
  document.getElementById("year").innerHTML = createYear;
  
  var calendar = document.getElementById("calendar");
  var lang = calendar.getAttribute('data-lang');
  
  var months = ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"];
  var days = ["日", "月", "火", "水", "木", "金", "土"];
  
  var dayHeader = "<tr>";
  for (day in days) {
    dayHeader += "<th data-days='" + days[day] + "'>" + days[day] + "</th>";
  }
  dayHeader += "</tr>";
  
  document.getElementById("thead-month").innerHTML = dayHeader;
  
  monthAndYear = document.getElementById("monthAndYear");
  showCalendar(currentMonth, currentYear);
  
  function next() {
    currentYear = (currentMonth === 11) ? currentYear + 1 : currentYear;
    currentMonth = (currentMonth + 1) % 12;
    showCalendar(currentMonth, currentYear);
  }
  
  function previous() {
    currentYear = (currentMonth === 0) ? currentYear - 1 : currentYear;
    currentMonth = (currentMonth === 0) ? 11 : currentMonth - 1;
    showCalendar(currentMonth, currentYear);
  }
  
  function jump() {
    currentYear = parseInt(selectYear.value);
    currentMonth = parseInt(selectMonth.value);
    showCalendar(currentMonth, currentYear);
  }
  
  function showCalendar(month, year) {
  
    var firstDay = ( new Date( year, month ) ).getDay();
  
    tbl = document.getElementById("calendar-body");
  
    tbl.innerHTML = "";
  
    monthAndYear.innerHTML = months[month] + " " + year;
    selectYear.value = year;
    selectMonth.value = month;
  
    // creating all cells
    var date = 1;
    for ( var i = 0; i < 6; i++ ) {
        var row = document.createElement("tr");
  
        for ( var j = 0; j < 7; j++ ) {
            if ( i === 0 && j < firstDay ) {
                cell = document.createElement( "td" );
                cellText = document.createTextNode("");
                cell.appendChild(cellText);
                row.appendChild(cell);
            } else if (date > daysInMonth(month, year)) {
                break;
            } else {
                cell = document.createElement("td");
                cell.setAttribute("data-date", date);
                cell.setAttribute("data-month", month + 1);
                cell.setAttribute("data-year", year);
                cell.setAttribute("data-month_name", months[month]);
                cell.className = "date-picker";
                cell.innerHTML = "<span>" + date + "</span>";
  
                if ( date === today.getDate() && year === today.getFullYear() && month === today.getMonth() ) {
                    cell.className = "date-picker selected";
                }
                row.appendChild(cell);
                date++;
            }
        }
  
        tbl.appendChild(row);
    }
  
  }
  
  function daysInMonth(iMonth, iYear) {
    return 32 - new Date(iYear, iMonth, 32).getDate();
  }
*/