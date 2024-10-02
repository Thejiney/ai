package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.dao.JobRepository;
import com.lec.dao.PersonRepository;
import com.lec.dto.Person;

public class Quiz {
	public static void main(String[] args) {
		PersonRepository personRepository = PersonRepository.getInstance();
		JobRepository jobRepository = JobRepository.getInstance();
		Scanner sc = new Scanner(System.in);
		String jobs = jobRepository.jnameList().toString();

		while (true) {
			System.out.print("수행할 동작을 입력해주세요(1:삽입, 2:직업별 조회, 3: 전체 조회, 그외: 종료)");
			int num = sc.nextInt();
			if (num < 1 || num > 3) {
				System.out.println("종료합니다");
				break;
			}
			switch (num) {
			case 1:
				System.out.print("이름을 입력해주세요 > ");
				String pname = sc.next();
				System.out.print("직업" + jobs + "을 입력해주세요 > ");
				String jname = sc.next();
				System.out.print("국어 점수를 입력해주세요 > ");
				int kor = sc.nextInt();
				System.out.print("영어 점수를 입력해주세요 > ");
				int eng = sc.nextInt();
				System.out.print("수학 점수를 입력해주세요 > ");
				int mat = sc.nextInt();
				personRepository.insertPerson(pname, jname, kor, eng, mat);
				break;
			case 2:
				System.out.print("직업" + jobs + "을 입력해주세요 > ");
				jname = sc.next();
				ArrayList<Person> persons = personRepository.getPerson(jname);
				if (persons.isEmpty()) {
					System.out.println("등록된 사람이 없습니다");
				} else {
					for (Person person : persons) {
						System.out.println(person);
					}
				}
				break;
			case 3:
				persons = personRepository.getPerson();
				if (persons.isEmpty()) {
					System.out.println("현재 등록된 사람이 없습니다");
				} else {
					for (Person person : persons) {
						System.out.println(person);
					} // for person
				} // if
			}// switch
		} // while
		sc.close();
	}
}
