package com.lec.loop;

// 10, 9, 8, ... 1
public class Ex07while {
	public static void main(String[] args) {
		int i = 10;
		while (i > 0) {
			System.out.print(i + "\t");
			i--;
		} // while

		System.out.println();
		i = 10;
		while (true) {
			System.out.print(i + "\t");
			i--;
			if (i < 1)
				break;
		}
//		for (int i = 10; i > 0; i--) {
//			System.out.print(i + "\t");
//		}//for

	}// main
}// Class