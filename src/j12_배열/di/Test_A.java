package j12_배열.di;

public class Test_A {

	private final Test_B tb;

	public Test_A(Test_B tb) { // Test A가 있어야 Test B가 존재하는 상황이다. -> 의존성이 높다. -> 결합도가 높다
		this.tb = tb;
	}

//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}

	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
//		Test_B tb = new Test_B();

		tb.testB1();
	}

	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!");
//		Test_B tb = new Test_B();

		tb.testB1();

	}
}
