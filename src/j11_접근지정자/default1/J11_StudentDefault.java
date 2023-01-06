package j11_접근지정자.default1;

public class J11_StudentDefault { //public을 빼면 자기 class에서만 사용한다는 의미.
	
	private String name;
	private int age;
	
	public J11_StudentDefault() {
		
	}

	public J11_StudentDefault(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	//Getter
	public String getName() {
		return name;
	}
	
	//Setter
	public void setName(String name) {
		this.name = name;
	}
	
	
}
