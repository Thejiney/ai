package com.lec.dto;

public class Person {
	private String rank;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int tot;

	public Person(String rank, String pname, String jname, int kor, int eng, int mat, int tot) {
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
	}

	@Override
	public String toString() {
		return rank + "\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot;
	}
}