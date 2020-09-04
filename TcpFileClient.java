package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
	클라이언트가 서버에 접속하면 'd:/d_other'폴더에 있는 
	'호랑이.jpg' 파일을 서버로 전송한다.
	
 */
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class TcpFileClient {
	private Socket socket;
	private BufferedOutputStream bos;	// 소켓 전송용
	private DataOutputStream dos;		// 문자 전송용
	
	private BufferedInputStream bis;	// 파일 읽기용
	
	
	public void clientStart(){
		
//		// 전송할 파일을 이용한 File객체 생성
//		File file = new File("d:/d_other/호랑이.jpg");
//		String fileName = file.getName();	// 파일 이름 구하기
//		if(!file.exists()){ // 전송할 파일이 있는지 검사
//			System.out.println(fileName + " 파일이 없습니다.");
//			return;
//		}
		
		JFileChooser filechooser = new JFileChooser();
		filechooser.setCurrentDirectory(new File("d:/d_other"));
		
		String fileName = null;
		File file = null;
		int result= filechooser.showOpenDialog(new JPanel());
		if(result == filechooser.APPROVE_OPTION){
			file = filechooser.getSelectedFile();
			fileName = file.getName();
		}else{
			System.out.println("파일 전송을 취소합니다.");
			return;
		}
		
		
		try {
			Socket socket = new Socket("localhost", 7777);
			
			System.out.println("파일 전송 시작...");
			
			// 처음 접속되면 '파일이름'을 전송한다.
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			
			// 파일 읽기용 스트림 객체 생성
			bis = new BufferedInputStream(new FileInputStream(file));
			
			// 서버로 전송할 스트림 객체 생성
			bos = new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024];
			int len = 0;
			// 파일 내용을 읽어와 소켓을 통해서 전송한다.
			while((len = bis.read(temp))>0){
				bos.write(temp, 0, len);
			}
			bos.flush();	// 마지막에 버퍼 비우기
			
			System.out.println("파일 전송 완료...");
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패...");
			e.printStackTrace();
		} finally {
			// 사용한 스트림 닫기
			if(dos != null) try { dos.close(); } catch (IOException e){ }
			if(bis != null) try { bis.close(); } catch (IOException e){ }
			if(bos != null) try { bos.close(); } catch (IOException e){ }
			if(socket != null) try { socket.close(); } catch (IOException e){ }
		}
	}
	
	public static void main(String[] args) {
		
		new TcpFileClient().clientStart();
		

	}

}
