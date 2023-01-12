package j17_스태틱;

public class Student {
	
	private static final int CODE = 2023000;
	private static int ai = 1; //auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
	}
	
//	생성이 안되도 사용가능한 메소드 안에
//	생성이 되어야만 사용할 수 있는 변수 name을 사용할 수 없다.
//	스태틱 메소드 안에서 스태틱 전역 변수만 사용.(메소드 안 지역변수는 가능)
	public static int getAutoIncrement() {
		System.out.println("현재 AI: " + ai);
//		System.out.println("학생이름: " + name);
		return ai;
	}
	
	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	
}
