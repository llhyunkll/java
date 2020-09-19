package homework;

import java.io.File;

public class FileTest0919_01 {

	public static void main(String[] args) {
		// File객체 만들기
		File file1 = new File("D:/d_other/test0919.txt");
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("path : " + file1.getPath());
		System.out.println("디렉토리? : " + file1.isDirectory());
		System.out.println("파일? : " + file1.isFile());
		System.out.println();
		
		File file2 = new File("d:/d_other");
		System.out.println("파일명 : " + file2.getName());
		System.out.println("path : " + file2.getPath());
		System.out.println("디렉토리? : " + file2.isDirectory());
		System.out.println("파일? : " + file2.isFile());
		System.out.println();
		
		File file3 = new File(file2, "test0919.txt");
		System.out.println("파일명 : " + file3.getName());
		System.out.println("path : " + file3.getPath());
		System.out.println("디렉토리? : " + file3.isDirectory());
		System.out.println("파일? : " + file3.isFile());
		System.out.println();
		
		// 디렉토리 만들기
		// mkdir() : File객체의 경로 중 마지막 위치의??? 디렉토리를 만든다.
		// mkdirs() : 중간 경로가 없으면 그 중간 부분의 경로도 같이 만든다. 
		File file4 = new File("d:/d_other/study");
		System.out.println(file4.getName() + "의 존재 여부 " + file4.exists());
		if(!file4.exists()){
			if(file4.mkdir()){
				System.out.println(file4.getName() + "폴더 만들기 성공");
			}else{
				System.out.println(file4.getName() + "폴더 만들기 실패");
			} // 이미 존재하면 실패함
		}
		System.out.println("--------------------------------------");
		
		File file5 = new File("d:/d_other/study/test/java");
		System.out.println(file5.getName() + "의 존재 여부 " + file5.exists());
		if(!file5.exists()){
			if(file5.mkdirs()){
				System.out.println(file5.getName() + "폴더 만들기 성공");
			}else{
				System.out.println(file5.getName() + "폴더 만들기 실패");
			} // 이미 존재하면 실패함
		}
		
		System.out.println(file1.getName() + "의 크기 : " + file1.length() + "byte");
		System.out.println("absolutePath : " + file1.getAbsolutePath());
		System.out.println();
		
		File f2 = new File(".");
		System.out.println("path : " + f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		
	}
	
}
