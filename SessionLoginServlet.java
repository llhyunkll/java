package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionLoginServlet.do")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청하면 세션을 확인해서 없으면 sessionLogin.jsp 페이지로 이동 
		// 세션에 값이 있으면 'sessionLoginResult.jsp' 페이지로 이동
		HttpSession session = request.getSession();
		
		String viewpage = "/basic/03/sessionLoginResult.jsp";
		// 세션값 읽기
		String userId = (String)session.getAttribute("id");
		
		if(userId == null){ // 세션값이 없으면... 
			viewpage = "/basic/03/sessionLogin.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewpage);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 요청이 오면 로그인 검증 작업을 수행한다.
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		HttpSession session = request.getSession();
		if(userId != null && pass != null){
			
			if(userId.equals("admin") && pass.equals("1234")){
				session.setAttribute("id", userId);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);

		
	}

}
