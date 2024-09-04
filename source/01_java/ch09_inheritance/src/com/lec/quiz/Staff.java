package com.lec.quiz;

public class Staff extends Person {
	private String department;
	private static int staffNo;

	public Staff(String id, String name, String department) {
		super(id, name);
		setNo(++staffNo);
		this.department = department;
	}

	@Override
	public String infoString() {
		return String.format("(번호)staff%d", getNo()) + super.infoString() + String.format("\t(부서)%s", department);
	}
}
