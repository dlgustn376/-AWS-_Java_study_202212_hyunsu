package j12_배열;

// main의 class 기능을 담당하는 객체, 비즈니스 객체
// Entity : 정보를 담는다. 정보를 담는 클래스
public class J12_User {
	private String username;	//사용자이름(아이디, 계정)
	private String passward;	//비밀번호
	private String name;		//성명
	private String email;		//이메일
	
	
	public J12_User() {}			// ctrl + space
	
	// alt + shift + s
	
	public J12_User(String username, String passward, String name, String email) {
		super();
		this.username = username;
		this.passward = passward;
		this.name = name;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "J12_User [username=" + username + ", passward=" + passward 
				+ ", name=" + name + ", email=" + email
				+ "]";
	}
	
	
	
}
