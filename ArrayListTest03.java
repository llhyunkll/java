package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
  	���� 1) 5���� ������ �Է� �޾� ArrayList�� ������ �� 
  	 	     �̵� �� ������ ���̰� ���� �� ������ ����Ͻÿ�.
  	      (��, �Է��� ������ ������ ���̴� ��� �ٸ���.)
  	���� 2) ���� 1���� ������ ���̰� ���� ���� �ߺ��� ��� ó���Ͻÿ�.  	
 */

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		
		ArrayList<String> nickname = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++){
			System.out.print(i + "��° ���� �Է� >>");
			String input = scan.nextLine();
			nickname.add(input); 
		}
		
		// ���� �� ������ ����� ���� ���� �� �� �������� List�� ù��° �������� �ʱ�ȭ�Ѵ�.
		String maxAlias = nickname.get(0);
		// ���� �� ������ List�� index ��ȣ�� ������ ������ ����
		int maxIndex = 0;
		for(int i = 1; i < nickname.size(); i++){
			if(nickname.get(i).length() > maxAlias.length()){
				maxAlias = nickname.get(i);
			}
			if(nickname.get(i).length() > nickname.get(maxIndex).length()){
				maxIndex = i; 
			}
		}
		System.out.println("���� �� ���� : " + maxAlias);
		System.out.println(nickname.get(maxIndex));
		
		// ���� �� ���� ���� �������ϴ�....
		
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
