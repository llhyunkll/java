package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

/*
	10마리의 말들이 경주하는 경마 프로그램 작성하기 
	
	말은 Horse라는 이름의 클래스로 구성한다.(이 각각의 말들은 하나의 경기를 진행하는 쓰레드가 한다.) 
	이 클래스는 말이름(String), 등수(int), 말의 현재위치(int)를 멤버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다. (Comparable인터페이스 구현하기)
	
	경기 구간은 1 ~ 50 구간으로 되어있다.
	
 	경기 중 중간 중간에 각 막들의 위치를 나타내시오. 
 	예)
 	말이름1 --->--------------------------
 	말이름2 ----------->------------------
 	말이름3 ----->------------------------
 	말이름4 ------>-----------------------
 	...
 	말이름9 ------->----------------------
 	말이름10 ----->------------------------
 	
 	......
 	
 	말이름1 ----------------------------->
 	말이름2 ----------------------------->
 	말이름3 ----------------------------->
 	말이름4 ----------------------------->
 	...
 	말이름9 ----------------------------->
 	말이름10 ----------------------------->
 	
 	경기가 끝나면 등수 순으로 출력한다.

*/
public class ThreadTest13 {

	public static void main(String[] args) {
		
		List<Horse> list = new ArrayList<>();
		list.add( new Horse("1번말"));
		list.add( new Horse("2번말"));
		list.add( new Horse("3번말"));
		list.add( new Horse("4번말"));
		list.add( new Horse("5번말"));
		
		PrintHorse printer = new PrintHorse(list);

		for(Horse h : list){
			h.start();
		}
		
		printer.start();
		
		for(Horse h : list){
			try {
				h.join();
			} catch (InterruptedException e) {
			}
		}
		
		try {
			printer.join();
		} catch (InterruptedException e) {
		}
		
		for(Horse h : list){
			System.out.println(h.getHorseName() + " 등수 : " + h.getRank());
		}
		
	}
}


class PrintHorse extends Thread {
	
	List<Horse> list;
	
	public PrintHorse(List<Horse> list){
		this.list = list;
	}
	
	
	public void print(){
		System.out.println("\n\n\n------------------------------------------------");
		for(int i = 0; i< list.size(); i++){
			System.out.print(list.get(i).getHorseName() + " : ");
			for(int j = 1; j<= 50; j++){
				if(list.get(i).getPnt() == j){
					System.out.print(">");
				}
				else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}
	
	@Override
	public void run() {
		
		while(true){

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			print();
			
			if(Horse.setRank == list.size()){
				break;
			}
		}
	}
	
}

class Horse extends Thread implements Comparable<Horse>{
	
	public static int setRank;
	private String name;
	private int rank;
	private int pnt;
	
	public Horse(String name) {
		this.name = name;
	} 
	
	
	@Override
	public void run() {
		for(int i = 1; i <= 50; i++){ //말의 현재 위치
			pnt++;
			try {
				Thread.sleep( (int)(Math.random()*500 + 1) );
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		setRank++;
		rank = setRank;
		System.out.println("경기 끝");
	}

	@Override
	public int compareTo(Horse o) {
		return this.rank - o.rank;
	}


	public int getRank() {
		return rank;
	}


	public int getPnt() {
		return pnt;
	}
	
	public String getHorseName(){
		
		return name;
	}
	
	
}
