package com.lec.ex3_exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

// 데이터 : 이름, 전화번호, 생년월일(Date) 
// Friend f = new Friend("홍길동", "010-9999-9999", new Date(98, 8, 1));
// sysout(f) => [이름]홍길*	[전화]***-****-9999	[생일]9월1일 ♬ 생일축하 ♬
public class Friend {
	private String name;
	private String tel;
	private Date birth;

	public Friend(String name) {
		this.name = name;
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}

	@Override
	public String toString() {
		String nameOut = name.substring(0, name.length() - 1) + "*";
		String telOut="\t\t";
		String birthOut="";
		if (tel != null) {
			telOut = "***-****-" + tel.substring(tel.lastIndexOf("-") + 1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("M월d일");
		if (birth != null) {
			birthOut = sdf.format(birth);
		}
		String result = String.format("[이름]%s\t[전화]%s\t[생일]%s", nameOut, telOut, birthOut);
		String today = sdf.format(new Date());
		if (today.equals(birthOut)) {
			result += " ♬ 생일축하 ♬";
		}
		return result;
	}
}
