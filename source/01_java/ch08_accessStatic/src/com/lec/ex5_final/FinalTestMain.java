package com.lec.ex5_final;

import constant.Constant;

// final 변수 : 수정 불가
public class FinalTestMain {
	public static void main(String[] args) {
		double r = 3;
		r = 5;
//		PI = 3.14159265358979;
		double area = r * r * Constant.PI;
		System.out.println(area);
	}
}
