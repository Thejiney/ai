package com.lec.ex.service;

import java.sql.Date;

import com.lec.ex.dao.PersonRepository;
import com.lec.ex.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateService2 implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if (!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		String memo = request.getParameter("memo");

		PersonRepository repository = PersonRepository.getInstance();
		Person person = repository.getPerson(id);
		if (!name.equals("")) {
			person.setName(name);
		}
		if (!tel.equals("")) {
			person.setTel(tel);
		}
		if (!address.equals("")) {
			person.setAddress(address);
		}
		person.setBirth(birth);
		if (!memo.equals("")) {
			person.setMemo(memo);
		}
		int result = repository.updatePerson(person);
		System.out.println(result == PersonRepository.SUCCESS ? "수정2성공" : "수정2실패");

	}

}
