package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

public class Quiz {
	public static void main(String[] args) {
		PersonRepository personRepository = PersonRepository.getInstance();
		Scanner sc = new Scanner(System.in);

		System.out.print("수행할 동작을 입력해주세요(1:삽입, 2:직업별 조회, 3: 전체 조회, 그외: 종료)");
		int num = sc.nextInt();
		switch (num) {
		case 1: {
			System.out.print("이름을 입력해주세요 > ");
			String pname = sc.next();
			System.out.print("직업을 입력해주세요 > ");
			String jname = sc.next();
			System.out.print("국어 점수를 입력해주세요 > ");
			int kor = sc.nextInt();
			System.out.print("영어 점수를 입력해주세요 > ");
			int eng = sc.nextInt();
			System.out.print("수학 점수를 입력해주세요 > ");
			int mat = sc.nextInt();
			personRepository.insertPerson(pname, jname, kor, eng, mat);
		}
		case 2: {
			System.out.println("직업을 입력해주세요 > ");
			String jname = sc.next();
			ArrayList<Person> persons = personRepository.getPerson(jname);
			for (Person person : persons) {
				System.out.println(person);
			}
		}
		case 3: {
			ArrayList<Person> persons = personRepository.getPerson();
			for (Person person : persons) {
				System.out.println(person);
			}
		}
		default: {
			System.out.println("종료합니다.");
		}
		}
		sc.close();
	}
}
