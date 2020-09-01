package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	'd:/d_other' 폴더에 있는 '호랑이.jpg'파일을
	'd:/d_other/연습용' 폴더에 '호랑이_복사본.jpg'파일로 저장하시오.
 */
public class FileCopy {
	
	public static void main(String[] args) {
		String sourceFile = "d:/d_other/호랑이.jpg";
		String targetFile = "d:/d_other/연습용/호랑이_복사본.jpg";

		
		File file = new File(sourceFile);
		if(!file.exists()){
			System.out.println(file.getPath() + " 파일이 없습니다.");
			System.out.println("복사 작업을 중지합니다.");
			return;
		}

		try {
			// 복사할 원본 파일을 읽는데 사용될 스트림 객체 생성
			FileInputStream fin = new FileInputStream(sourceFile);
			
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			// 복사될 대상 파일을 저장하는데 사용될 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream(targetFile);
			
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			int data;	// 읽어온 데이터가 저장될 변수
			byte[] temp = new byte[1024];
			int len = 0;
			
			System.out.println("복사 시작...");
			
			// 1byte씩 복사
//			while( (data = fin.read()) != -1){
//				fout.write(data);
//			}
//			fout.flush();
			
			
			// 배열을 이용한 복사
//			while((len = fin.read(temp)) > 0 ){
//				fout.write(temp, 0, len);
//			}
//			fout.flush();
			
			// 버퍼 스트림을 이용한 복사
			while((data = bin.read()) != -1){
				
			}
			
			
			System.out.println("복사 완료...");
			
			fin.close();	// 사용한 스트림 닫기
			fout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

}
