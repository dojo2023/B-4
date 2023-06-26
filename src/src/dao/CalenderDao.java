package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Calender;
import model.Trainings;
import model.Weight;


public class CalenderDao {
	// ログインできるならtrueを返す
	public ArrayList<Weight> selectWeight(int user_id) {
		Connection conn = null;
		ArrayList<Trainings> partsList = new ArrayList<>();


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");//リードするドライブ名

			// データベースに接続する(usename and password)
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SELECT文を準備する
			String sql = "select parts_name,id,created_at from trainings where user_id = ?"; //?は後で書き換える
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery(); //問い合わせ実行

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする

			while(rs.next()) {
				Calender cp = new Calender();
				cp.setWeight("parts_name");
				String created_at = rs.getString("created_at");
				String created_date = created_at.substring(0,10);
				String created_time = created_at.substring(11,19);

				cp.setCreated_date(created_date);
				cp.setCreated_time(created_time);
				partsList.add(cp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace(); //例外の内容をコンソールに表示
			partsList=null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			partsList = null;
		}
		finally { //nullでなければ接続てきているということになるからログアウトできる
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					partsList = null;
				}
			}
		}

		// 結果を返す IDPWが存在していたらtrueを返す
		return partsList;
	}
}

