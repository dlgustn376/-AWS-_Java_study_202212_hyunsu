package j14_추상;

public class Airplane extends Transportation{
	// 1. 추상클래스(부모)를 상속받아서 추상클래스(자식)로 만들기
	// 2. 추상클래스의 메소드를 다 구현하기
	
	// 필수가 되어버림.
	
	
	@Override
	public void go() {
		System.out.println("비행기를 타고 출발");
	}

	@Override
	public void stop() {
		System.out.println("비행기를 타고 출발");
	}
	
	public void checkTiket() {
		System.out.println("비행기 티켓 확인");
	}
	
}
