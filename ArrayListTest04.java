package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		ArrayList<String> nickname = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++){
			System.out.print(i + "번째 별명 입력>>");
			String input = scan.nextLine();
			nickname.add(input); 
			
		}
		
		// 제일 긴 글자 수를 저장할 변수를 선언한 후 리스트의 첫번째 별명의 글자수로 초기화한다.
		
		int num = 0;
		
		for(int i = 0; i < nickname.size(); i++){
			if(nickname.get(i).length() > num){
				num = nickname.get(i).length();
					
			}
		}
		for(int i = 0; i < nickname.size(); i++){
			if(nickname.get(i).length() == num){
				System.out.println(nickname.get(i));
			}
		}
			
		
		
		
		
	}

}
