package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Target;
import model.Weight;



public class ChartDAO {
	// user_idの体重データを取得
		public ArrayList<Weight> select(int user_id) {
			Connection conn = null;
			ArrayList<Weight> cardList = new ArrayList<Weight>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

				// SQL文を準備する
				String sql = "select user_id, weight, Left(created_at,10) as day from users_weights WHERE user_id = ? order by Left(created_at,10) asc ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

					pStmt.setInt(1,user_id);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {

					Weight card = new Weight();
					card.setUser_id(rs.getInt("user_id"));
					card.setWeight(rs.getInt("weight"));
					card.setDate(rs.getString("day"));

					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}

		//もっとも新しい目標体重を取得
		public ArrayList<Target> select_target(int user_id) {
			Connection conn = null;
			ArrayList<Target> cardList = new ArrayList<Target>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

				// SQL文を準備する
				String sql = "select user_id,target ,Left(created_at,10) as day from users_targets WHERE user_id = ? order by created_at desc limit 1";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

					pStmt.setInt(1,user_id);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {

					Target card = new Target();
					card.setUser_id(rs.getInt("user_id"));
					card.setTarget(rs.getInt("target"));
					card.setDate(rs.getString("day"));

					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}
}
