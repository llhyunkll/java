package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	
	Map<Integer, Room> hotelRoom = new HashMap<>();
	
	Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		new Hotel().start();

	}

	public void start(){
		
		for(int j = 1; j < 10; j++){
			hotelRoom.put(200+j, new Room(200+j, "싱글룸"));
			hotelRoom.put(300+j, new Room(300+j, "더블룸"));
			hotelRoom.put(400+j, new Room(400+j, "스위트룸"));
		}
		System.out.println("*********************************************");
		System.out.println("\t호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		
		while(true){
			System.out.println("---------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("---------------------------------------------");
			System.out.println("1.체크인 \t2.체크아웃\t3.객실상태\t4.업무종료");
			System.out.println("---------------------------------------------");
			System.out.println("선택 >>");
			int input = Integer.parseInt(sc.next());
			
			switch(input){
			case 1: checkIn(); break;
			case 2: checkOut(); break;
			case 3: roomCheck(); break;
			case 4: 
				System.out.println("*********************************************");
				System.out.println("\t호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				System.exit(0);
			}
			
		}
	
	}
	
	
	public void roomCheck() { //객실확인
		System.out.println("----------------------------------------------");
		System.out.println("\t현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("----------------------------------------------");
		Set<Integer> roomList = hotelRoom.keySet();
		List<Integer> keyList = new ArrayList<>(roomList);
		Collections.sort(keyList);
		for(int i = 0; i < roomList.size(); i++){
			System.out.println(hotelRoom.get(keyList.get(i)).toString());
		}
		System.out.println("----------------------------------------------");
		
	}

	public void checkOut() { //체크아웃
		System.out.println("----------------------------------------------");
		System.out.println("\t체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크 아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int roomNo = sc.nextInt();
		if(hotelRoom.get(roomNo) == null){
			System.out.println(roomNo+"호 객실은 존재하지 않습니다."); return;
		}
		if(hotelRoom.get(roomNo).getVisitor() == null){
			System.out.println(roomNo+"호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}else{
			String name = hotelRoom.get(roomNo).getVisitor();
			System.out.println(roomNo+"호 객실의 "+name+"님 체크 아웃을 완료하였습니다.");
			hotelRoom.get(roomNo).setVisitor(null);
		}
		
	}

	public void checkIn(){ //체크인
		
		System.out.println("----------------------------------------------");
		System.out.println("\t체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >>");
		int num = Integer.parseInt(sc.next());
		
		if(!hotelRoom.containsKey(num)){
			System.out.println(num+"호 객실은 존재하지 않습니다."); return;
		}
		if(hotelRoom.get(num).getVisitor() == null){
			System.out.println(num+"호 객실에 체크인 합니다.");
			System.out.println("누구를 체크인 하시겠습니까?");
			String name = sc.next();
			hotelRoom.get(num).setVisitor(name);
			System.out.println("체크인이 완료되었습니다.");
		}else{
			System.out.println(num+"호 객실은 이미 손님이 있습니다."); return;
		}
		
	}
	
}

class Room{
	private int roomNo;
	private String roomGb;
	private String visitor;
	
	public Room(int roomNo, String roomGb) {
		super();
		this.roomNo = roomNo;
		this.roomGb = roomGb;
		this.visitor = null;
	}
	
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomGb() {
		return roomGb;
	}

	public void setRoomGb(String roomGb) {
		this.roomGb = roomGb;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	@Override
	public String toString() {
		
		return roomNo +"\t"+ roomGb +"\t"+ (visitor == null ? "-" : visitor);
	}
	
	
}
