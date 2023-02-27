package j17_스태틱.싱글톤;

public class Student {
	
	private static final int CODE = 20230000; // final -> 상수로 고정
	private static int ai = 1; // auto_increment // 학번을 1씩 증가시킬 예정

	private int studentCode;
	private String name;

	public Student(String name) {
		studentCode = CODE + ai; // 학번부여
		ai++; // static 은 글씨체가 다르다.
		this.name = name;
	}

	@Override // alt + shift + s -> toString
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}

}
