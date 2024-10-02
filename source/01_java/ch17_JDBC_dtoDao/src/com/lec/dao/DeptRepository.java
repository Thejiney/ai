package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Dept;

public class DeptRepository {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;

	private static DeptRepository INSTANCE = new DeptRepository();

	public static DeptRepository getInstance() {
		return INSTANCE;
	}

	private DeptRepository() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

//	-- (1) 부서 정보들 가져오는 함수 : getDeptList
	public ArrayList<Dept> getDeptList() {
		ArrayList<Dept> dtos = new ArrayList<Dept>();
		// SQL 수행한 결과를 dtos에 추가하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dtos.add(new Dept(deptno, dname, loc));
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dtos;
	}

//	-- (2) deptno로 부서정보 가져오는 함수 : getDept(10)
	public Dept getDept(int deptno) {
		Dept dto = null;
		// query 수행 결과를 dto에 할당
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dto;
	}

//	-- (3) dname으로 부서정보 가져오는 함수 : getDept("sales")
	public Dept getDept(String dname) {
		Dept dto = null;
		// query 수행 결과를 dto에 할당
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		@formatter:off
		String sql = "SELECT * "
				+ "FROM DEPT "
				+ "WHERE DNAME = upper(?);";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new Dept(deptno, dname, loc);
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return dto;
	}

//	-- (4) 부서정보 입력받아 dept에 insert하는 함수 : insertDept(80,"it","seoul")
	public int insertDept(int deptno, String dname, String loc) {
		int result = FAIL;
		// insert
		Connection conn = null;
		PreparedStatement pstmt = null;
//		@formatter:off
		String sql = "INSERT INTO DEPT (DEPTNO, DNAME, LOC) "
				+ "VALUES(?,upper(?),upper(?))";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno + dname + loc);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

//	-- (5) 부서정보 입력받아	dept에 update하는 함수 : updateDept
	public int updateDept(int deptno, String dname, String loc) {
		int result = FAIL;
		// insert
		Connection conn = null;
		PreparedStatement pstmt = null;
//		@formatter:off
		String sql = "UPDATE DEPT "
				+ "SET DNAME = UPPER(?), "
				+ "	LOC = UPPER(?) "
				+ "WHERE DEPTNO = ?";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "수정성공" : "수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno + dname + loc);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

//	-- (6) 부서번호 입력받아 dept에서 delete하는 함수 : deleteDept
	public int deleteDept(int deptno) {
		int result = FAIL;
		// insert
		Connection conn = null;
		PreparedStatement pstmt = null;
//		@formatter:off
		String sql = "DELETE FROM DEPT "
				+ "WHERE DEPTNO = ?";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "삭제성공" : "삭제실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + deptno);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
}
