package com.lec.quiz;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("i?");
		int i = scanner.nextInt();
		
		System.out.println((i%2)==0? "짝수입니다":"홀수입니다.");
		scanner.close();
	
	}
}
