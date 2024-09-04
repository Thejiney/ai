package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위:0,바위:1,보:2 입니다.\n한개의 수를 입력해주세요:");
		int num = sc.nextInt();
		String result;

//		if
//		if (num == 0) {
//			result = "가위";
//		} else if (num == 1) {
//			result = "바위";
//		} else if (num == 2) {
//			result = "보";
//		} else {
//			result = "유효하지 않은 수";
//		} // if

//		삼항연산자
//		result = num == 0 ? "가위" : num == 1 ? "바위" : num == 2 ? "보" : "유효하지 않은 수";

//		switch
		switch (num) {
		case 0:
			result = "가위";	break;
		case 1:
			result = "바위";	break;
		case 2:
			result = "보";	break;
		default:
			result = "유효하지 않은 수";	break;
		}

		System.out.printf("%s를 내셨습니다.", result);
		sc.close();
	}
}
