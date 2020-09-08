package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1) 사용자로부터 LPROD_ID값을 입력받아 입력한 값 보다 lprod_id가 큰 자료들을 출력하시오.
public class JdbcTest02 {

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
			
			System.out.print("숫자 입력 1~9 >>");
			int input = scan.nextInt();
			
			String sql = "SELECT * FROM LPROD WHERE LPROD_ID > ?";
			sql = "SELECT * FROM LPROD WHERE LPROD_ID > " + input;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, input);
//			rs = ps.executeQuery();
			
			System.out.println("== 검 색 결 과 출 력 ==");
			while(rs.next()){
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println("-------------------------");
			}
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			// 7. 사용했던 자원 반납
			if(rs !=null) try { rs.close(); } catch (Exception e2) { }
			if(ps !=null) try { ps.close(); } catch (Exception e2) { }
			if(stmt !=null) try { stmt.close(); } catch (Exception e2) { }
			if(conn !=null) try { conn.close(); } catch (Exception e2) { }
		}


	}

}
