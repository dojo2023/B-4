package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Registdata;

public class RegistdataDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Registdata> select(Registdata param) {
			Connection conn = null;
			List<Registdata> cardList = new ArrayList<Registdata>();
			try {
    // JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4","","");

		// SQL文を準備する
		String sql = "select * from REGISTDATA WHERE USER_ID LIKE ? AND USER_PASSWORD LIKE ? AND USER_NAME LIKE ? ORDER BY USER_ID";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
					if (param.getUser_id() != null) {
						pStmt.setString(1, "%" + param.getUser_id() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (param.getUser_password() != null) {
						pStmt.setString(2, "%" + param.getUser_password() + "%");
					}
					else {
						pStmt.setString(2, "%");
					}

					if (param.getUser_name() != null) {
						pStmt.setString(3, "%" + param.getUser_name() + "%");
					}
					else {
						pStmt.setString(3, "%");
					}

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Registdata card = new Registdata(
						rs.getString("ID"),
						rs.getString("PASSWORD"),
						rs.getString("USER")
						);
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

			// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
			public boolean insert(Registdata card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "", "");

					// SQL文を準備する
					String sql = "insert into REGISTDATA values (?, ?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getUser_id() != null && !card.getUser_id().equals("")) {
						pStmt.setString(1, card.getUser_id());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getUser_password() != null && !card.getUser_password().equals("")) {
						pStmt.setString(2, card.getUser_password());
					}
					else {
						pStmt.setString(2, null);
					}
					if (card.getUser_name() != null && !card.getUser_name().equals("")) {
						pStmt.setString(3, card.getUser_name());
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

			// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
			public boolean update(Registdata card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "", "");

					// SQL文を準備する
					String sql = "update REGISTDATA set USER_PASSWORD=?, USER_NAME=? where USER_ID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getUser_password() != null && !card.getUser_password().equals("")) {
						pStmt.setString(1, card.getUser_password());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getUser_name() != null && !card.getUser_name().equals("")) {
						pStmt.setString(2, card.getUser_name());
					}
					else {
						pStmt.setString(2, null);
					}


					pStmt.setString(3, card.getUser_id());

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

			// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
			public boolean delete(String id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "", "");

					// SQL文を準備する
					String sql = "delete from REGISTDATA where USER_ID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, id);

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

