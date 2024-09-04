package com.lec.loopQuiz;

import java.util.Scanner;

// 사용자로부터 원하는 구구단 수 입력받아 해당 구구단
public class Quiz3_gugudan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력할까요?:");
		int num = sc.nextInt();
		if (num<=1||num>9){
			System.out.println("유효하지 않은 수입니다.");
			System.exit(0);
		}
		
		for (int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n",num,i,num*i);
		}
		sc.close();	
	}
}
