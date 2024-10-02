package com.lec.dto;

public class Job {
	private int jno;
	private String jname;

	public Job() {
	}

	public Job(int jno, String jname) {
		this.jno = jno;
		this.jname = jname;
	}

	@Override
	public String toString() {
		return jno + "\t" + jname;
	}
}
