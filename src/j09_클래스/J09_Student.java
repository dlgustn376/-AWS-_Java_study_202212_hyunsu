package j09_클래스;

public class J09_Student { // 어디서나 접근이 가능하다 -> 패키지 단위, private -> 해당 클래스 내부에서만 사용 가능

	String name;
	int age;

	// 기본 생성자
	public J09_Student() {
		System.out.println("생성됨!!!!");
	}

	void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}

}
