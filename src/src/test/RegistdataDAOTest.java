package test;

import java.util.List;

import dao.RegistdataDAO;
import model.Registdata;

public class RegistdataDAOTest {
	public static void main(String[] args) {
		RegistdataDAO dao = new RegistdataDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Registdata> cardList2 = dao.select(new Registdata());
		for (Registdata card : cardList2) {
			System.out.println("USER_ID：" + card.getUser_id());
			System.out.println("USER_PASSWORD：" + card.getUser_password());
			System.out.println("USER_NAME：" + card.getUser_name());
			System.out.println();
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Registdata insRec = new Registdata("health", "care0326", "きんにくまん");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Registdata> cardList3 = dao.select(insRec);
			for (Registdata card : cardList3) {
				System.out.println("USER_ID：" + card.getUser_id());
				System.out.println("USER_PASSWORD：" + card.getUser_password());
				System.out.println("USER_NAME：" + card.getUser_name());
				System.out.println();
			}
		}
		else {
			System.out.println("登録失敗！");
		}
	}
}