package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제2) lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오.
public class JdbcTest03 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"mjkim", "java");
			
			
			System.out.print("숫자 입력 (1~9) 1 >>");
			int input = scan.nextInt();
			System.out.print("숫자 입력(1~9) 2 >>");
			int input2 = scan.nextInt();
			
//			int max, min;
//			if(input > input2){
//				max = input; min = input2;
//			}else{
//				max = input2; min = input1;
//			}
//			sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN " + min +  "AND " + max ;
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
			
			String sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN ? AND ? ";
			ps = conn.prepareStatement(sql);
			
			
			if(input > input2){
				ps.setInt(1, input2);
				ps.setInt(2, input);
			}else{
				ps.setInt(1, input);
				ps.setInt(2, input2);
			}
			
			rs = ps.executeQuery();
			
			
			while(rs.next()){
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println("--------------------------------------");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 7. 사용했던 자원 반납
			if(rs !=null) try { rs.close(); } catch (Exception e2) { }
			if(ps !=null) try { ps.close(); } catch (Exception e2) { }
			if(conn !=null) try { conn.close(); } catch (Exception e2) { }
		}

	}

}
