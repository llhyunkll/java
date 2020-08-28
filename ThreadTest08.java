package kr.or.ddit.basic;

public class ThreadTest08 {

	public static void main(String[] args) {
		// 쓰레드의 우선순위 
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread(); 
		
		th1.setPriority(9);
		th2.setPriority(3);
		
		System.out.println("th1의 우선순위 : " + th1.getPriority());
		System.out.println("th2의 우선순위 : " + th2.getPriority());
		System.out.println();
		
		th1.start();
		
		th2.start();
		
	}
}


// 대문자를 출력하는 쓰레드
class UpperThread extends Thread {
	@Override
	public void run() {
		for(char c = 'A'; c <= 'Z'; c++){
			System.out.println(c);
			
			for(long i = 1; i <= 2100000000L; i++){ } // 실행중이긴 하지만 아무것도 안하는 반복문
													// sleep은 쓰레드의 실행을 잠시 멈춘 것
		}
	}
}

// 소문자를 출력하는 쓰레드
class LowerThread extends Thread {
	
	@Override
	public void run() {
		for(char c = 'a'; c <= 'z'; c++){
			System.out.println(c);
			
			for(long i = 1; i <= 2100000000L; i++){ }
	
		}
	}	
}