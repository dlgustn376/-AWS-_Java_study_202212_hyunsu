package j23_database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usermanagement.entity.User;


public class UserInsert {
	
	private DBConnectionMgr pool;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public int saveUser(User user) {
		int successCount = 0;
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
//		1. connection 연결
//		예외처리 = 연결이 안될 경우.

		
		
		try {
			connection = pool.getConnection();
//		MySQL DB와 정상적으로 연결이 된 것.
			
			sql = "insert into user_mst\r\n"
					+ "values (0 , ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			데이터베이스에 접속한 것.
//			에디터에 sql 쿼리를 작성하겠다.
//			숫자는 ? 순서. 들어가는 자료형이 int면 setInt() 사용...			
//			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			successCount = preparedStatement.executeUpdate();		// insert, update, delete 명령 실행
//			적용된 갯수를 return 해서 int값으로 가져옴.
			
//			Set으로 iterator 형식으로 사용되며, next()를 통해 다음 값이 있으면 반복함.
			resultSet = preparedStatement.getGeneratedKeys();
//			key 값은 하나 밖에 없기때문에 if로 해도 된다.
			if(resultSet.next()) {
				System.out.println("이번에 만들어진 user_id Key값: " + resultSet.getInt(1));
				user.setUserId(resultSet.getInt(1));
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return successCount;
	}
	
	/*
		public int saveUser(User user){
			
			int successCount = 0;
			
			DBConnectionMgr pool = DBconnection.getInsatance();
			
			String sqp = null;
			
			Connection connection = null;
			PrepareStetement prepareStatement = null;
			ReultSet resultSet = null;
			
			try {
				connection = pool.getConnection();
			
				sql = "insert into user_mst\r\n"
						+ "values (0 , ?, ?, ?, ?)";
				
				preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getName());
				preparedStatement.setString(4, user.getEmail());
				
				successCount = prepareStatemnet.executeUpdate();
				
				resultSet = prepareStatemetn.getGeneratedKeys();
				
				if(resultSet.next()){
					System.out.println("이번에 만들어진 user_id key 값: " + resultSet.getInt(1));
					user.setUserId(resultSet.getInt(1));
				}
				
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return successCount;
	}
	
	
	
	*/
	
	
	
//	권한 role_dtl을 추가해 주어야 한다.
	public int saveRoles(Map<String, Object> map) {
		int succesCount = 0;
		
		
		String sql = null;
		String values = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			
			connection = pool.getConnection();
			
			List<Integer> roles = (List<Integer>) map.get("roles");
			User user = (User) map.get("user");
			
			sql = "insert into role_dtl values";
			
			
			for(int i = 0; i < roles.size(); i++) {
				sql += "(0,?,?)";
				
				if(i <  roles.size() - 1) {
					sql += ",";
				}
			}
			
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i = 0; i < roles.size(); i++) {
				preparedStatement.setInt((i * 2) + 1, roles.get(i));
				preparedStatement.setInt((i * 2) + 2, user.getUserId());
			}
			
			succesCount = preparedStatement.executeUpdate();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return succesCount;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert();
		
		User user = User.builder()
				.username("ccc")
				.password("1234")
				.name("ccc")
				.email("ccc@gamil.com")
				.build();
		
		int successCount = userInsert.saveUser(user);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		System.out.println(user);
		
		
		/*=============================================================================*/
		
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(2);
		roleIdList.add(3);
		
		Map<String, Object> map = new HashMap<>(); 
		
		map.put("user", user);
		map.put("roles", roleIdList);
		
		successCount = userInsert.saveRoles(map);
		
		
	}

}
