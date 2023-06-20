package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Bc;
import model.Training;

public class TrainingDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す      //////////////////
	public List<Training> select(Training param) {
		Connection conn = null;
		List<Training> cardList = new ArrayList<Training>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "select USER_ID, PARTS_NAME from TRAININGS WHERE USER_ID LIKE ? PARTS_NAME LIKE ? ORDER BY USER_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getParts_name() != null) {
				pStmt.setString(2, "%" + param.getParts_name() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Training card = new Training(
				rs.getString("USER_ID"),
				rs.getString("PARTS_NAME")
				);

				cardList.add(card);
			}

		}

}
