package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	����) 5���� ��� �̸��� �Է¹޾�  ArrayList�� ������ �Ŀ� 
 	�̵� �� '��'�� ���� �̸��� ��� ����Ͻÿ�.
 	(��, �Է��� Scanner��ü�� �̿��Ѵ�.)
 	
*/

public class ArrayListTest02 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> name = new ArrayList<>();
		
//		for(int i = 0; i < 5; i++){
//			System.out.print(i + "��° �̸� �Է� >>");
//			String temp = sc.nextLine();
			name.add("�����");
			name.add("������");
			name.add("�����");
			name.add("������");
			name.add("������");
			
//		}
			
			
		System.out.println("�达 ���� ���� �����");
		for(int i= 0; i < name.size(); i++){
			if(name.get(i).substring(0,1).contains("��")){
				System.out.println(name.get(i));
			}
			if(name.get(i).charAt(0) == '��'){
				System.out.println(name.get(i));
			}
			if(name.get(i).indexOf("��") == 0){
				System.out.println(name.get(i));
			}
			if(name.get(i).startsWith("��")){ //������ �����ϸ� true, �ƴϸ� false
				System.out.println(name.get(i));
			}
		}
		
		for(String str : name){
			if(str.substring(0,1).equals("��")){
				System.out.println(str);
			}			
		}
		for(String st : name){
			if(st.startsWith("��")){
				System.out.println(st);
			}
		}

	}

}
