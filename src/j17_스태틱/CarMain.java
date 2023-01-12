package j17_스태틱;

public class CarMain {
	
	public static void main(String[] args) {
		
		Car[] cars = new Car[10];
		
		cars[0] = new Car("2022 카니발");
		cars[1] = new Car("2023 스팅어");
		cars[2] = new Car("2023 K9");
		cars[3] = new Car("2023 니로 EV");
		cars[4] = new Car("2023 EV6 GT");
		cars[5] = new Car("2023 모하비");
		cars[6] = new Car("2023 니로 플러스");
		cars[7] = new Car("2023 쏘렌토 하이브리드");
		cars[8] = new Car("2023 K8");
		cars[9] = new Car("2023 스포티지");
		
		for(Car car: cars) {
			System.out.println(car);
		}
	}
}
