<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 이 영역은 Java영역 입니다.

// JSP문서에서 request는 HttpServletRequest객체의 참조값이 저장된 변수이다.
// 			 response는 HttpServletResponse객체의 참조값이 저장된 변수이다.

request.setCharacterEncoding("utf-8"); // POST방식을 전송 했을 때의 인코딩 방식

String userName = request.getParameter("username");
String tel = request.getParameter("tel");
String tel2 = (String)request.getAttribute("tel");

String name = "test";
String color = "red";

out.println("이름 : " + name);

%>
<br>
<!-- JSP영역에서 만든 변수의 값이나 식의 결과를 바로 출력하기 -->
<div style="background-color:<%=color%>">이름 : <%= name %></div>
<div style="background-color:<%=color%>">UserName : <%= userName %></div>
<div style="background-color:<%=color%>">전화번호 : <%= tel %></div>
<div style="background-color:<%=color%>">전화번호2 : <%= tel2 %></div>


</body>
</html>