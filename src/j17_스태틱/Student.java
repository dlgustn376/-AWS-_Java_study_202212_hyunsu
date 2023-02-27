package j17_스태틱;

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

	
	public static int getAutoIncrement() {
		int num = 10;
		System.out.println("현재 AI : " + ai); // static 메소드라서 생성하지 않아도 호출이 가능하다.
//		 System.out.println("학생이름 : " + name); // 생성이 된 후(메모리에 할당 된 후) 호출을 하지 않았기 때문에 사용이 불가능 하다. 
		return ai; // static 메소드 안에서 static 변수만 사용이 가능하다. 하지만 지역변수는 사용이 가능하다.
	}
	
	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}

}
