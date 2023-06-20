package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CharaDao {

	public String select(String user) {
		Connection conn = null;
		String chara_file = "";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT chara_file FROM usercharas as uc join charas as c on c.chara_id = uc.chara_id where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, user);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			chara_file=rs.getString("chara_file");

		}
		catch (SQLException e) {
			e.printStackTrace();
			chara_file = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			chara_file = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					chara_file = null;
				}
			}
		}

		// 結果を返す
		return chara_file;
	}
}
