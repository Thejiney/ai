package com.lec.quiz;
//국어, 영어, 수학 점수를 할당하고, 각 점수와 총점을 출력
public class Example {
	public static void main(String[] args) {
		int kor=50, eng=70, mat=80;
		int sum = kor+eng+mat;
		
		System.out.printf("국어:%d, 영어:%d, 수학:%d\n총점:%d\n",kor,eng,mat,sum);
	}
}
