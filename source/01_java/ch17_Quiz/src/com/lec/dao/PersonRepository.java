package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.Person;

public class PersonRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static PersonRepository INSTANCE;
	private static int SUCCESS = 1;
	private static int FAIL = 0;

	public static PersonRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonRepository();
		}
		return INSTANCE;
	}

//	--1 이름, 직업명, 국어, 영어, 수학점수 입력 데이터 베이스에 번호를 포함하여 입력한다.

	public int insertPerson(String pname, String jname, int kor, int eng, int mat) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
//		@formatter:off
		String sql = "INSERT INTO PERSON(pNO, pNAME, jNO, KOR, ENG, MAT) "
				+ "VALUES(p_SEQ.NEXTVAL, ?,( "
				+ "		SELECT JNO "
				+ "		FROM JOB "
				+ "		WHERE JNAME=? "
				+ "	), ?, ?, ?)";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setString(2, jname);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, mat);

			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

//	--2 직업명 입력, 직업별 조회 후 총점추가 총점이 높은 순으로 이름(번호) 출력
	public ArrayList<Person> getPerson(String jname) {
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		@formatter:off
		String sql = "SELECT ROWNUM||'등' \"RANK\", A.*  "
				+ "FROM ( "
				+ "	SELECT pNAME||'('||pNO||'번)' \"pNAME\", jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOT\" "
				+ "	FROM PERSON P, JOB J "
				+ "	WHERE P.jNO=J.jNO "
				+ "		AND jNAME=? "
				+ "	ORDER BY TOT DESC "
				+ ") A";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");
				jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				persons.add(new Person(rank, pname, jname, kor, eng, mat, tot));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return persons;
	}

//	--3 전체 사람 조회 후 총점 추가 높은순 출력
	public ArrayList<Person> getPerson() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		@formatter:off
		String sql = "SELECT ROWNUM||'등' \"RANK\", A.*  "
				+ "FROM ( "
				+ "	SELECT pNAME||'('||pNO||'번)' \"pNAME\", jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOT\" "
				+ "	FROM PERSON P, JOB J "
				+ "	WHERE P.jNO=J.jNO "
				+ "	ORDER BY TOT DESC "
				+ ") A";
//		@formatter:on
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				persons.add(new Person(rank, pname, jname, kor, eng, mat, tot));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return persons;
	}
}
