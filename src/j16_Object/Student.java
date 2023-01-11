package j16_Object;

import java.util.Objects;

public class Student {
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super(); // Object 클래스가 상속된 상태
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "이름: " + name + "\n나이: " + age;
	}
//	Objects 클래스를 활용하기 위한 도구들
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	public boolean equals(Object obj) {
//		업캐스팅된 s2를 다운 캐스팅해주어야 함.
		
//		nul 체크
		
//3. 같은 주소 체크
		if(this == obj) {
			return true;
		}
		
//2. null 체크
		if(obj == null) {
			return false;
		}
		
//4. 동일한 객체인지 체크 instanceof, instanceof는 상속되었을 때 문제가 있다.
//명확하게 Student 일때 다운 캐스팅을 하라.
//타입을 확인할 때, 클래스 이름을 확인할 때, 그 클래스 안에 무엇을 가지고 있는지 확인할 때 
		if(!(obj.getClass() == Student.class)) {
			return false;
		}
		
//1. s1의 이름과 나이가 같은지
		Student s = (Student) obj; 
		boolean result = name.equals(s.name) && age == s.age;
		
		return result;
	}
	
	
	
}