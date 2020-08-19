package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제) 5명의 사람 이름을 입력받아  ArrayList에 저장한 후에 
 	이들 중 '김'씨 성의 이름을 모두 출력하시오.
 	(단, 입력은 Scanner객체를 이용한다.)
 	
*/

public class ArrayListTest02 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> name = new ArrayList<>();
		
//		for(int i = 0; i < 5; i++){
//			System.out.print(i + "번째 이름 입력 >>");
//			String temp = sc.nextLine();
			name.add("김민지");
			name.add("배현태");
			name.add("김용진");
			name.add("정선영");
			name.add("임형묵");
			
//		}
			
			
		System.out.println("김씨 성을 가진 사람들");
		for(int i= 0; i < name.size(); i++){
			if(name.get(i).substring(0,1).contains("김")){
				System.out.println(name.get(i));
			}
			if(name.get(i).charAt(0) == '김'){
				System.out.println(name.get(i));
			}
			if(name.get(i).indexOf("김") == 0){
				System.out.println(name.get(i));
			}
			if(name.get(i).startsWith("김")){ //김으로 시작하면 true, 아니면 false
				System.out.println(name.get(i));
			}
		}
		
		for(String str : name){
			if(str.substring(0,1).equals("김")){
				System.out.println(str);
			}			
		}
		for(String st : name){
			if(st.startsWith("김")){
				System.out.println(st);
			}
		}

	}

}
