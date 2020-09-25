<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습용 Result</title>
</head>
<body>
<%
	// JSP문서에서는 'session'이라는 이름으로 세션이 저장되어 있다.
	
	// 세션값 읽기
	String userId = (String)session.getAttribute("id");
	
%>

<%
	if(userId == null){ // 로그인 실패
%>		
<script>
	alert("로그인실패");
	history.go(-1);

</script>
<%	
	}else{
%>
	<h3><%=userId %>님 반갑습니다.</h3>
	<a href="<%=request.getContextPath()%>/SessionLogoutServlet.do">Logout</a>

<%
	}
%>

 
<!-- 
	로그인이 성공하면 
	~~~님 반갑습니다.
		로그아웃
	로그인 실패하면
		alert("로그인실패");
		이전 페이지로 이동
 -->
 
 
</body>
</html>