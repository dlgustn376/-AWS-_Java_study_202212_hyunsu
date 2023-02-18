package J16_Object;

import java.util.Objects;

public class Student {
	private String name;
	private int age;

	public Student(String name, int age) { // Alt + Shift + S -> GCUF
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) { // 두 개의 주소가 같으면
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj.getClass() == Student.class)) {
			return false;
		}

		Student s = (Student) obj;
		boolean result = name.equals(s.name) && age == s.age;

		return result;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age;

	}
}
