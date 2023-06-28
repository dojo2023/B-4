package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Friends;

public class FriendsDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す      //////////////////
		public List<Friends> select(Friends param) {
			Connection conn = null;
			List<Friends> FriendsList = new ArrayList<Friends>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

				// SQL文を準備する
				String sql = "select id, user_id, friends_id from FRIENDS WHERE iD LIKE ? AND USER_ID LIKE ? AND FRIENDS_ID LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getName() != null) {
					pStmt.setString(1, "%" + param.getName() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getUser_id() != null) {
					pStmt.setString(2, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getFriends_id() != null) {
					pStmt.setString(3, "%" + param.getFriends_id() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Friends card = new Friends(
					rs.getString("ID"),
					rs.getString("USER_ID"),
					rs.getString("FRIENDS_ID")
					);
//					System.out.println("company:"+rs.getString("COMPANY"));
//					System.out.println("others:"+rs.getString("OTHERS"));
					FriendsList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				FriendsList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				FriendsList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						FriendsList = null;
					}
				}
			}

			// 結果を返す
			return FriendsList;
		}

		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す /////////////////
		public boolean insert(Friends card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

				// SQL文を準備する
				String sql = "insert into FRIENDS values (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getName() != null && !card.getName().equals("")) {
					pStmt.setString(1, card.getName());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(2, card.getUser_id());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getFriends_id() != null && !card.getFriends_id().equals("")) {
					pStmt.setString(3, card.getFriends_id());
				}
				else {
					pStmt.setString(3, null);
				}


				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
}
