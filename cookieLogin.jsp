<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	// 쿠키값 가져오기
	String cookieUserId = ""; 	// 쿠키값이 저장될 변수
	String check = ""; 			// 체크박스의 체크 상태를 나타낼 변수
	
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("userId")){
				// 원하는 쿠키값을 찾아서 저장하기 
				cookieUserId = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				check = "checked";
			}
		}
	}

%>


	<h2>로그인</h2>
	<table></table>
	<form method="post" action="/servletTest/CookieLogin.do">
		아이디 : <input type="text" name="id" value="<%=cookieUserId%>">
		<input type="checkbox" name="chkid" <%=check%> value="ok">id 기억하기 		
		<br>
		비밀번호 : <input type="password" name="psw"><br>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>