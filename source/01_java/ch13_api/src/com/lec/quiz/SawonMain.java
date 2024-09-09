package com.lec.quiz;

public class SawonMain {
	public static void main(String[] args) {
		Sawon hong = new Sawon("a01", "홍길동", Sawon.COMPUTER);
		Sawon sin = new Sawon("b01", "신길동", Sawon.PLANNING);
		Sawon bak = new Sawon("a02", "박길동", Sawon.DESIGN, 2024, 9, 2);
		Sawon lee = new Sawon("a03", "이길동", Sawon.COMPUTER, 2024, 9, 1);
		Sawon[] employee = { hong, sin, bak, lee };
		for (Sawon emp : employee) {
			System.out.println(emp);
		}
	}
}
