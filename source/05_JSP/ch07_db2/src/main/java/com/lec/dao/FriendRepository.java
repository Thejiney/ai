package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.Friend;

public class FriendRepository {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static FriendRepository INSTANCE = new FriendRepository();

	public static FriendRepository getInstance() {
		return INSTANCE;
	}

	private FriendRepository() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public ArrayList<Friend> getFriendList() {
		ArrayList<Friend> dtos = new ArrayList<Friend>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND";

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				dtos.add(new Friend(no, name, tel));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return dtos;
	}

	public int insertFriend(String name, String tel) {
		int result = FAIL;
		ArrayList<Friend> dtos = new ArrayList<Friend>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		//@formatter:off
		String sql = "INSERT INTO FRIEND (NO, NAME, TEL)\r\n"
				+ "VALUES (FRIEND_NO_SQ.NEXTVAL, ?, ?)";
		//@formatter:on

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "친구추가 성공" : "친구추가 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "친구 추가 실패(이름이나 전번을 잘못 입력)");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
}
