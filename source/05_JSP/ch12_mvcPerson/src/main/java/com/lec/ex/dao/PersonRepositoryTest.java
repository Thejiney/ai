package com.lec.ex.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.lec.ex.dto.Person;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonRepositoryTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PersonRepository repository = PersonRepository.getInstance();
		ArrayList<Person> persons = repository.getPersonList();
		int result = 0;

		System.out.println(1);
		for (Person person : persons) {
			System.out.println(person);
		}
		System.out.println(2);
		persons = repository.getPersonList(3, 4);
		for (Person person : persons) {
			System.out.println(person);
		}
		System.out.println(3);
		int cnt = repository.getCount();
		System.out.println("현재 " + cnt + "행이 데이터베이스에 있음.");

		Person person = new Person("김삼순", null, "강릉", new Date(93, 10, 22), "테스트중");
		result = repository.insertPerson(person);

		System.out.println(result == PersonRepository.SUCCESS ? "삽입성공" : "삽입실패");

		person = repository.getPerson(1);
		System.out.println(person);

		person.setName("한삼식");
		person.setTel("010-4567-5878");
		result = repository.updatePerson(person);

		System.out.println(result == PersonRepository.SUCCESS ? "수정성공" : "수정실패");

		result = repository.deletePerson(1);
		System.out.println(result == PersonRepository.SUCCESS ? "삭제성공" : "삭제실패");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
