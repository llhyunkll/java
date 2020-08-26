package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		// 사용자로부터 데이터 입력 받기
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		
		System.out.println("입력값 : " + str); //취소나 x 누르면 null값 입력됨
		
		for(int i = 10; i >= 0; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초동안 잠시 멈춘다.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
