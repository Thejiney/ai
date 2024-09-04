package com.lec.ex;
//비트연산자 : &(and), |(or) => 정수를 비트끼리 연산
//논리연산자 : &&(and), ||(or) => true나 false끼리 연산
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 4; // 0100
		int n2 = 7; // 0111
		//4 & 7 =      0100(4)
		//4 | 7 =      0111(7)
		System.out.println("n1 & n2 = " + (n1&n2));
		System.out.println("n1 | n2 = " + (n1|n2));
	}
}
