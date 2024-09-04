package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("현재 몇월인지 입력해주세요:");
		int month = sc.nextInt();
		String season = null;
		if (month <= 0 || month > 12) {
			System.out.println("유효하지 않은 수를 입력하셨습니다.");
			System.exit(0);
		}

//		if
//		if (month / 3 == 0 || month / 3 == 4) {
//			season = "겨울";
//		} else if (month / 3 == 1) {
//			season = "봄";
//		} else if (month / 3 == 2) {
//			season = "여름";
//		} else {
//			season = "가을";
//		}
//
//		삼항연산자
//		season = month / 3 == 0 || month / 3 == 4 ? "겨울" : month / 3 == 1 ? "봄" : month / 3 == 2 ? "여름" : "가을";

		switch (month / 3) {
		case 0:
		case 4:
			season = "겨울";
			break;
		case 1:
			season = "봄";
			break;
		case 2:
			season = "여름";
			break;
		case 3:
			season = "가을";
			break;
		}// switch

		System.out.printf("현재 계절은 %s입니다", season);

		sc.close();

	}
}
