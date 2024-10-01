package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 입력받은 부서번호 중복체크 후, 부서명, 근무지를 입력받아 insert
public class Ex2_InsertDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String confirmSql = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
//		@formatter:off
		String insertSql ="INSERT INTO dept\r\n"
				+ "VALUES (?, UPPER(?), UPPER(?))";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(confirmSql);
			System.out.print("입력할 부서번호는 : ");
			int deptno = sc.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("중복된 부서번호는 입력 불가합니다");
			} else { // 부서명과 부서위치를 입력받아 insert 전송
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setInt(1, deptno);
				System.out.print("부서명은 ?");
				pstmt.setString(2, sc.next());
				System.out.print("근무지는 ?");
				pstmt.setString(3, sc.next());
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "입력성공" : "입력실패");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
