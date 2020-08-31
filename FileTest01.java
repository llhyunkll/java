package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		// File객체 만들기 연습
		
		// 형식1) new File(String 파일 또는 경로)
		//		 ==> 디렉토리와 디렉토리 사이 또는 디렉토리의 파일명 사이의 구분문자는
		// 			 '\'를 사용ㅎ하거나 '/'를 사용할 수 있다.
		File file1 = new File("D:/D_Other/test.txt"); // 구분문자를 '/'로 사용한 경우
		//File file1 = new File("D:\\D_Other\\test.txt"); // 구분문자를 '\'로 사용한 경우
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("path : " + file1.getPath());
		System.out.println("디렉토리일까? : " + file1.isDirectory());
		System.out.println("파일일까? : " + file1.isFile());
		System.out.println("-----------------------------------");
		
		File file2 = new File("D:/d_other"); //디렉토리, 폴더도 객체로 받을수있음
		System.out.println("파일명 : " + file2.getName());
		System.out.println("path : " + file2.getPath());
		System.out.println("디렉토리일까? : " + file2.isDirectory());
		System.out.println("파일일까? : " + file2.isFile());
		System.out.println("-----------------------------------");
		
		// 형식2) new File(File parent, String child)
		// 		 ==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file3 = new File(file2, "test.txt"); //(폴더, 파일)폴더안에 있는 파일
		System.out.println("파일명 : " + file3.getName());
		System.out.println("path : " + file3.getPath());
		System.out.println("디렉토리일까? : " + file3.isDirectory());
		System.out.println("파일일까? : " + file3.isFile());
		System.out.println("-----------------------------------");
		
		
		// 형식3) new File(String parent, String child)
		// 		 ==> 'parent'디렉토리 안에 있는 'child'파일을 갖는다.
		File file4 = new File("D:/d_other", "test.txt");
		System.out.println("파일명 : " + file4.getName());
		System.out.println("path : " + file4.getPath());
		System.out.println("디렉토리일까? : " + file4.isDirectory());
		System.out.println("파일일까? : " + file4.isFile());
		System.out.println("-----------------------------------");
		
		// 디렉토리(폴더) 만들기
		// - mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		// 			 ==> 반환값 : 만들기 성공(true), 만들기 실패(false)
		//			 ==> 경로의 중간부분의 폴더(디렉토리)들이 모두 만들어져 있어야 마지막 위치의 폴더를 만들수 있다.
		// - mkdirs() ==> 중간 부분의 경로가 없으면 그 중간 부분의 경로도 같이 만들어 준다.
		
		File file5 = new File("D:/D_other/연습용");
		System.out.println(file5.getName() + "의 존재 여부 : " + file5.exists());
		if(!file5.exists()){//file5가 존재하지 않으면~
			if(file5.mkdir()){
				System.out.println(file5.getName() + " 폴더 만들기 성공");
			}else{
				System.out.println(file5.getName() + " 폴더 만들기 실패~~~");
			}//이미 존재하면 실패함
		}
		System.out.println("-----------------------------------");
		
		File file6 = new File("D:/d_other/test/java/src");
		if(!file6.exists()){
			//if(file6.mkdir()){ //test, java라는 폴더가 없으니까 마지막 위치의 src를 만들수 없음 
			if(file6.mkdirs()){
				System.out.println(file6.getName() + " 폴더만들기 성공");
			}else{
				System.out.println(file6.getName() + " 폴더 만들기 실패!!!");
			}
		}
		
		
		
	}
}
