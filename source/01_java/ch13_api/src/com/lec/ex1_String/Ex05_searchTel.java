package com.lec.ex1_String;

import java.util.Scanner;

//배열에 있는 전화번호 검색
public class Ex05_searchTel {
	public static void main(String[] args) {
		String[] tel = { "010-9999-9999", "02-777-9999", "010-8888-8888" };
		Scanner scanner = new Scanner(System.in);
		boolean noSearch = true; // 검색결과가 없으면 true. 검색결과가 있으면 false

		do {
			System.out.print("전화번호 뒷자리를 입력해주세요 :");
			String searchTel = scanner.next(); // "1344"

			for (String t : tel) {
				int lastNumIdx = t.lastIndexOf('-') + 1;
				String postTel = t.substring(lastNumIdx);
				if (postTel.equals(searchTel)) {
					System.out.println("검색하신 전화번호 전체는 " + t);
					noSearch = false;
				}
			}

			if (noSearch) {
				System.out.println("검색하신 전화번호가 없습니다.");
			}
		} while (noSearch);

		scanner.close();
	}
}
