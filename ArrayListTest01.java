package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// ��ü ����
		ArrayList list1 = new ArrayList<>();

		
		System.out.println("size => "+ list1.size());
		// ������ �߰� : add(�߰��� ������) ==> ��ȯ�� : ����(true), ����(false)
		list1.add("aaaa");
		list1.add(new Integer(123));
		list1.add(111);
		list1.add('a');
		list1.add(true);
		list1.add(3.14f); 
	 	
		System.out.println("size => "+ list1.size());
		System.out.println("���� List => " + list1);
		
		// ������ �߰�2 : add(index, �߰��ҵ�����)
		// ==> index��°�� '�߰��� ������'�� ���� �ִ´�.
		list1.add(3, "CCC"); //���� �ִ� �����ʹ� �� ĭ�� �ڷ� �з���
		
		System.out.println("List => " + list1);
		
		// ������ ���� : set(index, ���ο����)
		// ==> index��°�� �����͸� '���ο� ������'�� �����.
		// ==> ��ȯ�� : ������ ������
		String temp = (String)list1.set(0, "ZZZZZ");
		System.out.println("List => " + list1);
		System.out.println("������ ������ : " + temp);
		
		// ������ ���� : remove(index);
		// ==> index��°�� �����͸� �����Ѵ�.
		// ==> ��ȯ�� : ������ ������
		temp = (String)list1.remove(0);
		System.out.println("������ List => " + list1);
		System.out.println("������ ������ : " + temp);
		
		// ������ ����2 : remove(������ ������)
		//		 ==> '������ ������'�� ã�Ƽ� �����Ѵ�.
		//		 ==> '������ ������'�� �������̸� �տ��� ���� �����ȴ�.
		// 		 ==> '������ ������'�� '������'�̰ų� 'char��'�� ��쿡�� �ݵ�� ��ü�� ��ȯ�ؼ� ����ؾ� �Ѵ�.
		// 		 ==> ��ȯ�� : ��������(true), ��������(false)
		list1.remove("CCC");
		System.out.println("������ List => " + list1);
		
		//111 ������ �����ϱ�
		//list1.remove(111); // ���Ұ� //������ index�� �ν��ؼ� 111��° �����͸� ���� 
		list1.remove(new Integer(111)); //������ �����ʹ� ��ü������ ��ȯ�ؼ� ����Ѵ�.
		System.out.println("������ List => " + list1);
		
		// 'a' ������ �����ϱ� 
		//list1.remove('a'); //���Ұ� //���ڿ��� ������, char�� ���ڴ� �ڵ尪�� ����
		list1.remove(new Character('a')); //char�� �����ʹ� ��ü������ ��ȯ�ؼ� ����Ѵ�.
		System.out.println("������ List => " + list1);
		
		list1.remove(true);
		list1.remove(3.14f);
		System.out.println("������ List => " + list1);
		
		// ��ü ���� : clear();
		list1.clear();
		System.out.println("size => " + list1.size());
		System.out.println("clear�� List => " + list1);
		
		list1.add("AAAAA");
		list1.add("BBBBB");
		list1.add("CCCCC");
		list1.add("DDDDD");
		
		System.out.println("List => " + list1);
		// ������ �������� : get(index);
		// ==> index��° �����͸� ������ ��ȯ�Ѵ�.
		String data = (String)list1.get(1);
		System.out.println("1��° ������ : " + data);
		
		//-------------------------------------------------------------------------------------
		
		/*
		 ���׸� Ÿ��(Generic Type) ==> ��ü�� ������ �� < >�ȿ� �� Collection�� ����� �������� Ÿ����
		 	�����ִ� ���� ���Ѵ�.
		 	�̷������� �����ϰ� �Ǹ� �� ������ Ÿ�� �̿��� �ٸ� �����ʹ� ������ �� ����. 
		 	�׸���, ���׸����� ����� �� �ִ� ������ Ÿ���� Ŭ�������̾�� �Ѵ�.
		 	(��, int => Integer, boolean => Boolean, char => Character ��)
		 	
		 	���׸� Ÿ������ �����ϰ� �Ǹ� �����͸� ������ �� ������ ����ȯ�� �ʿ� ����. 
		*/
		
		ArrayList<String> list2 = new ArrayList<>(); //String�� �����Ҽ��ִ� List
		
		list2.add("�ȳ��ϼ���");
		//list2.add(123); // ���� : �ٸ� ������ �����͸� ������ �� ����.
		String temp2 = list2.get(0);
		System.out.println("������ ������ : " + temp2);
		System.out.println();
		
		list2.clear();
		//------------------------------------------------------------------------------------
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		list2.add("FFF");
		
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("BBB");
		list3.add("DDD");
		list3.add("EEE");
		
		System.out.println("List2 => " + list2);
		System.out.println("List3 => " + list3 );
		
		// ������ ���� : removeAll(Collection��ü)
		// ==> ��ü ������ �� 'Collection��ü'�� ������ �ִ� ������ ��ü�� �����Ѵ�.
		list2.removeAll(list3);
		System.out.println("������ List2 => " + list2);
		System.out.println();
		
		list2.clear();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		list2.add("FFF");
		
		
		System.out.println("------------------------------------");
		// List�� �����͸� ������� ������ ����� ��쿡�� �ݺ����� ����Ѵ�.
		for(int i = 0; i < list2.size(); i++){
			System.out.println(i + "��° �ڷ� : " + list2.get(i));
		}
		System.out.println("------------------------------------");
		
		// ���� for�� ���
		for(String str : list2){
			System.out.println(str);
		}
		System.out.println("------------------------------------");
		
		// �����Ͱ� �ִ��� ���� �˻� : contains(�˻��ҵ�����)
		//  ==> �˻��� �����Ͱ� ������ true, ������ false ��ȯ
		System.out.println("DDD�� : " + list2.contains("DDD"));
		System.out.println("KKK�� : " + list2.contains("KKK"));
		
		// �˻��� �������� ��ġ�� ���ϱ� : indexOf(�˻��ҵ�����)
		//  ==> ����Ʈ�� '�˻��ҵ�����'�� ������ '�˻��� ������'�� �ִ� index���� ��ȯ�ϰ� ������ -1�� ��ȯ�Ѵ�. 
		System.out.println("DDD�� ��ġ�� : " + list2.indexOf("DDD"));
		System.out.println("KKK�� ��ġ�� : " + list2.indexOf("KKK"));
		
		// List�� �����͸� �迭�� ��ȯ�ϱ�
		// ���1) toArray() ==> List���� �����͸� Object�� �迭�� ��ȯ�ؼ� ��ȯ�Ѵ�.
		// ���2) toArray(new ���׸�Ÿ���ڷ���[0]) ==> ���׸� Ÿ���� �迭�� ��ȯ�ؼ� ��ȯ�Ѵ�.
		
		Object[] objArr= list2.toArray();
		System.out.println("�迭�� ���� : " + objArr.length);
		for(int i = 0; i < objArr.length; i++){
			System.out.println(i +"��° �ڷ� : " + objArr[i]);
			
			String test = (String)objArr[i];
			System.out.println(i + "��° �ڷ� : " + test);
		}
		System.out.println("====================================");
		
		String[] strArr = list2.toArray(new String[0]);
		for(String str : strArr){
			System.out.println(str);
		}
		

	}

}
