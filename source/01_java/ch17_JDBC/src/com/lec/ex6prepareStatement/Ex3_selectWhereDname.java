package com.lec.ex6prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// 부서명을 입력 받아 해당 부서정보를 출력하고, 해당부서 사원(사번, 이름, 급여. 급여순)을 출력
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String deptSql = "SELECT * FROM DEPT WHERE DNAME = UPPER(?)";
//		@formatter:off
		String empSql = "SELECT EMPNO, ENAME, SAL"
				+ " FROM EMP E, DEPT D"
				+ " WHERE E.DEPTNO = D.DEPTNO"
				+ "		AND DNAME = UPPER(?)"
				+ " ORDER BY SAL DESC";
//		@formatter:on

		System.out.print("출력할 부서명 >");
		String dname = sc.next();
		sc.close();

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(deptSql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서이름 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
				rs.close();
				pstmt.close();

				pstmt = conn.prepareStatement(empSql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("사번\t이름\t급여");
					do {
						String empno = rs.getString("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						System.out.printf("%s\t%s\t%d", empno, ename, sal);
						System.out.println();
					} while (rs.next());
				} else {
					System.out.println("부서에 아무도 없습니다");
				}	

			} else {
				System.out.println("유효하지 않은 부서명입니다.");
			}
		} catch (Exception e) {
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
	}
}