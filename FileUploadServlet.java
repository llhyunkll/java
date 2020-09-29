package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/FileUploadServlet.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10 ,	// 10M 
		maxFileSize = 1024 * 1024  * 30,		// 30M //  
		maxRequestSize = 1024 * 1024 * 50		// 50M
)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 업로드된 파일이 저장될 폴더 설정
	private static final String UPLOAD_DIR = "d:/d_other/uploadFiles";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드에서는 GET방식을 사용할 수 없다.
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 저장될 폴더가 없으면 해당 폴더를 생성한다.
		File fileUploadDirectory = new File(UPLOAD_DIR);
		if(!fileUploadDirectory.exists()){
			fileUploadDirectory.mkdirs();
		}
		
		String fileName = ""; // 업로드한 파일명이 저장될 변수
		
		List<UploadDetail> fileList = new ArrayList<>();
		
		// Part 개수만큼 반복
		for(Part part : request.getParts()){
			fileName = getFileName(part); 	//  파일명 구하기
			
			if("".equals(fileName)) continue; // 파일이름이 없으면 건너 뛴다. 파일이 아니니까?
			
			UploadDetail details = new UploadDetail(); 		// 파일 정보가 저장될 객체 생성
			details.setFileName(fileName);
			details.setFileSize(part.getSize() / 1024); // Kb단위로 변환
			
			try {
				part.write(UPLOAD_DIR + File.separator + fileName); // 파일 저장
				details.setUploadStatus("Success");
			} catch (IOException e) {
				details.setUploadStatus("Fail : " + e.getMessage());
			}
			
			fileList.add(details); // 리스트에 파일정보가 저장도리 객체 추가
			
		}
		
		request.setAttribute("uploadFileList", fileList);
		
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	
	// Part 영역에서 업로드한 파일 이름을 구해서 반환하는 메서드
	private String getFileName(Part part){
	/*
	- Part의 구조
	1) 파일이 아닌 경우
	-------- adkjnfk3048udhnfkajsdf203428dfa9djkankdf 		==> Part 구분선
	Content-Disposition : form-data; name="memid" 	==> 파라미터명 
							==> 빈줄
	a001 					==> 파라미터 값
	
	2) 파일인 경우
	-------- adkjnfk3048udhnfkajsdf203428dfa9djkankdf 		==> Part 구분선
	Content-Disposition : form-data; name="fileUpload1"; filename="test1.txt" 	==> 파일 정보 
	Content-Type : text/plain			==> 파일 종류
							==> 빈줄
	abcde123가나다 			==> 파일 내용
	
	 */
		
		String fileName = "";
		String contentDisposition = part.getHeader("content-disposition");
		//filename이 있는지 없는지 보면 file인지 아닌지 알수 있음
		String[] items = contentDisposition.split(";");
		for(String item : items){
			if(item.trim().startsWith("filename")){
				fileName = item.substring(item.indexOf("=") + 2, item.length()-1);
			}
		}
		
		return fileName;
	}
	
	
	

}
