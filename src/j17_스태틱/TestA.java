package j17_스태틱;

public class TestA {

//	공유되는 영역
//	static을 선어하면 클래스에 공유됨.
//	생성과 전혀 상관없다.
//	그래서 클래스명을 찍고 접근이 가능하다.
	private static int num;
//	private static final int num;

	public static void setNum(int num) {
		TestA.num = num;
	}
	
	public static int getNum() {
		return num;
	}
	
}
