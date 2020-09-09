package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JdbcTest05Sample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", 
//					"mjkim", "java");
			
			conn = DBUtil.getConnection();
			
			String sql = "select max(nvl(lprod_id, 0)) maxid from lprod";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int maxid = 0;
			
			if(rs.next()){
				//maxid = rs.getInt(1); // 컬럼의 번호 이용
				//maxid = rs.getInt("max(nvl(lprod_id, 0))"); 
				// 컬럼의 alias가 없으면 컬럼의 식 자체를 지정한다.
				maxid = rs.getInt("maxid"); // 컬럼의 alias로 지정하기
			}
			maxid++;
			
			// 입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력받는다.
			String gu; 
			int count = 0;
			
			do{
				System.out.print("상품분류코드 입력 : " );
				gu = scan.next();
				
				String sql2 = "select count(*) cnt from lprod where lprod_gu = ?";
				
				ps = conn.prepareStatement(sql2);
				ps.setString(1, gu);
				
				rs = ps.executeQuery();
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				
				if(count > 0){
					System.out.println("입력한 상품 분류 코드 '" + gu + "'는 이미 등록된 코드 입니다." );
					System.out.println("다시 입력하세요.");
				}
				
			}while(count > 0);
			
			//------------------------------------------------------
			
			System.out.print("상품 분류명 입력 : ");
			String nm = scan.next();
			
			String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) "
					+ " values (?, ?, ?)";
			
			ps = conn.prepareStatement(sql3);
			ps.setInt(1, maxid);
			ps.setString(2, gu);
			ps.setString(3, nm);
			
			int cnt = ps.executeUpdate();
			
			if(cnt > 0){
				System.out.println("등록 성공");
			}else{
				System.out.println("등록 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}

	}

}
