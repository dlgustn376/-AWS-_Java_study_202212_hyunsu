package j09_클래스;

public class J09_Student {
	
	String name; 
	int age;	
	
	// 기본 생성자
	J09_Student() {
		System.out.println("생성됨!!!!");
	}
	
	
	
	public J09_Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name + "님";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

	@Override
	public String toString() {
		return "J09_Student [name=" + name + ", age=" + age + "]";
	}
	
}
