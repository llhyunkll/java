package homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest0919_04 {
	
	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 출력하기
		try {
			// InputStreamReader ==> 입력용 바이트 기반 스트림을 
			// 입력용 문자 기반 스트림으로 변환해준다.
			// OutputStreamWriter ==> 출력용 바이트 기반 스트림을 
			// 출력용 문자 기반 스트림으로 변환해준다.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("입력의 끝은 Ctrl + z 입니다.");
			int c; 
			
			// 콘솔에서 데이터를 입력 할 때 입력의 끝은 ctrl + z 키를 누르면 된다.
			while( (c=isr.read()) != -1){
				fw.write(c);
			}
			
			// 스트림 닫기
			fw.close();
			isr.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
