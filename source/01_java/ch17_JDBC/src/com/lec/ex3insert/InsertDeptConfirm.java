package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.print("입력할 부서번호는 >");
		int deptno = scanner.nextInt();

		// deptno 중복 체크
		String confirmSql = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(confirmSql);
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt == 0) {
				System.out.print("입력할 부서명은 >");
				String dname = scanner.next();
				System.out.print("입력할 부서위치는 >");
				String loc = scanner.next();
//				@formatter:off
				String insertSql = String.format("INSERT INTO dept\r\n"
						+ "VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno, dname, loc);
//				@formatter:on
				int result = stmt.executeUpdate(insertSql);
				System.out.println(result > 0 ? "입력성공" : "입력실패");

			} else {
				System.out.println("중복된 부서번호는 입력 불가합니다");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
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
	}
}
