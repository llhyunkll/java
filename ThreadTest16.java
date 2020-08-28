package kr.or.ddit.basic;

public class ThreadTest16 {
	
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		TestThread th1 = new TestThread("Test1", sObj);
		TestThread th2 = new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();
		
	}

}

class TestThread extends Thread {
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name);	// 쓰레드의 name설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			sObj.add();
		}
	}
	
}



class ShareObject {
	private int sum = 0; 
	
	// 동기화 처리 하기
	// public synchronized void add() { // 동기화 방법1 : 메서드 자체에 동기화 설정을 한다.
	public void add() { 
		
		synchronized (this) { // 동기화 방법2 : 동기화 블럭으로 설정한다.
			int n = sum;
			
			n += 10; 	// 10 증가
			
			sum = n; 
			
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
			
		}
	}
}

//동기화 하지 않으면 두개의 쓰레드가 같이 실행되면서 연산중이던 값을 가져가서 사용하여 연산하기 때문에 
//신뢰성 있는 결과를 주지 못함 