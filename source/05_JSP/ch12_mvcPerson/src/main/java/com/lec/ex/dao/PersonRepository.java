package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.Person;

public class PersonRepository {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static PersonRepository INSTANCE;
	DataSource ds;

	public static PersonRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonRepository();
		}
		return INSTANCE;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	// 1. LIST (PAGING 없이) : public ArrayList<Person> getPersonList()
	public ArrayList<Person> getPersonList() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PERSON";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				Date brith = rs.getDate("birth");
				String memo = rs.getString("memo");
				Timestamp rdate = rs.getTimestamp("rdate");
				persons.add(new Person(id, name, tel, address, brith, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return persons;
	}

	// 1. LIST (PAGING 포함) : public ArrayList<Person> getPersonList(int startRow,
	// int endRow) : 몇등~몇등
	public ArrayList<Person> getPersonList(int startRow, int endRow) {
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//@formatter:off
		String sql = "SELECT * \r\n"
				+ "	FROM (\r\n"
				+ "		SELECT ROWNUM RN, A.*\r\n"
				+ "			FROM (\r\n"
				+ "				SELECT *\r\n"
				+ "					FROM PERSON\r\n"
				+ "					ORDER BY ID desc\r\n"
				+ "			) A\r\n"
				+ "	)\r\n"
				+ "	WHERE RN BETWEEN ? AND ?";
		//@formatter:on
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				Date brith = rs.getDate("birth");
				String memo = rs.getString("memo");
				Timestamp rdate = rs.getTimestamp("rdate");
				persons.add(new Person(id, name, tel, address, brith, memo, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return persons;
	}

	// 2. getCount (PAGING처리시 필요한 전체 갯수)
	public int getCount() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//@formatter:off
		String sql = "SELECT COUNT(*) CNT FROM PERSON";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return cnt;
	}
	
	// 3. 추가 : public int insertPerson(Person person)
	public int insertPerson(Person person) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//@formatter:off
		String sql = "INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)"
				+ "VALUES(PERSON_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		//@formatter:on
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getTel());
			pstmt.setString(3, person.getAddress());
			pstmt.setDate(4, person.getBirth());
			pstmt.setString(5, person.getMemo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

	// 4. 한명출력 : public Person getPerson(int id)
	public Person getPerson(int id) {
		Person person = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//@formatter:off
		String sql = "SELECT * FROM PERSON WHERE ID=?";
		//@formatter:on
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				Date brith = rs.getDate("birth");
				String memo = rs.getString("memo");
				Timestamp rdate = rs.getTimestamp("rdate");
				person = new Person(id, name, tel, address, brith, memo, rdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		return person;
	}

	// 5. 수정 : public int updatePerson(Person person)
	public int updatePerson(Person person) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//@formatter:off
		String sql = "UPDATE PERSON"
				+ " SET NAME = ?,"
				+ "	TEL = ?,"
				+ "	ADDRESS = ?,"
				+ "	BIRTH = ?,"
				+ "	MEMO = ?,"
				+ "	RDATE = SYSDATE"
				+ " WHERE ID=?";
		//@formatter:on
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getTel());
			pstmt.setString(3, person.getAddress());
			pstmt.setDate(4, person.getBirth());
			pstmt.setString(5, person.getMemo());
			pstmt.setInt(6, person.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

	// 6. 삭제 : public int deletePerson(int id)
	public int deletePerson(int id) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//@formatter:off
		String sql = "DELETE FROM PERSON"
				+ "	WHERE ID=?";
		//@formatter:on
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
