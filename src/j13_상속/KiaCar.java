package j13_상속;

public class KiaCar extends Car {

	public KiaCar() {
		super(); // this -> 자기자신을 의미, super -> 상위 객체를 호출
		System.out.println("자식");

//		System.out.println("자식");
//		super(); // 이렇게 하면 부모 객체를 호출할 수 없다. 그래서 최상단에 입력을 해야 한다.

	}

	@Override
	public int discountPrice(int percentage) {
		// TODO Auto-generated method stub
		return super.discountPrice(percentage);
	}

	

	public void test() {
		KiaCar kc = this;
	}
}
