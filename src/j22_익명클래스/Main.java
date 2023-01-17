package j22_익명클래스;

public class Main {
	
	public static void main(String[] args) {
		Calculator c1 = new Addition();
		
		System.out.println(c1.calc(10, 20));

//=====================================================================================================
		Calculator c2 = new Calculator() {
//			{ 객체, 임시 구현된 클래스, 이름이 없다. 다른 곳에서는 사용할 수 없다.}
			@Override
			public int calc(int x, int y) {
				return x - y;
			}
		};
		System.out.println(c2.calc(200, 100));
		
		
		
		
		
	}
	
}
