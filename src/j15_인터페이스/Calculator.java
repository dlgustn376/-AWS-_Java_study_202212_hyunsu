package j15_인터페이스;

public interface Calculator {

	public int ERROR = -99999;
	
	public double plus(double x, double y); // interface에는 abstract존재 하므로 {} 사용x
	
	public double minus(double x, double y);
	
	public default double multiplication(double x, double y) {  // interface에서 default를 적어주어야 일반 메소드 사용이 가능하다. 일반변수를 가질 수 없고 상수는 가질 수 있다.
		return x * y;
	}

	public double division(double x, double y);

}
