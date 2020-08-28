package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07Sample {
	public static boolean inputCheck;
	
	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		// 컴퓨터의 가위 바위 보를 난수를 이용해서 정한다.
		String[] data = {"가위", "바위", "보"};	// 0~2사이의 인덱스
		int index = (int)(Math.random()*3); // 0~2사이의 난수 만들기
		String com = data[index]; // 컴퓨터의 가위 바위 보를 정한다.
		
		// 사용자의 가위 바위 보 입력 받기 
		gt.start(); // 카운트다운 시작
		
		String man = null;
		do{
			
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
			
		//}while( man == null || !(man.equals("가위") || man.equals("바위") || man.equals("보")) );
		}while( man == null || !man.equals("가위") && !man.equals("바위") && !man.equals("보") );
		
		inputCheck = true;
		
		// 결과 판정하기
		String result = ""; // 결과가 저장될 변수 선언 및 초기화
		if(man.equals(com)){
			result = "비겼습니다.";
		}else if( (man.equals("가위") && com.equals("보") ) ||
				  (man.equals("바위") && com.equals("가위") ) ||
				  (man.equals("보") && com.equals("바위") )){
					  result = "당신이 이겼습니다.";
		}else{
			result = "당신이 졌습니다.";
		}
		
		// 결과 출력
		System.out.println("-- 결   과 --");
		System.out.println("컴퓨터 : " + com);
		System.out.println("당신 : " + man);
		System.out.println("결과 : " + result);
		System.out.println();
		
	}
}

class GameTimer extends Thread{
	
	@Override
	public void run() {
		for(int i=5; i >= 1; i--){
			
			// 입력이 완료되었는지 여부를검사해서 입력이 완료되면 쓰레드를 종료시킨다.
			if(ThreadTest07Sample.inputCheck == true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("지정된 시간이 경과했습니다.");
		System.out.println("당신이 졌습니다."); System.exit(0);
	}
}