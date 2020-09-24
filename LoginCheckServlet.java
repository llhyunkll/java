package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("name");
		String password = request.getParameter("psw");
		
		if(userName == null || password == null){
			response.sendRedirect("/servletTest/basic/01/login.jsp");
			
		}else{
			// 로그인 성공
			if(userName.equals("admin") && password.equals("1234")){
				//response.sendRedirect("/servletTest/basic/01/main.jsp?name="+userName +"&psw="+ password);
	
				// request.setAttribute("name", "admin");
				request.setAttribute("name", userName);
				
				RequestDispatcher rd = request.getRequestDispatcher("/basic/01/main.jsp");
				rd.forward(request, response);
				
			}else{ 
				// 로그인 실패
				response.sendRedirect("/servletTest/basic/01/loginfail.jsp");
				
			}
			
			
			
			
		}
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
