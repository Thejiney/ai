package com.lec.quiz;
// new Sawon("사번","이름","부서","입사일");

import java.text.SimpleDateFormat;

// new Sawon("24a001","홍길동",Sawon.COMPUTER);
// new Sawon("24a001","홍길동",Sawon.COMPUTER, 2024, 9, 9);

import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	public static final String COMPUTER = "전산실";
	public static final String PLANNING = "기획팀";
	public static final String DESIGN = "설계팀";
	private String no; // 사번
	private String name;// 사원명
	private String dept;// 부서명
	private Date hireDate;// 입사일

	public Sawon(String no, String name, String dept) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		hireDate = new Date();
	}

	public Sawon(String no, String name, String dept, int y, int m, int d) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
//		hireDate = new Date(y - 1900, m - 1, d);
		hireDate = new Date(new GregorianCalendar(y, m - 1, d).getTimeInMillis());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일(E)");
		return "[사번]" + no + " [이름]" + name + " [부서]" + dept + " [입사일]" + sdf.format(hireDate);
	}

}
