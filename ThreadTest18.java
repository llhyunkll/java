package kr.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 은행의 입출금 작업을 쓰레드로 처리하는 예제
// (Lock객체를 이용한 동기화 처리 예제)
public class ThreadTest18 {
	private int balance; // 잔액 저장될 객체
	
	// Lock객체 생성 ==> 되도록이면 private final로 만든다.
	private final Lock lock = new ReentrantLock();
	// Lock은 인터페이스
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금하는 메서드
	public void deposit(int money){
		// Lock객체는 lock()메서드로 락을 설정하고 
		// 반드시 unlock()메서드로 락을 해제해 주어야 한다.
		lock.lock(); // 락 설정 시작...
				
		balance += money;
		
		lock.unlock(); // 락을 해제해준다.
	}
	
	// 출금하는 메서드
	public boolean withdraw(int money){
		
		// 만약 try-catch 블럭이 사용되는 부분에서
		// unlock()메서드를 호출할 때는 finally영역에서 호출하도록 한다.

		boolean chk = false;
		try{
			lock.lock();
			if(balance >= money){ // 잔액확인 : 잔액이 출금액보다 커야됨

				for(int i = 0; i <= 10_000_000; i++){ } //시간 지연용
				
				balance -= money;
				System.out.println("메서드 안에 balance = " + balance);
				//return true;
				chk = true;
			
			}else{
				//return false;
				chk = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
		return chk;
		
	}
	
	public static void main(String[] args) {
		final ThreadTest18 account = new ThreadTest18(); // 익명구현체 사용하려면 final 붙여야함???
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
