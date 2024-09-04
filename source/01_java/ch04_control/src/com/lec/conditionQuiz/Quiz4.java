package com.lec.conditionQuiz;

// 사용자에게 가위(0),바위(1),보(2) 입력받는다
// 1. 0~2사이의 수를 입력 안 한 경우 : 프로그램 강제 종료
// 2. 0~2사이의 수를 입력 한 경우
//		(1)컴퓨터가 0~2사이의 난수를 발생
//		(2)당신 가위, 컴퓨터는 바위 출력
//		(3)가위바위보 결과 출력(ex. 당신이 졌습니다 ㅠ.ㅠ)
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위:0,바위:1,보:2 입니다.\n한개의 수를 입력해주세요:");
		int numUser = sc.nextInt();
		String user, com, result = null;

		// if
//		if (numUser == 0) {
//			user = "가위";
//		} else if (numUser == 1) {
//			user = "바위";
//		} else if (numUser == 2) {
//			user = "보";
//		} else {
//			user = "유효하지 않은 수";
//		}

		// 삼항연산자
//		user = numUser == 0 ? "가위" : numUser == 1 ? "바위" : numUser == 2 ? "보" : "유효하지 않은 수";

		// switch
		switch (numUser) {
		case 0:
			user = "가위"; break;
		case 1:
			user = "바위"; break;
		case 2:
			user = "보";	break;
		default:
			user = "유효하지 않은 수";break;
		}// 유저판단

		System.out.printf("당신은 %s를 내셨습니다.", user);
		if (user == "유효하지 않은 수") {
			System.exit(0);
		}

		int numCom = (int) (Math.random() * 3);

		// if
//		if(numcom==0) {
//			com = "가위";
//		}else if(numcom==1) {
//			com ="바위";
//		}else {
//			com = "보";
//		}

		// 삼항연산자
//		com = numcom==0?"가위":numcom==1?"바위":"보";

		// switch
		switch (numCom) {
		case 0:
			com = "가위";	break;
		case 1:
			com = "바위";	break;
		default:
			com = "보";	break;
		}// 컴퓨터판단
		System.out.printf("컴퓨터는 %s를 냈습니다.\n", com);

		// if
//		if(numUser - numCom == 0) {
//			result = "무승부";
//		}else if(numUser - numCom == 1 || numUser - numCom ==-2) {
//			result = "승리";
//		}else {
//			result = "패배";
//		}

		// 삼항연산자
//		result = numUser - numCom == 0 ? "무승부" : numUser - numCom == 1 || numUser - numCom == -2 ? "승리" : "패배";

		// switch
		switch (numUser - numCom) {
		case 0:
			result = "무승부";break;
		case 1: case -2:
			result = "승리";	break;
		case 2: case -1:
			result = "패배";	break;
		}

		System.out.printf("당신은 %s하셨습니다.\n", result);

		sc.close();

	}
}