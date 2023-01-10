package j14_추상_Test;

public abstract class Car {
	public void run() {
		System.out.println("차가 달립니다.");
	};
	
	public void refuel() {
		System.out.println("연료를 주입합니다.");
	}; 
	
	public void stop() {
		System.out.println("차가 멈춥니다.");
	};


}
