package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Users> select(Users param) {
		Connection conn = null;
		List<Users> cardList = new ArrayList<Users>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "select * from USERS WHERE USER_ID LIKE ? AND USER_PASSWORD LIKE ? AND USER_NAME LIKE ? ORDER BY USER_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getUser_password() != null) {
				pStmt.setString(2, "%" + param.getUser_password() + "%");
			} else {
				pStmt.setString(2, "%");
			}

			if (param.getUser_name() != null) {
				pStmt.setString(3, "%" + param.getUser_name() + "%");
			} else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Users card = new Users(
						rs.getString("user_id"),
						rs.getString("user_password"),
						rs.getString("user_name"));
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Users card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");
			// SQL文を準備する
			String sql = "insert into USERS (user_id,user_password,user_name) values (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, card.getUser_id());

			pStmt.setString(2, card.getUser_password());

			pStmt.setString(3, card.getUser_name());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}



	public boolean setUser_id(String id) {
		Connection conn = null;
		boolean checkResult =false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

			// SQL文を準備する
			String sql = "select count(*) from USERS WHERE USER_ID LIKE ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる

			pStmt.setString(1,id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				checkResult = true;
			}



		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

		// 結果を返す
		return checkResult;
	}




}