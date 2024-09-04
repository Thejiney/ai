package com.lec.quiz;

//   ban / print() or infoString()
public class Student extends Person {
	private String ban;
	private static int studentNo;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		setNo(++studentNo);
		this.ban = ban;
	}

	@Override
	public String infoString() {
		return String.format("(번호)student%d", getNo()) + super.infoString() + String.format("\t(반)%s", ban);
	}
}
