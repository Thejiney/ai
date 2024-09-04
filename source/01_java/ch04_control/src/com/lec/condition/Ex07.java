package com.lec.condition;

import java.util.Scanner;

// 입력받은 수가 홀수인지 짝수인지 출력(if, switch, 삼항연산자)
public class Ex07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요:");
		int num = sc.nextInt();
		
		System.out.println("if");
		if (num%2==0)
		{
			System.out.printf("입력하신 수 %d는 짝수입니다\n",num);
		}else {
			System.out.printf("입력하신 수 %d는 홀수입니다\n",num);
		}//if
		
		System.out.println("switch");
		switch(num%2) { 
		case 0:
			System.out.printf("입력하신 수 %d는 짝수입니다\n",num); break;
		default:
			System.out.printf("입력하신 수 %d는 홀수입니다\n",num); break;
		}//switch
		
		System.out.println("삼항연산자");
		System.out.printf("입력하신 수 %d는 %s입니다\n",num,num%2==0?"짝수":"홀수");
			
		sc.close();
	}//main
}//Class
