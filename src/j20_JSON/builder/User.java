package j20_JSON.builder;


import lombok.Builder;
import lombok.Data;


//public static UserBuilder builder() {
//	return new UserBuilder();

//public static class UserBuilder() { // 내부클래스 : 클래스 안에 클래스
//	private String username;
//	private String password;
//}

@Data
@Builder

public class User {
	private int userId;
	private String username;
	private String password;
	private String name;
	private String email;

	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
//		public UserBuilder username(String username) {
//			this.username = username;
//			return this;
//		}
//
//		public UserBuilder password(String password) {
//			this.password = password;
//			return this;
//		}
//
//		public UserBuilder name(String name) {
//			this.name = name;
//			return this;
//		}
//
//		public UserBuilder email(String email) {
//			this.email = email;
//			return this;
//		}
//
//		public User build() {
//			return new User(username, password, name, email);
//		}
//
//	}
}