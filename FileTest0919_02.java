package homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest0919_02 {

	public static void main(String[] args) {
		FileTest0919_02 test = new FileTest0919_02();
		
		File file = new File("c:/windows/");
		test.displayList(file);

	} // main 끝
	
	
	// 디렉토리를 매개변수로 받아서 해당 디렉토리에 있는 
	// 모든 파일과 디렉토리 목록을 출력하는 메서드
	public void displayList(File dir){
		if(!dir.isDirectory()){
			System.out.println(dir.getName() + "은 디렉토리가 아님");
			return;
		}
		System.out.println(dir.getAbsolutePath() + "디렉토리 내용들...");
		
		// 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구한다.
		File[] files = dir.listFiles();
		String[] filestrs = dir.list();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		// 가져온 파일과 디렉토리 목록 개수만큼 반복
		for(int i = 0; i < files.length; i++){
			String fileName = files[i].getName();
			String attr = "";
			String size = "";
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : ""; 
				attr += files[i].canWrite() ? "W" : "";
			}
			System.out.printf("%s %5s %12s %s\n", 
					df.format(new Date(files[i].lastModified())), 
					attr, size, fileName );
			
		}
		
	}
	

}
