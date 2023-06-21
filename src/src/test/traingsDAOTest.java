package test;

import dao.TrainingDao;

public class traingsDAOTest {
	public static void main(String[] args) {
		String id = "001"; //今はテストサンプルとして「００１」とする
		//鍛えたいブイのデータを取得する
		String parts = "お腹";
		//idと取得した部位を引数にしてtrainsテーブルにデータを追加するdaoを呼び出す
		TrainingDao tDao = new TrainingDao();
		System.out.println(tDao.insert(id, parts));
	}
}
