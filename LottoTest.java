package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LottoTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int coin = 0; // 금액

		while(true){
			System.out.println("=================================");
			System.out.println("\tLotto 프로그램");
			System.out.println("---------------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("=================================");
			System.out.println("메뉴 선택 >>");
			int input = sc.nextInt();
			
			switch(input){
			case 1:
				System.out.println("Lotto 구입 시작");
				System.out.println("Lotto는 한 게임 당 1000원 입니다.");
				System.out.print("금액을 입력해주세요 >>");
				coin = sc.nextInt();
				if(coin < 1000){
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!"); break;
				}
				if(coin > 100000){
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!"); break;
				}
				
				System.out.println("받은 금액은 " + coin + "원이고 "
						+ "거스름 돈은 " + (coin % 1000) + "원 입니다."  );
				int lotCnt = coin / 1000;
				
				System.out.println("행운의 Lotto 번호는 아래와 같습니다.");
				for(int i = 1; i <= lotCnt; i++){
					System.out.print("로또 번호 " + i + " : ");
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
				System.out.println("프로그램을 종료합니다");
				System.out.println("감사합니다");
				System.exit(0);
			}
			
		}



	}

}
