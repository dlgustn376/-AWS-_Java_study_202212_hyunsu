package j18_제네릭;

public class Main2 {
//	reponse() 생성 필수
//	? : 와일드 카드
//	어떠한 형태로든 사용가능.
//CMRespDto<?> j18_제네릭.Main2.reponse(CMRespDto<?> cmRespDto)
//	와일드 카드의 제약
//	extends 대상 객체 하위
//	super 대상 객체 상위
//	<? extends String> : String을 상속받은 와일드 카드로 score를 사용 못 함.
//	<? extends Person> : Person을 상속받은 와일드 카드만 사용가능.
//	<? super Student > : Studnet랑 Person만 사용 가능한 와일드 카드 허용.
//	
	public CMRespDto<?> reponse(CMRespDto<?> cmRespDto) {
		System.out.println("[응답데이터]");
		System.out.println(cmRespDto);
		return cmRespDto;
	}
	
	public static void main(String[] args) {
//		객체생성이 존재 해야지만 reponse메소드를 호출가능하다.
		Main2 main = new Main2();
		
		CMRespDto<String> hello =
				new CMRespDto<String>(200, "성공", "안녕하세요");
		
		CMRespDto<Integer> score = 
				new CMRespDto<Integer>(200, "성공", 85);
		
//		data = reponse(hello);
//		repose는 생성이 되어야 호출되는 멤버 메소드이다.
//		static은 생성이 안되도 할당이 되어 있다.
		System.out.println("hello");
		System.out.println(main.reponse(hello));
		System.out.println("score");
		System.out.println(main.reponse(score));
		
	}
}
