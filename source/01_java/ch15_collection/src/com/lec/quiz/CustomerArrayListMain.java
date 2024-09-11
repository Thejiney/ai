package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerArrayListMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String continuous;

		do {
			// 가입의사 확인
			System.out.print("회원가입을 하시겠습니까?(Y/N): ");
			continuous = sc.next();

			if (continuous.equalsIgnoreCase("y")) {
				Customer newCustomer = new Customer();
				System.out.print("이름을 입력해주세요 :");
				newCustomer.setName(sc.next());
				System.out.print("전화번호를 입력해주세요 :");
				newCustomer.setTel(sc.next());
				sc.nextLine();
				System.out.print("주소를 입력해주세요 :");
				newCustomer.setAddress(sc.nextLine());
				customers.add(newCustomer);
//				// 이름 입력
//				System.out.print("이름을 입력해주세요 :");
//				name = sc.next();
//				// 전화번호 입력
//				System.out.print("전화번호를 입력해주세요 :");
//				tel = sc.next();
//				// 주소 입력
//				sc.nextLine();
//				System.out.print("주소를 입력해주세요 :");
//				address = sc.nextLine();
//				// List 생성
//				customers.add(new Customer(name, tel, address));
			} else if (continuous.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.");
				continue;
			}
		} while (true);
		sc.close();

		// 가입정보 출력
		for (int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i));
		}

		// 가입정보 없을 시 출력
		if (customers.isEmpty()) {
			System.out.println("가입한 회원 목록이 없습니다");
		}
	}
}
