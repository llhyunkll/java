package homework;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileIOTest0919_06 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 출력하기
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileOutputStream fout = new FileOutputStream("d:/d_other/outTest.txt");
			// 기본 인코딩 방식으로 저장
			OutputStreamWriter osw = new OutputStreamWriter(fout, "MS949");
			
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
		
			System.out.println("파일에 저장할 내용 입력");
			System.out.println("입력의 끝 Ctrl + z");
			int c; 
			
			while( (c = isr.read()) != -1 ){
				fw.write(c);
			}
			
			fw.close();
			isr.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
