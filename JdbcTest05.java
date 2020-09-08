package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	Lprod 테이블에 새로운 데이터 추가하기
	
	lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
	lprod_id는 현재의 lprod_id 중에 제일 큰 값보다 1 크게 한다.
	그리고, 입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력받는다.
	
 */
public class JdbcTest05 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mjkim", "java");
			
			String sql = null;
			String gu = null; String nm = null;
			
			while(true){
				
				System.out.print("gu 입력 >>");
				gu = scan.nextLine();
				
				sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_GU = UPPER (?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, gu);
				rs = ps.executeQuery();
				
				rs.next();
				int temp = rs.getInt(1);
				
				if(temp == 1){
					System.out.println("중복된 값 입니다. 재입력하세요.");
					System.out.print("gu 입력 >>");
					gu = scan.nextLine();
				}else{
					break;
				}
			}
			
			System.out.print("nm 입력 >>");
			nm = scan.nextLine();

			
			sql = "SELECT MAX(LPROD_ID) FROM LPROD";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			int tmp = rs.getInt(1) + 1 ;
			
			sql = "INSERT INTO LPROD VALUES (?, UPPER(?), ?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, tmp);
			ps.setString(2, gu);
			ps.setString(3, nm);
			
			int result = ps.executeUpdate();
			
			if(result > 0){
				System.out.println("입력 성공!");
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
