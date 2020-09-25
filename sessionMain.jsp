<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습용 main</title>
</head>
<body>
	<h2>Session 연습용 main</h2>
	<!-- form에서 method값이 post가 아닌 모든 것은 get방식 -->
	<a href="<%=request.getContextPath()%>/SessionLoginServlet.do">Login</a>
</body>
</html>