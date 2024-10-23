package com.lec.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hiddenParam = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<head>");
		out.println("<link href='css/join.css' rel='stylesheet'>");
		out.println("</head>");

		
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id=\"join_title\">회원가입정보</div>");
		out.println("<h2>hiddenParam : " + hiddenParam + "</h2>");
		out.println("<h2>이름 : " + name + "</h2>");
		out.println("<h2>아이디 : " + id + "</h2>");
		out.println("<h2>비번 : ");
		for(int i = 0 ; i<pw.length();i++) {
			out.println("*");
		}
		out.println("</h2>");
		out.println("<h2>생년월일 : " + birth + "</h2>");
		out.println("<h2>취미 : ");
		for (String temp : hobby) {
			out.println(temp + " ");
		}
		out.println("</h2>");
		out.println("<h2>성별 : " + gender + "</h2>");
		out.println("<h2>이메일 : " + email + "</h2>");
		out.println("<h2>메일수신동의 : ");
		for (String temp : mailSend) {
			out.println(temp + " ");
		}
		out.println("</h2>");
		out.println("</div>");
		out.close();
	}

}
