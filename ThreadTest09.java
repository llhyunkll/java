package kr.or.ddit.basic;

//데몬 쓰레드 연습 ==> 자동 저장하는 쓰레드
public class ThreadTest09 {

	public static void main(String[] args) {
		AutoSaveThread auto = new AutoSaveThread();
		
		// 데몬 쓰레드로 설정하기 ==> 반드시 start()메서드를 호출하기 전에 설정해야 한다.
		auto.setDaemon(true);
		
		auto.start();
		// auto.setDaemon(true); start이후에 있으면 에러...
		
		try {
			for(int i = 1; i <= 20; i++){
				System.out.println(i);
				Thread.sleep(1000); // 20초 동안 작업을 한다..
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("main 쓰레드 종료");
	}
}

// 자동 저장하는 쓰레드 (3초에 한번씩 저장하느 쓰레드)
class AutoSaveThread extends Thread {
	
	// 지금까지의 작업 내용을 저장하는 메스드 
	public void save(){
		System.out.println("작업 내용을 저장합니다...");
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000); //3초
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			save(); // 3초 마다 저장하기
		}
	}
	
}