package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.sound.midi.ControllerEventListener;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(7, "이순신", "010-2222-1111"));
		memList.add(new Member(3, "성춘향", "010-3333-1111"));
		memList.add(new Member(8, "강감찬", "010-4444-1111"));
		memList.add(new Member(9, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		memList.add(new Member(6, "김삿갓", "010-7777-1111"));
		
		System.out.println("정렬 전...");
		
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------------");
		
		Collections.sort(memList); 	// sort 컴파일에러 => 내부정렬 기준이 있어야 정렬을 해줄수 있음.
									// 내부 정렬 기준으로 정렬
		
		System.out.println("정렬 후...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------------");
		
		Collections.sort(memList, new DescSort()); //전화번호 내림차순 정렬
		System.out.println("정렬 후...");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------------");
		

	}

}

// 내부 정렬 기준을 포함 할 클래스는 Comparable인터페이스를 구현해야한다.
// (Collection에 추가되는 데이터 자체에 정렬 기준을 넣어주는 것을 말한다.)

// Comparable을 구현하는 클래스에서는 compareTo() 메서드를 재정의 해야한다.
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	// 생성자 alt+shift+S => using Fields...?
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
//	// Member의 이름을 오름차순으로 정렬하는 내부 정렬 기준 구현하기
//	@Override
//	public int compareTo(Member mem) {
//		
//		return this.name.compareTo(mem.getName());
//	}
	
	
	
	// Member의 번호를 내림차순으로 정렬하는 내부 정렬 기준 구현하기
	@Override
	public int compareTo(Member mem) {
		// 비교 방법 1
		if(this.num > mem.getNum()){
			return -1;
		}else if(this.num == mem.getNum()){
			return 0; 
		}else{
			return 1;
		}
		
		// 비교 방법 2 ==> Wrapper클래스를 이용하는 방법
		// return new Integer(this.num).compareTo(mem.getNum()) * -1;
	}

}

//전화번호의 내림차순으로 정렬할 수 있는 외부 정렬 기준을 만들고 정렬한 결과를 출럭하시오.

class DescSort implements Comparator<Member> {

	@Override
	public int compare(Member o1, Member o2) {
		
		// 방법 1
		if(o1.getTel().compareTo(o2.getTel()) < 0){
			return 1;
		}else if(o1.getTel().compareTo(o2.getTel()) == 0){
			return 0;
		}else{
			return -1;
		}
		
		// 방법2
		// return o1.getTel().compareTo(o2.getTel()) * -1; 
	}
	
	
	
	
}