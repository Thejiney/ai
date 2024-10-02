package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.Job;

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
	public ArrayList<Job> jnameList() {
		ArrayList<Job> jobs = new ArrayList<Job>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM JOB";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int jno = rs.getInt("jno");
				String jname = rs.getString("jname");
				jobs.add(new Job(jno, jname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return jobs;
	}
}
