package j09_클래스Test.example;

public class Person {
	private String name;
	private int age;
	private boolean isMarried;
	private int numberOfChild;
	
	Person() {}
	
	public Person(String name, int age, boolean isMarried, int numberOfChild) {
		this.name = name;
		this.age = age;
		this.isMarried = isMarried;
		this.numberOfChild = numberOfChild;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public int getnumberOfChild() {
		return numberOfChild;
	}

	public void setnumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", isMarried=" + isMarried + ", numberOfChild=" + numberOfChild + "]";
	}
	
	
}
