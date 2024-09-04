package com.lec.quiz;

// no, id, name /print() or infoString(), getter&setter
public class Person {
	private int no;
	private String id;
	private String name;

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String infoString() {
		return String.format("\t(ID)%s\t(이름): %s", id, name);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
