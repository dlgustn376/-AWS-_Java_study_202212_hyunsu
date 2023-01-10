package j14_추상_Test;

public class Main {
	
	public static void main(String[] args) {
		Bus bus = new Bus();
		AutoCar autoCar = new AutoCar();
		
		bus.run();
		autoCar.run();
		
		bus.refuel();;
		autoCar.refuel();;
		
		bus.takePassenger();;
		autoCar.load();
		
		bus.stop();;
		autoCar.stop();;
		
	}
}
