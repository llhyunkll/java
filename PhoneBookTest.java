package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 
 	문제) 이름, 주소, 나이, 전화번호, 주소를 멤버변수로 갖는 Phone클래스를 만들고 
 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 		
 		- 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
 		- 삭제와 검색 기능은 '이름'을 입력 받아 처리한다.
 		- (Map의 구조는 key값으로 그 사람의 '이름'을 사용하고, 
 		 			 value값으로는 'phone클래스의 인스턴스'로 한다.)
 		 			 
 	실행예시) 
 		다음 메뉴를 선택하세요.
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 	------------------------
 	번호이름 >> 1
 	
 	새롭게 등록할 전화번호 정보를 입력하세요.
 	이름 >> 홍길동
 	전화번호 >> 010-1111-1111
 	나이 >> 30
 	주소 >> 대전시 중구 대흥동
 	
 	'홍길동' 전화번호 등록완료!!	
 	
 	 	다음 메뉴를 선택하세요.
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 	------------------------
 	번호이름 >> 1
 	
	새롭게 등록할 전화번호 정보를 입력하세요.
 	이름 >> 홍길동
 	
 	'홍길동'은 이미 등록된 사람입니다.
 	
 	 	 다음 메뉴를 선택하세요.
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체 출력
 		0. 프로그램 종료
 	------------------------
 	번호이름 >> 5
 	
 	==============================================
 	  번호	 이름 	전화번호			나이		 주소
 	==============================================
 	  1		홍길동 	010-1111-1111	30		대전시 중구 대흥동	
 	  
 	  
 	==============================================
 	출력 완료...
 	
 	
 
 */

public class PhoneBookTest {
	
	Map<String, Phone> phoneBook = new HashMap<>();
	public static void main(String[] args) {
	//메인 
		new PhoneBookTest().start();

	}

	
	Scanner sc = new Scanner(System.in);
	
	public void start(){
		
		while(true){
			System.out.println("다음 메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("------------------------");
			System.out.print("번호입력 >>");
			int input = sc.nextInt();
			
			switch(input){
			case 1: add(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: select(); break;	
			case 5: hpList(); break;
			case 0: 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
 		}
	}
	
	public void hpList() { // 조회
		int cnt = 1; 
		System.out.println("==============================================");
	 	System.out.println("번호\t이름\t전화번호\t\t나이\t주소");
	 	System.out.println("==============================================");
	 	
	 	Set<String> phoneSet = phoneBook.keySet();
	 	
		for(String key : phoneSet){
		    System.out.println(cnt + "\t"+phoneBook.get(key).toString());
		    cnt++;
		}
	 	System.out.println("==============================================");
	}

	public void select() { //검색
		System.out.println("검색 할 전화번호 이름 정보를 입력하세요");
		System.out.print("입력 >>");
		String name = sc.next();
		if(!phoneBook.containsKey(name)){
			System.out.println("등록되지 않은 이름 입니다.");
			System.out.println();
			return;
		}else{
			System.out.println("==============================================");
		 	System.out.println("이름\t전화번호\t나이\t주소");
		 	System.out.println("==============================================");
		 	System.out.println(phoneBook.get(name).toString());
		 	System.out.println("==============================================");
			
		}
	}

	
	
	public void delete() { //삭제
		System.out.println("삭제 할 전화번호 이름 정보를 입력하세요.");
		System.out.print("입력 >>");
		String name = sc.next();
		if(!phoneBook.containsKey(name)){
			System.out.println("등록되지 않은 이름 입니다.");
			System.out.println();
			return;
		}
		phoneBook.remove(name);
		System.out.println("'"+ name+"' " + "전화번호 삭제완료!!");
		System.out.println();
		
	}

	public void update(){ //수정
		
		System.out.println("수정 할 전화번호 이름 정보를 입력하세요.");
		System.out.print("입력 >>");
		String name = sc.next();
		if(!phoneBook.containsKey(name)){
			System.out.println("등록되지 않은 이름 입니다.");
			System.out.println();
			return;
		}
		System.out.print("전화번호를 입력하세요 >> ");
		String hp = sc.next();
		System.out.print("나이를 입력하세요 >> ");
		String age = sc.next();
		System.out.print("주소를 입력하세요 >>");
		String addr = sc.next();
			
		Phone ph = new Phone(name, hp, age, addr);
		phoneBook.put(name, ph);
		
		System.out.print("'"+ name+"' " + "전화번호 수정완료!!");
		System.out.println();
		
	}
	
	
	public void add(){ //등록
		System.out.println("새롭게 등록 할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >>");
		String name = sc.next(); //key
		System.out.println(phoneBook.containsKey(name));
		
		if(phoneBook.containsKey(name)){
			System.out.println("'"+ name+"' "+"은 이미 등록된 사람입니다.");
			return; 
		}
		
		System.out.print("전화번호 >>");
		String hp = sc.next();

		System.out.print("주소 >>");
		String addr = sc.next();
		
		System.out.print("나이 >>");
		String age = sc.next();
		                         //객체에 담을 변수
		System.out.println();
		
		Phone ph = new Phone(name, hp, age, addr);
		
		phoneBook.put(name, ph);
		System.out.println("'"+ name+"' " + "전화번호 등록완료!!");
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