package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//9월1일
public class FileIOTest02 {

	public static void main(String[] args) {
		// 파일에 데이터를 출력하는 예제
		
		try {
			File f = new File("d:/d_other/out.txt");

			//파일 출력용 스트림 객체 생성 
			// 파일이 없으면 새로 만들고, 있으면 그 내용을 덮어쓰기 한다.
			FileOutputStream fout = new FileOutputStream(f);
			//없은 파일은 만들고 있는 파일은 덮어씀
			
			for(char ch = 'A'; ch <= 'Z'; ch++){
				fout.write(ch);	// ch변수의 데이터를 파일로 출력한다.
			}
			System.out.println("출력 작업 완료...");
			
			fout.close(); // 스트림 닫기
			
			// -------------------------------------
			
			// 저장된 파일 내용을 읽어와서 출력하기 
			FileInputStream fin = new FileInputStream(f);
			int c;
			System.out.print(f.getName() + " 파일에서 읽어온 내용 : ");
			while( (c=fin.read()) != -1){
				System.out.print( (char)c );
			}
			fin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
