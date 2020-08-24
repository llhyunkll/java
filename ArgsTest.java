package kr.or.ddit.basic;

public class ArgsTest {
	
	// 배열을 이용한 메서드 
	public int sumArr(int[] data){
		int total = 0;
		for(int i=0; i < data.length; i++){
			total += data[i];
		}
		return total;
	}
	/*
	 	가변형 인수 - 메서드의 매개변수의 개수가 호출될 때 마다 다를 경우에 사용한다.
	 			- 이 가변형 인수는메서드 내에서는 배열로 처리된다.
	 			- 가변형 인수는 하나의 메서드에 하나만 사용할 수 있다.  
	 */
	
	// 가변형 인수를 이용한 메서드
	public int sumArg(int...data){ //입력받는 int 값이 하나만 써있지만 여러개 변수를 가변적으로 입력받을수있다.
		int total = 0;
		for(int i=0; i < data.length; i++){
			total += data[i];
		}
		return total;
	}

//	하나의 메서드에 2개 이상의 가변형 변수 사용 불가
//	public void argTest(int...t, float...k){ //이런건 불가능
//		
//	}
	
	// 가변형 변수와 일반 변수를 같이 사용할 경우에는 가변형 변수를 제일 뒤에 배치해야 한다.
	public void argTest(String name, int...data){
		
	}
	
	public static void argTest2(int num, int...data){
		
		
	}
	

//	public void argTest3(int...data, int num){
//		
//	}
//	argTest3(1, 2, 3, 4, 5); // 불가능

	public static void main(String[] args) {
		ArgsTest test = new ArgsTest();
		
		// int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int[] nums2; 
		// nums2 = {1, 2, 3, 4, 5}; //에러
		nums2 = new int []{1, 2, 3, 4, 5}; 
		int result = test.sumArr(nums);
		System.out.println("result = "+result);
		
		// 10, 20, 30, 40 배열을 직접 생성
		System.out.println(test.sumArr(new int[]{10, 20, 30, 40})); 
		System.out.println("======================================");
		
		System.out.println(test.sumArg(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println(test.sumArg(1, 2, 3, 4, 5));
		
		
		
		argTest2(1, 2, 3, 4, 5); 
		
		
		
		
		
		
		
		
	}

}
