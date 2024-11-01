package com.lec.ex.service;

import com.lec.ex.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// pageNum파라미터 받아, startRow, endRow 계산 => getPersonList(startRow, endRow)
		// pageCnt, startPage, endPage 계산후 view단으로 넘길 데이터 request에 setAttribute
		// list.do나 lsit.do?pageNum=7
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum); // 숫자형 현재 페이지 번호
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;

		PersonRepository repository = PersonRepository.getInstance();
		request.setAttribute("personList", repository.getPersonList(startRow, endRow));

		int totCnt = repository.getCount();
		int pageCnt = (int) Math.ceil((double) totCnt / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		// 뷰단에서 필요한 항목들을 request에 setAttribute
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // 이전을 출력할지 여부
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); // 현재 페이지 수
		request.setAttribute("pageCnt", pageCnt); // 다음을 출력할지 여부
	}

}
