package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDeptConfirm {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.print("입력할 부서번호는 >");
		int deptno = scanner.nextInt();

		// deptno 중복 체크
		String confirmSql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(confirmSql);
			if (rs.next()) {
				System.out.println("입력할 부서이름은 >");
				String dname = scanner.next();
				System.out.println("입력할 부서위치는 >");
				String loc = scanner.next();
//				@formatter:off
				String updateSql = String.format("UPDATE DEPT \r\n"
						+ "SET DNAME=UPPER('%s'),\r\n"
						+ "	LOC = UPPER('%s')\r\n"
						+ "WHERE DEPTNO = %d", dname, loc, deptno);
//				@formatter:on
				stmt.executeUpdate(updateSql);
				System.out.println("수정완료");
			} else {
				System.out.println(deptno + "번 부서는 유효하지 않은 부서번호입니다");
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
