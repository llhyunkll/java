package kr.or.ddit.basic;

// 은행의 입출금 작업을 쓰레드로 처리하는 예제

public class ThreadTest17 {
	private int balance;		// 잔액이 저장될 변수
	
	public synchronized int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금을 처리하는 메서드
	public void deposit(int money){
		balance += money; 
	}
	
	// 출금을 처리하는 메서드
	// 출금이 성공하믄 true, 실패하면 false 반환한다.
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해 주어야 안전하다.
	
	public boolean withdraw(int money){ // 출금액
	// public synchronized boolean withdraw(int money){ // 출금액
		synchronized (this) { // 동기화 블럭
			
			if(balance >= money){ // 잔액확인 : 잔액이 출금액보다 커야됨
				
				for(int i = 0; i <= 10_000_000; i++){ } //시간 지연용
				
				balance -= money;
				System.out.println("메서드 안에 balance = " + balance);
				return true;
			}else{
				return false;
		}
		}
	}



	public static void main(String[] args) {
		
		final ThreadTest17 account = new ThreadTest17(); // 익명구현체 사용하려면 final 붙여야함???
		account.setBalance(10000); // 잔액을 10000으로 설정한다.
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000); // 6000원 출금
				System.out.println("쓰레드에서  result = " + result + ", balance = " + 
									account.getBalance());
			}
		};
		// 익명 구현체 끝... ----------------------------------------
		
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r1); // 하나의 잔액에서 6000원씩 출금하는 작업을 같이함
		
		th1.start();
		th2.start();
		
		
	}
}
