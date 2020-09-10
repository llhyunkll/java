package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

/*
	회원을 관리하는 프로그램을 작성하시오.
	(오라클 DB의 MYMEMBER테이블 이용)
	
	아래 메뉴의 기능을 모두 구현하시오. (CRUD 구현하기 연습) CREATE READ - select insert UPDATE DELELE
	
	메뉴예시)
	-- 작업 선택 --
	1. 자료 추가 C
	2. 자료 삭제 D
	3. 자료 수정 U
	4. 전체자료 출력 R
	5. 작업 끝
	---------------
	원하는 작업 선택 >> 
 */
public class JdbcTest06 {
	
	Scanner scan = new Scanner(System.in);
	private Connection con = null;
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public static void main(String[] args) {
		new JdbcTest06().start();

	}
	
	private void start() {
		while(true){
			
			System.out.println("-- 작업 선택 --");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체자료 출력");
			System.out.println("5. 작업 끝");
			System.out.println("---------------");
			System.out.print("원하는 작업 선택 >>");
			int input = scan.nextInt();
			
			switch(input){
			case 1: insert(); break;
			case 2: delete(); break;
			case 3: update(); break;
			case 4: selectAll(); break;
			case 5: System.exit(0); System.out.println("종료되었습니다.");break;
			default : System.out.println("잘못입력하셨습니다."); return;
			
			}
		}
		
	}
private void selectAll() {
		try {
			con = DBUtil2.getConnection();
			
			System.out.println("전체 자료를 출력합니다.");
			
			String sql = "SELECT * FROM MYMEMBER ";
			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			System.out.println("===============================");
			System.out.println("  아이디\t이름\t전화번호\t주소");
			System.out.println("===============================");
			while(rs.next()){
				System.out.println("  "+ rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4) );
			}
			System.out.println("===============================");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs !=null) try { rs.close(); } catch (Exception e2) { }
			if(st !=null) try { st.close(); } catch (Exception e2) { }
			if(ps !=null) try { ps.close(); } catch (Exception e2) { }
			if(con !=null) try { con.close(); } catch (Exception e2) { }
		}	
		
	}

private void update() {
	try {
		con = DBUtil.getConnection();
		
		System.out.println("자료를 수정합니다.");
		System.out.println("수정할 자료의 아이디를 입력하세요.");
		System.out.print("아이디 입력 >>");
		String id = scan.next();
		
		String sql = "SELECT COUNT(*) CNT FROM MYMEMBER WHERE mem_id = ? ";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		
		rs.next();
		int idChe = rs.getInt("CNT");
		
		if(idChe == 0){
			System.out.println("수정 할 아이디가 없습니다.");
		}else{
			System.out.print("수정할 이름 >>");
			String name = scan.next();
			System.out.print("수정할 전화번호 >>");
			String num = scan.next();
			System.out.print("수정할 주소 >>");
			String addr = scan.next();
			sql = "UPDATE MYMEMBER SET mem_name = ?, mem_tel = ?, mem_addr = ? "
					+ " WHERE mem_id = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, num);
			ps.setString(3, addr);
			ps.setString(4, id);
			
			int tmp = ps.executeUpdate();
			
			if(tmp > 0){
				System.out.println("수정 성공");
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(rs !=null) try { rs.close(); } catch (Exception e2) { }
		if(ps !=null) try { ps.close(); } catch (Exception e2) { }
		if(con !=null) try { con.close(); } catch (Exception e2) { }
	}	
		
	}


	private void insert() {
		try {
			con = DBUtil.getConnection();
				
				System.out.println("자료를 입력합니다.");
				System.out.print("아이디 입력 >> ");
				String id = scan.next();
				
				String sql = "SELECT COUNT(*) CNT FROM MYMEMBER WHERE mem_id = ? ";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				rs.next();
				int idChe = rs.getInt("CNT");
				
				if(idChe > 0){
					System.out.println("중복된 아이디 입니다.");
				}else{
					System.out.print("이름 입력>>");
					String name = scan.next();
					System.out.print("전화번호 입력>>");
					String num = scan.next();
					System.out.print("주소 입력>>");
					String addr = scan.next();
					
					sql = "INSERT INTO MYMEMBER (mem_id, mem_name, mem_tel, mem_addr) "
							+ " VALUES (?, ?, ?, ?)";
					
					ps = con.prepareStatement(sql);
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, num);
					ps.setString(4, addr);
					
					int tmp = ps.executeUpdate();
					
					if(tmp > 0){
						System.out.println("입력 성공");
					}
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs !=null) try { rs.close(); } catch (Exception e2) { }
			if(ps !=null) try { ps.close(); } catch (Exception e2) { }
			if(con !=null) try { con.close(); } catch (Exception e2) { }
		}
		return;
	}
	
	private void delete() {
		try {
			con = DBUtil.getConnection();
			
			System.out.println("자료를 삭제합니다.");
			System.out.println("삭제할 자료의 아이디를 입력하세요.");
			System.out.print("아이디 입력 >>");
			String id = scan.next();
			
			String sql = "SELECT COUNT(*) CNT FROM MYMEMBER WHERE mem_id = ? ";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			rs.next();
			int idChe = rs.getInt(1);
			System.out.println(idChe);
			if(idChe == 0){
				System.out.println("삭제할 아이디가 없습니다."); 
			}else{
				
				sql = "DELETE MYMEMBER WHERE MEM_ID = ?";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				int tmp = ps.executeUpdate();
				
				if(tmp > 0){
					System.out.println("삭제 성공");
				}

			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs !=null) try { rs.close(); } catch (Exception e2) { }
			if(ps !=null) try { ps.close(); } catch (Exception e2) { }
			if(con !=null) try { con.close(); } catch (Exception e2) { }
		}
	}
		

}
