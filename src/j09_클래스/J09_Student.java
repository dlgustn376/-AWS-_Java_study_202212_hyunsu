package j09_클래스;

public class J09_Student {
	
	String name; // 생성이 되면서 기본 값들이 초기화
	int age;	
	
	// 기본 생성자
	// 생성자는 반환 자료형이 없다.
	// 그런데 호출하고 주소값이 들어있다.
	// 반환자료형을 정해줄 필요가 없다.
	// 무조건 주소값을 반환하기 때문에
	// 자료형을 적으면 안됨.
	J09_Student() {
		System.out.println("생성됨!!!!");
	}
	
	void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	
}
