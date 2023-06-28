/**
 *
 */

const target_weight= document.getElementById("target").value;

//ここでは2組、3種類のデータを受け取ると仮定して設定する
//配列の宣言

//let data0 = [];
//let data1 = [];
//各要素へのデータの格納今回はindexによる

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
			data: [target_weight,target_weight,target_weight],
			borderColor: 'Green',

		}],
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