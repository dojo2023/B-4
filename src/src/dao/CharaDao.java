package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Serifus;




public class CharaDao {

	public Serifus select(String user_id) {
		Connection conn = null;
		Serifus sf = new Serifus();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");


			// SQL文を準備する
			String sql = "SELECT uc.user_id,uc.chara_id,se.serif ,ch.chara_file  FROM USERCHARAS as uc join serifs as se on uc.chara_id = se.chara_id  join charas as ch on uc.chara_id = ch.chara_id where user_id= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			System.out.println(rs.getString("chara_file"));
				sf.setChara_file(rs.getString("chara_file"));
				sf.setSerif(rs.getString("serif"));


//			chara_file=rs.getString("chara_file");

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
		return sf;
	}
	public String selectId(String user_id) {
		Connection conn = null;
		String chara_id = "";
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");


			// SQL文を準備する
			String sql = "SELECT chara_id FROM USERCHARAS  where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

				pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			System.out.println(rs.getString("chara_id"));
			chara_id=rs.getString("chara_id");


//			chara_file=rs.getString("chara_file");

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
		return chara_id;
	}



public String update(String user_id) {
	Connection conn = null;
	String chara_id = "";
	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B4", "sa", "");


		// SQL文を準備する
		String sql = "update userscharas set chara_id  = chara_id where user_id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる

			pStmt.setString(1, user_id);


		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		rs.next();
		System.out.println(rs.getString("chara_id"));
		chara_id=rs.getString("chara_id");


//		chara_file=rs.getString("chara_file");

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
	return chara_id;
}
}

