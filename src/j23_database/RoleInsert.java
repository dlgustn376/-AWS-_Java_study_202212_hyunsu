package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
//	private DBConnectionMgr pool;
//	
//	public RoleInsert() {
//		pool = DBConnectionMgr.getInstance();
//	}
//	
//	public int saveRole(String roleName) {
//		int successCount = 0;
//		
//		String sql = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			con = pool.getConnection();
//			sql = "insert into role_mst values (0, ?)";
//			
//			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			pstmt.setString(1, roleName);
//			
//			successCount = pstmt.executeUpdate();
//			
//			int newkey = 0;
//			
//			ResultSet rs = pstmt.getGeneratedKeys();
//			if(rs.next()) {
//				newkey = rs.getInt(1);
//			}
//			
//			System.out.println(newkey != 0 ? "새로운 키값: " + newkey : "키가 생성되지 않음" );
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//	
//		
//		return successCount;
//	}
//	
//	
//	public static void main(String[] args) {
//		RoleInsert roleInsert = new RoleInsert();
//		
//		int successCount = roleInsert.saveRole("ROLE_TESTER");
//		
//		System.out.println("insert 성공 건수: " + successCount);
//	}
	
	private DBConnectionMgr pool;		// RoleInsert에서 pool을 전역변수로 선언.
	
	public RoleInsert() {				// RoleInsert 객체가 생성되면 하나만 존재해야 하므로 싱글톤 패턴을 사용.
		pool = DBConnectionMgr.getInstance();
	}
	
	public int saveRole(String roleName) {	// int 값으로 반환. insert,update, delete는 개수를 반환하기 떄문. Stirng roleName의 매개변수를 받는다.
		int successCount = 0;			// successCount 반환에 성공한 개수를 지역변수로 선언 및 초기화하고 최종 반환하는 변수이다.
		
		String sql = null;				// sql은 MySQL에 String 문자열로 입력되기 때문에 sql의 선언 및 초기화를 해줌. Connection이 정확히 무슨 역할인지는 모름.
		Connection con = null;			// Connection con은 java의 sql에서 연결에 필요한 인터페이스이다.
		PreparedStatement pstmt = null;	// 무슨 역할인지 모름.
		
		try {
			con = pool.getConnection();	// con에 생성된 DBConnectionMgr의 객체에서 getConnection을 사용.
			
			sql = "insert into role_mst values (0, ?)";		// sql문으로 role_mst에 값을 입력한다는 의미. 0은 autoIncrese로 값이 증가. ? 는 role_name으로 받는다.
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	// prepareStatement 메소드는 sql문을 처리하는 메소드로 생성된 키값을 반환해 준다.
			successCount = pstmt.executeUpdate();		// executeUpdate()는 insert, update, delete 등 성공한 건수를 int 값으로 반환해준다.
			
			int newkey = 0;				// 새로운 키 값을 알기위한 선언 및 초기화
			
			ResultSet rs = pstmt.getGeneratedKeys(); 	// 데이터베이스 결과 집합을 나타내는 테이블, 데이터 베이스를 쿼리하는 문을 실행함.
														// getGeneratedKeys() 생성된 키값을 가져오는 메소드.
			
			if(rs.next()) {				// rs.next() 는 다음 key 값이 있다면 실행이 되는 조건이다.
				newkey = rs.getInt(1);	// 컬럼index 1번과 비교하여 1번 컬럼인데스에 다음 값이 있다면 실행. 
										// getInt메소드에서 컬럼인덱스 1에서 SQL의 value 가 null이면 0으로 반환
			}
						
			System.out.println(newkey != 0 ? "새로운 키값: " + newkey : "키가 생성되지 않음" );	// 삼항 논리연산자로 newkey의 값이 0이아니면 새로운 키값과 값을 실행하고,
																								// newkey 값이 0이면 키가생성되지 않음으로 실행
			
		} catch (Exception e) {			// 예외처리. con 에서 연결이 되지 않은 경우 등 예외처리를 해주어야 함.
			e.printStackTrace();		// 예외처리문으로 예외의 이유를 알림.
		}		
		
		
		
		return successCount;
	}
	
	public static void main(String[] args) {	// 메인 문
		RoleInsert roleInsert = new RoleInsert();	// saveRole메소드가 static이 아니기 떄문에 class RoleInsert를 생성해주어야 한다.
		
		int successCount = roleInsert.saveRole("ROLE_TESTER");	// successCount 변수에 roleInsert.saveRole("ROLE_TESTER")를 대입
		// saveRole("ROLE_TESTER")는 int 값을 반환하기 때문에.
		
		System.out.println("insert 성공 건수: " + successCount);	// 성공건수를 console 창에 출력
		
	}
	
	
}
