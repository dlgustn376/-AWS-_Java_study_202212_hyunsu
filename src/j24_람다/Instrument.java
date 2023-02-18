package j24_람다;

@FunctionalInterface // 

public interface Instrument {
	public String play(String instrument);
	
	public default void testPrint() { // 구현된 메소드는 추가로 만들 수 있다.
		System.out.println("테스트");
	}

}
