<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
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
<%!String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;%>
<body>
	<table>
		<%
		String sql = "SELECT E.*, DNAME " + "FROM EMP E, DEPT D" + " WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||?";
		String deptno = request.getParameter("deptno");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			//stmt = conn.createStatement(sql);
			pstmt.setString(1, deptno);
			rs = pstmt.executeQuery();
			out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			out.print(" <th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				out.print("<tr><td>" + empno + "</td>");
				out.print("<td>" + ename + "</td>");
				out.print("<td>" + job + "</td>");
				out.print("<td>" + (mgr == 0 ? "CEO" : mgr) + "</td>");
				out.print("<td>" + hiredate + "</td>");
				out.print("<td>" + sal + "</td>");
				out.print("<td>" + comm + "</td>");
				out.print("<td>" + deptno + "</td></tr>");
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		%>
	</table>
</body>
</html>