package J17_스태틱;

public class CarMain {

	public static void main(String[] args) {
		Car[] cars = new Car[5];

		cars[0] = new Car("K1");
		cars[1] = new Car("K3");
		cars[2] = new Car("K5");
		cars[3] = new Car("K7");
		cars[4] = new Car("K9");
		
		
		for(Car car : cars) {
		System.out.println(car);
		}
	}
}
