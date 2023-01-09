package j12_배열.di;

public class Test_A {
	// 초기화가 무조건 있어야 함.
	// 중간에 부품교체 안됨.
	// 중간에 다른 객체로 바꾸면 안되는 경우 final을 걸어준다.
//	private final Test_B tb;
	
	private Test_B tb;
	
	// TestB는 TestA에 의존하고 있다.
	// 의존성이 높다 == 결합도가 높다.
	
	// 1. 생성자 생성을 통해서
	// 필수 조건
	// 딱 한번만 동작해서 사용가능
	// 무조건 초기화되어야 하는 변수
	// 리콰이어드 아규먼드 생성자
	// required argument constructor
	// none argument constructor
	public Test_A(Test_B tb) {
		this.tb = tb;
	}
	
	// 2. setter를 통해서
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	// tb 객체가 필수
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.TestB1();
	}
	
	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!");
//		Test_B tb = new Test_B();
		
		tb.TestB1();
	}
	
	
}