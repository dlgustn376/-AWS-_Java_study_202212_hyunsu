package j09_클래스;

public class J09_Usermain {
	public static void main(String[] args) {
		J09_User u1 = new J09_User();
		
		u1.username = "aaa";
		u1.password = "1234";
		u1.name = "김종환";
		u1.email = "aaa@gmail.com";
		
		u1.printUserInfo();
		
	}

}
