<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>栄養管理</h1>
<div class="col-auto my-1">
    <label for="sample">目的を選択</label>
</div>
<div class="col-auto my-1">
    <select class="form-control" id="sample" onchange="viewChange();">
        <option value="select1">体を鍛えたい（タンパク質）</option>
        <option value="select2">食生活の改善（ビタミン重視）</option>
        <option value="select3">瘦せたい、ダイエット（脂質抜きダイエット）</option>
        <option value="select4">瘦せたい、ダイエット（糖質抜きダイエット）</option>
        <option value="select5">日々の健康維持（ミネラル）</option>
    </select>
</div>
<div class="col-auto my-5">
<div id="Box1" class="my-5" style="display:none;">
    <p>タンパク質を摂取するための食事方法やレシピを表示するコンテンツ</p>
</div>
<div id="Box2" class="my-5" style="display:none;">
    <p>ビタミンを豊富に含む食品や食事の改善方法に関する情報を表示するコンテンツ</p>
</div>
<div id="Box3" class="my-5" style="display:none;">
    <p>脂質抜きダイエットに適した食品やダイエット方法に関する情報を表示するコンテンツ</p>
</div>
<div id="Box4" class="my-5" style="display:none;">
    <p>糖質抜きダイエットに適した食品やダイエット方法に関する情報を表示するコンテンツ</p>
</div>
<div id="Box5" class="my-5" style="display:none;">
    <p>ミネラルを含む食品や健康維持のための食事に関する情報を表示するコンテンツ</p>
</div>
</div>
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
</body>
</html>

<!-- https://bonoponz.hatenablog.com/entry/2020/05/12/%E3%80%90Web%E3%80%91%E3%83%97%E3%83%AB%E3%83%80%E3%82%A6%E3%83%B3%E3%81%A7%E8%A1%A8%E7%A4%BA%E5%86%85%E5%AE%B9%E3%82%92%E5%88%87%E3%82%8A%E6%9B%BF%E3%81%88%E3%82%8B#HTML-1参考 -->
