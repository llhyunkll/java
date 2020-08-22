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
			hotelRoom.put(200+j, new Room(200+j, "�̱۷�"));
			hotelRoom.put(300+j, new Room(300+j, "�����"));
			hotelRoom.put(400+j, new Room(400+j, "����Ʈ��"));
		}
		System.out.println("*********************************************");
		System.out.println("\tȣ�ڹ��� �������ϴ�. ����ʽÿ�.");
		System.out.println("*********************************************");
		
		while(true){
			System.out.println("---------------------------------------------");
			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("---------------------------------------------");
			System.out.println("1.üũ�� \t2.üũ�ƿ�\t3.���ǻ���\t4.��������");
			System.out.println("---------------------------------------------");
			System.out.println("���� >>");
			int input = Integer.parseInt(sc.next());
			
			switch(input){
			case 1: checkIn(); break;
			case 2: checkOut(); break;
			case 3: roomCheck(); break;
			case 4: 
				System.out.println("*********************************************");
				System.out.println("\tȣ�ڹ��� �ݾҽ��ϴ�.");
				System.out.println("*********************************************");
				System.exit(0);
			}
			
		}
	
	}
	
	
	public void roomCheck() { //����Ȯ��
		System.out.println("----------------------------------------------");
		System.out.println("\t���� ���� ����");
		System.out.println("----------------------------------------------");
		System.out.println("�� ��ȣ\t�� ����\t������ �̸�");
		System.out.println("----------------------------------------------");
		Set<Integer> roomList = hotelRoom.keySet();
		List<Integer> keyList = new ArrayList<>(roomList);
		Collections.sort(keyList);
		for(int i = 0; i < roomList.size(); i++){
			System.out.println(hotelRoom.get(keyList.get(i)).toString());
		}
		System.out.println("----------------------------------------------");
		
	}

	public void checkOut() { //üũ�ƿ�
		System.out.println("----------------------------------------------");
		System.out.println("\tüũ�ƿ� �۾�");
		System.out.println("----------------------------------------------");
		System.out.println("üũ �ƿ� �� �� ��ȣ�� �Է��ϼ���.");
		System.out.print("�� ��ȣ �Է� >> ");
		int roomNo = sc.nextInt();
		if(hotelRoom.get(roomNo) == null){
			System.out.println(roomNo+"ȣ ������ �������� �ʽ��ϴ�."); return;
		}
		if(hotelRoom.get(roomNo).getVisitor() == null){
			System.out.println(roomNo+"ȣ ���ǿ��� üũ�� �� ����� �����ϴ�.");
			return;
		}else{
			String name = hotelRoom.get(roomNo).getVisitor();
			System.out.println(roomNo+"ȣ ������ "+name+"�� üũ �ƿ��� �Ϸ��Ͽ����ϴ�.");
			hotelRoom.get(roomNo).setVisitor(null);
		}
		
	}

	public void checkIn(){ //üũ��
		
		System.out.println("----------------------------------------------");
		System.out.println("\tüũ�� �۾�");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : �̱۷�");
		System.out.println(" * 301~309 : �����");
		System.out.println(" * 401~409 : ����Ʈ��");
		System.out.println("----------------------------------------------");
		System.out.print("�� ��ȣ �Է� >>");
		int num = Integer.parseInt(sc.next());
		
		if(!hotelRoom.containsKey(num)){
			System.out.println(num+"ȣ ������ �������� �ʽ��ϴ�."); return;
		}
		if(hotelRoom.get(num).getVisitor() == null){
			System.out.println(num+"ȣ ���ǿ� üũ�� �մϴ�.");
			System.out.println("������ üũ�� �Ͻðڽ��ϱ�?");
			String name = sc.next();
			hotelRoom.get(num).setVisitor(name);
			System.out.println("üũ���� �Ϸ�Ǿ����ϴ�.");
		}else{
			System.out.println(num+"ȣ ������ �̹� �մ��� �ֽ��ϴ�."); return;
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
