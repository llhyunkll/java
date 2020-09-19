package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileIOTest0919_05 {

	// 한글이 저장된 파일 읽어오기 (한글의 인코딩 방식을 지정해서)
	public static void main(String[] args) {
		//File f = new File("d:/d_other/text_ansi.txt");
		File f = new File("d:/d_other/text_utf8.txt");
		
		try {
			// 보통의 FileReader객체는 java파일의 인코딩에 맞춰서
			// 데이터를 읽어온다.
			FileReader fr = new FileReader(f);
			
			// 입출력 할 파일의 인코딩 방식을 지정할 수 있는 스트림 객체는 
			// InputStreamReader, OutputStreamWriter
			
			FileInputStream fin = new FileInputStream(f);
			
			// 기본 인코딩 방식
			// InputStreamReader isr = new InputStreamReader(fin);
			
			InputStreamReader isr = new InputStreamReader(fin, "MS949");
			//InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
			int c;
			while( (c = isr.read()) != -1){
				System.out.print( (char)c );
			}
			
			isr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
