package com.lec.loop;

/*
 * *
 * * *
 * * * *
 * * * * */
public class Ex04for {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			} // for-j
			System.out.println();
		} // for-i
	}// main
}// Class