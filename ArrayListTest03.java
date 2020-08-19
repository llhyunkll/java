package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
  	문제 1) 5명의 별명을 입력 받아 ArrayList에 저장한 후 
  	 	     이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
  	      (단, 입력한 각각의 별명의 길이는 모두 다르다.)
  	문제 2) 문제 1에서 별명의 길이가 같은 것이 중복될 경우 처리하시오.  	
 */

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		
		ArrayList<String> nickname = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++){
			System.out.print(i + "번째 별명 입력 >>");
			String input = scan.nextLine();
			nickname.add(input); 
		}
		
		// 제일 긴 별명이 저장될 변수 선언 후 이 변수에는 List의 첫번째 별명으로 초기화한다.
		String maxAlias = nickname.get(0);
		// 제일 긴 별명의 List의 index 번호를 저장할 변수를 선언
		int maxIndex = 0;
		for(int i = 1; i < nickname.size(); i++){
			if(nickname.get(i).length() > maxAlias.length()){
				maxAlias = nickname.get(i);
			}
			if(nickname.get(i).length() > nickname.get(maxIndex).length()){
				maxIndex = i; 
			}
		}
		System.out.println("제일 긴 별명 : " + maxAlias);
		System.out.println(nickname.get(maxIndex));
		
		// 제일 긴 별명도 같이 구해집니다....
		
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
