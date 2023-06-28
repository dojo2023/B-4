/**
 *
 */

//ここでは2組、3種類のデータを受け取ると仮定して設定する
//配列の宣言

const date_array = [];
const weight_array = [];
const target_array=[];



//データの格納
//最終データ数量の読み込み
//Class名がtrueのidがデータ数量になるのでそれを読み取る
const end_count = document.querySelector(".weight_true").value;

for (let i = 0; i < end_count; i++) {

	//体重の格納
	const weight = document.getElementById("weight" + i).value;
	weight_array[i]=weight;
	//日付の格納
	const date = document.getElementById("date" + i).value;
	date_array[i] = date;
	//console.log("weight:" + weight);
	//console.log("date:" + date);

	//目標体重の格納
	const target = document.getElementById("target").innerText;
	target_array[i]=target;
}
console.log(weight_array[0]);
console.log(date_array[0]);
//描画エリアの設定
let lineCtx = document.getElementById("Chart");
// 折れ線グラフの設定
let lineConfig = {
	type: 'line',
	data: {
		labels: date_array,
		datasets: [{
			label: 'Red',
			data: weight_array,
			borderColor: 'Red',
		}
		, {
			label: 'Green',
			data: target_array,
			borderColor: 'Green',

		}
		],
	},
	options: {
		scales: {
			// Y軸の最大値・最小値、目盛りの範囲などを設定する
			y: {
				suggestedMin: 20,
				suggestedMax: 100,
				ticks: {
					stepSize: 5,
				}
			}
		},
	},
};
let lineChart = new Chart(lineCtx, lineConfig);
