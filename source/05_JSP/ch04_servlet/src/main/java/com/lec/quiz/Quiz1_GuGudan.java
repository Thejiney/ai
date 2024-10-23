package com.lec.quiz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Quiz1_GuGudan")
/**
 * Servlet implementation class Quiz1_GuGudan
 */
public class Quiz1_GuGudan extends HttpServlet {
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
		String[] select = request.getParameterValues("select");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		if (select != null) {
			String msg;
			for (String sel : select) {
				int i = Integer.parseInt(sel);
				msg = String.format("%d단<br>", i);
				out.println(msg);
				for (int j = 1; j < 10; j++) {
					msg = String.format("%d * %d = %d<br>", i, j, i * j);
					out.println(msg);
				}
				out.println("<br>");
			}
		} else {
			out.println("선택하신 단수가 없습니다.");
		}
		out.close();
	}

}
