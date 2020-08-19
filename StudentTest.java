package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 	����) �й�, �̸�, ��������, ��������, ��������, ����, ����� ����� ���� StudentŬ������ �����.
 		�� Ŭ������ �����ڿ����� �й�, �̸�, ��������, ��������, ���������� �Ű������� �޾Ƽ� �ʱ�ȭ ó���� �Ѵ�.
 		
 		�� Student ��ü�� List�� �����Ͽ� �����Ѵ�.
 		
 		List�� ����� �����͵��� �й��� �������� ������ �� �� �ִ� ���� ���� ������ �����ϰ�,
 		������ ����(��������)���� �����ϴ� ������ ������ �̸��� ������������ ������ �Ǵ� �ܺ����� ���� Ŭ������ �ۼ��Ͽ�
 		���ĵ� ����� ����Ͻÿ�.
 		
 		(����� List�� ��ü �����Ͱ� �߰��� �Ŀ� ����ǵ��� �Ѵ�.)
 */

public class StudentTest {

	public static void main(String[] args) {
		
		ArrayList<Student> stuList = new ArrayList<>();
		
		stuList.add(new Student(1, "�谡��", 90, 80, 70));
		stuList.add(new Student(5, "������", 50, 90, 70));
		stuList.add(new Student(4, "����", 60, 70, 50));
		stuList.add(new Student(2, "������", 50, 60, 70));
		stuList.add(new Student(3, "�̴ٴ�", 80, 70, 80));
		stuList.add(new Student(6, "�Ϲٹ�", 60, 50, 70));
		
		Collections.sort(stuList); // �й� ��������
		
		for(Student st : stuList){
			System.out.println(st);
		}
		
		System.out.println("-------------------------");
		
		Collections.sort(stuList, new sumSort());
		//�̰� ������ ���� �̹� ���ĵ� ���·� ����Ǿ�����.
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