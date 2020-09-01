package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileIOTest06 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 출력하기
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
				
			FileOutputStream fout = new FileOutputStream("d:/d_other/outTest.txt");
			// 기본 인코딩 방식으로 저장
			//OutputStreamWriter osw = new OutputStreamWriter(fout);
			
			// 인코딩 방식을 지정해서 저장하기
			OutputStreamWriter osw = new OutputStreamWriter(fout, "MS949");
			//OutputStreamWriter osw = new OutputStreamWriter(fout, "UTF-8");
				
			// 문자 기반 파일 출력용 스트림 객체 생성 
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
					
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("입력의 끝은 Ctrl + z 입니다.");
			int c;
					
			// 콘솔에서 데이터를 입력 할 때 입력의 끝은 'Ctrl' + 'z'키를 누르면 된다.
			while( (c = isr.read()) != -1){
				fw.write(c);
			}
					
			// 스트림 닫기
					
			fw.close();
			isr.close();
					
					
			} catch (IOException e) {
					// TODO: handle exception
			}

	}

}
