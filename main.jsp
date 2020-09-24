<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<h3>메인 페이지</h3>
<%
	request.setCharacterEncoding("utf-8");
	
	//String userName = request.getParameter("name");

	String userName =(String) request.getAttribute("name");

%>

<%= userName %>님 환영합니다.

</body>
</html>