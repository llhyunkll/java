package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieLogin.do")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		String pass = request.getParameter("psw");
		String check = request.getParameter("chkid");
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 쿠키 생성
		Cookie cookie = new Cookie("userId", URLEncoder.encode(userId, "utf-8"));
		
		// 체크박스의 체크여부에 따라 쿠키 저장하기 
		if(check != null){ // 체크가 되었을 때 
			// 쿠키 저장하기
			response.addCookie(cookie);
			
		}else{ // 체크되지 않았을 때
			// 쿠키 삭제하기
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// 로그인 여부 처리 
		
		if(userId != null && pass != null){
			if(userId.equals("admin") && pass.equals("1234")){ 
				// 로그인 성공
				response.sendRedirect(request.getContextPath() + "/basic/02/cookieLogin.jsp");
			}else{
				// 로그인 실패
				response.sendRedirect(request.getContextPath() + "/basic/02/cookieLogin.jsp");
			}
		}else{
			response.sendRedirect(request.getContextPath() + "/basic/02/cookieLogin.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
