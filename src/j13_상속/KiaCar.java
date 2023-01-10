package j13_상속;

public class KiaCar extends Car {
	
	public KiaCar() {
		super();		// 항상 상위
		System.out.println("자식");
		
	}
	
	@Override
	public int discountPrice(int percentage) {
		return super.discountPrice(percentage);
	}
	// 오버라이드를 안하면 Car 부모에 있는 것을 직접 가져오는 것.
	// 오버라이드를 하면 KiaCar 자식에 있는 오버라이드 된 것을 가져오는것
	// 서로 다른 메소드로 주소값도 다르다.
	
	
}
