package com.lec.lect;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LC")
/**
 * Servlet implementation class Ex3_LifeCycle
 */
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex3_LifeCycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// 서블릿 객체가 생성되자 마자 실행
		System.out.println("Ex3_LifeCycle 서블릿 생성될 때 수행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// 서블릿 객체가 소멸될 때 실행
		System.out.println("Ex3_LifeCycle 서블릿 객체가 소멸될 때 실행");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// service를 오버라이드함ㄴ doGet()함수와 doPost()함수가 실행되지 않고 service()실행
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().println("<h1>service() 함수 수행</h1>");
//		response.getWriter().close();
//		System.out.println("Ex3_LifeCycle Service() 실행");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get방식으로 요청시 실행
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>doGet() 함수 수행</h1>");
		response.getWriter().close();
		System.out.println("Ex3_LifeCycle doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>doPost() 함수 수행</h1>");
		response.getWriter().close();
		System.out.println("doPost() 실행");
	}

}
