package j12_배열;

//Entity 클래스 (실제 DataBase의 테이블과 1 : 1로 매핑 되는 객체, Entity란 DB에서 영속적으로 저장된 데이터를 자바 객체로 매핑하여 '인스턴스의 형태'로 존재하는 데이터를 말합니다. )
public class J12_User {
	private String username; // 사용자 이름(아이디, 계정)
	private String password; // 비밀번호
	private String name; // 성명
	private String email; // 이메일
	
	public J12_User() { // 기본 생성자 -> Ctrl + Space
		
	}
	
//	Alt + Shift + S
	public J12_User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
//	Alt + Shift + S

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
//	Alt + Shift + s 3 -> Generate toString 클릭
	@Override
	public String toString() {
		return "J12_User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	
	

}
