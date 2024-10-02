package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JobRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static JobRepository INSTANCE;

	public static JobRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new JobRepository();
		}
		return INSTANCE;
	}

//	--직업리스트
	public ArrayList<String> jnameList() {
		ArrayList<String> jobs = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM JOB";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String jname = rs.getString("jname");
				jobs.add(jname);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return jobs;
	}
}
