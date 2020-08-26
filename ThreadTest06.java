package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	
	public static void main(String[] args) {
		Thread th1 = new DataInputThread();
		Thread th2 = new CountDownThread();
		
		th1.start();
		th2.start();
		
	}
}

// 데이터를 입력하는 쓰레드

class DataInputThread extends Thread {
	// 입력 여부를 확인하기 위한 변수 선언 ==> 쓰레드에서 공통으로 사용할 변수
	public static boolean inputCheck;
	
	
	@Override
	public void run() {
		// 사용자로부터 데이터 입력 받기
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		
		inputCheck = true; // 입력이 완료되면 inputCheck를 true로 변경하기
		
		System.out.println("입력값 : " + str);
	}
}

// 카운트다운을 진행하는 쓰레드
class CountDownThread extends Thread {
	@Override
	public void run() {
		for(int i = 10; i >= 0; i--){
			
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면 쓰레드를 종료시킨다.
			if(DataInputThread.inputCheck == true){
				//break; //반복문을 빠져나가서 프로그램 종료됨
				return; // run()메서드가 종료되면 쓰레드도 종료된다.
			}
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //1초동안 잠시 멈춘다.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("지정된 시간이 경과했습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}