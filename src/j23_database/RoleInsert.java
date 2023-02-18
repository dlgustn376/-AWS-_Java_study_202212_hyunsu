package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {

	private DBConnectionMgr pool;

	public RoleInsert() {
		pool = DBConnectionMgr.getInstance();
	}

	public int saveRole(String roleName) {
		int successCount = 0;

		String sql = null;
		Connection con = null; // db 연결
		PreparedStatement pstmt = null; //쿼리 실행
		ResultSet rs = null;

		try { // connection 했을 때 연결 안 될 경우(ID, PW 오류) 가 있기 때문에 사용한다.
			con = pool.getConnection(); // pool : db의 인원을 제한하는 것
			
			sql = "insert into role_mst values (0, ?)";
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, roleName);

			successCount = pstmt.executeUpdate(); // 쿼리 실행 (sql -> Ctrl + Enter)

			int newKey = 0;

			 rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				newKey = rs.getInt(1);
			}
			System.out.println(newKey != 0 ? "새로운 키값 : " + newKey : "키가 생성되지 않음");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return successCount;
	}

	public static void main(String[] args) {

		RoleInsert roleInsert = new RoleInsert();

		int successCount = roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수 : " + successCount);
	}

}
