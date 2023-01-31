package j24_람다;

@FunctionalInterface // 함수형 인터페이스. 람다용이란 의미.
public interface Instrument {
	
	public String play(String instrument);
	
	
//	구현된 메소드는 상관이 없다.
	public default void testPrint() {
		System.out.println("테스트");
	}
}
