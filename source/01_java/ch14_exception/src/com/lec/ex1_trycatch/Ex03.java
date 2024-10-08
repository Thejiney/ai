package com.lec.ex1_trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

// 첫번째 정수를 제대로 입력할 때까지 입력받음
//두번째 정수를 제대로 입력하지 않으면 1로 할당받고, 곱셈, 덧셈, 뺄셈을 출력
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0, j = 1;
		do {
			try {
				System.out.print("첫번째 정수는 ");
				i = sc.nextInt();// InputMismatchException
				break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine(); // 버퍼지우는 목적
			}
		} while (true);

		System.out.print("두번째 정수는 ");
		try {
			j = sc.nextInt();// InputMismatchException
			System.out.println("i/j = " + (i / j));// ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌수는 없습니다" + e.getMessage());
		} catch (Exception e) {
			System.out.println("두번째 정수를 입력하지 않았습니다, 1로 수행합니다");
		}
		System.out.println("i*j = " + (i * j));
		System.out.println("i+j = " + (i + j));
		System.out.println("i-j = " + (i - j));
		sc.close();
	}
}
