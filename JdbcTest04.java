package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "mjkim", "java");
			
			System.out.println("계좌 번호 정보 추가하기");
			System.out.print("계좌번호 : " );
			String bankNo = scan.nextLine();
			
			System.out.print("은 행 명 : " );
			String bankName = scan.nextLine();
			
			System.out.print("예금주명 : ");
			String bankUser = scan.nextLine();
			/*
			// Statement객체를 이용하여 데이터 추가하기
			String sql = "INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE) "
					+ " VALUES ('" + bankNo + "', '" + bankName +"', '" +bankUser+ "', SYSDATE)";
			
			stmt = conn.createStatement();
			
			// 실행할 SQL문이 SELECT문일 경우에는 executeQuery()메서드를 사용하고,
			// 실행할 SQL문이 SELECT문이 아닐 경우에는 executeUpdate()메서드를 사용한다.
			// executeUpdate()메서드의 반환값 ==> 작업에 성공한 레코드 수 
			
			int cnt = stmt.executeUpdate(sql);
			*/
			
			// PreparedStatement객체를 이용하여 처리하기
			// SQL문에서 데이터가 들어갈 자리에 물음표(?)로 표시한다.
			String sql = "INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE) "
					+ " VALUES (?, ?, ?, SYSDATE)";
			
			// PreparedStatement객체 생성
			// 		==> 이 때 처리할 SQL문을 매개변수에 넘겨준다.
			ps = conn.prepareStatement(sql);
			
			// SQL문의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			// 형식) ps.set자료형이름(물음표번호, 데이터)
			//		'물음표 번호'는 1부터 시작한다
			ps.setString(1, bankNo);
			ps.setString(2, bankName);
			ps.setString(3, bankUser);
			
			// 데이터 셋딩이 완료되면 SQL문을 실행한다.
			int cnt = ps.executeUpdate();

			
			System.out.println("반환값 : " + cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(stmt !=null) try { stmt.close(); } catch (Exception e2) { }
			if(ps !=null) try { ps.close(); } catch (Exception e2) { }
			if(conn !=null) try { conn.close(); } catch (Exception e2) { }
		}

	}

}
