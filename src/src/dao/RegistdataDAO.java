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
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4","sa","");

		// SQL文を準備する
		String sql = "select * from BC WHERE ID LIKE ? AND PASSWORD LIKE ? AND REPASS LIKE ? ORDER BY NUMBER";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
					if (param.getId() != null) {
						pStmt.setString(1, "%" + param.getId() + "%");
					}
					else {
						pStmt.setString(1, "%");
					}
					if (param.getPassword() != null) {
						pStmt.setString(2, "%" + param.getPassword() + "%");
					}
					else {
						pStmt.setString(2, "%");
					}
					if (param.getRepass() != null) {
						pStmt.setString(3, "%" + param.getRepass() + "%");
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
						rs.getString("REPASS")
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
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

					// SQL文を準備する
					String sql = "insert into BC values (?, ?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getId() != null && !card.getId().equals("")) {
						pStmt.setString(1, card.getId());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getPassword() != null && !card.getPassword().equals("")) {
						pStmt.setString(2, card.getPassword());
					}
					else {
						pStmt.setString(2, null);
					}
					if (card.getRepass() != null && !card.getRepass().equals("")) {
						pStmt.setString(3, card.getRepass());
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
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

					// SQL文を準備する
					String sql = "update BC set PASSWORD=?, REPASS=? where ID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getPassword() != null && !card.getPassword().equals("")) {
						pStmt.setString(1, card.getPassword());
					}
					else {
						pStmt.setString(1, null);
					}
					if (card.getRepass() != null && !card.getRepass().equals("")) {
						pStmt.setString(2, card.getRepass());
					}
					else {
						pStmt.setString(2, null);
					}

					pStmt.setString(3, card.getId());

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
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");

					// SQL文を準備する
					String sql = "delete from REGISTDATA where ID=?";
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

