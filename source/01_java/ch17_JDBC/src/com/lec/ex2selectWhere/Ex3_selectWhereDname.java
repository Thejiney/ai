package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 부서이름을 입력받아 해당 부서 정보 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서명은?");
		String dname = sc.next();
		sc.close();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
//		String sql = "SELECT * FROM DEPT WHERE DNAME=UPPER('" + dname + "')";
		String sql = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("원하는 부서번호 : " + rs.getInt("deptno"));
				System.out.println("원하는 부서이름 : " + rs.getString("dname"));
				System.out.println("원하는 부서위치 : " + rs.getString("loc"));
			} else {
				System.out.println(dname + "부서는 없습니다.");
			}
		} catch (Exception e) {
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
	}
}
