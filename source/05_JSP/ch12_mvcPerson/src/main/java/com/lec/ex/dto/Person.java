package com.lec.ex.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private int id;
	private String name;
	private String tel;
	private String address;
	private Date birth;
	private String memo;
	private Timestamp rdate;
	
	public Person(String name, String tel, String address, Date birth, String memo) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birth = birth;
		this.memo = memo;
	}
}
