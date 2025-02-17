package com.lec.ch12.dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.lec.ch12.dto.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberRepositoryTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberRepository repository = MemberRepository.getInstance();
		ArrayList<Member> members = repository.getMemberList();
		for (Member member : members) {
			System.out.println(member);
		}
		Member newMember = new Member("ddd", "11", "김길순", new Date(100, 0, 1), null);
		
		int cnt = repository.getCountMember(newMember.getId());
		if(cnt==MemberRepository.MEMBER_NONEXISTENT) {
			int result = repository.insertMember(newMember);
			System.out.println(result==MemberRepository.SUCCESS ? "가입성공":"가입실패");
		}else {
			System.out.println("중복된 ID로는 회원가입 불가합니다");
		}
	}
}
