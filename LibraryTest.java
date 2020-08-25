package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LibraryTest {

	Map<String, Book> library = new HashMap<>();
	
	public void start(){
		Scanner scan = new Scanner(System.in);
		
		while(true){
				
			System.out.println("----------------------------------");
			System.out.println(">> 사용할 메뉴를 선택하세요.");
			System.out.println("----------------------------------");
			System.out.println("1. 도서 정보 등록");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 정보 삭제");
			System.out.println("4. 도서 정보 검색");
			System.out.println("5. 전체 도서 정보 출력");
			System.out.println("6. 도서 반납 및 대여");
			System.out.println("0. 프로그램 종료");
			System.out.println("----------------------------------");
			System.out.print("번호선택 >> ");
			int input = scan.nextInt();
			
			switch(input){
			case 1: insert(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: search(); break;
			case 5: listUp(); break;
			case 6: loan(); break;
			case 0: 
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			default : System.out.println("다시 입력하세요");
			}
		
		}
	}
	
	
	private void loan() {
		Scanner scan = new Scanner(System.in);
		System.out.println("도서를 대출 혹은 반납합니다.");
		System.out.println("1.대출 2.반납");
		int temp = scan.nextInt();
		switch(temp){
		case 1: 
			System.out.println("도서를 대출합니다. 대출하실 도서의 번호를 입력하세요.");
			String num = scan.next();
			if(!library.containsKey(num)){
				System.out.println("등록된 도서 정보가 없습니다."); return;
			}
			if(library.get(num).isBooKLoan() == false){
				System.out.println(num+"번 도서를 대여합니다.");
				library.get(num).setBooKLoan(true); 
				System.out.println("대여 완료!");
				break;
			}else{
				System.out.println("해당 도서는 이미 대출중입니다."); return;
			}
		case 2:	
			System.out.println("도서를 반납합니다. 반납하실 도서의 번호를 입력하세요.");
			num = scan.next();
			if(!library.containsKey(num)){
				System.out.println("등록된 도서 정보가 없습니다."); return;
			}
			if(library.get(num).isBooKLoan() == true){
				System.out.println(num+"번 도서를 반납합니다.");
				library.get(num).setBooKLoan(false);
				System.out.println("반납완료!"); break;
			}else{
				System.out.println("해당 도서는 대출중이 아닙니다."); return;
			}

		}
		
	}


	private void listUp() {
		System.out.println("------------------------------------------");
		System.out.println("\t도    서     리    스    트");
		System.out.println("------------------------------------------");
		System.out.println("도서번호\t도서 제목\t\t도서 저자\t도서 장르\t대출여부");
		System.out.println("------------------------------------------");
		Set<String>bookList = library.keySet();
		List<String> keyList = new ArrayList<>(bookList);
		Collections.sort(keyList);
		if(keyList.size() == 0){
			System.out.println("등록된 도서 정보가 없습니다."); return;
		}
		for(int i = 0; i < keyList.size(); i++){
			System.out.println(library.get(keyList.get(i)).toString());
		}

		
	}



	private void search() {
		Scanner scan = new Scanner(System.in);
		System.out.println("도서 정보를 검색합니다. 검색할 도서의 번호를 입력하세요.");
		String num = scan.next();
		if(!library.containsKey(num)){
			System.out.println("해당 번호의 도서를 찾을 수 없습니다."); return;
		}
		System.out.println("------------------------------------------");
		System.out.println("\t도    서     정      보");
		System.out.println("------------------------------------------");
		System.out.println("도서 번호 : " + library.get(num).getBookNo()); 
		System.out.println("도서 제목 : " + library.get(num).getTitle()); 
		System.out.println("도서 저자 : " + library.get(num).getAuthor()); 
		System.out.println("도서 장르 : " + library.get(num).getCaltegory()); 
		System.out.println("도서 대출여부 : " + (library.get(num).isBooKLoan() == false ? "대출가능" : "대출중")); 
	}



	private void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("도서 정보를 삭제합니다. 삭제할 도서의 번호를 입력하세요.");
		String bookNo = scan.nextLine();
		if(!library.containsKey(bookNo)){
			System.out.println("해당 번호의 도서를 찾을 수 없습니다."); return;
		}
		String title= library.get(bookNo).getTitle();
		System.out.println(bookNo + "번 의 " + title +" 도서 정보를 삭제합니다.");
		library.remove(bookNo);
		System.out.println("삭제 완료!");
	
	}


	private void update() {
		Scanner scan = new Scanner(System.in);
		System.out.println("도서 정보를 수정합니다. 수정할 도서의 번호를 입력하세요.");
		String bookNo = scan.nextLine();
		if(!library.containsKey(bookNo)){
			System.out.println("해당 번호의 도서를 찾을 수 없습니다."); return;
		}
		System.out.print("수정할 도서 제목 >>");
		String title = scan.nextLine();
		System.out.print("수정할 도서 지은이 >>");
		String author = scan.nextLine();
		System.out.print("수정할 도서 장르 >>");
		String calte = scan.nextLine();
		boolean booKche= library.get(bookNo).isBooKLoan();
		library.put(bookNo, new Book(bookNo, title, author, calte, booKche));
		System.out.println("수정완료!");
		
		
	}



	private void insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("도서를 등록합니다. 도서 정보를 입력해주세요.");
		System.out.println("도서 번호를 입력 해주세요");
		String bookNo = scan.next();
		if(library.containsKey(bookNo)){
			System.out.println("존재하는 도서 번호입니다."); return;
		}
		System.out.print("도서 제목 >>");
		String title = scan.next();
		System.out.print("도서 지은이 >>");
		String author = scan.next();
		System.out.print("도서 장르 >>");
		String calte = scan.next();
		boolean loan = false;
		library.put(bookNo, new Book(bookNo, title, author, calte, loan));
		System.out.println("등록완료!");
		
		
	}



	public static void main(String[] args) {
		LibraryTest test = new LibraryTest();
		test.start();

	}

}

class Book {
	
	private String bookNo;
	private String title;
	private String author;
	private String caltegory;
	private boolean booKLoan;
	
	public Book(String bookNo, String title, String author, String caltegory,
			boolean booKLoan) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.caltegory = caltegory;
		this.booKLoan = booKLoan;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCaltegory() {
		return caltegory;
	}

	public void setCaltegory(String caltegory) {
		this.caltegory = caltegory;
	}

	public boolean isBooKLoan() {
		return booKLoan;
	}

	public void setBooKLoan(boolean booKLoan) {
		this.booKLoan = booKLoan;
	}

	@Override
	public String toString() {
		return bookNo+"\t"+title+"\t\t"+author + "\t"+caltegory + "\t"+(booKLoan == false ? "대출가능" : "대출중");
	}
	
}