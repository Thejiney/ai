package com.lec.quiz;

public class Gangsa extends Person {
	private String subject;
	private static int gangsaNo;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		setNo(++gangsaNo);
		this.subject = subject;
	}

	@Override
	public String infoString() {
		return String.format("(번호)lecturer%d", getNo()) + super.infoString() + String.format("\t(과목)%s", subject);
	}
}
