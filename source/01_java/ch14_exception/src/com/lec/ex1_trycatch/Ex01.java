package com.lec.ex1_trycatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수는 ");
		int i = sc.nextInt();
		System.out.print("두번째 정수는 ");
		int j = sc.nextInt();
		System.out.println("i/j = " + (i / j));
		System.out.println("i*j = " + (i * j));
		System.out.println("i+j = " + (i + j));
		System.out.println("i-j = " + (i - j));
		sc.close();
	}
}
