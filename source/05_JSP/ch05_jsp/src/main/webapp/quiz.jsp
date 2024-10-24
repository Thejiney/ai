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
<%
//건네받은 파라미터가 있을 때를 위하여 선 request
String sName = request.getParameter("name");
String sNum = request.getParameter("num");

//변수 초기화
String name = "";
int num = 0;

//건네받은 파라미터가 있을 경우 포맷에 맞게 변경 후 변수에 할당
if (sName != null) {
	name = sName.trim();
}
if (sNum != "" && sNum != null) {
	num = Integer.parseInt(sNum);
}
%>
</head>
<body>
	<fieldset>
		<legend>입력</legend>
		<form>
			<p>
				이름 <input type="text" name="name" value=<%=name%>>
			</p>
			<p>
				숫자 <input type="number" name="num" min="1" value=<%=sNum%>>
			</p>
			<p>
				<input type="submit" value="누적">
			</p>
		</form>
	</fieldset>
	<%
	if (num != 0) {
		int result = 0;
		for (int i = 1; i <= num; i++) {
			result += i;
		}
		out.print("<h2>1부터 " + num + "까지 누적합은 " + result + "입니다.</h2>");
	}
	%>
</body>
</html>