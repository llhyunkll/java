package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballSample {
	ArrayList<Integer> numList; // 난수가 저장될 리스트 변수
	ArrayList<Integer> userList; // 사용자가 입력한 값이 저장될 리스트 변수
	
	int strike;
	int ball; 
	
	Scanner scan = new Scanner(System.in);
	
	// 게임이 시작되는 메서드
	public void gameStart(){
		System.out.println("숫자 야구게임을 시작합니다.");
		System.out.println();
		getNum(); // 난수 만드는 메서드 호출
		
		int cnt = 0; // 몇 번만에 맞췄는지를 저장하는 변수
		
		do{
			cnt++;
			// 사용자 입력 메서드 호출
			inputNum();
			
			// 볼카운트 구하는 메서드 호출
			ballCount();
			
		}while(strike != 3); // 3 스트라이크가 될 때 까지 반복
		
		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은 "+cnt+"번째만에 맞췄습니다.");
		
	}
	
	// 1~9사이의 다른 난수 3개를 만들어서 리스트에 저장하는 메서드
	public void getNum(){
		Set<Integer> numSet = new HashSet<>();
		
		while(numSet.size() < 3){
			numSet.add( (int)(Math.random()*9+1) );
		}
		
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<>(numSet);
		
		// 리스트의 데이터를 섞어준다.
		Collections.shuffle(numList);
		
		System.out.println("컴퓨터 난수 : " + numList);
		
	}
	
	// 사용자로부터 3개의 서로다른 정수 3개를 입력 받아 리스트에 저장하는 메서드
	public void inputNum(){
		int n1, n2, n3;
		do{
			System.out.print("숫자 입력 >> ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			
			if(n1 == n2 || n2 == n3 || n1 == n3){
				System.out.println("중복되는 숫자는 입력할 수 없습니다.\n다시 입력하세요");
			}
			
		}while(n1 == n2 || n2 == n3 || n1 == n3);
		
		userList = new ArrayList<>();
		
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);

	}
	
	// 스트라이크와 볼을 판정하고 결과를 출력하는 메서드 
	public void ballCount(){
		strike = 0;
		ball = 0; 
		
		for(int i = 0; i < userList.size(); i++){
			for(int j = 0; j < numList.size(); j++){
				if(userList.get(i) == numList.get(j)){
					if(i == j){
						strike++;
					}else{
						ball++;
					}
				}
			}
		}
		
		// 볼 카운트의 결과를 출력한다.
		System.out.println(userList.get(0) + ", " + userList.get(1) + ", " 
							+ userList.get(2) + " ==> " + strike + "S "+ ball + "B");
		
	}
	
	public static void main(String[] args) {
//		BaseballSample test = new BaseballSample();
//		test.gameStart();
		
		new BaseballSample().gameStart(); //위의 두줄을 한줄로..!!!

	}

}
