package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int coin = 0; // �ݾ�

		while(true){
			System.out.println("=================================");
			System.out.println("\tLotto ���α׷�");
			System.out.println("---------------------------------");
			System.out.println("1. Lotto ����");
			System.out.println("2. ���α׷� ����");
			System.out.println("=================================");
			System.out.println("�޴� ���� >>");
			int input = sc.nextInt();
			
			switch(input){
			case 1:
				System.out.println("Lotto ���� ����");
				System.out.println("Lotto�� �� ���� �� 1000�� �Դϴ�.");
				System.out.print("�ݾ��� �Է����ּ��� >>");
				coin = sc.nextInt();
				if(coin < 1000){
					System.out.println("�Է� �ݾ��� �ʹ� �����ϴ�. �ζǹ�ȣ ���� ����!!!"); break;
				}
				if(coin > 100000){
					System.out.println("�Է� �ݾ��� �ʹ� �����ϴ�. �ζǹ�ȣ ���� ����!!!"); break;
				}
				
				System.out.println("���� �ݾ��� " + coin + "���̰� "
						+ "�Ž��� ���� " + (coin % 1000) + "�� �Դϴ�."  );
				int lotCnt = coin / 1000;
				
				System.out.println("����� Lotto ��ȣ�� �Ʒ��� �����ϴ�.");
				for(int i = 1; i <= lotCnt; i++){
					System.out.print("�ζ� ��ȣ " + i + " : ");
					HashSet<Integer> lotto = new HashSet<>();
					while(lotto.size() < 6){
						lotto.add((int)(Math.random()*45+1));
					}
					
					ArrayList<Integer> lottoNo = new ArrayList<>(lotto);
					
					for(int j = 0; j < lottoNo.size(); j++){
						System.out.print(lottoNo.get(j));
						if(j < lottoNo.size() - 1) System.out.print(", ");
					}
					System.out.println();
				}break;
				
				
			case 2:
				System.out.println("���α׷��� �����մϴ�");
				System.out.println("�����մϴ�");
				System.exit(0);
			}
			
		}



	}

}
