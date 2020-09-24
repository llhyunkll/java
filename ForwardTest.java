package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// forward로 넘어온 데이터 구하기
		String userName = request.getParameter("username");
		String tel = (String) request.getAttribute("tel"); //object형을 String으로 형변환
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>forward 연습</title></head>");
		out.println("<body>");
		
		out.println("<h2>forward 결과</h2><hr>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름</td><td>" + userName + "</td></tr>");
		out.println("<tr><td>전화</td><td>" + tel + "</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.println();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
