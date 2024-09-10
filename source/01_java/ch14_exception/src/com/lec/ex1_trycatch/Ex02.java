package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수는 ");
		int i = sc.nextInt();// InputMismatchException
		System.out.print("두번째 정수는 ");
		int j = sc.nextInt();// InputMismatchException
		try {
			System.out.println("i/j = " + (i / j));// ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("i*j = " + (i * j));
		System.out.println("i+j = " + (i + j));
		System.out.println("i-j = " + (i - j));
		sc.close();
	}
}
