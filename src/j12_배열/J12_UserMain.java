package j12_배열;

public class J12_UserMain {
	
	public static void main(String[] args) {
		// users 배열 생성
		J12_User[] users = new J12_User[0];
		
		// users는 userRepository에 의존
		J12_UserRepository userRepository = new J12_UserRepository(users);
		
		// userRepository는 service에 의존
		J12_UserService service = new J12_UserService(userRepository);
		
		service.run();
		service.stop();
	
	}
	
}
