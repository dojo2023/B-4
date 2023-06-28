package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Friends;
public class FriendListDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す

	public String selectId(String user_id) {
		Connection conn = null;
		String user_name = "";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "select user_id,user_name from users WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			if (rs.getString("user_name") != null) {
				user_name = rs.getString("user_name");
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
		return user_name;
	}
	public boolean insertFriend(String user_id,String friend_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "insert into modal_users_friends (user_id, friend_id) values (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, user_id);
				pStmt.setString(2, friend_id);


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
	

	public List<Friends> select(Friends friends) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public ArrayList<Friends> selectModal_users_friends(String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		ArrayList<Friends> FriendList = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "select f.user_id,f.friend_id,u.user_name from modal_users_friends as f join users as u on u.user_id = f.friend_id where f.user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Friends card = new Friends(
				rs.getString("USER_ID"),
				rs.getString("USER_NAME"),
				rs.getString("FRIEND_ID")
				);
				
				FriendList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			FriendList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			FriendList = null;
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
		return FriendList;
	}
}