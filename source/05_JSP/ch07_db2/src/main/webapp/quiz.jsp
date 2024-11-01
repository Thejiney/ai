<%@page import="com.lec.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String conPath = request.getContextPath(); // 톰캣에 의해 실행되는 프로젝트 이름
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/ex.css" rel="stylesheet" type="text/css">
<style>
p {
	text-align: center;
}
</style>
</head>
<body>
	<%
	EmpRepository empRepository = EmpRepository.getInstance();
	String name = request.getParameter("name");
	ArrayList<Emp> empList = empRepository.empListBySchName(name);
	if(name!=null){
		name= name.trim().toUpperCase();
	}
	%>
	<form>
		<p>
			사원명 <input type='text' name='name'
				value="<%=name != null ? name : ""%>">
			<input type='submit' value='검색'>
		</p>
	</form>
	<table>
		<%
		if (empList.isEmpty()) {
			out.print("<tr><td>해당하는 사원정보가 없습니다</td></tr>");
		} else {
			out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			out.print(" <th>입사일</th><th>급여</th><th>부서번호</th><th>부서명</th></tr>");
			for (Emp emp : empList) {
				out.print("<tr><td>" + emp.getEmpno() + "</td>");
				out.print("<td>" + emp.getEname() + "</td>");
				out.print("<td>" + emp.getJob() + "</td>");
				out.print("<td>" + emp.getMgr() + "</td>");
				out.print("<td>" + emp.getHiredate() + "</td>");
				out.print("<td>" + emp.getSal() + "</td>");
				out.print("<td>" + emp.getDeptno() + "</td>");
				out.print("<td>" + emp.getDname() + "</td></tr>");
			}
		}
		%>
	</table>
</body>
</html>