<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
</head>
<body>
<table>
	<%!String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";%>
	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM EMP";
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) { // sql문 전송결과가 1행이상 있을 때
			out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			out.print(" <th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			do {
		int empno = rs.getInt("empno");
		String ename = rs.getString("ename");
		String job = rs.getString("job");
		int mgr = rs.getInt("mgr");
		Date hiredate = rs.getDate("hiredate");
		Timestamp hire2 = rs.getTimestamp("hiredate");
		String hire3 = rs.getString("hiredate");
		int sal = rs.getInt("sal");
		int comm = rs.getInt("comm");
		int deptno = rs.getInt("deptno");
		out.print("<tr><td>" + empno + "</td>");
		out.print("<td>" + ename + "</td>");
		out.print("<td>" + job + "</td>");
		out.print("<td>" + (mgr==0?"CEO":mgr) + "</td>");
		out.print("<td>" + hiredate + "</td>");
		out.print("<td>" + sal + "</td>");
		out.print("<td>" + comm + "</td>");
		out.print("<td>" + deptno + "</td></tr>");

			} while (rs.next());

		}else{
			out.print("<tr><td>입력된 사원정보가 없습니다</td></tr>");
		}

	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			if (rs != null)
		rs.close();
			if (stmt != null)
		stmt.close();
			if (conn != null)
		conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	%>
</table>
</body>
</html>