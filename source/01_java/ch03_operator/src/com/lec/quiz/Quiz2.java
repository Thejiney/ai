package com.lec.quiz;
import java.util.Scanner;
public class Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 :");
		int kor = scanner.nextInt();
		System.out.print("영어 :");
		int eng = scanner.nextInt();
		System.out.print("수학 :");
		int mat = scanner.nextInt();
		
		int sum = kor+eng+mat;
		double avg = sum/3.0;
		
		System.out.printf("국어 :%d, 영어 :%d, 수학 :%d\n",kor,eng,mat);
		System.out.printf("총점 :%d\n평균 :%.2f\n",sum,avg);
		
		scanner.close();
	}
}