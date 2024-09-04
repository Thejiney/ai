package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요:");
		int num = sc.nextInt();

		if (num < 0) {
			System.out.printf("입력하신 %d의 절대값은 %d입니다", num, -num);
		} else {
			System.out.printf("입력하신 %d의 절대값은 %d입니다", num, num);
		}

		sc.close();
	}
}
