package j20_JSON.builder;

public class UserMain {
	public static void main(String[] args) {
//		User user = new User();
		User.UserBuilder userBuilder = new User.UserBuilder();// userclass 안에 들어있는 userbuilder 생성자
		
		User user = User.builder()
				.username("aaa")
				.password("1234")
				.name("김준일")
				.build();
		
		

		System.out.println(user);
	}

}
