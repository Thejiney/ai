package com.lec.ex.service;

import com.lec.ex.dao.PersonRepository;
import com.lec.ex.service.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PersonRepository repository = PersonRepository.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("person", repository.getPerson(id));
	}

}
