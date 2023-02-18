package j24_람다;

public class Lambda1 {
	public static void main(String[] args) {

		Instrument instrument = new Instrument() {

			@Override
			public String play(String instrument) { // 클래스
				return instrument + "을(를) 연주합니다.";
			}
		};

		Instrument instrument2 = (String itm) -> { // 메소드, 정의&생성
			return itm + "을(를) 연주합니다.";
		};

		
//		매개변수의 자료형을 생략할 수 있다.
//		매개변수의 이름을 바꿀 수 있다.
		Instrument instrument3 = (itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		
//		매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
		Instrument instrument4 = itm -> {
			return itm + "을(를) 연주합니다.";
		};
		
//		
//		구현부의 명령이 하나일 때 중괄호를 생략할 수 있다.  -> 리턴은 무조건 생략
//		이 때 리턴 자료형이 정해져 있으면 리턴값으로 사용이 된다.
		Instrument instrument5 = itm -> itm + "을(를) 연주합니다.";
		
		
		int result = 10 + 20;
		
		Instrument instrument6 = itm -> itm + "을(를) 연주합니다." + result;
		

		System.out.println(instrument2.play("피아노"));

		String playText = instrument2.play("드럼");
		System.out.println(playText);
		
		System.out.println(instrument6.play("기타"));

	}

}

// 추상메소드를 딱하나만 가지고있는 인터페이스만 가능