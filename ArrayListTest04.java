package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		ArrayList<String> nickname = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++){
			System.out.print(i + "��° ���� �Է�>>");
			String input = scan.nextLine();
			nickname.add(input); 
			
		}
		
		// ���� �� ���� ���� ������ ������ ������ �� ����Ʈ�� ù��° ������ ���ڼ��� �ʱ�ȭ�Ѵ�.
		
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
