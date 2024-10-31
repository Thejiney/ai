package com.lec.ex.service;

import java.sql.Date;

import com.lec.ex.dao.PersonRepository;
import com.lec.ex.dto.Person;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository repository = PersonRepository.getInstance();
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if (!birthStr.equals("")) {
			birth = Date.valueOf(birthStr);
		}
		String memo = request.getParameter("memo");
		Person person = new Person(name, tel, address, birth, memo);
		
		int insertResult = repository.insertPerson(person);
//		request.setAttribute("insertResult", insertResult); // 1방법
		if (insertResult == PersonRepository.SUCCESS) { // 2방법
			request.setAttribute("insertMsg", "지인추가 완성");
		} else {
			request.setAttribute("insertMsg", "지인추가 실패");
		}
	}

}
