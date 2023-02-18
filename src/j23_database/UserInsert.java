package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import j20_JSON.builder.User;

public class UserInsert {

	private DBConnectionMgr pool;

	public UserInsert() {
		pool = DBConnectionMgr.getInstance(); // 싱글톤
	}

	public int saveUser(User user) {
		int successCount = 0;

		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try { // 예외처리
			connection = pool.getConnection();

			sql = "insert into user_mst\r\n" 
					+ "value (0, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());

			successCount = preparedStatement.executeUpdate(); // insert, update, delete 명령 실행할 떄 사용한다.

			resultSet = preparedStatement.getGeneratedKeys(); //
			if (resultSet.next()) {
				System.out.println("이번에 만들어진 user_id key값: " + resultSet.getInt(1)); // 1은 열의 위치
				user.setUserId(resultSet.getInt(1));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return successCount;
	}

	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;

		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = pool.getConnection();
			List<Integer> roles = (List<Integer>) map.get("roles");
			User user = (User) map.get("user");

			sql = "insert into role_dtl values";

			for (int i = 0; i < roles.size(); i++) {

				sql += "(0, ?, ?)";

				if (i < roles.size() - 1) {
					sql += ",";
				}
			}

			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < roles.size(); i++) {
				preparedStatement.setInt((i * 2) + 1, roles.get(i));
				preparedStatement.setInt((i * 2) + 2, user.getUserId());
			}

			successCount = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return successCount;
	}

	public static void main(String[] args) {

		UserInsert userInsert = new UserInsert();

		User user = User.builder().username("ddd").password("1234").name("ddd").email("ddd@gmail.com").build();

		int successCount = userInsert.saveUser(user);

		System.out.println("쿼리 실행 성공: " + successCount + "건");

		System.out.println(user);

		/*
		 * =============================================================================
		 */

		List<Integer> roleIdsList = new ArrayList<>();
		roleIdsList.add(2);
		roleIdsList.add(3);

		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdsList);

		System.out.println(map);

		int listSize = 3;

		String sql = "insert into test values";
		String values = "(0, ?, ?)";

		for (int i = 0; i < listSize; i++) {
			sql += values;
			if (i < listSize - 1) {
				sql += ",";

			}
		}

		successCount = userInsert.saveRoles(map);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");

	}

}
