package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex1_InsertDept {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;

//		@formatter:off
		String sql = "INSERT INTO dept\r\n"
				+ "VALUES ("
				+ "?, UPPER(?), UPPER(?))";
//		@formatter:on

		System.out.print("입력할 부서번호는 >");
		int deptno = sc.nextInt();
		System.out.print("입력할 부서명은 >");
		String dname = sc.next();
		System.out.print("입력할 부서위치는 >");
		String loc = sc.next();
		sc.close();

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // 첫번째 물음표는 int값 deptno로 채움
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? "입력성공" : "입력실패");

		} catch (Exception e) {
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
	}
}
