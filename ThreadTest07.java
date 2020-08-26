package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
	사용자의 가위 바위 보는 showInputDialog()를 이용해서 입력받는다.
	
	입력 시간은 5초로 제한하고 카운트다운을 진행한다.
	5초안에 입력이 없으면 게임에 진것으로 처리한다.
	
	5초안에 입력이 완료되면 승패를 구해서 출력한다.
	
	결과 예시)
			-- 결  과 -- 
		컴퓨터 : 가위
		사용자 : 바위 
		결   과 : 당신이 이겼습니다. / 당신이 졌습니다. / 비겼습니다. 
 */
public class ThreadTest07 {

	public static void main(String[] args) {
		Thread th1 = new InputThread();
		Thread th2 = new CountThread();
		
		System.out.println("가위 바위 보 게임을 시작합니다.");
		th1.start();
		th2.start();

	}

}
class InputThread extends Thread {
	public static boolean inputCheck; 
	
	@Override
	public void run() {
		
		String str = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
		String str2 = "";
		int temp = (int)(Math.random()*3 )+1 ; 
		switch(temp){
		case 1: str2 = "가위"; break;
		case 2: str2 = "바위"; break;
		case 3: str2 = "보"; break;
		}
		inputCheck = true;
		System.out.println("사용자 : " + str);
		System.out.println("컴퓨터 : " + str2);
		if(str2.equals(str)){
			System.out.println("비겼습니다.");
		}else{
			if(str.equals("가위") && str2.equals("보")){System.out.println("당신이 이겼습니다"); }
			if(str.equals("보") && str2.equals("바위")){System.out.println("당신이 이겼습니다"); }
			if(str.equals("바위") && str2.equals("가위")){ System.out.println("당신이 이겼습니다");}
			
			if(str.equals("가위") && str2.equals("바위")){System.out.println("당신이 졌습니다"); }
			if(str.equals("보") && str2.equals("가위")){System.out.println("당신이 졌습니다"); }
			if(str.equals("바위") && str2.equals("보")){System.out.println("당신이 졌습니다");}
				//가위 보 	//보 바위 	//바위 가위
				//가위 바위 //보 가위 //바위 보
		}
	}
}



class CountThread extends Thread {
	@Override
	public void run() {
		for(int i = 10; i >= 0; i--){
			
			if(InputThread.inputCheck == true){
				return; // run()메서드가 종료되면 쓰레드도 종료된다.
			}
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //1초동안 잠시 멈춘다.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("지정된 시간이 경과했습니다.");
		System.out.println("당신이 졌습니다.");
	}
}