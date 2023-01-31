package j24_람다;

import java.util.ArrayList;
import java.util.List;

public class Lambda1 {
	
	public static void main(String[] args) {
		Instrument instrument = new Instrument() {
			
			@Override
			public String play(String instrument) {
				
				return instrument + "을(를) 연주합니다."; 
			}
		};
		
		// 정의와 생성하는 부분
		Instrument instrument2 = (String itm) -> {
				return itm + "을(를) 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할 수 있다.
		// 매개변수의 이름을 바꿀 수 있다.
		Instrument instrument3 = (itm) -> {
			return itm + "을(를) 연주합니다.";
		};
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
		Instrument instrument4 = itm -> {
			return itm + "을(를) 연주합니다.";
		};
		
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다,
		// 이때 리턴 자료형이 정해져 있으면 리턴값으로 사용이 된다.
		// 중괄호를 생략하는 경우 반드시 return도 같이 생략.
		Instrument instrument5 = itm -> itm + "을(를) 연주합니다.";
		
		// 메인 메소드 안에 지역변수를 가져와서 사용이 가능하다.
		// 그래서 매개변수이름이 지역변수 이름과 같게 사용할 수 없다.
		// 최종적
		int result = 10 +20;
		Instrument instrument6 = itm -> itm + "을(를) 연주합니다." + result;
		
		
		// instrument 호출
		// 호출하는 부분
		// 호출을 해야 실행
		System.out.println(instrument.play("바이올린"));
		System.out.println(instrument.play("피아노"));
		System.out.println(instrument.play("첼로"));
		
		String playText = instrument.play("드럼");
		System.out.println(playText);
		
		//instrument2 호출
		List<String> playList = new ArrayList<>();
		
		playList.add("비올라");
		playList.add("플롯");
		playList.add("기타");
		playList.add("베이스");
		
		for(int i = 0; i < playList.size(); i++) {
			playText = instrument2.play(playList.get(i));
			System.out.println(playText);
		}
		
		// instrument3와 instrument4 호출
		System.out.println(instrument3.play("콘트라베이스"));
		System.out.println(instrument4.play("팀파니"));
		
		System.out.println(instrument5.play("트럼본"));
		
		System.out.println(instrument6.play("클라리넷"));
		
		
	}
}
