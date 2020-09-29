package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/FileDownloadServlet.do")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIR = "d:/d_other/uploadFiles";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일명을 파라미터로 받는다.
		String fileName = request.getParameter("fileName");
		
		String filePath = UPLOAD_DIR + File.separator + fileName;
		File file = new File(filePath);
		if(file.exists()){
			// ContentType 설정
			response.setContentType("application/oatet-stream; charset=utf-8");
			
			// Response의 Header에 content-disposition속성 설정
			response.setHeader("content-Disposition", 
					"attachment; filename=\"" + file);
			
			FileInputStream fin = null;
			OutputStream out = null;
			
			try {
				// 출력용 스트림 객체 생성 ==> Respose객체 시용 
				out = response.getOutputStream();
						
				// 파일 입력용 스트림 객체 생성
				fin = new FileInputStream(file);
				
				byte[] buffer = new byte[8192];
				int bytesRead = -1;
				
				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림으로 출력한다.
				while( (bytesRead = fin.read(buffer)) != -1){
					out.write(buffer, 0, bytesRead);
					
				}
				out.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(fin != null) fin.close();
				if(out != null) out.close();
			}
			
		}else {
			response.setContentType("text/html");
			response.getWriter().println("<h3>파일이 존재하지 않습니다.</h3>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
