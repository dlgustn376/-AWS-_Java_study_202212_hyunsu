package j10_생성자;

public class J10_Student {
	
	String name;	// 참조 변수
	int age;		// 레퍼런스 변수 , 멤버 변수
	
	
	J10_Student() {
		System.out.println("기본 생성자 호출");
	}

	J10_Student(int age) {
		System.out.println("학생의 나이: " + age);
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}
	
	J10_Student(String name, int age) {
		// 우선순위는 지역변수가 높다.
		// this는 자기 자신의 주소값
		// . 은 주소값, 참조
		// this.name 자기 자신의 주소안에 멤버변수를 말한다.
		this.name = name;
		this.age = age;
		
	}
	
	void printInfo() {
		System.out.println("학생의 이름: " + name);
		System.out.println("학생의 나이: " + age);
	}
	
}
