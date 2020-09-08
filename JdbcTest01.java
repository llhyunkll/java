package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC(Java DataBase Connectivity) 라이브러리를 이용한 DB자료 처리하기
/*
	- 데이터베이스 처리 순서
	1. 드라이버 로딩 ==> 라이브러리를 사용 할 수 있게 메모리로 읽어 들이는 작업
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
	2. DB시스템에 접속하기 ==> 접속이 완료되면 Connection객체가 생성되어 반환된다.
	   DriverManager.getConnection()메서드를 사용한다.
	   
	3. 질의 ==> SQL문장을 DB서버에 보내서 그 결과를 얻어온다.
		(Statement객체나 PreParedStatement객체를 이용하여 작업한다.)
	
	4. 결과 처리 ==> 질의 결과를 받아서 원하는 작업을 수행한다. 
		1) SQL문이 select문 일 경우 ==> select한 결과가 ResultSet객체에 저장되어 반환된다.
		2) SQL문이 select문이 아닌 경우(update, insert, delete, create 등등)
		  		==> 정수값이 반환된다.(이 정수값 보통 실행에 성공한 레코드 수를 말한다.)
		  		
	5. 사용했던 자원을 반납한다.
	
 */
public class JdbcTest01 {

	public static void main(String[] args) {
		// DB작업에 필요한 객체변수들 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	// 사용할 SQL문이 SELECT문일 경우에 필요
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB시스템 접속 ==> Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"mjkim", "java");
			
			// 3. SQL문 작성 ==> SQL문은 대소문자를 구분하지 않는다.
			String sql = "SELECT * FROM LPROD";
			
			// 4. Statement객체 생성 ==> 질의를 수행해는 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL문을 DB서버로 보내서 결과를 얻어온다. 
			//		(지금은 SQL문이 SELECT문이기 때문에 결과가 ResultSet객체에 저장되어 반환된다.)
			rs = stmt.executeQuery(sql);
			
			// 6. 결과 처리하기 ==> 한 레코드씩 화면에 출력하기
			//		(ResultSet에 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.)
			System.out.println("== SQL문의 처리 결과 ==");
			
			// rs.next() ==> ResultSet객체의 데이터를 가리키는 포인터를 
			//				 다음번째 레코드 위치로 이동시키고 그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			while(rs.next()){
				// 포인터가 가치키는 위치의 데이터를 가져오는 방법
				// 형식1) rs.get자료형이름("컬럼명")
				// 형식2) rs.get자료형이름(컬럼번호) ==> 컬럼번호는 1부터 시작
				// 형식3) rs.get자료형이름("컬럼의Alias명")
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println("--------------------------------------");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			
		} finally {
			// 7. 사용했던 자원 반납
			if(rs !=null) try { rs.close(); } catch (Exception e2) { }
			if(stmt !=null) try { stmt.close(); } catch (Exception e2) { }
			if(conn !=null) try { conn.close(); } catch (Exception e2) { }
		}

	}

}
