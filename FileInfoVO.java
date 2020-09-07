package kr.or.ddit.basic.vo;

import java.io.Serializable;

// 파일 전송용 VO클래스 
public class FileInfoVO implements Serializable{
	private String filename;	// 파일 이름이 저장될 변수
	private byte[] fileData;	// 파일의 내용이 저장될 변수 
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	

}
