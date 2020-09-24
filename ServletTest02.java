package kr.or.ddit.basic;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 애노테이션(@WebServlet)을 이용한 Servlet처리 예제
// 애노테이션(@WebServlet)은 Servlet버전 3.0이상에서 사용할 수 있다.

// @WebService 애너테이션의 속성들
// 1. name : 서블릿의 이름을 설정한다. (기본값 : 빈문자열(""))
// 2. urlPatterns : 서블릿의 URL 패턴의 목록을 설정한다. (기본값 : 빈배열( {} ))
// 		예) urlPatterns="/url1" 또는 urlPatterns={"/url1} ==> 패턴이 1개일 경우
// 		예) urlPantterns={"/url1", "/url2", ... } ==> 패턴이 2개 이상일 경우
// 3. value : urlPatterns와 동일한 기능을 한다.
// 4. description : 주석(설명글)을 설정한다.


@WebServlet(urlPatterns={"/servletTest02.do"}, description="애너테이션을 이용한 서블릿 예제")
//@WebServlet("/servletTest02.do")
public class ServletTest02 extends HttpServlet{
	
	
	//doGet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); // 응답 문서의 인코딩 방식 지정 //문서를 읽어갈때의 인코딩방식
		response.setContentType("text/html; charset=utf-8"); // 응답 문서의 ContentType 지정 //문서를 읽어서 화면에 보여줄때 인코딩방식
		
		// 처리한 내용을 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		PrintWriter out = response.getWriter(); //문자기반의 스트림?
		
		// 처리한 내용을 출력한다.
		
		// 방법1) append()메서드 이용하기
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>두번째 Servlet 연습</title>");
		out.println("</head>");
		out.println("<boby>");
		out.println("<h1 style='text-align:center'>");
		out.println("안녕하세요. 두번째 Servlet 프로그램 입니다.<br>");
		out.println("Server 경로 : " + request.getContextPath());
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}
