package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 	문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 		이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 		
 		이 Student 객체는 List에 저장하여 관리한다.
 		
 		List에 저장된 데이터들을 학번의 오름차순 정렬이 될 수 있는 내부 정렬 기준을 구현하고,
 		총점의 역순(내림차순)으로 정렬하는 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부정렬 기준 클래스를 작성하여
 		정렬된 결과를 출력하시오.
 		
 		(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */

public class StudentTest {

	public static void main(String[] args) {
		
		ArrayList<Student> stuList = new ArrayList<>();
		
		stuList.add(new Student(1, "김가가", 90, 80, 70));
		stuList.add(new Student(5, "정마마", 50, 90, 70));
		stuList.add(new Student(4, "배라라", 60, 70, 50));
		stuList.add(new Student(2, "강나나", 50, 60, 70));
		stuList.add(new Student(3, "이다다", 80, 70, 80));
		stuList.add(new Student(6, "하바바", 60, 50, 70));
		
		Collections.sort(stuList); // 학번 오름차순
		
		for(Student st : stuList){
			System.out.println(st);
		}
		
		System.out.println("-------------------------");
		
		Collections.sort(stuList, new sumSort());
		//이걸 실행한 순간 이미 정렬된 상태로 저장되어있음.
		int count = 1;
		stuList.get(0).setRank(1);
		for(int i = 1; i< stuList.size(); i++){
			
			if(stuList.get(i-1).getSum() != stuList.get(i).getSum()){
				count++;
			}
			stuList.get(i).setRank(count);
		}
		
		for(Student st : stuList){
			
			System.out.println(st);
		}
		
		
		
	}

}

class Student implements Comparable<Student>{
	
	private int st_no;
	private String name; 
	private int kor_score;
	private int eng_score;
	private int math_score;
	private int sum;
	private int rank;
	
	public Student(int st_no, String name, int kor_score, int eng_score, int math_score) {
		this.st_no = st_no;
		this.name = name;
		this.kor_score = kor_score;
		this.eng_score = eng_score;
		this.math_score = math_score;
	}
	
	public int getKor_score() {
		return kor_score;
	}

	public void setKor_score(int kor_score) {
		this.kor_score = kor_score;
	}

	public int getEng_score() {
		return eng_score;
	}

	public void setEng_score(int eng_score) {
		this.eng_score = eng_score;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getMath_score() {
		return math_score;
	}

	public void setMath_score(int math_score) {
		this.math_score = math_score;
	}

	public int getSt_no() {
		return st_no;
	}

	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	
	public int getSum() {
		sum = kor_score + eng_score + math_score; 
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {

		
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [st_no=" + st_no + ", name=" + name + ", kor_score="
				+ kor_score + ", eng_score=" + eng_score + ", math_score="
				+ math_score + ", sum=" + sum + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student stu) {
		if(this.st_no > stu.st_no){
			return 1;
		}else{
			return -1;
		}
	}
}



class sumSort implements Comparator<Student>{
	
	@Override
	public int compare(Student st1, Student st2) {
		
		if(st1.getSum() > st2.getSum()){
			return -1;
		}else if(st1.getSum() == st2.getSum()){
			
			return st1.getName().compareTo(st2.getName());
			
			/*if(st1.getName().compareTo(st2.getName()) < 0){
				return -1; 
				
			}else if(st1.getName() == st2.getName()){
				return 0;
			}else{
				return 1; 
			}*/
		}else{
			return 1;
		}
	}
	
	
}