package com.lec.loopQuiz;

//1~10까지의 곱의 결과를 출력해 보자(for문이용)
public class Quiz1 {
	public static void main(String[] args) {
		int total = 1;
		for (int i = 1; i <= 10; i++) {
			total *= i;
			if (i != 10) {
				System.out.print(i + "*");
			} else {
				System.out.print(i + "=");
			}

		}
		System.out.println(total);
	}
}
