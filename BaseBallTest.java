package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 2 5 1 
// 2 1 3 => 1S 1B
// 3 5 7 => 3O
/*

	문제 ) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
		  컴퓨터의 숫자는 난수를 이용하여 구한다.(1~9사이의 서로 다른 난수 3개)
		 (스트라이크는 S, 볼은 B로 나타낸다.)
		 
	예시)
		 컴퓨터 난수 ==> 9 5 7 set => arraylist
		 
	실행예시)
		숫자입력 >> 3 5 6 
			3 5 6 ==> 1S 0B list, 배열
		숫자입력 >> 7 8 9 
			7 8 9 ==> 0S 2B
		숫자입력 >> 9 7 5 
			9 7 5 ==> 1S 2B
		숫자입력 >> 9 5 7 
			9 5 7 ==> 3S
			
		축하합니다.
		당신은 4번째만에 맞췄습니다.

 */

public class BaseBallTest {

	public static void main(String[] args) {
		
		HashSet<Integer> baseBall = new HashSet<>();
		
		while(baseBall.size() < 3){
			baseBall.add((int)(Math.random() * 9 + 1));
		}
//		System.out.println(baseBall);
		
		ArrayList<Integer> game = new ArrayList<>(baseBall);
		
//		for(int i = 0; i < game.size(); i++){
//			System.out.print(game.get(i));
//		}
		
		Scanner scan = new Scanner(System.in);
		int strike = 0;
		int ball = 0; 
		int out = 0; 
		int count = 0;
		
		while(true){
			
			System.out.print("숫자 입력 >>");
			int temp1 = scan.nextInt();
			int temp2 = scan.nextInt();
			int temp3 = scan.nextInt();
			
			ArrayList<Integer> input = new ArrayList<>();
			input.add(temp1);
			input.add(temp2);
			input.add(temp3);
			
			count++; 

			for(int i = 0; i < game.size(); i++){
				if(game.get(i) == input.get(i)){
					strike++;
				}		
			}
			System.out.print(strike+ "S");
			
			for(int i = 0; i < game.size(); i++){
				for(int j = 0; j< input.size(); j++){
					if(i != j){
						if(game.get(i).equals(input.get(j))){
							ball++;
						}
					}
				}
			}
			System.out.println(ball+"B");
			
			if(strike == 3){
				System.out.println("정답입니다.");
				System.out.println(count + "번만에 맞췄습니다.");
				break;
			}else{
				input.clear();
				strike = 0;
				ball = 0;
			}

			
			
		}
	}

}
