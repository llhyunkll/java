package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil3 {
	
	private static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("dbinfo");
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
	}
	
	// DB시스템에 접속한 후 접속 정보를 갖는 Connection 객체를 반환하는 메서드
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mjkim", "java");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!!!");
			return null;
		}
	}
	

}
