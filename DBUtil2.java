package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil2 {
	
	private static Properties prop;

	static {
		prop = new Properties();
		File f = new File("res/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(f); //
			prop.load(fin);
			Class.forName(prop.getProperty("driver"));
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	// DB시스템에 접속한 후 접속 정보를 갖는 Connection 객체를 반환하는 메서드
	public static Connection getConnection(){
		try {
//			return DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", 
//					"mjkim", "java");
			
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass")
					);
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!!!");
			return null;
		}
	}
}
