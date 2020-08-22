package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 
 	����) �̸�, �ּ�, ����, ��ȭ��ȣ, �ּҸ� ��������� ���� PhoneŬ������ ����� 
 		Map�� �̿��Ͽ� ��ȭ��ȣ ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 		
 		- �� ���α׷����� ��ȭ��ȣ�� ���, ����, ����, �˻�, ��ü ����ϴ� ����� �ִ�.
 		- ������ �˻� ����� '�̸�'�� �Է� �޾� ó���Ѵ�.
 		- (Map�� ������ key������ �� ����� '�̸�'�� ����ϰ�, 
 		 			 value�����δ� 'phoneŬ������ �ν��Ͻ�'�� �Ѵ�.)
 		 			 
 	���࿹��) 
 		���� �޴��� �����ϼ���.
 		1. ��ȭ��ȣ ���
 		2. ��ȭ��ȣ ����
 		3. ��ȭ��ȣ ����
 		4. ��ȭ��ȣ �˻�
 		5. ��ȭ��ȣ ��ü ���
 		0. ���α׷� ����
 	------------------------
 	��ȣ�̸� >> 1
 	
 	���Ӱ� ����� ��ȭ��ȣ ������ �Է��ϼ���.
 	�̸� >> ȫ�浿
 	��ȭ��ȣ >> 010-1111-1111
 	���� >> 30
 	�ּ� >> ������ �߱� ���ﵿ
 	
 	'ȫ�浿' ��ȭ��ȣ ��ϿϷ�!!	
 	
 	 	���� �޴��� �����ϼ���.
 		1. ��ȭ��ȣ ���
 		2. ��ȭ��ȣ ����
 		3. ��ȭ��ȣ ����
 		4. ��ȭ��ȣ �˻�
 		5. ��ȭ��ȣ ��ü ���
 		0. ���α׷� ����
 	------------------------
 	��ȣ�̸� >> 1
 	
	���Ӱ� ����� ��ȭ��ȣ ������ �Է��ϼ���.
 	�̸� >> ȫ�浿
 	
 	'ȫ�浿'�� �̹� ��ϵ� ����Դϴ�.
 	
 	 	 ���� �޴��� �����ϼ���.
 		1. ��ȭ��ȣ ���
 		2. ��ȭ��ȣ ����
 		3. ��ȭ��ȣ ����
 		4. ��ȭ��ȣ �˻�
 		5. ��ȭ��ȣ ��ü ���
 		0. ���α׷� ����
 	------------------------
 	��ȣ�̸� >> 5
 	
 	==============================================
 	  ��ȣ	 �̸� 	��ȭ��ȣ			����		 �ּ�
 	==============================================
 	  1		ȫ�浿 	010-1111-1111	30		������ �߱� ���ﵿ	
 	  
 	  
 	==============================================
 	��� �Ϸ�...
 	
 	
 
 */

public class PhoneBookTest {
	
	Map<String, Phone> phoneBook = new HashMap<>();
	public static void main(String[] args) {
	//���� 
		new PhoneBookTest().start();

	}

	
	Scanner sc = new Scanner(System.in);
	
	public void start(){
		
		while(true){
			System.out.println("���� �޴��� �����ϼ���.");
			System.out.println("1. ��ȭ��ȣ ���");
			System.out.println("2. ��ȭ��ȣ ����");
			System.out.println("3. ��ȭ��ȣ ����");
			System.out.println("4. ��ȭ��ȣ �˻�");
			System.out.println("5. ��ȭ��ȣ ��ü ���");
			System.out.println("0. ���α׷� ����");
			System.out.println("------------------------");
			System.out.print("��ȣ�Է� >>");
			int input = sc.nextInt();
			
			switch(input){
			case 1: add(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: select(); break;	
			case 5: hpList(); break;
			case 0: 
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
 		}
	}
	
	public void hpList() { // ��ȸ
		int cnt = 1; 
		System.out.println("==============================================");
	 	System.out.println("��ȣ\t�̸�\t��ȭ��ȣ\t\t����\t�ּ�");
	 	System.out.println("==============================================");
	 	
	 	Set<String> phoneSet = phoneBook.keySet();
	 	
		for(String key : phoneSet){
		    System.out.println(cnt + "\t"+phoneBook.get(key).toString());
		    cnt++;
		}
	 	System.out.println("==============================================");
	}

	public void select() { //�˻�
		System.out.println("�˻� �� ��ȭ��ȣ �̸� ������ �Է��ϼ���");
		System.out.print("�Է� >>");
		String name = sc.next();
		if(!phoneBook.containsKey(name)){
			System.out.println("��ϵ��� ���� �̸� �Դϴ�.");
			System.out.println();
			return;
		}else{
			System.out.println("==============================================");
		 	System.out.println("�̸�\t��ȭ��ȣ\t����\t�ּ�");
		 	System.out.println("==============================================");
		 	System.out.println(phoneBook.get(name).toString());
		 	System.out.println("==============================================");
			
		}
	}

	
	
	public void delete() { //����
		System.out.println("���� �� ��ȭ��ȣ �̸� ������ �Է��ϼ���.");
		System.out.print("�Է� >>");
		String name = sc.next();
		if(!phoneBook.containsKey(name)){
			System.out.println("��ϵ��� ���� �̸� �Դϴ�.");
			System.out.println();
			return;
		}
		phoneBook.remove(name);
		System.out.println("'"+ name+"' " + "��ȭ��ȣ �����Ϸ�!!");
		System.out.println();
		
	}

	public void update(){ //����
		
		System.out.println("���� �� ��ȭ��ȣ �̸� ������ �Է��ϼ���.");
		System.out.print("�Է� >>");
		String name = sc.next();
		if(!phoneBook.containsKey(name)){
			System.out.println("��ϵ��� ���� �̸� �Դϴ�.");
			System.out.println();
			return;
		}
		System.out.print("��ȭ��ȣ�� �Է��ϼ��� >> ");
		String hp = sc.next();
		System.out.print("���̸� �Է��ϼ��� >> ");
		String age = sc.next();
		System.out.print("�ּҸ� �Է��ϼ��� >>");
		String addr = sc.next();
			
		Phone ph = new Phone(name, hp, age, addr);
		phoneBook.put(name, ph);
		
		System.out.print("'"+ name+"' " + "��ȭ��ȣ �����Ϸ�!!");
		System.out.println();
		
	}
	
	
	public void add(){ //���
		System.out.println("���Ӱ� ��� �� ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.print("�̸� >>");
		String name = sc.next(); //key
		System.out.println(phoneBook.containsKey(name));
		
		if(phoneBook.containsKey(name)){
			System.out.println("'"+ name+"' "+"�� �̹� ��ϵ� ����Դϴ�.");
			return; 
		}
		
		System.out.print("��ȭ��ȣ >>");
		String hp = sc.next();

		System.out.print("�ּ� >>");
		String addr = sc.next();
		
		System.out.print("���� >>");
		String age = sc.next();
		                         //��ü�� ���� ����
		System.out.println();
		
		Phone ph = new Phone(name, hp, age, addr);
		
		phoneBook.put(name, ph);
		System.out.println("'"+ name+"' " + "��ȭ��ȣ ��ϿϷ�!!");
		System.out.println();
		
	}
}


class Phone{
	private String name;
	private String num;
	private String age;
	private String addr;
	
	public Phone(String name, String num, String age, String addr) {
		this.name = name;
		this.num = num;
		this.age = age;
		this.addr = addr;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return name + "\t" + num + "\t" + age
				+ "\t" + addr;
	} 
	
}