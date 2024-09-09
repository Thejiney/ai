package com.lec.ex1_String;

import java.util.Scanner;

// quiz : 전화번호(010-7894-7897) 입력받아 전번, 짝수번째문자, 거꾸로, 국번, 뒷4자리 출력(X를 입력할때까지 반복적)
public class Ex04_tel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;

		while (true) {
			System.out.print("전화번호(000-0000-0000), 단 종료시 x :");
			tel = sc.next();
			int irregular = tel.replaceAll("[0-9-]", "").length();

			if (tel.equalsIgnoreCase("x")) {
				break;
			} else if (irregular != 0) {
				continue;
			}

			System.out.println("입력한 전화번호 : " + tel);

			System.out.print("짝수번째 문자열 : ");
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i) + " ");
				}
			}
			System.out.println();

			System.out.print("문자를 거꾸로 : ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();

			int idx = tel.indexOf("-");
			if (idx != -1) {
				String preTel = tel.substring(0, tel.indexOf('-'));
				System.out.println("전화번호 맨앞자리는 : " + preTel);

				String postTel = tel.substring(tel.lastIndexOf('-') + 1);
				System.out.println("전화번호 뒷자리는 : " + postTel);
			}
		}
		sc.close();
	}
}
