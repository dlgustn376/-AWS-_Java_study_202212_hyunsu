package j14_추상_Test;

public class AutoCar extends Car{

	@Override
	public void run() {
		super.run();
	}

	@Override
	public void refuel() {
		System.out.println("휘발유를 주유합니다.");
	}

	@Override
	public void stop() {
		super.stop();
	}
	
	public void load() {
		System.out.println("짐을 싣습니다.");
	}
}
