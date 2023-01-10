package j15_인터페이스;

public class Main {
	public static void main(String[] args) {
		Equipment[] equipments = new Equipment[2];
		
		equipments[0] = new GeneralCalculator();
		equipments[1] = new SmartPhone();
		
//		인터페이스
		Calculator calculator = new Computer();
//		calculator.plus(0, 0);
		
		System.out.println("모든 장비 전원 켜기");
		for(Equipment eq : equipments) {
			eq.powerOn();
		}
		System.out.println();

		System.out.println("모든 장비에서 10과 20을 더하기");
		for(Equipment eq : equipments) {
			// 스마트폰에 equipments(상속) + Calculator(인터페이스)를 가지고 있어서 계산기로 형태를 변형
			// 스마트폰이 equipments 또는 Calculator 가 될 수 있다.
			// 스마트폰만 가지고 있는 메소드를 실행하고 싶으면 스마트폰 까지 가야 한다.
			Calculator c = (Calculator) eq;
			double result = c.plus(10, 20);
			System.out.println("결과: " + result);
		}
		System.out.println();
		
		System.out.println("모든 장비에서 10과 3을 나구기");
		for(Equipment eq : equipments) {
			Calculator c = (Calculator) eq;
			double result = c.division(10, 3);
			System.out.println("결과: " + result);
		}
		System.out.println();

		
		System.out.println("모든 장비 전원 끄기");
		for(Equipment eq : equipments) {
			eq.powerOff();
		}
		System.out.println();
		
	}
}
