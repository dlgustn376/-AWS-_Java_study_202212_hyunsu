package J16_Object;

import java.util.Objects;

public class SubStudent {
	private String name;
	private int age;

	public SubStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(name, age);
	}

}
