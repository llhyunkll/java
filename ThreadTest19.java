package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
/*
 	Vector, Hashtable등의 예전부터 존재하던 Collection객체들은 동기화 처리가 되어 있다.
 	
 	그런데, 최근에 새로 구성된 Collection들은 동기화 처리가 되어있지 않다.
 	그래서, 동기화가 필요한 프로그램에서 이런  Collection객체들은 사용하려면
 	동기화 처리를 한 후에 사용해야 한다.
 */
public class ThreadTest19 {
	private static Vector<Integer> vec = new Vector<>();
	
	// 동기화 처리가 되어 있지 않은 List
	private static List<Integer> list = new ArrayList<>();
	
	// 동기화 처리를 한 후의 List
	private static List<Integer> list2 = 
			Collections.synchronizedList(new ArrayList<Integer>());
			//제네릭을 정확하게 명시해줘야함
	
	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10000; i++){
					//vec.add(i); //i값을 10000번 추가
					//list.add(i); //배열의 갯수가 모자라서 추가하는 과정이 생기고 
					//그러다가 다음 쓰레드로 넘어가고... 5만개를 다 저장하지 못함
					list2.add(i); //동기화처리한 list
				}
				
			}
		};
		
		// --------------------------------------------
		Thread[] ths = new Thread[]{
				new Thread(r), new Thread(r),
				new Thread(r), new Thread(r), new Thread(r)
		};
		
		for(Thread th : ths){
			th.start();
		}
		
		for(Thread th : ths){
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		//System.out.println("vec의 개수 : " + vec.size());
		//System.out.println("list의 개수 : " + list.size());
		System.out.println("list2의 개수 : " + list2.size());
		
		
	}

}
