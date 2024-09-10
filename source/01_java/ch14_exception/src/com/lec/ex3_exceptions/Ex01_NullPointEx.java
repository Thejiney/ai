package com.lec.ex3_exceptions;

public class Ex01_NullPointEx {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		String gretting = "Hello";
		System.out.println(gretting.substring(2));
		gretting = null;
		System.out.println(gretting.substring(2));
	}
}