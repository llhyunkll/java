package kr.or.ddit.basic;
/*
 	제네릭 클래스 만드는 방법
 	
 	형식) class 클래스명<제네릭타입글자>{
 			제네릭타입글자 변수명;		// 변수 선언에 제네릭을 사용할 경우
 			...
 			
 			제네릭타입글자 메서드명(파라미터변수들...){ // 반환값이 있는 메서드에서 사용할 경우
 				...
 				return 값;
 			
 			}
 			
 			반환값타입 메서드명(제네릭타입글자 변수명, ...){ // 메서드의 파라미터변수에 사용할 경우
 				...
 			
 			}
 	
 	
 		}
 	
 */

// 제네릭을 사용하지 않는 클래스 작성
class NonGenericClass{
	private Object val;
	
	public void setVal(Object val){
		this.val = val;
	}
	
	public Object getVal(){
		return val;
		
	}
	
}
//어떤종류의 데이터도 담고싶을 때

// 제네릭을 사용하는 클래스 작성

class MyGeneric<T>{
	private T val; //T타입의 변수 val; // 변수 선언
	
	public void setVal(T val){ // 메서드의 파라미터변수에 사용
		this.val = val; 
	}
	
	public T getVal(){
		return val;
	}
}


public class GenericTest {

	public static void main(String[] args) {
		NonGenericClass ngc1 = new NonGenericClass();
		ngc1.setVal("가나다라"); 
		
		NonGenericClass ngc2 = new NonGenericClass();
		ngc2.setVal(123); //저장할때 자동으로 object형(조상쪽)으로 형변환해서 저장
		
//		String rtnStr = ngc1.getVal(); //Object타입으로 반환하기 때문에 컴파일에러
		String rtnStr = (String)ngc1.getVal(); 
//		int rtnStr = (int)ngc1.getVal(); //컴파일에러는 나지 않지만, 반환하는 타입과 맞지않기 때문에 실행하면 에러발생
		System.out.println("문자열 반환값 : " + rtnStr);
		
		int rtnInt = (int)ngc2.getVal();
		System.out.println("정수형 반환값 : " + rtnInt);
		System.out.println();
		
		//-------------------------------------------------------------------------------
		
		MyGeneric<String> mgc1 = new MyGeneric<>(); //T로 선언했던 것을 String타입으로 받음
		mgc1.setVal("우리나라");

		MyGeneric<Integer> mgc2 = new MyGeneric<>();
		mgc2.setVal(500); 
		
		rtnStr = mgc1.getVal();
		//int rtnStr1 = mgc1.getVal();
		System.out.println("제네릭 문자열 반환값 : " + rtnStr);
		
		rtnInt = mgc2.getVal();
		System.out.println("제네릭 정수형 반환값 : " + rtnInt);


	}

}
