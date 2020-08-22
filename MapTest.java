package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
	/*
		Map ==> key���� value���� �� ������ �����ϴ� ��ü
			- key���� �ߺ��� ������� �ʰ�, ����(index)�� ����. (Set�� Ư¡�� ���´�.)
			- value���� �ߺ��� ����Ѵ�.
	*/
		
		HashMap<String, String> map = new HashMap<>();
		
		// �ڷ� �߰� ==> put(key��, value��);
		
		map.put("name", "ȫ�浿");
		map.put("addr", "����");
		map.put("tel", "010-1111-1111");
		
		System.out.println("map ==> " + map); //key���� ������ ���� ������ �Է��� ������ ��µ��� �ʴ´�
		
		// �ڷ� ���� ==> �����͸� �߰��� �� key���� ������ ���߿� �߰��� value���� ����ȴ�.
		map.put("addr", "����");
		System.out.println("map ==> " + map);
		
		// �ڷ� ���� ==> remove(key��) ==> 'key��'�� ���� �ڷḦ ã�Ƽ� �����Ѵ�.
		// 			    ��ȯ�� : ������ �ڷ��� value���� ��ȯ�ȴ�.
		
//		String removeData = map.remove("tel");
//		System.out.println("map ==> " + map);
//		System.out.println("������ value : " + removeData);
		
		// �ڷ� �б� ==> get(key��) --> key���� ���� ���� value���� ��ȯ�Ѵ�. 
		System.out.println("�̸� : " + map.get("name"));
		System.out.println("��ȭ : " + map.get("tel"));
		System.out.println();
		
		// key���� ���� ���θ� ��Ÿ���� �޼��� : containsKey(key��);
		//		==> �ش� 'key��'�� ������ true, ������ false�� ��ȯ�Ѵ�.
		System.out.println("tel Ű ���� ���� ���� : " + map.containsKey("tel"));
		System.out.println("age Ű ���� ���� ���� : " + map.containsKey("age"));
		System.out.println();
		
		// Map�� ����� ��� key������ �о�� ��ü Map �����͸� ó���ϴ� ��� -- 1,2���� ���� ��... value���� �ʿ��Ҷ��� 3��
		
		// ���1 : keySet()�޼��� �̿��ϱ�
		//		==> Map�� ��� key������ �о�� Set������ ��ȯ�Ѵ�.
		Set<String> keySet = map.keySet();
		
		Iterator<String> keyIt = keySet.iterator();
		while(keyIt.hasNext()){
			String key = keyIt.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("------------------------------------");
		System.out.println();
		
		// ���2 : keySet()�� ����� ���� for������ ����ϱ�
		System.out.println("���� for�� �̿��ϱ�...");
		for(String key2 : map.keySet()){
			String value2 = map.get(key2);
			System.out.println(key2 + " : " + value2);
		}
		System.out.println("-----------------------------------");
		System.out.println();
		
		// ���3 : value���� �о�� ó���ϱ�  --> values()�޼��� �̿�
		for(String value3 : map.values()){
			System.out.println(value3);
		}
		System.out.println("-----------------------------------");
		System.out.println();
		
		/*
		  	���4 : Map���� Entry��� ���� class�� ������� �ִ�.
		  		     �� Entry Ŭ������ key�� value��� ��������� �����Ǿ� �ִ�.
		  		   Map������ �� EntryŬ������ Set�������� �����Ͽ� �����Ѵ�.
		  		   
		  		   - Map�� ����� ��ü Entry��ü�� �������� (������  Entry ��ü���� Set�������� �Ǿ��ִ�.)
		  		   		==> entrySet()�޼��带 �̿��Ѵ�.
		 */
		 
		// Entry��� ���� ��ü ��ü ��������
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next(); // Entry��ü �ϳ��� ���ؿ���
			System.out.println("key��  : " + entry.getKey());
			System.out.println("value�� : " + entry.getValue());
			System.out.println();
		}
		System.out.println("-----------------------------------");
		System.out.println();
		

	}

}
