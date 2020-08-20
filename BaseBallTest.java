package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 2 5 1 
// 2 1 3 => 1S 1B
// 3 5 7 => 3O
/*

	���� ) Set�� �̿��Ͽ� ���� �߱� ���� ���α׷��� �ۼ��Ͻÿ�.
		  ��ǻ���� ���ڴ� ������ �̿��Ͽ� ���Ѵ�.(1~9������ ���� �ٸ� ���� 3��)
		 (��Ʈ����ũ�� S, ���� B�� ��Ÿ����.)
		 
	����)
		 ��ǻ�� ���� ==> 9 5 7 set => arraylist
		 
	���࿹��)
		�����Է� >> 3 5 6 
			3 5 6 ==> 1S 0B list, �迭
		�����Է� >> 7 8 9 
			7 8 9 ==> 0S 2B
		�����Է� >> 9 7 5 
			9 7 5 ==> 1S 2B
		�����Է� >> 9 5 7 
			9 5 7 ==> 3S
			
		�����մϴ�.
		����� 4��°���� ������ϴ�.

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
			
			System.out.print("���� �Է� >>");
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
				System.out.println("�����Դϴ�.");
				System.out.println(count + "������ ������ϴ�.");
				break;
			}else{
				input.clear();
				strike = 0;
				ball = 0;
			}

			
			
		}
	}

}
