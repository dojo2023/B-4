/**
 *
 */

//ここでは2組、3種類のデータを受け取ると仮定して設定する
//配列の宣言

let data0 = [];
let data1 = [];
//各要素へのデータの格納今回はindexによる
data0[0] = document.getElementById('0data1').value;
data0[1] = document.getElementById("0data2").value;
data0[2] = document.getElementById("0data3").value;
data1[0] = document.getElementById("1data1").value;
data1[1] = document.getElementById("1data2").value;
data1[2] = document.getElementById("1data3").value;
//描画エリアの設定
let lineCtx = document.getElementById("Chart");
// 折れ線グラフの設定
let lineConfig = {
	type: 'line',
	data: {
		labels: ['data1', 'data2', 'data3'],
		datasets: [{
			label: 'Red',
			data: [data0[0], data0[1], data0[2]],
			borderColor: 'Red',
		}, {
			label: 'Green',
			data: [data1[0], data1[1], data1[2]],
			borderColor: 'Green',

		}],
	},
	options: {
		scales: {
			// Y軸の最大値・最小値、目盛りの範囲などを設定する
			y: {
				suggestedMin: 0,
				suggestedMax: 150,
				ticks: {
					stepSize: 20,
				}
			}
		},
	},
};
let lineChart = new Chart(lineCtx, lineConfig);
