package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionAddServlet.do")
public class SessionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 저장하는 방법
		
		// 1. Session객체 구한다.
		// 형식1) request객체.getSession(); 또는 request객체.getSession(true);
		// 		==> 현재 세션이 있으면 현재 세션을 반환하고, 없으면 새로 생성해서 반환한다.
		// 형식2) request객체.getSession(false);
		// 		==> 현재 세션이 있으면 현재 세션을 반환하고, 없으면 null을 반환한다.
		
		HttpSession session = request.getSession();
		
		//session.setMaxInactiveInterval(60*60*24*365); //세션 유효 시간 설정
		// 2. setAttribute()메서드로 Session값 저장
		// 형식) session객체.setAttribute("세션key값", 세션값);
		// 		==> '세션key값'은 문자열, '세션값'은 모든 데이터 가능
		
		session.setAttribute("testSession", "연습용 세션입니다");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 30);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 저장되었습니다.</h2>");
		out.println("<a href='"+ request.getContextPath() + 
				"/basic/03/sessionTest.jsp'>시작문서로 이동</a>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
