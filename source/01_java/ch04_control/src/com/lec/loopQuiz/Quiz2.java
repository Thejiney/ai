package com.lec.loopQuiz;

//1~10까지 숫자 중 홀수의 합을 구해보자(for문 이용)
public class Quiz2 {
	public static void main(String[] args) {
		int totalEven = 0;
		int totalOdd = 0;
		for (int i = 1; i <= 10; i ++) {
			if (i%2==0) {
				totalEven += i;
			} else {
				totalOdd += i;
			}
		}
		System.out.println("짝수합:"+totalEven+", 홀수합:"+totalOdd);
	}
}
