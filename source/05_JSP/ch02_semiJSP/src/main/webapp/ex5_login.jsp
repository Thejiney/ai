<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
td {
	text-align: center;
}
</style>
<body>
	<form action="ex5_loginPro.jsp" method=get>
		<table>
			<tr>
				<td>이름</td>
				<td><input type='text' name=name></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type='text' name=id></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type='password' name=pw></td>
			</tr>
			<tr>
				<td colspan=2><p>
						<input type="submit" value='로그인'>
					</p></td>
		</table>
	</form>
</body>
</html>